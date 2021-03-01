import java.util.ArrayList;
import java.util.List;

public class Rezeptbuch {
    public static class Rezept {
        String name;
        int dauer;
        List<Zutat> zutaten;
        List<String> anweisungen;

        public Rezept(String rezeptname, int rezeptdauer, List<Zutat> rezeptzutaten, List<String> rezeptanweisungen) {
            this.name = rezeptname;
            this.dauer = rezeptdauer;
            this.zutaten = rezeptzutaten;
            this.anweisungen = rezeptanweisungen;
        }

        public void zutatHinzufuegen(Zutat zutat, int position) {
        	this.zutaten.add(zutat);
        }

        public void zutatEntfernen(int position) {
        	this.zutaten.remove(0);
        }

        public void anweisungHinzufuegen(String anweisung, int position) {
        	this.anweisungen.add(dauer, anweisung);
        }

        public void anweisungEntfernen(int position) {
        	this.anweisungen.remove("position");
        }

        public String toString() {
        	String rezept = "Name: " + name + "\n" + "Dauer: " + dauer + "\n";
        	rezept = rezept + "Zutaten: \n";
        	for (Zutat zutat : zutaten) {
        		rezept = rezept + zutat.toString() + "\n";
        	}
        	rezept = rezept + "Anweisungen: \n";
        	for (String anweisung : anweisungen) {
        		rezept = rezept + anweisung + "\n";
        	}
        	return rezept;
        }

    }

    public static class Zutat {
        String name;
        int menge;


        public Zutat(String zutatenname, int zutatenmenge) {
            this.name = zutatenname;
            this.menge = zutatenmenge;
        }

        public String toString() {
            return menge + " " + name;
        }
    }

    List<Rezept> rezepte;

    public Rezeptbuch(List<Rezept> rezepte) {
        this.rezepte = rezepte;
    }

    public void rezeptHinzufuegen(Rezept rezept) {
    	this.rezepte.remove(rezept);
    }

    public void rezeptEntfernen(Rezept rezept) {
    	this.rezepte.add(rezept);
    }

    public String toString() {
    	String rezeptbuch = "Rezeptbuch: \n";
    	for (Rezept rezept : rezepte) {
    		rezeptbuch = rezeptbuch + rezept.toString() + "\n";
    	}
    	return rezeptbuch;
    }

    public static void main(String[] args) {

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

    	Rezept rezept = new Rezept("Nudeln",10,zutaten,anweisungen);

    	List<Rezept> rezepte = new ArrayList<Rezept>();
    	rezepte.add(rezept);

    	Rezeptbuch rezeptbuch = new Rezeptbuch(rezepte);

    	System.out.println(rezeptbuch.toString());

    }
}
