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
        ArrayList<Zutat> testZutListe = new ArrayList<Zutat>();
        var testRezept = new Rezept("", 0, testZutListe, null);
        testRezept.zutatHinzufuegen(testZutat1, 0);
        assertEquals(1, testRezept.zutaten.size());

        ArrayList<Zutat> sollListe = new ArrayList<Zutat>();
        sollListe.add(testZutat1);
        assertEquals(testRezept.zutaten, sollListe);
    }

    @Test public void testZutatEntfernen(){
        ArrayList<Zutat> testZutListe = new ArrayList<Zutat>();
        var testRezept = new Rezept("", 0, testZutListe, null);
        testRezept.zutatHinzufuegen(testZutat1);
        testRezept.zutatHinzufuegen(testZutat2);
        testRezept.zutatEntfernen(1);
        assertEquals(testRezept.zutaten.size(), 1);
        assertEquals(testRezept.zutaten.get(0), testZutat1);
    }

    @Test public void testAnweisungHinzufuegen(){
        ArrayList<String> testAnwListe = new ArrayList<String>();
        var testRezept = new Rezept("", 0, null, testAnwListe);
        testRezept.anweisungHinzufuegen("ANW0", 0);
        assertEquals(1, testRezept.anweisungen.size());

        ArrayList<String> sollListe = new ArrayList<String>();
        sollListe.add("ANW0");
        assertEquals(testRezept.anweisungen, sollListe);
    }

    @Test public void testAnweisungEntfernen(){
        ArrayList<String> testAnwListe = new ArrayList<String>();
        var testRezept = new Rezept("", 0, null, testAnwListe);
        testRezept.anweisungHinzufuegen("ANW0");
        testRezept.anweisungHinzufuegen("ANW1");
        testRezept.anweisungEntfernen(1);
        assertEquals(testRezept.anweisungen.size(), 1);
        assertEquals(testRezept.anweisungen.get(0), "ANW0");
    }

    @Test public void stringTest(){
        ArrayList<Zutat> testZutListe = new ArrayList<Zutat>();
        ArrayList<String> testAnwListe = new ArrayList<String>();
        var testRezept = new Rezept("testrezept", 0, testZutListe, testAnwListe);
        testRezept.anweisungHinzufuegen("ANW0");
        testRezept.zutatHinzufuegen(testZutat1);
        String rezeptStr = testRezept.toString();
        String erwarteterStr = "Name: testrezept\nDauer: 0\nZutaten: \n10 Milch\n5 Brot\nAnweisungen: \nANW0\n";
    }
}
