package GUIElemente;

import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import EventManagement.ButtonClickManager;
import EventManagement.TableClickManager;
import javafx.scene.layout.BorderPane;

public class HauptPane extends BorderPane {

    RezeptScrollListe rezeptScroll;
    ButtonSteuerMenu buttonPane;
    InputSteuerung inputGrid;

    ButtonClickManager cm;
    TableClickManager tcm;

    public static Rezept rezeptWahl; // Hier wird das aktuell ausgewählte Rezept gespeichert

    public HauptPane(Rezeptbuch rb){
        this.rezeptScroll = new RezeptScrollListe(rb);
        this.buttonPane = new ButtonSteuerMenu();
        this.inputGrid = new InputSteuerung();
        this.setBottom(buttonPane);
        this.setCenter(inputGrid);
        this.setTop(rezeptScroll);
        rezeptWahl = null;

        cm = new ButtonClickManager(rezeptScroll.getSelectionModel(), rb, buttonPane.getNewBtn(), buttonPane.getSaveBtn(), buttonPane.getDeleteBtn(), inputGrid.getNameField(), inputGrid.getDurationField(), inputGrid.getZutatenArea(), inputGrid.getAnweisungsArea(), rezeptScroll.getTable());
        tcm = new TableClickManager(rezeptScroll.getTable(), inputGrid.getNameField(), inputGrid.getDurationField(), inputGrid.getZutatenArea(), inputGrid.getAnweisungsArea());
        buttonPane.setListener(cm);
        rezeptScroll.setListener(tcm);
    }
}
