import Datenstrukturen.Rezept;
import Datenstrukturen.Zutat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RezeptTest {
    Zutat testZutat1 = new Zutat("Milch", 10);
    Zutat testZutat2 = new Zutat("Brot", 5);

    @Test public void testRezeptNotNull() {
        ArrayList<Zutat> testZutListe = new ArrayList<Zutat>();
        testZutListe.add(testZutat1);
        ArrayList<String> testAnweisungen = new ArrayList<String>();
        testAnweisungen.add("anw1");

        var testRezept = new Rezept("", 0, testZutListe, testAnweisungen);
        assertNotNull(testRezept);
    }

    @Test public void testZutatHinzufuegen(){
        var testRezept = new Rezept("", 0, new ArrayList<Zutat>(), null);
        testRezept.zutatHinzufuegen(testZutat1);
        assertEquals(1, testRezept.getZutaten().size());
        assert(testRezept.getZutaten().contains(testZutat1));
    }

    @Test public void testZutatEntfernen(){
        var testRezept = new Rezept("", 0, new ArrayList<Zutat>(), null);
        testRezept.zutatHinzufuegen(testZutat1);
        testRezept.zutatHinzufuegen(testZutat2);
        testRezept.zutatEntfernen(testZutat1);
        assert(!testRezept.getZutaten().contains(testZutat1));
        assertEquals(testRezept.getZutaten().size(), 1);
        assertEquals(testRezept.getZutaten().get(0), testZutat2);
    }

    @Test public void testAnweisungHinzufuegen(){
        var testRezept = new Rezept("", 0, null, new ArrayList<String>());
        testRezept.anweisungHinzufuegen("ANW0");
        assertEquals(1, testRezept.getAnweisungen().size());
        assert(testRezept.getAnweisungen().contains("ANW0"));
    }

    @Test public void testAnweisungEntfernen(){
        var testRezept = new Rezept("", 0, null, new ArrayList<String>());
        testRezept.anweisungHinzufuegen("ANW0");
        testRezept.anweisungHinzufuegen("ANW1");
        testRezept.anweisungEntfernen("ANW0");
        assert(!testRezept.getAnweisungen().contains("ANW0"));
        assertEquals(testRezept.getAnweisungen().size(), 1);
        assertEquals(testRezept.getAnweisungen().get(0), "ANW1");
    }

    @Test public void stringTest(){
        var testRezept = new Rezept("testrezept", 0, new ArrayList<Zutat>(), new ArrayList<String>());
        testRezept.anweisungHinzufuegen("ANW0");
        testRezept.zutatHinzufuegen(testZutat1);
        testRezept.zutatHinzufuegen(testZutat2);
        String rezeptStr = testRezept.toString();
        String erwarteterStr = "Name: testrezept\nDauer: 0\nZutaten: \n10 Milch\n5 Brot\nAnweisungen: \nANW0\n";
        assertEquals(erwarteterStr, rezeptStr);
    }
}
