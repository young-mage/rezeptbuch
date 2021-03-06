import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class ButtonSteuerMenu extends FlowPane {

    private Button newBtn;
    private Button saveBtn;
    private Button deleteBtn;

    public ButtonSteuerMenu(){
        newBtn = new Button("Neu");
        saveBtn = new Button("Speichern");
        deleteBtn = new Button("Löschen");
        this.getChildren().addAll(newBtn, saveBtn, deleteBtn);
        this.setPadding(new Insets(10));
        this.setHgap(5);
    }

    public void setListener(ButtonClickManager clickManager){
        newBtn.setOnAction(clickManager);
        saveBtn.setOnAction(clickManager);
        deleteBtn.setOnAction(clickManager);
    }

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
