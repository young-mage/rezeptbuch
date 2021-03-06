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

        cm = new ButtonClickManager(buttonPane.getNewBtn(), buttonPane.getSaveBtn(), buttonPane.getDeleteBtn(), inputGrid.getZutatenField(), inputGrid.getAnweisungsArea());
        tcm = new TableClickManager(rezeptScroll.getTable());
        buttonPane.setListener(cm);
        rezeptScroll.setListener(tcm);
    }
}
