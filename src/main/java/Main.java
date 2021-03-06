import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Rezeptbuch rb = testRezBuch();

        BorderPane hauptPane = new HauptPane(rb);

        Scene scene = new Scene(hauptPane, 400, 500);

        stage.setTitle("Rezeptbuch-TestApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Rezept testRezept() {
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
    public Rezeptbuch testRezBuch(){
        ArrayList<Rezept> rezepte = new ArrayList<Rezept>();
        for(int i = 0; i < 20; i++) {
            rezepte.add(testRezept());
        }
        return new Rezeptbuch(rezepte);
    }

}