import Datenstrukturen.Rezeptbuch;
import GUIElemente.HauptPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Hauptklasse des Programms. Startes die GUI und erzeugt das Root-Element
 */
public class Main extends Application {

    Rezeptbuch rezeptbuch;

    @Override
    public void start(Stage stage) {

        // Rezeptbuch wird aktuell mithilfe einer Testklasse konstruiert
        rezeptbuch = new SaveManager().load();

        // Das Root-Element des Programms
        BorderPane hauptPane = new HauptPane(rezeptbuch);

        // Erzeuge das Fenster
        Scene scene = new Scene(hauptPane, 400, 500);
        stage.setTitle("Rezeptbuch");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> onClose(e));
        stage.show();
    }

    /**
     * Diese Methode wird beim Schließen ausgeführt und speichert die neue Rezeptliste
     * @param e das übergebene "Fenster schließen"-Event
     */
    public void onClose(WindowEvent e) {
        new SaveManager().save(rezeptbuch);
    }

    public static void main(String[] args) {
        launch(); // Startet das Programm über sie start-Methode
    }



}