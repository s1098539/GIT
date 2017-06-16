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

    public SpelController() {
    }

    public void initialize() throws Exception {
        quit.setOnAction(event ->{
            System.out.println("QUIT");
        });
    }

    //beurtAfhandelers
    public void nieuwRook(){

    }

    //Kijkt of er stoffen zijn die van het spel af kunnen worden gehaald.
    public void checkStoffen() {

    }

    //Kijkt of er ergens de condities voor een explosie zijn behaald, en hanteert dan deze explosie.
    public void checkExplosies(){

    }

    //Kijkt of er ergens de condities voor een vonkoverslag zijn  behaald, en hanteert dan deze explosie.
    public void checkVonkoverslagen(){

    }

    //Kijkt of er 3 personen op het bord aanwezig zijn, al is dit niet het geval, dan worden deze bijgevult
    public void checkPersonen(){

    }

    public void addStoffen(){

    }

    public void addPersoon(){

    }

    public void addVuur(){

    }

    public void checkWin(){

    }

    public void checkVerlies(){

    }

}
