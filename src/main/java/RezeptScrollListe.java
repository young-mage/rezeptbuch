import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class RezeptScrollListe extends BorderPane {

    private TableView<Rezept> table;
    private final ObservableList<Rezept> data;

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
        this.setCenter(table);
    }

}
