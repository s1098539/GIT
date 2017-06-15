package Main;

import Model.Kleur;
import Model.Rol;
import Model.Speler;
import View.SpelView;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class Main2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SpelView spelView = new SpelView();
        primaryStage.setScene(spelView.getScene());
        primaryStage.setTitle("Flash point");
        primaryStage.show();
        System.out.println("The Application has started.");
        //TODO DEBUG

//        Speler test = new Speler("Sam", Kleur.ROOD, "127", 0, 0, 0, 0, Rol.COMMANDANT, true);

    }

}
