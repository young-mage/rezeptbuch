import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TableClickManager implements ListChangeListener<Rezept> {

    private TableView tableView;
    private TextField nameField;
    private TextArea zutatenArea;
    private TextArea anweisungsArea;

    public TableClickManager(TableView tableView, TextField nameField, TextArea zutatenArea, TextArea anweisungsArea) {
        this.tableView = tableView;
        this.nameField = nameField;
        this.zutatenArea = zutatenArea;
        this.anweisungsArea = anweisungsArea;
    }

    @Override
    public void onChanged(Change<? extends Rezept> c) {
        Rezept rezeptWahl = c.getList().get(0);
        nameField.setText(rezeptWahl.getName());
        zutatenArea.setText(rezeptWahl.zutatenToString());
        anweisungsArea.setText(rezeptWahl.anweisungenToString());
    }
}
