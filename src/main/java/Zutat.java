public class Zutat {
    private String name;
    private int menge;

    /**
     * Konstruktor der Klasse
     * @param zutatenname Name der Zutat
     * @param zutatenmenge Menge der Zutat
     */
    public Zutat(String zutatenname, int zutatenmenge) {
        this.name = zutatenname;
        this.menge = zutatenmenge;
    }

    /**
     * Gibt Zutat als melschlich lesbaren String zurück
     * @return Der Zutat-Text
     */
    public String toString() {
        return menge + " " + name;
    }

    //Gibt name-Attribut zurück
    public String getName(){
        return name;
    }

    //Setzt name-Attribut
    public void setName(String name){
        this.name = name;
    }

    //Gibt menge-Attribut zurück
    public int getMenge(){
        return menge;
    }

    //Setzt menge-Attribut
    public void setMenge(int menge){
        this.menge = menge;
    }
}