import javafx.scene.control.ScrollPane;

import java.util.List;

public class RezeptScrollListe extends ScrollPane {

    private List<Rezept> rezepte;
    public RezeptScrollListe(List<Rezept> rezepte){
        this.rezepte = rezepte;
    }

}
