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

/**
 * Diese Klasse nimmt verarbeitet Clicks auf die Tabelleneinträge der GUI.
 */
public class TableClickManager implements ListChangeListener<Rezept> {

    // Die Attribute sind nur da, um Pointer der benötigten Datenstrukturen und GUI-Elemente zu speichern
    private final TextField nameField;
    private final TextField durationField;
    private final TextArea zutatenArea;
    private final TextArea anweisungsArea;

    // Standard-Konstruktor. Nummt Pointer der verwalteten GUI-Klassen entgegen.
    public TableClickManager(TextField nameField, TextField durationField, TextArea zutatenArea, TextArea anweisungsArea) {
        this.nameField = nameField;
        this.durationField = durationField;
        this.zutatenArea = zutatenArea;
        this.anweisungsArea = anweisungsArea;
    }

    // Methode, welche beim Wechseln der Auswahl (in unserem Programm: bei jedem Click auf einen Tabelleneintrag) ausgeführt wird
    @Override
    public void onChanged(Change<? extends Rezept> c) {
        if(c.getList().size() == 0) return; // Diese Zeile steht hier nur, weil sonst ständig OutOfBoundsExceptions con JavaFX abgefangen werden
        Rezept rezeptWahl = c.getList().get(0);
        HauptPane.rezeptWahl = rezeptWahl;

        // Füllt Textfelder mit den Daten des ausgewählten Eintrags
        nameField.setText(rezeptWahl.getName());
        durationField.setText(Integer.toString(rezeptWahl.getDauer()));
        zutatenArea.setText(rezeptWahl.zutatenToString());
        anweisungsArea.setText(rezeptWahl.anweisungenToString());
    }
}
