import Datenstrukturen.BeispielRezepte;
import Datenstrukturen.Rezeptbuch;
import GUIElemente.HauptPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Hauptklasse des Programms. Startes die GUI und erzeugt das Root-Element
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Rezeptbuch wird aktuell mithilfe einer Testklasse konstruiert
        Rezeptbuch rb = BeispielRezepte.testRezBuch();

        // Das Root-Element des Programms
        BorderPane hauptPane = new HauptPane(rb);

        // Erzeuge das Fenster
        Scene scene = new Scene(hauptPane, 400, 500);
        stage.setTitle("Rezeptbuch-TestApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(); // Startet das Programm über sie start-Methode
    }

}