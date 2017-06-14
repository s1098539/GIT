package View;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class LobbyView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button oke = new Button("OKE");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(oke);


        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(vbox);

        Pane pane = new Pane(borderPane);
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lobby");
        primaryStage.show();
    }
}
