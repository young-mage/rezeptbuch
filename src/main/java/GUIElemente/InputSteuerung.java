package GUIElemente;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class InputSteuerung extends GridPane {

    private HBox nameDurationPane;
    private Label nameLbl;
    private Label zutatenLbl;
    private Label anweisungsLbl;
    private TextField nameField;
    private TextField durationField;
    private TextArea zutatenArea;
    private TextArea anweisungsArea;

    public InputSteuerung() {
        nameLbl = new Label("Name / Dauer:");
        zutatenLbl = new Label("Zutaten:");
        anweisungsLbl = new Label("Anweisungen:");
        nameField = new TextField();
        durationField = new TextField();
        zutatenArea = new TextArea();
        anweisungsArea = new TextArea();
        nameDurationPane = new HBox();
        nameDurationPane.setSpacing(5);
        nameDurationPane.getChildren().addAll(nameField, durationField);
        this.add(nameLbl, 0, 0);
        this.add(zutatenLbl, 0, 1);
        this.add(anweisungsLbl, 0, 2);
        this.add(nameDurationPane, 1, 0);
        this.add(zutatenArea, 1, 1);
        this.add(anweisungsArea, 1, 2);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.getColumnConstraints().add(new ColumnConstraints(110));
        this.getColumnConstraints().add(new ColumnConstraints(270));
        this.setVgap(5);
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextArea getZutatenArea() {
        return zutatenArea;
    }

    public TextArea getAnweisungsArea() {
        return anweisungsArea;
    }

    public TextField getDurationField() {
        return durationField;
    }
}
