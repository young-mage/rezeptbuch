package GUIElemente;

import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import EventManagement.TableClickManager;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.TableView.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

/**
 * Dieses Element beinhaltet die (scrollbare) Tabelle
 * mit allen Rezeptbucheinträgen
 */
public class RezeptScrollListe extends BorderPane {

    // Die Attribute sind nur da, um Pointer der benötigten Datenstrukturen und GUI-Elemente zu speichern
    private final TableView<Rezept> rezeptTabelle;
    private final ObservableList<Rezept> rezeptListe;
    private final Rezeptbuch rezeptbuch;

    private final TableViewSelectionModel selectionModel; // Dieses Objekt speichert die aktuelle Tabellenauswahl des Nutzers
    private final ObservableList<Rezept> selectedItems;   // Diese Variable speichert das aktuell ausgewählte Objekt (aus formalen Gründen) in einer Liste

    // Konstruktor mit Setup der Tabelle, Spalte und Click-Managements
    public RezeptScrollListe(Rezeptbuch rezeptbuch){
        this.rezeptbuch = rezeptbuch;

        rezeptListe = (ObservableList<Rezept>) rezeptbuch.getRezepte(); // Cast möglich, da Rezeptliste bereits eine ObservableList ist

        // Erzeugt die Tabelle und die dazugehörige Rezept-Spalte
        rezeptTabelle = new TableView<>();
        TableColumn recipeCol = new TableColumn("Rezepte");
        recipeCol.setCellValueFactory(new PropertyValueFactory<Rezept, String>("name"));
        rezeptTabelle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        rezeptTabelle.setItems(rezeptListe);
        rezeptTabelle.getColumns().add(recipeCol);
        rezeptTabelle.setPlaceholder(new Label("Noch keine Rezepte..."));

        // Management der Nutzerauswahl wird durch diese Objekte verwaltet
        selectionModel = rezeptTabelle.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE); //Es soll immer je 1 Objekt ausgewählt werden
        selectedItems = selectionModel.getSelectedItems();

        this.setCenter(rezeptTabelle);
        this.setPrefHeight(150);
    }

    /**
     * Nimmt einen TableClickManager entgegen (Klasse, welche Clicks auf die
     * Tabelleneinträge verarbeitet) und fügt diesen den Buttons als Listener-Klasse hinzu
     * @param tableClickManager der an die Tablelle übergebene TableClickManager
     */
    public void setListener(TableClickManager tableClickManager) {
        selectedItems.addListener(tableClickManager);
    }

    // Getter-Methoden
    public TableView<Rezept> getRezeptTabelle() {
        return rezeptTabelle;
    }

    public TableViewSelectionModel getSelectionModel() {
        return selectionModel;
    }
}
