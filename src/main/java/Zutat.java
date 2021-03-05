public class Zutat {
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