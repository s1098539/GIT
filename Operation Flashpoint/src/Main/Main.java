package Main;

import View.LobbyView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by joep on 15-06-17.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        LobbyView lobbyView = new LobbyView();
        stage.setScene(lobbyView.getScene());
        stage.setTitle("Lobby");
        stage.show();
    }
}
