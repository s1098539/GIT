package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Flash point");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        View view = new View();
//        Speelveld speelveld = new Speelveld();
//        BeurtAfronding beurtAfronding = new BeurtAfronding(speelveld,6);
//        Speler speler = new Speler("Joepin",Kleur.GROEN,3,4,speelveld);
        Controller controller = new Controller(view/*,beurtAfronding,speelveld,speler*/);
        launch(args);
    }
}
