package Controller;

import Model.Fiche;
import Model.Richting;
import Model.Vak;
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

    @FXML private StackPane stackPane;
    @FXML private GridPane gridpane;
    @FXML private Button btnUP;
    @FXML private Button btnLEFT;
    @FXML private Button btnRIGHT;
    @FXML private Button btnDOWN;
    @FXML private Button btnET;
    @FXML private ImageView imgHakken;
    @FXML private ImageView imgOpenendeur;
    @FXML private ImageView imgBrandblusser;
    @FXML private ImageView imgRijden;
    @FXML private ImageView imgWagenblussen;
    @FXML private ImageView imgPickup;
    @FXML private ImageView imgRolswap;
    @FXML private Button btnSpecial;
    @FXML private TextArea chatArea;
    @FXML private TextField textInput;
    @FXML private Button stuur;
    @FXML private VBox vboxchat;
    @FXML private HBox chatSize;
    @FXML private Button groterChat;
    @FXML private Button kleinerChat;
    @FXML TextInputDialog dialog = new TextInputDialog("");
    @FXML TextInputDialog dialog2 = new TextInputDialog("");
    @FXML private VBox chatVenster;
    @FXML private HBox minMaxknoppen;
    @FXML private HBox stuurKnopEnTextField;
    @FXML private Button chatTop;
    @FXML private Button options;
    @FXML private Button veranderKlasse;
    @FXML private Button quit;
    int murenkapot = 0;
    Vak vak;
    boolean spawnBrandhaard;
    int hotspots = 6;
    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;

    public SpelController() throws IOException {

    }

    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC) {
        this.veldC = veldC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
    }

    // Lion, dit is de eerste methode die deze klasse runt, de stackpane wordt uit de fxml view gehaald en een gridpane word toegevoegd.
    public void run() {
        stackPane.getChildren().add(veldC.getVeld().getGridPane());
    }

    // Lion, keep this one EMPTY and DON'T REMOVE
    public void initialize() throws Exception {

    }

    // Lion, Alle set on action komt hier in
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnET.setOnAction(event -> {
            endTurn();
        });

        btnUP.setOnAction(event -> {
            spelerC.beweegNoord();
        });

        btnRIGHT.setOnAction(event -> {
            spelerC.beweegOost();
        });

        btnDOWN.setOnAction(event -> {
            spelerC.beweegZuid();
        });

        btnLEFT.setOnAction(event -> {
            spelerC.beweegWest();
        });

    }



    // Lion, word aangeroepen als op de end turn knop word gedrukt en handeld alle relevante methodes hier voor af.
    public void endTurn() {
        for(int i = 0; i<3; i++) {
            nieuwRook();
        }
        checkVonkoverslag();
        checkStoffen();
        veldC.ImageSetterALL();
    }

    public void nieuwRook() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        vak = veldC.veld.getVakken()[x][y];
        System.out.println(x+" "+y);
        if (vak.isNiks()) {
            vak.setNiks(false);
            vak.setRook(true);
            vak.setVuur(false);
            System.out.println("nieuwRook "+x+" "+y);
        } else if (vak.isRook()) {
            vak.setNiks(false);
            vak.setRook(false);
            vak.setVuur(true);
            System.out.println("nieuwVuur "+x+" "+y);
        } else if (vak.isVuur()){
            System.out.println("newExplosie "+x+" "+y);
            checkExplosie(x,y);
        }
       checkBrandhaard();
    }

    public void checkBrandhaard() {
        if(vak.isHotspot()) {
            spawnBrandhaard = true;
            nieuwRook();
        } else if(spawnBrandhaard){
            if(hotspots>0) {
                vak.setHotspot(true);
                hotspots--;
            }
            spawnBrandhaard = false;
        }
    }

    public void checkStoffen() {
        Vak vak;
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 7; y++) {
                vak=veldC.veld.getVakken()[x][y];
                if(vak.isStoffen() && vak.isVuur()) {
                    checkExplosie(x,y);
                    vak.setStoffen(false);
                }
            }
        }
    }

    public void checkExplosie(int x, int y) {// Joep
        boolean doorgaan;
        int teller;
        Vak vak;
        for (Richting richting: Richting.values()) {
            teller = 0;
            doorgaan = true;
            while (richting == Richting.BOVEN && doorgaan && ((y - teller) >= 1)) {
                vak = veldC.veld.getVakken()[x][y-teller];
                if (!vak.boven.isBegaanbaar()){
                    veldC.doeBeschadiging(x, y-teller, richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veld.getVakken()[x][y-teller];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
            while (richting == Richting.RECHTS && doorgaan && ((x + teller) <= 8)) {
                vak = veldC.veld.getVakken()[x+teller][y];
                if (!vak.rechts.isBegaanbaar()){
                    veldC.doeBeschadiging((x+teller), y, richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veld.getVakken()[x+teller][y];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
            while (richting == Richting.ONDER && doorgaan && ((y + teller) <= 6)) {
                vak = veldC.veld.getVakken()[x][y+teller];
                if (!vak.onder.isBegaanbaar()){
                    veldC.doeBeschadiging(x, (y + teller), richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veld.getVakken()[x][y+teller];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
            while (richting == Richting.LINKS && doorgaan && ((x - teller) >= 1)) {
                vak = veldC.veld.getVakken()[x-teller][y];
                if (!vak.links.isBegaanbaar()){
                    veldC.doeBeschadiging((x-teller), y, richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veld.getVakken()[x-teller][y];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
        }
    }

    public void checkVonkoverslag() {
        Vak vak;
        Vak vak2 = null;
        boolean loop = true;
        while(loop) {
            loop = false;
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 8; y++) {
                    vak = veldC.veld.getVakken()[x][y];
                    if (vak.isVuur()) {
                        for (Richting richting: Richting.values()) {
                            if (vak.getObstakelRichting(richting).isBegaanbaar()) {
                                switch (richting) {
                                    case BOVEN:
                                        if (y > 0) {
                                            vak2 = veldC.veld.getVakken()[x][y-1];
                                        }
                                        break;
                                    case RECHTS:
                                        if (x < 9) {
                                            vak2 = veldC.veld.getVakken()[x+1][y];
                                        }
                                        break;
                                    case ONDER:
                                        if (y < 7) {
                                            vak2 = veldC.veld.getVakken()[x][y+1];
                                        }
                                        break;
                                    case LINKS:
                                        if (x > 0) {
                                            vak2 = veldC.veld.getVakken()[x-1][y];
                                        }
                                        break;
                                }
                                if (vak2.isRook()) {
                                    vak2.setNiks(false);
                                    vak2.setRook(false);
                                    vak2.setVuur(true);
                                    if (richting==Richting.BOVEN || richting==Richting.LINKS) {
                                        loop = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void addPersoon() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        int[] locatie = new int[2];
        vak = veldC.veld.getVakken()[x][y];
        while(vak.isVuur()){
            locatie = veldC.volgPijl(x,y);
            x = locatie[0];
            y = locatie[1];
            vak = veldC.veld.getVakken()[x][y];
        }


    }

    //TODO checkPersonen()

    //TODO checkWin()

    //TODO checkVerlies()
}
