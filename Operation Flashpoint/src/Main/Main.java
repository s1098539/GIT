package Main;

import Controller.DobbelsteenController;
import Controller.SpeelveldController;
import Controller.SpelController;
import Controller.SpelerController;
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

        SpeelveldController veldC = new SpeelveldController();
        SpelController spelC = new SpelController();
        SpelerController spelerC = new SpelerController();
        DobbelsteenController dobbelC = new DobbelsteenController();

        veldC.setControllers(spelC,spelerC,dobbelC);
        spelC.setControllers(veldC,spelerC,dobbelC);
        spelerC.setControllers(veldC,spelC,dobbelC);
        dobbelC.setControllers(veldC,spelC,spelerC);
    }
}
