import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class SaveManager {

    public void save(Rezeptbuch rezeptbuch) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("RezeptbuchSave"));
            outputStream.writeObject(rezeptListeArray((ObservableList<Rezept>) rezeptbuch.getRezepte()));
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rezeptbuch load() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("RezeptbuchSave"));
            return new Rezeptbuch(FXCollections.observableArrayList( (Rezept[]) inputStream.readObject() ));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Rezeptbuch(FXCollections.observableArrayList());
        }
    }

    public Rezept[] rezeptListeArray(ObservableList<Rezept> rezepte) {
        int len = rezepte.size();
        Rezept[] rezeptArray = new Rezept[len];
        for(int i = 0; i < len; i++) {
            rezeptArray[i] = rezepte.get(i);
        }
        return rezeptArray;
    }
}
