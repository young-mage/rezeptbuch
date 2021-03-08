package GUIElemente;

import EventManagement.ButtonClickManager;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * Das untere Panel mit Buttons für das neu Erstellen, Speichern
 * und Löschen von Rezeptbucheinträgen
 */
public class ButtonMenu extends FlowPane {

    // Die drei child-Buttons des Panels
    private final Button newBtn;
    private final Button saveBtn;
    private final Button deleteBtn;

    // Standard-Konstruktor
    public ButtonMenu(){
        newBtn = new Button("Neu");
        saveBtn = new Button("Speichern");
        deleteBtn = new Button("Löschen");
        this.getChildren().addAll(newBtn, saveBtn, deleteBtn);
        this.setPadding(new Insets(10));
        this.setHgap(5);
    }

    /**
     * Nimmt einen ButtonClickManager entgegen (Klasse, welche Clicks auf die
     * Buttons verarbeitet) und fügt diesen den Buttons als Listener-Klasse hinzu
     * @param clickManager der an die Buttons übergebene ClickManager
     */
    public void setListener(ButtonClickManager clickManager){
        newBtn.setOnAction(clickManager);
        saveBtn.setOnAction(clickManager);
        deleteBtn.setOnAction(clickManager);
    }

    // Getter-Methoden der Butons
    public Button getNewBtn() {
        return newBtn;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }
}
