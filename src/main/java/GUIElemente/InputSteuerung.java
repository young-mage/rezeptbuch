package GUIElemente;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

/**
 * Diese Klasse stellt das mittlere Gitter dar und beinhaltet alle Textfelder,
 * welche zur Eingabe von Daten notwendig sind
 */
public class InputSteuerung extends GridPane {

    private final HBox nameDurationPane;
    private final Label nameLbl;
    private final Label zutatenLbl;
    private final Label anweisungsLbl;
    private final TextField nameField;
    private final TextField durationField;
    private final TextArea zutatenArea;
    private final TextArea anweisungsArea;

    // Konstruktor, welcher alle Unterelemente richtig anordnet
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

    // Getter-Methoden
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
