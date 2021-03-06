package EventManagement;

import Datenstrukturen.Rezept;
import GUIElemente.HauptPane;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableClickManager implements ListChangeListener<Rezept> {

    // Die Attribute sind nur da, um Pointer der benötigten Datenstrukturen und GUI-Elemente zu speichern
    private TableView tableView;
    private TextField nameField;
    private TextField durationField;
    private TextArea zutatenArea;
    private TextArea anweisungsArea;



    public TableClickManager(TableView tableView, TextField nameField, TextField durationField, TextArea zutatenArea, TextArea anweisungsArea) {
        this.tableView = tableView;
        this.nameField = nameField;
        this.durationField = durationField;
        this.zutatenArea = zutatenArea;
        this.anweisungsArea = anweisungsArea;
    }

    @Override
    public void onChanged(Change<? extends Rezept> c) {
        Rezept rezeptWahl = c.getList().get(0);
        System.out.println(rezeptWahl != null);
        HauptPane.rezeptWahl = rezeptWahl;
        nameField.setText(rezeptWahl.getName());
        durationField.setText(Integer.toString(rezeptWahl.getDauer()));
        zutatenArea.setText(rezeptWahl.zutatenToString());
        anweisungsArea.setText(rezeptWahl.anweisungenToString());
    }
}
