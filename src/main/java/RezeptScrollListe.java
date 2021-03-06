import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.TableView.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class RezeptScrollListe extends BorderPane {

    private TableView<Rezept> table;
    private final ObservableList<Rezept> data;
    TableViewSelectionModel selectionModel;
    ObservableList<Rezept> selectedItems;

    private Rezeptbuch rezeptbuch;
    public RezeptScrollListe(Rezeptbuch rezeptbuch){
        this.rezeptbuch = rezeptbuch;

        data = FXCollections.observableArrayList(rezeptbuch.getRezepte());

        table = new TableView<>();
        TableColumn recipeCol = new TableColumn("Rezepte");
        recipeCol.setCellValueFactory(new PropertyValueFactory<Rezept, String>("name"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(data);
        table.getColumns().add(recipeCol);
        this.setPrefHeight(150);
        table.setPlaceholder(new Label("Noch keine Rezepte..."));

        selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE); //Es soll immer je 1 Objekt ausgewählt werden
        selectedItems = selectionModel.getSelectedItems();

        this.setCenter(table);
    }

    public void setListener(TableClickManager tableClickManager) {
        selectedItems.addListener(tableClickManager);
    }

    public TableView<Rezept> getTable() {
        return table;
    }
}
