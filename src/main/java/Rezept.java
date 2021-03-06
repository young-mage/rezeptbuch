import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Rezept {
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
     * @param zutat die hinzuzufügende Zutat
     */
    public void zutatHinzufuegen(Zutat zutat) {
        this.zutaten.add(zutat);
    }

    /**
     * Füge Zutat an bestimmter Stelle hinzu
     * @param zutat die hinzuzufügende Zutat
     * @param position der Index der neuen Zutat
     */
    public void zutatHinzufuegen(Zutat zutat, int position) {
        this.zutaten.add(position, zutat);
    }

    /**
     * Entferne Zutat aus dem Rezept
     * @param position der Index der entfernten Zutat
     */
    public void zutatEntfernen(int position) {
        this.zutaten.remove(position);
    }

    /**
     * Füge neue Anweisung zum Rezept hinzu
     * @param anweisung Text der neuen Anweisung
     */
    public void anweisungHinzufuegen(String anweisung) {
        this.anweisungen.add(anweisung);
    }

    /**
     * Füge Anweisung an bestimmter Stelle zum Rezept hinzu
     * @param anweisung Text der neuen Anweisung
     * @param position Index der Anweisung
     */
    public void anweisungHinzufuegen(String anweisung, int position) {
        this.anweisungen.add(position, anweisung);
    }

    /**
     * Entferne Anweisung aus der Anweisungsliste
     * @param position Index der zu entfernenden Anweisung
     */
    public void anweisungEntfernen(int position) {
        this.anweisungen.remove(position);
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

    public String zutatenToString() {
        String zutatenStr = "";
        for (Zutat zutat : zutaten) {
            zutatenStr = zutatenStr + zutat.toString() + "\n";
        }
        return zutatenStr;
    }

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