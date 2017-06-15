package View;


import Controller.LobbyController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class LobbyView {
    Scene scene;

    public LobbyView(){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("LobbyView.fxml"));
        } catch (IOException e){
            e.printStackTrace();
        }
        scene = new Scene(root, 400, 400);
    }
    public Scene getScene(){return scene;}

}
