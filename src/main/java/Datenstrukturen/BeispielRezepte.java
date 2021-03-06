package Datenstrukturen;

import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import Datenstrukturen.Zutat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class BeispielRezepte {

    public static Rezept butterbrot() {
        Zutat brot = new Zutat("Brot",1);
        Zutat butter = new Zutat("Butter",1);
        List<Zutat> zutaten = new ArrayList<Zutat>();
        zutaten.add(brot);
        zutaten.add(butter);

        String anweisung1 = "Brot auf Butter schmieren";
        List<String> anweisungen = new ArrayList<String>();
        anweisungen.add(anweisung1);

        return new Rezept("Butterbrot",2,zutaten,anweisungen);
    }

    public static Rezept pizza() {
        Zutat brot = new Zutat("Teig",2);
        Zutat butter = new Zutat("Tomatensauce",1);
        List<Zutat> zutaten = new ArrayList<Zutat>();
        zutaten.add(brot);
        zutaten.add(butter);

        List<String> anweisungen = new ArrayList<String>();
        anweisungen.add("Teig ausrollen");
        anweisungen.add("Sauce Hinzufügen");
        anweisungen.add("Backen");

        return new Rezept("Pizza",10,zutaten,anweisungen);
    }

    public static Rezeptbuch testRezBuch(){
        ObservableList<Rezept> rezepte = FXCollections.observableArrayList();
        rezepte.add(butterbrot());
        return new Rezeptbuch(rezepte);
    }

}
