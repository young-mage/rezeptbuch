import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import Datenstrukturen.Rezept;
import Datenstrukturen.Rezeptbuch;
import Datenstrukturen.Zutat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RezeptbuchTest {

    public Rezept testRezept1() {
        Zutat wasser = new Zutat("Wasser",100);
        Zutat nudeln = new Zutat("Nudeln",200);
        List<Zutat> zutaten = new ArrayList<Zutat>();
        zutaten.add(wasser);
        zutaten.add(nudeln);

        String anweisung1 = "Nudeln in kochendes Wasser geben";
        String anweisung2 = "10 Minuten kochen";
        String anweisung3 = "Wasser abgiessen";
        List<String> anweisungen = new ArrayList<String>();
        anweisungen.add(anweisung1);
        anweisungen.add(anweisung2);
        anweisungen.add(anweisung3);

        return new Rezept("Nudeln",10,zutaten,anweisungen);
    }

    public Rezept testRezept2() {
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

    @Test public void testZutatNotNull() {
        var foo = new Zutat("", 10);
        assertNotNull(foo);
    }

    @Test public void testRezeptHinzufuegen(){
        Rezept rezept1 = testRezept1();
        Rezept rezept2 = testRezept2();
        Rezeptbuch testRezBuch = new Rezeptbuch(new ArrayList<Rezept>());
        testRezBuch.rezeptHinzufuegen(rezept1, 0);
        testRezBuch.rezeptHinzufuegen(rezept2, 0);
        assertEquals(2, testRezBuch.getRezepte().size());
        assertEquals(rezept2, testRezBuch.getRezepte().get(0));
    }

    @Test public void testRezeptEntfernen(){
        Rezept rezept1 = testRezept1();
        Rezept rezept2 = testRezept2();
        ArrayList<Rezept> rezList = new ArrayList<Rezept>();
        rezList.add(rezept1);
        rezList.add(rezept2);
        Rezeptbuch testRezBuch = new Rezeptbuch(rezList);
        testRezBuch.rezeptEntfernen(rezept1);
        testRezBuch.rezeptEntfernen(0);
        assertEquals(0, testRezBuch.getRezepte().size());
    }
}
