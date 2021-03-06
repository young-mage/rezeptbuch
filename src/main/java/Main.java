import Datenstrukturen.BeispielRezepte;
import Datenstrukturen.Rezeptbuch;
import GUIElemente.HauptPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Rezeptbuch rb = BeispielRezepte.testRezBuch();

        BorderPane hauptPane = new HauptPane(rb);

        Scene scene = new Scene(hauptPane, 400, 500);

        stage.setTitle("Rezeptbuch-TestApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}