import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class ButtonSteuerMenu extends FlowPane {

    Button newBtn;
    Button saveBtn;
    Button deleteBtn;

    public ButtonSteuerMenu(){
        newBtn = new Button("Neu");
        saveBtn = new Button("Speichern");
        deleteBtn = new Button("Löschen");
        this.getChildren().addAll(newBtn, saveBtn, deleteBtn);
    }
}
