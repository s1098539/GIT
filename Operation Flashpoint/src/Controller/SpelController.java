package Controller;

/**
 * Created by Joep Oonk on 14-6-2017.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SpelController {
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
    private StackPane stackpane;
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

    public GridPane getGridpane() {
        return gridpane;
    }

    public void setGridpane(GridPane gridpane) {
        this.gridpane = gridpane;
    }



    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;

    public void setControllers(SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC) {
        this.veldC = veldC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
    }

    public SpelController(SpeelveldController veldC) {
        this.veldC = veldC;
    }

    public SpelController() {
    }

    public void initialize() throws Exception {
        quit.setOnAction(event ->{
            System.out.println("QUIT");
        });
    }
}
