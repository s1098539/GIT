package Main;

import Controller.*;
import View.LobbyView;
import View.SpelView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by lion on 14-06-17.
 */
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LobbyView lobbyView = new LobbyView();
        stage.setScene(lobbyView.getScene());
        stage.setTitle("Lobby");
        stage.show();
    }
}
