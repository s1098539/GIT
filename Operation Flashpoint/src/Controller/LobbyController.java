package Controller;
import Model.Kleur;
import Model.Lobby;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class LobbyController extends Application {
    Lobby model = new Lobby();
    @FXML
    private Button btnIP;
    @FXML
    private TextField IPtext;
    @FXML
    private Button btnHelpIP;
    @FXML
    private Button btnNaam;
    @FXML
    private TextField naamText;
    @FXML
    private Button btnHelpNaam;
    Parent root;
    Scene scene;
    Stage stage;
    public LobbyController(){

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LobbyView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Lobby");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void setIPtext() throws IOException{
        model.setIp(IPtext.getText());
        getIP();
        Parent root = FXMLLoader.load(getClass().getResource("/View/NaamView.fxml"));
        stage = (Stage) btnIP.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void helpdialoog(){
        System.out.println("yeah boy");

    }

    public Kleur getSpelerKleur(){
        return model.getKleur();

    }
    public void setSpelerKleur(){
        //SpelerController.setKleur(getSpelerKleur());

    }
    public void getIP(){
        System.out.println(model.getIp());
    }
    @FXML
    public void naamHelp(){
        System.out.println("eindelijk");

    }
    @FXML
    public void setNaam(){
        System.out.println("eindelijk");

    }


}
