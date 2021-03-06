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

public class ButtonClickManager implements EventHandler<ActionEvent>{

    private Button newBtn;
    private Button saveBtn;
    private Button deleteBtn;
    private TextField nameField;
    private TextField durationField;
    private TextArea zutatenArea;
    private TextArea anweisungsArea;
    private TableView table;

    private Rezeptbuch rezeptbuch;

    private TableViewSelectionModel selectionModel;

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

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == newBtn){
            clearTextFields();
            HauptPane.rezeptWahl = null;
            selectionModel.clearSelection();
        }

        if(event.getSource() == saveBtn && fieldsFilledCorrectly()){
            Rezept newRecipe = compileRecipe();
            rezeptbuch.rezeptHinzufuegen(newRecipe);
            clearTextFields();
            selectionModel.clearSelection();
            table.refresh();
            System.out.println(rezeptbuch.getRezepte().size());
        }

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

    public void clearTextFields() {
        nameField.setText("");
        durationField.setText("");
        zutatenArea.setText("");
        anweisungsArea.setText("");
    }

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
