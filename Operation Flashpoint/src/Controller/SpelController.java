package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SpelController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private GridPane gridpane;
    @FXML
    private Button btnUP;
    @FXML
    private Button btnLEFT;
    @FXML
    private Button btnRIGHT;
    @FXML
    private Button btnDOWN;
    @FXML
    private Button btnEndTurn;
    @FXML
    private ImageView imgHakken;
    @FXML
    private ImageView imgOpenendeur;
    @FXML
    private ImageView imgBrandblusser;
    @FXML
    private ImageView imgRijden;
    @FXML
    private ImageView imgWagenblussen;
    @FXML
    private ImageView imgPickup;
    @FXML
    private ImageView imgRolswap;
    @FXML
    private Button btnSpecial;
    @FXML
    private TextArea chatArea;
    @FXML
    private TextField textInput;
    @FXML
    private Button stuur;
    @FXML
    private VBox vboxchat;
    @FXML
    private HBox chatSize;
    @FXML
    private Button groterChat;
    @FXML
    private Button kleinerChat;
    @FXML
    TextInputDialog dialog = new TextInputDialog("");
    @FXML
    TextInputDialog dialog2 = new TextInputDialog("");
    @FXML
    private VBox chatVenster;
    @FXML
    private HBox minMaxknoppen;
    @FXML
    private HBox stuurKnopEnTextField;
    @FXML
    private Button chatTop;
    @FXML
    private Button options;
    @FXML
    private Button veranderKlasse;
    @FXML
    private Button quit;

    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;

    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC) {
        this.veldC = veldC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
    }

    public SpelController() throws IOException {

    }

    public void run() {
        System.out.print("run: ");
        System.out.println(getStackPane());
        stackPane.getChildren().add(veldC.getVeld().getGridPane());
    }

    public void initialize() throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.print("initialize: ");
        System.out.println(getStackPane());
    }

    public StackPane getStackPane() {
        return stackPane;
    }

    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }
}
