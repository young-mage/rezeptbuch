package EventManagement;

import Datenstrukturen.BeispielRezepte;
import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import Datenstrukturen.Zutat;
import GUIElemente.HauptPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * Diese Klasse nimmt verarbeitet Clicks auf die Buttons der GUI.
 */
public class ButtonClickManager implements EventHandler<ActionEvent>{

    // Folgende Attribute sind nur dazu da, um Pointer der verwalteten GUI-Elemente zu speichern
    private Button newBtn;
    private Button saveBtn;
    private Button deleteBtn;
    private TextField nameField;
    private TextField durationField;
    private TextArea zutatenArea;
    private TextArea anweisungsArea;
    private TableView table;

    // Speichert nur den Pointer des im Programm verwendeten Rezeptbuchs
    private Rezeptbuch rezeptbuch;

    // Dieses Objekt wird in RezeptScrollListe instanziiert und speichert die aktuelle Tabellenauswahl
    private TableViewSelectionModel selectionModel;

    // Standard-Konstruktor, um Attributen ihre Werte zuzuordnen
    public ButtonClickManager(TableViewSelectionModel selectionModel, Rezeptbuch rezeptbuch, Button newBtn, Button saveBtn, Button deleteBtn, TextField nameField, TextField durationField, TextArea zutatenArea, TextArea anweisungsArea, TableView table) {
        this.newBtn = newBtn;
        this.saveBtn = saveBtn;
        this.deleteBtn = deleteBtn;
        this.nameField = nameField;
        this.durationField = durationField;
        this.zutatenArea = zutatenArea;
        this.anweisungsArea = anweisungsArea;
        this.rezeptbuch = rezeptbuch;
        this.table = table;

        this.selectionModel = selectionModel;
    }

    // Dieser Handler verarbeitet Click-Events der drei Buttons
    @Override
    public void handle(ActionEvent event) {

        // Leert die Textfelder und hebt die Auswahl auf, um neue Rezepte anzulegen
        if(event.getSource() == newBtn){
            clearTextFields();
            HauptPane.rezeptWahl = null;
            selectionModel.clearSelection();
        }

        // Falls der "Speichern"-Button geclickt wird und alle Felder richtig ausgefüllt sind, füge das neue Rezept hinzu
        if(event.getSource() == saveBtn && fieldsFilledCorrectly()){
            Rezept newRecipe = compileRecipe();
            rezeptbuch.rezeptHinzufuegen(newRecipe);
            clearTextFields();
            selectionModel.clearSelection();
            table.refresh();
            System.out.println(rezeptbuch.getRezepte().size());
        }

        // Falls ein Element ausgewählt ist, lösche es aus der Liste
        if(event.getSource() == deleteBtn){
            if(HauptPane.rezeptWahl != null){
                rezeptbuch.rezeptEntfernen(HauptPane.rezeptWahl);
                HauptPane.rezeptWahl = null;
                clearTextFields();
                selectionModel.clearSelection();
                table.refresh();
            }
        }
    }

    /**
     * Leert alle TextFields und TextAreas der GUI
     */
    public void clearTextFields() {
        nameField.setText("");
        durationField.setText("");
        zutatenArea.setText("");
        anweisungsArea.setText("");
    }

    /**
     * Prüft, um alle Felder richtig ausgefüllt sind, damit das
     * eingegebene Rezept hinzugefügt werden kann. Dafür müssen alle Felder
     * nichtleer sein, und alle erwarteten numerischen Werte tatsächlich Zahlen sein.
     * @return Bool-Wert dafür, ob alle Felder richtig ausgefüllt sind
     */
    public boolean fieldsFilledCorrectly() {
        if(nameField.getText().equals("") || durationField.getText().equals("") || zutatenArea.getText().equals("") || anweisungsArea.getText().equals("")) {
            return false;
        }
        try {
            Integer.parseInt(durationField.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Unter der Voraussetzung, dass alle Felder richtig ausgefüllt sind:
     * Liest den gesamten eingegebenen Text ein und erstellt daraus ein neues Rezept
     * @return das neu erstellte Rezept
     */
    public Rezept compileRecipe() {
        String name = nameField.getText();
        int dauer = Integer.parseInt(durationField.getText());
        String[] zutaten = zutatenArea.getText().split("\n");
        String[] anweisungen = anweisungsArea.getText().split("\n");

        ArrayList<Zutat> zutatenListe = new ArrayList<>();
        ArrayList<String> anweisungsListe = new ArrayList<>();

        for (String zutatStr : zutaten) {
            zutatenListe.add(new Zutat(zutatStr, 1));
        }

        for (String anweisungStr : anweisungen) {
            anweisungsListe.add(anweisungStr);
        }

        return new Rezept(name, dauer, zutatenListe, anweisungsListe);
    }
}
