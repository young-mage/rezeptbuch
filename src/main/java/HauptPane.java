import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class HauptPane extends BorderPane {

    ScrollPane rezeptScroll;
    FlowPane buttonPane;
    GridPane inputGrid;

    public HauptPane(Rezeptbuch rb){
        this.rezeptScroll = new RezeptScrollListe(rb);
        this.buttonPane = new ButtonSteuerMenu();
        this.inputGrid = new InputSteuerung();
        this.setBottom(buttonPane);
        this.setCenter(inputGrid);
        this.setTop(rezeptScroll);
    }
}
