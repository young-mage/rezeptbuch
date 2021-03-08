package GUIElemente;

import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import EventManagement.ButtonClickManager;
import EventManagement.TableClickManager;
import javafx.scene.layout.BorderPane;

/**
 * Das Root-Element des Programms, enthält alle für
 * das Programm benötigten GUI-Elemente
 */
public class HauptPane extends BorderPane {

    // Die drei 'großen', für die App benötighten Elemente
    private final RezeptTabelle rezeptScroll;
    private final ButtonMenu buttonPane;
    private final InputSteuerung inputGrid;

    // Die beiden Event-Listener für Buttons und Tabelle
    private final ButtonClickManager cm;
    private final TableClickManager tcm;

    // Hier wird das aktuell ausgewählte Rezept als static-Variable gespeichert.
    public static Rezept rezeptWahl;

    // Standard-Konstruktor
    public HauptPane(Rezeptbuch rb){
        this.rezeptScroll = new RezeptTabelle(rb);
        this.buttonPane = new ButtonMenu();
        this.inputGrid = new InputSteuerung();
        this.setBottom(buttonPane);
        this.setCenter(inputGrid);
        this.setTop(rezeptScroll);
        rezeptWahl = null;

        cm = new ButtonClickManager(rezeptScroll.getSelectionModel(), rb, buttonPane.getNewBtn(), buttonPane.getSaveBtn(), buttonPane.getDeleteBtn(), inputGrid.getNameField(), inputGrid.getDurationField(), inputGrid.getZutatenArea(), inputGrid.getAnweisungsArea(), rezeptScroll.getRezeptTabelle());
        tcm = new TableClickManager(inputGrid.getNameField(), inputGrid.getDurationField(), inputGrid.getZutatenArea(), inputGrid.getAnweisungsArea());
        buttonPane.setListener(cm); // Füge den Buttons/Tabelle ihre Listener hinzu
        rezeptScroll.setListener(tcm);
    }
}
