package View;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
        TextField text = new TextField();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(text, oke);
        vbox.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();

        pane.setCenter(vbox);

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lobby");
        primaryStage.show();
    }
}
