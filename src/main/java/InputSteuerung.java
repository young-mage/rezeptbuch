import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputSteuerung extends GridPane {

    Label nameLbl;
    Label zutatenLbl;
    TextField nameField;
    TextArea zutatenArea;

    public InputSteuerung() {
        nameLbl = new Label("Name:");
        zutatenLbl = new Label("Zutaten:");
        nameField = new TextField();
        zutatenArea = new TextArea();
        this.add(nameLbl, 0, 0);
        this.add(zutatenLbl, 0, 1);
        this.add(nameField, 1, 0);
        this.add(zutatenArea, 1, 1);
    }
}
