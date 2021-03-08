import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

/**
 * Diese Klasse verwaltet das Speichern und Laden des Rezeptbuchs
 * mittels Konvertierung des Rezeptbuchs in/aus statischer Array
 */
public class SaveManager {

    /**
     * Speichert das übergebene Rezeptbuch in einer Binary
     * @param rezeptbuch Das zu speichernde Rezeptbuch
     */
    public void save(Rezeptbuch rezeptbuch) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("RezeptbuchSave"));
            outputStream.writeObject(rezeptListeArray((ObservableList<Rezept>) rezeptbuch.getRezepte())); // Verschiedene Variationen von ToArray funktionieren hier aus irgendeinem Grund nicht
            outputStream.close();                                                                         // Daher die manuelle Methode rezeptListeArray() unten
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt das übergebene Rezeptbuch aus einer Binary
     * @return das geladene Rezeptbuch
     */
    public Rezeptbuch load() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("RezeptbuchSave"));
            return new Rezeptbuch(FXCollections.observableArrayList( (Rezept[]) inputStream.readObject() ));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Rezeptbuch(FXCollections.observableArrayList());
        }
    }

    /**
     * Konvertiert eine ObservableList in eine Array von Rezepten,
     * weil .toArray() Fehler beim Speichern erzeugt
     * @param rezepte ObservableList von Rezepten
     * @return Die Liste, konvertiert in eine Array
     */
    public Rezept[] rezeptListeArray(ObservableList<Rezept> rezepte) {
        int len = rezepte.size();
        Rezept[] rezeptArray = new Rezept[len];
        for(int i = 0; i < len; i++) {
            rezeptArray[i] = rezepte.get(i);
        }
        return rezeptArray;
    }
}
