package EventManagement;

import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import Datenstrukturen.Zutat;
import GUIElemente.HauptPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.TableView.*;

import java.util.ArrayList;

/**
 * Diese Klasse nimmt verarbeitet Clicks auf die Buttons der GUI.
 */
public class ButtonClickManager implements EventHandler<ActionEvent>{

    // Folgende Attribute sind nur dazu da, um Pointer der verwalteten GUI-Elemente zu speichern
    private final Button newBtn;
    private final Button saveBtn;
    private final Button deleteBtn;
    private final TextField nameField;
    private final TextField durationField;
    private final TextArea zutatenArea;
    private final TextArea anweisungsArea;
    private final TableView table;

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
            if(HauptPane.rezeptWahl == null) { // Falls kein Element ausgewählt ist, speichere neues Rezept
                rezeptbuch.rezeptHinzufuegen(newRecipe);
            } else { // Falls Rezept ausgwählt ist, speichere die Änderungen
                rezeptbuch.rezeptSetzen(HauptPane.rezeptWahl, newRecipe);
            }
            clearTextFields();
            selectionModel.clearSelection();
            table.refresh();
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
     * Falls ein Fehler auftritt, erzeugt diese Methode eine grafische Fehlermeldung.
     * @return Bool-Wert dafür, ob alle Felder richtig ausgefüllt sind
     */
    public boolean fieldsFilledCorrectly() {
        if(nameField.getText().equals("") || durationField.getText().equals("") || zutatenArea.getText().equals("") || anweisungsArea.getText().equals("")) {
            showErrorAlert("Eingabefehler", "Alle Felder müssen ausgefüllt sein!");
            return false;
        }
        try {
            Integer.parseInt(durationField.getText());
        } catch (NumberFormatException e) {
            showErrorAlert("Eingabefehler", "'Dauer' muss eine ganze Zahl sein!");
            return false;
        }
        return ingredientsFilledCorrectly();
    }

    /**
     * Prüft, ob die Zutatenliste richtig Formattiert ist:
     * Jede Zutat muss in neuer Zeile Stehen, in der Form [MENGE] [ZUTAT]
     * @return Boolean, ob Zutatenliste richtig ausgefüllt ist.
     */
    public boolean ingredientsFilledCorrectly() {
        String[] zutatenEingabe = zutatenArea.getText().split("\n"); // Lese eingegebene Zeilen in Array ein
        for (String z : zutatenEingabe) {
            String[] zeile = z.split(" ");
            if (zeile.length < 2) {
                showErrorAlert("Eingabefehler", "Schreibe jede Zutat in eine neue Zeile.\nEine Zutat muss das Format\n[Menge] [Bezeichnung] haben.");
                return false;
            }
            try {
                Integer.parseInt(zeile[0]);
            } catch (NumberFormatException e) {
                showErrorAlert("Eingabefehler", "Zutatenmenge muss eine ganze Zahl sein");
                return false;
            }
        }
        return true;
    }

    /**
     * Unter der Voraussetzung, dass alle Felder richtig ausgefüllt sind:
     * Liest den gesamten eingegebenen Text ein und erstellt daraus ein neues Rezept
     * @return das neu erstellte Rezept
     */
    public Rezept compileRecipe() {
        // Definition der für das neue Rezept notwendigen Variablen
        String name = nameField.getText();
        int dauer = Integer.parseInt(durationField.getText());
        ArrayList<Zutat> zutatenListe = new ArrayList<>();
        ArrayList<String> anweisungsListe = new ArrayList<>();

        // Spalte die Eingaben nach Zeilen auf
        String[] zutaten = zutatenArea.getText().split("\n");
        String[] anweisungen = anweisungsArea.getText().split("\n");

        // Liest Zutatenliste ein und betreibt Parsing, um Mengen und Zutatente zu exrtahieren
        for (String zutatStr : zutaten) {
            String[] zeile = zutatStr.split(" ");
            String zutatText = "";
            for(int i = 1; i < zeile.length; i++) {
                zutatText += zeile[i] + " ";
            }
            zutatenListe.add(new Zutat(zutatText, Integer.parseInt(zeile[0])));
        }

        // Liest Anweisungsliste ein und speichert diese in ArrayList
        for (String anweisungStr : anweisungen) {
            anweisungsListe.add(anweisungStr);
        }

        // Erstelle neues Rezept mit den oben eingelesenen Informationen
        return new Rezept(name, dauer, zutatenListe, anweisungsListe);
    }

    /**
     * Zeigt eine grafische Fehlermeldung an
     * @param title Die Überschrift der Fehlermeldung
     * @param message Der Text der Fehlermeldung (kann mehrzeilig sein)
     */
    void showErrorAlert(String title, String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText(title);
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }
}
