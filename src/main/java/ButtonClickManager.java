import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ButtonClickManager implements EventHandler<ActionEvent>{

    private Button newBtn;
    private Button saveBtn;
    private Button deleteBtn;
    private TextField zutatenField;
    private TextArea anweisungsArea;

    public ButtonClickManager(Button newBtn, Button saveBtn, Button deleteBtn, TextField zutatenField, TextArea anweisungsArea) {
        this.newBtn = newBtn;
        this.saveBtn = saveBtn;
        this.deleteBtn = deleteBtn;
        this.zutatenField = zutatenField;
        this.anweisungsArea = anweisungsArea;
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == newBtn){
            // TODO
        }

        if(event.getSource() == saveBtn){
            // TODO
        }

        if(event.getSource() == deleteBtn){
            // TODO
        }
    }
}
