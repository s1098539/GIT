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

//        launch(args);
        Vak vak = new Vak();
        vak.setBoven(Status.MUUR2);
        if(vak.getBoven().isBegaanbaar() == false) {
            System.out.println("nee");
        } else {
            System.out.println("ja");
        }

    }
}
