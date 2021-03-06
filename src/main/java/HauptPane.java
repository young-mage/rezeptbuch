import javafx.scene.layout.BorderPane;

public class HauptPane extends BorderPane {

    RezeptScrollListe rezeptScroll;
    ButtonSteuerMenu buttonPane;
    InputSteuerung inputGrid;

    ButtonClickManager cm;
    TableClickManager tcm;

    public HauptPane(Rezeptbuch rb){
        this.rezeptScroll = new RezeptScrollListe(rb);
        this.buttonPane = new ButtonSteuerMenu();
        this.inputGrid = new InputSteuerung();
        this.setBottom(buttonPane);
        this.setCenter(inputGrid);
        this.setTop(rezeptScroll);

        cm = new ButtonClickManager(buttonPane.getNewBtn(), buttonPane.getSaveBtn(), buttonPane.getDeleteBtn(), inputGrid.getNameField(), inputGrid.getAnweisungsArea());
        tcm = new TableClickManager(rezeptScroll.getTable(), inputGrid.getNameField(), inputGrid.getZutatenArea(), inputGrid.getAnweisungsArea());
        buttonPane.setListener(cm);
        rezeptScroll.setListener(tcm);
    }
}
