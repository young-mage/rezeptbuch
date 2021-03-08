package Datenstrukturen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rezeptbuch {

    private List<Rezept> rezepte;

	/**
	 * Default-Konstruktor mit leerer Rezeptliste
	 */
	public Rezeptbuch(){
    	rezepte = new ArrayList<Rezept>();
	}

	/**
	 * Rezeptbuch-Konstruktor mit gegebener Rezeptliste
	 * @param rezepte Liste der Rezepte
	 */
	public Rezeptbuch(List<Rezept> rezepte) {
        this.rezepte = rezepte;
    }

	/**
	 * Füge Datenstrukturen.Rezept zum Datenstrukturen.Rezeptbuch hinzu
	 * @param rezept das hinzuzufügende Datenstrukturen.Rezept
	 */
	public void rezeptHinzufuegen(Rezept rezept) {
    	this.rezepte.add(rezept);
    }

	/**
	 * Entferne gegebenes Rezept aus dem Rezeptbuch
	 * @param rezept Datenstrukturen.Rezept, das zu entfernen ist
	 */
    public void rezeptEntfernen(Rezept rezept) {
    	this.rezepte.remove(rezept);
    }

	/**
	 * Nimmt einen Rezept-Pointer entgegen und ersetzt diesen mit einem anderen Rezept
	 * @param altesRezept Rezept, das zu ersetzen ist
	 * @param neuesRezept Neues Rezept, welches das alte ersetzen soll
	 */
	public void rezeptSetzen(Rezept altesRezept, Rezept neuesRezept) {
		rezepte.set(rezepte.indexOf(altesRezept), neuesRezept);
	}

	/**
	 * Konvertiere das Rezept zu einem menschlich lesbaren String
	 * @return das konvertierte Rezeptbuch als String
	 */
    public String toString() {
    	String rezeptbuch = "Rezeptbuch: \n";
    	for (Rezept rezept : rezepte) {
    		rezeptbuch = rezeptbuch + rezept.toString() + "\n";
    	}
    	return rezeptbuch;
    }

    /* Getter und Setter */

	// Gibt Rezeptliste
	public List<Rezept> getRezepte() {
		return rezepte;
	}

	// Setzt Rezeptliste
	public void setRezepte(List<Rezept> rezepte) {
		this.rezepte = rezepte;
	}
}
