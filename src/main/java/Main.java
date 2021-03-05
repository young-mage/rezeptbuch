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

    public Rezept testRezept1() {
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

        return new Rezept("Nudeln",10,zutaten,anweisungen);
    }

    public Rezept testRezept2() {
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

    public Rezeptbuch testBuch(){
        ArrayList<Rezept> rezepte = new ArrayList<Rezept>();
        rezepte.add(testRezept1());
        rezepte.add(testRezept2());
        return new Rezeptbuch(rezepte);
    }

    @Override
    public void start(Stage stage) {

        Rezeptbuch rb = testBuch();

        ScrollPane rezeptScroll = new RezeptScrollListe(rb.getRezepte());

        Button newBtn = new Button("Neu");
        /*
        newBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e) {
                System.out.println("Hello World");
            }
        });*/
        Button saveBtn = new Button("Speichern");
        Button deleteBtn = new Button("Löschen");
        FlowPane buttonPane = new FlowPane();
        buttonPane.getChildren().addAll(newBtn, saveBtn, deleteBtn);

        Label nameLbl = new Label("Name:");
        Label zutatenLbl = new Label("Zutaten:");
        TextField nameField = new TextField();
        TextArea zutatenArea = new TextArea();
        GridPane inputGrid = new GridPane();
        inputGrid.add(nameLbl, 0, 0);
        inputGrid.add(zutatenLbl, 0, 1);
        inputGrid.add(nameField, 1, 0);
        inputGrid.add(zutatenArea, 1, 1);

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(buttonPane);
        borderPane.setCenter(inputGrid);
        borderPane.setTop(rezeptScroll);

        Scene scene = new Scene(borderPane, 640, 480);

        stage.setTitle("Rezeptbuch-TestApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}