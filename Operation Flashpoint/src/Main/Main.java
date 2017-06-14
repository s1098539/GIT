package Main;

import View.SpelView;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class Main extends Application{
    boolean test = false;
    public static void main(String[] args) {
//        Application.launch(LobbyView.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SpelView spelView = new SpelView();
        primaryStage.setScene(spelView.getScene());
        primaryStage.setTitle("Flash point");
        primaryStage.show();
    }

}
