package Datenstrukturen;

import java.io.Serializable;
import java.util.List;

public class Rezept implements Serializable {
    private String name;
    private int dauer;
    private List<Zutat> zutaten;
    private List<String> anweisungen;

    /**
     * Konstruktor der Klasse
     * @param rezeptname Titel des Rezepts
     * @param rezeptdauer Zubereitungsdauer des Rezepts
     * @param rezeptzutaten Liste der benötigten Zutaten
     * @param rezeptanweisungen Liste der Anweisungsschritte
     */
    public Rezept(String rezeptname, int rezeptdauer, List<Zutat> rezeptzutaten, List<String> rezeptanweisungen) {
        this.name = rezeptname;
        this.dauer = rezeptdauer;
        this.zutaten = rezeptzutaten;
        this.anweisungen = rezeptanweisungen;
    }

    /**
     * Füge Zutat zur Zutatenliste hinzu
     * @param zutat die hinzuzufügende Datenstrukturen.Zutat
     */
    public void zutatHinzufuegen(Zutat zutat) {
        this.zutaten.add(zutat);
    }

    /**
     * Entferne Zutat aus dem Rezept
     * @param zutat die zu entfernende Zutat
     */
    public void zutatEntfernen(Zutat zutat) {
        this.zutaten.remove(zutat);
    }

    /**
     * Füge neue Anweisung zum Rezept hinzu
     * @param anweisung Text der neuen Anweisung
     */
    public void anweisungHinzufuegen(String anweisung) {
        this.anweisungen.add(anweisung);
    }

    /**
     * Entferne Anweisung aus der Anweisungsliste
     * @param anweisung Die zu entfernenede Anweisung
     */
    public void anweisungEntfernen(String anweisung) {
        this.anweisungen.remove(anweisung);
    }

    /**
     * Konvertiere Rezept zu einem menschlich lesbaren String
     * @return Der Rezepttext
     */
    public String toString() {
        String rezept = "Name: " + name + "\n" + "Dauer: " + dauer + "\n";
        rezept = rezept + "Zutaten: \n" + zutatenToString();
        rezept = rezept + "Anweisungen: \n" + anweisungenToString();
        return rezept;
    }

    /**
     * Konvertiere Liste der Zutaten zu einem menschlich lesbaren String
     * @return die Zutatenliste als String
     */
    public String zutatenToString() {
        String zutatenStr = "";
        for (Zutat zutat : zutaten) {
            zutatenStr = zutatenStr + zutat.toString() + "\n";
        }
        return zutatenStr;
    }

    /**
     * Konvertiere Liste der Anweisungen zu einem menschlich lesbaren String
     * @return die Liste der Anweisungen als String
     */
    public String anweisungenToString() {
        String anweisungenStr = "";
        for (String anweisung : anweisungen) {
            anweisungenStr = anweisungenStr + anweisung + "\n";
        }
        return anweisungenStr;
    }

    /* Getter und Setter */

    // gibt name-Attribut
    public String getName() {
        return name;
    }

    // setzt name-Attribut
    public void setName(String name) {
        this.name = name;
    }

    // gibt dauer-Attribut
    public int getDauer() {
        return dauer;
    }

    // setzt dauer-Attribut
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    // gibt die Zutatenliste
    public List<Zutat> getZutaten() {
        return zutaten;
    }

    // setzt Zutatenliste
    public void setZutaten(List<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    // gibt die Anweisungs-Liste
    public List<String> getAnweisungen() {
        return anweisungen;
    }

    // setzt Anweisungsliste
    public void setAnweisungen(List<String> anweisungen) {
        this.anweisungen = anweisungen;
    }
}