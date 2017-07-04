package controller;

import enumerators.Rol;
import main.Interface;
import model.*;
import enumerators.Kleur;
import enumerators.Persoon;
import enumerators.Richting;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.util.Pair;

import java.io.*;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.util.List;

import static enumerators.Rol.*;

public class SpelController implements Initializable {

    @FXML private AnchorPane thePane;
    @FXML private Label blusTxt;
    @FXML private Label hakTxt;
    @FXML private Label spuitTxt;
    @FXML private Label APLabel;
    @FXML private Label EPLabel;
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
    @FXML private ImageView imgPickup1;
    @FXML private ImageView imgRolswap;
    @FXML private ImageView imgPva;
    @FXML private ImageView imgBrandHaard;
    @FXML private ImageView imgSchade;
    @FXML private ImageView imgOpenendeur1;
    @FXML private ImageView doodCounter;
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
    @FXML private Button gebruikershandleiding;
    @FXML private Label BeschadigingLabel;
    @FXML private Label HotspotLabel;
    @FXML private Label GeredLabel;
    @FXML private Label GeredLabel1;
    @FXML private Label user1;
    @FXML private Label user2;
    @FXML private Label user3;
    @FXML private Label user4;
    @FXML private Label user5;
    @FXML private Label user6;
    @FXML private Label rol1;
    @FXML private Label rol2;
    @FXML private Label rol3;
    @FXML private Label rol4;
    @FXML private Label rol5;
    @FXML private Label rol6;
    @FXML private ImageView user1Img;
    @FXML private ImageView user2Img;
    @FXML private ImageView user3Img;
    @FXML private ImageView user4Img;
    @FXML private ImageView user5Img;
    @FXML private ImageView user6Img;
    @FXML private Button btnRefresh;
    @FXML private ImageView background;


    Vak vak;
    boolean spawnBrandhaard;
    int hotspots = 6;
    String localMessage = "";
    String host = "127.0.0.1";
    String username = "";
    Spel spel;
    int i = 0;
    int b = 0;
    Registry registry = null;
    int port = 1099;
    Interface clientStub;
    Kleur kleur;
    boolean myTurn;

    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;
    ChatController chatC;
    SpraakController spraakC;
    SpelController spelC;
    Boolean invalidCoordinates;

    private void eersteBeurt() {
            invalidCoordinates = false;
            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Kies een start positie buiten het huis");

            // Set the button types.
            ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(loginButtonType);

            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(20, 150, 10, 10));

            TextField from = new TextField();
            from.setPromptText("X");
            TextField to = new TextField();
            to.setPromptText("Y");

            gridPane.add(new Label("X:"), 0, 0);
            gridPane.add(from, 1, 0);
            gridPane.add(new Label("Y:"), 2, 0);
            gridPane.add(to, 3, 0);

            dialog.getDialogPane().setContent(gridPane);
                Platform.runLater(() -> from.requestFocus());

                dialog.setResultConverter(dialogButton -> {
                    if (dialogButton == loginButtonType) {
                        return new Pair<>(from.getText(), to.getText());
                    }
                    return null;
                });

                Optional<Pair<String, String>> result = dialog.showAndWait();

                result.ifPresent(pair -> {
                    int x;
                    int y;
                    if(pair.getKey().equals("")) x = 0;
                    else x = Integer.parseInt(pair.getKey());
                    if(pair.getValue().equals("")) y = 0;
                    else y = Integer.parseInt(pair.getValue());
                    Speler speler = null;
                    for(int i = 0; i < spel.getSpelers().size(); i++) {
                        if(spel.getSpelers().get(i).getKleur() == kleur) {
                            speler = spel.getSpelers().get(i);
                        }
                    }
                    if(y>7 || x>9 || y<0 || x<0) invalidCoordinates = true;
                    for (int y1 = 1; y1 < 7; y1++) {
                        for (int x1 = 1; x1 < 9; x1++) {
                            if (x == x1 && y == y1) invalidCoordinates = true;
                        }
                    }
                    if (!invalidCoordinates) {
                        veldC.addSpeler(kleur, x, y);
                        speler.setX(x);
                        speler.setY(y);
                    }
                    else {
                        veldC.addSpeler(kleur, 0, 0);
                        speler.setX(0);
                        speler.setY(0);
                    }
                });
    }

    public void maakSpelers() throws RemoteException {

        for(int i = 0; i < clientStub.GetSpeler().size(); i++) {
            spel.setSpelers(clientStub.GetSpeler());
            spel.setHuidigeSpeler(spel.getSpelers().get(0));
        }
//            spel.setSpelers(new Speler("Michiel", Kleur.BLAUW, 0, 0));
//            spel.setSpelers(new Speler("Joep", Kleur.GEEL, 1, 0));
//            spel.setSpelers(new Speler("Norddin", Kleur.GROEN, 2, 0));
//            spel.setSpelers(new Speler("Sam", Kleur.ORANJE, 3, 0));
//            spel.setSpelers(new Speler("Calvin", Kleur.ROOD, 4, 0));
//            spel.setSpelers(new Speler("Lion", Kleur.ZWART, 5, 0));
        setNamen();
        spel.setHuidigeSpeler(spel.getSpelers().get(0));
    }

    public void switchSpeler() {
        for(int i = 0; i < spel.getSpelers().size(); i++){
            if(spel.getHuidigeSpeler()==spel.getSpelers().get(i)){
                if (i==(spel.getSpelers().size()-1)){
                    spel.setHuidigeSpeler(spel.getSpelers().get(0));

                    break;
                }
                else{
                    System.out.println(spel.getSpelers().size());
                    spel.setHuidigeSpeler(spel.getSpelers().get(i+1));

                    break;
                }

            }

        }
    }



    public Kleur getKleur() {return kleur;}

    public void setKleur(Kleur kleur) {this.kleur = kleur;}

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Spel getSpel() {
        return spel;
    }

    public void setSpel(Spel spel) {
        this.spel = spel;
    }

    public String getLocalMessage() {
        return localMessage;
    }

    public void setLocalMessage(String localMessage) {
        this.localMessage = localMessage;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TextArea getChatArea() {
        return chatArea;
    }

    public TextField getTextInput() {
        return textInput;
    }

    public Button getStuur() {
        return stuur;
    }

    public Button getGroterChat() {
        return groterChat;
    }

    public Button getKleinerChat() {
        return kleinerChat;
    }

    public Button getQuit() {
        return quit;
    }



    public SpelController() throws IOException {
        spel = new Spel(6);


    }

    // verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC, ChatController chatC, SpelController spelC, SpraakController spraakC) {
        this.veldC = veldC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;
        this.spelC = spelC;
        this.spraakC = spraakC;
    }

    // dit is de eerste methode die deze klasse runt, de stackpane wordt uit de fxml view gehaald en een gridpane word toegevoegd.
    public void run() throws RemoteException, NotBoundException {
        registry = LocateRegistry.getRegistry(spelC.getHost());
        clientStub = (Interface) registry.lookup("main.Interface");
        getChatArea().setEditable(false);
        String naam = getUsername();
        setKleur(clientStub.addSpeler(naam));
        veldC.carViewFactory();
        veldC.carSetter();
        stackPane.getChildren().add(veldC.veldI.getCarViews()[0]);
        stackPane.getChildren().add(veldC.veldI.getCarViews()[1]);
        stackPane.getChildren().add(veldC.getVeldI().getGridPane());
        maakSpelers();
        spel.setHuidigeSpeler(spel.getSpelers().get(0));

        setActiveSpelerPlaatje();
        long seed = System.nanoTime();

        toewijzenRollen();
        setRollen();
        spelerC.resetPunten();
        for (Persoon persoon : Persoon.values()) {
            veldC.getVeldD().getPersonenlijst().add(persoon);
        }
        Collections.shuffle(veldC.getVeldD().getPersonenlijst(), new Random(seed));
        eersteBeurt();

        checkTurn();
    }

    // keep this one EMPTY and DON'T REMOVE
    public void initialize() throws Exception {

    }

    // Alle set on action komt hier in
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SpraakController audioPlayer = new SpraakController();

        imgPickup1.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playSchade(spel.getHuidigeSpeler().getActiepunten());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgSchade.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playSchade(spelC.spel.getBeschadigingCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPva.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playPva(spelC.spel.getGeredCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgBrandHaard.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playBrandHaard(spelC.spel.getHotspotCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPickup1.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {

                try {
                    audioPlayer.playAP(spel.getHuidigeSpeler().getActiepunten());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgOpenendeur1.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playEP(spel.getHuidigeSpeler().getExtrapunten());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnET.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playEindigZet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgBrandblusser.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playBlussen(spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgBrandblusser.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {

                try {
                    audioPlayer.playBlussen(spelC.spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPickup.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playOppakken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnLEFT.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnLEFT.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnRIGHT.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnUP.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnDOWN.setOnContextMenuRequested(event ->{
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnSpecial.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playSpecial(spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgHakken.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playHakken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgWagenblussen.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playWagenBlussen(spelC.spel.getHuidigeSpeler().getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgOpenendeur.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playDeurActies();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPickup.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playOppakken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgRijden.setOnContextMenuRequested(event -> {
            if (spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playRijden();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgRolswap.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playRolWissel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        doodCounter.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {

                try {
                    audioPlayer.playDood(spelC.spel.getDoodCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gebruikershandleiding.setOnContextMenuRequested(event ->{
            if(spel.getHuidigeSpeler().isSlechtziendmodus()) {
                try {
                    audioPlayer.playSpelRegels(spraakC.audio.getSpelregels());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnET.setOnAction(event -> {
            endTurn();
        });

        btnUP.setOnAction(event -> {
            spelerC.noord();
            updateSpel();
        });

        thePane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.P) {
                endTurn();
            }
            if(myTurn) {
                if (e.getCode() == KeyCode.A) {
                    spelerC.west();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.D) {
                    spelerC.oost();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.W) {
                    spelerC.noord();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.S) {
                    spelerC.zuid();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.ENTER) {
                    endTurn();
                }
                if (e.getCode() == KeyCode.R) {
                    spelerC.special();

                }
                if (e.getCode() == KeyCode.Q) {
                    spelerC.btnHakken();

                }
                if (e.getCode() == KeyCode.E) {
                    spelerC.btnOpenenDeur();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.G) {
                    for (int i = 0; i < spelC.spel.getSpelers().size(); i++) {
                        spelC.spel.getSpelers().get(i).setRol(GODMODE);
                    }
                    setRollen();
                    spelerC.resetPunten();
                    updatePunten();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.DIGIT1) {
                    spelerC.oppakkenActie();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.DIGIT2) {
                    spelerC.btnBrandblusser();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.DIGIT3) {
                    spelerC.btnRijden();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.DIGIT4) {
                    spelerC.BrandweerwagenSpuitActie();
                    updateSpel();
                }
                if (e.getCode() == KeyCode.DIGIT5) {
                    veranderKlasse();
                    enableKnoppen();
                }

                toggleViewUpdate();
            }
        });


        btnRIGHT.setOnAction(event -> {
            spelerC.oost();
            updateSpel();
        });

        btnDOWN.setOnAction(event -> {
            spelerC.zuid();
            updateSpel();
        });

        btnLEFT.setOnAction(event -> {
            spelerC.west();
            updateSpel();
        });

        imgOpenendeur.setOnMouseClicked(event -> {
            spelerC.btnOpenenDeur();
            toggleViewUpdate();
            updateSpel();
        });

        imgBrandblusser.setOnMouseClicked(event -> {
            spelerC.btnBrandblusser();
            toggleViewUpdate();
            updateSpel();
        });

        imgHakken.setOnMouseClicked(event -> {
            spelerC.btnHakken();
            toggleViewUpdate();
            updateSpel();
        });

        imgRijden.setOnMouseClicked(event -> {
            spelerC.btnRijden();
            toggleViewUpdate();
            updateSpel();
        });

        imgWagenblussen.setOnMouseClicked(event -> {
            spelerC.BrandweerwagenSpuitActie();
            updateSpel();
        });

        stuur.setOnAction(event -> {
            chatC.stuurBericht();
        });

        textInput.setOnAction(e -> {
            chatC.stuurBericht();
        });

        groterChat.setOnAction(event -> {
            chatC.groterChat();
        });

        kleinerChat.setOnAction(event -> {
            chatC.kleinerChat();
        });

        gebruikershandleiding.setOnAction(event -> {
            spelerC.openHandleiding();
        });

        btnSpecial.setOnAction(event -> {
            spelerC.special();
            updateSpel();
        });

        imgRolswap.setOnMouseClicked(event -> {
            veranderKlasse();
            updateSpel();
            enableKnoppen();
        });

        quit.setOnAction(event -> {
            System.exit(0);
        });

        imgPickup.setOnMouseClicked(event -> {
            spelerC.oppakkenActie();
            toggleViewUpdate();
            updateSpel();
        });
        options.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Options");
            alert.setHeaderText("Wilt u opslaan/laden of de slechtzienmodes toggelen.");
            alert.setContentText("Maak uw keuze.");

            ButtonType buttonTypeOne = new ButtonType("slechtziend");
            ButtonType buttonTypeTwo = new ButtonType("Save/Load");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Slechtziendmodus");
                alert.setHeaderText("Wilt u slechtziendheids-modus toggelen?");
                alert.setContentText("Druk dan op Oke");
                if (spel.getHuidigeSpeler().isSlechtziendmodus()){
                    alert.setContentText("U bevind zich op de slechtziendenmodus");
                } else {
                    alert.setContentText("U bevind zich niet op de slechtziendenmodus.");
                }

                result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    if(spel.getHuidigeSpeler().isSlechtziendmodus()){
                        spel.getHuidigeSpeler().setSlechtziendmodus(false);
                    }
                    else{
                        spel.getHuidigeSpeler().setSlechtziendmodus(true);
                    }
                } else {
                    alert.close();
                }
            } else if (result.get() == buttonTypeTwo) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Bestaand spel openen/opslaan.");
                alert.setHeaderText("Wil je het spel openen of opslaan.");
                alert.setContentText("Maak uw keuze.");

                ButtonType knop1 = new ButtonType("Save");
                ButtonType knop2 = new ButtonType("Load");
                ButtonType cancelKnop = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(knop1, knop2, cancelKnop);

                result = alert.showAndWait();
                if (result.get() == knop1) {
                    save();
                }
                if (result.get() == knop2){
                    read();
                }
                else {
                    alert.close();
                }

            } else {
                // ... user chose CANCEL or closed the dialog
            }
        });

        btnRefresh.setOnAction(event -> {
            try {
                refreshSpel();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    public void spelerDood(){
        Speler speler = spel.getHuidigeSpeler();
        if (veldC.veldD.getVakken()[speler.getX()][speler.getY()].isVuur()){
            veldC.removeSpeler(speler.getKleur(), speler.getX(), speler.getY());
            switch (veldC.veldD.getAmbulance()) {
                case BOVEN:
                    speler.setY(0);
                    speler.setX(5);
                    break;
                case RECHTS:
                    speler.setX(9);
                    speler.setY(4);
                    break;
                case ONDER:
                    speler.setY(7);
                    speler.setX(3);
                    break;
                case LINKS:
                    speler.setX(0);
                    speler.setY(2);
                    break;
            }
            veldC.addSpeler(speler.getKleur(),speler.getX(),speler.getY());
        }
    }


    public void meerijden(Richting richting, String wagen) {
        boolean verplaatsbaar;
        ArrayList<Speler> passagiers = new ArrayList<>();
            for (Speler speler : spel.getSpelers()) {
                verplaatsbaar = false;
                if (wagen.equals("Ambulance")) {
                    switch (veldC.veldD.getAmbulance()) {
                        case BOVEN:
                            if (speler.getY() == 0 && (speler.getX() == 5 || speler.getX() == 6)) {
                                verplaatsbaar = true;
                            }
                            break;
                        case RECHTS:
                            if (speler.getX() == 9 && (speler.getY() == 4 || speler.getY() == 5)) {
                                verplaatsbaar = true;
                            }
                            break;
                        case ONDER:
                            if (speler.getY() == 7 && (speler.getX() == 3 || speler.getX() == 4)) {
                                verplaatsbaar = true;
                            }
                            break;
                        case LINKS:
                            if (speler.getX() == 0 && (speler.getY() == 2 || speler.getY() == 3)) {
                                verplaatsbaar = true;
                            }
                            break;
                    }
                }
                else if (wagen.equals("Brandweerwagen")) {
                    switch (veldC.veldD.getBrandweerwagen()) {
                        case BOVEN:
                            if ((speler.getX()==3 || speler.getX()==4) && speler.getY()==0) {
                                verplaatsbaar = true;
                            }
                            break;
                        case RECHTS:
                            if ((speler.getY()==2 || speler.getY()==3) && speler.getX()==9) {
                                verplaatsbaar = true;
                            }
                            break;
                        case ONDER:
                            if ((speler.getX()==5 || speler.getX()==6) && speler.getY()==7) {
                                verplaatsbaar = true;
                            }
                            break;
                        case LINKS:
                            if ((speler.getY()==4 || speler.getY()==5) && speler.getX()==0) {
                                verplaatsbaar = true;
                            }
                            break;
                    }
                }
                if (verplaatsbaar) {
                    if (wagen.equals("Brandweerwagen") && speler.equals(spel.getHuidigeSpeler())) {
                        veldC.removeSpeler(speler.getKleur(),speler.getX(),speler.getY());
                        passagiers.add(speler);
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Meerijden");
                        alert.setHeaderText("Wil je dat " + speler.getNaam() + " mee rijdt?");
                        alert.setContentText("Klik in dat geval op Ja");

                        ButtonType ja = new ButtonType("Ja");
                        ButtonType nee = new ButtonType("Nee", ButtonBar.ButtonData.CANCEL_CLOSE);

                        alert.getButtonTypes().setAll(ja, nee);

                        Optional<ButtonType> resultaat = alert.showAndWait();
                        if (resultaat.get() == ja) {
                            veldC.removeSpeler(speler.getKleur(), speler.getX(), speler.getY());
                            passagiers.add(speler);
                        }
                    }
                }
            }
            for (Speler speler : passagiers) {
                switch (richting) {
                    case BOVEN:
                        speler.setY(0);
                        if (wagen.equals("Ambulance")) {
                            speler.setX(5);
                        }
                        else {
                            speler.setX(3);
                        }
                        break;
                    case RECHTS:
                        speler.setX(9);
                        if (wagen.equals("Ambulance")) {
                            speler.setY(4);
                        }
                        else {
                            speler.setY(2);
                        }
                        break;
                    case ONDER:
                        speler.setY(7);
                        if (wagen.equals("Ambulance")) {
                            speler.setX(3);
                        }
                        else {
                            speler.setX(5);
                        }
                        break;
                    case LINKS:
                        speler.setX(0);
                        if (wagen.equals("Ambulance")) {
                            speler.setY(2);
                        }
                        else {
                            speler.setY(4);
                        }
                        break;
                }
                veldC.addSpeler(speler.getKleur(), speler.getX(), speler.getY());
            }
            veldC.ImageSetterALL();
        }












/*        if (result.get() == buttonTypeOne) {
            // ... user chose "One"
        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
        } else if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
        } else {
            // ... user chose CANCEL or closed the dialog
        }*/



    public void toggleViewUpdate() {
        if(spelerC.openendeur) imgOpenendeur.setImage(veldC.veldI.getOpenenDeurSelect());
        else imgOpenendeur.setImage(veldC.veldI.getOpenenDeur());
        if(spelerC.hakken) imgHakken.setImage(veldC.veldI.getHakkenSelect());
        else imgHakken.setImage(veldC.veldI.getHakken());
        if(spelerC.brandblusser) imgBrandblusser.setImage(veldC.veldI.getBrandBlusserSelect());
        else imgBrandblusser.setImage(veldC.getVeldI().getBrandBlusser());
        if(spelerC.rijden) imgRijden.setImage(veldC.veldI.getRijdenSelect());
        else imgRijden.setImage(veldC.getVeldI().getRijden());
        if(spel.getHuidigeSpeler().isStof() || spel.getHuidigeSpeler().getPersoon() != null) {
            imgPickup.setImage(veldC.veldI.getPickIpSelect());
        } else imgPickup.setImage(veldC.veldI.getPickup());
    }


    // wordt aangeroepen als op de end turn knop word gedrukt en handeld alle relevante methodes hier voor af.
    public void endTurn() {
        checkWin();
        spelerC.togglesOff(); //Zet alle geactiveerde knoppen uit.
        toggleViewUpdate(); //Updates button-toggle view.
        nieuwRook(); //Spawned nieuw rook element.
        checkVonkoverslag();
        checkStoffen();
        spelerC.dropItem();
        checkPersonen();
        spelerDood();
        switchSpeler();
        spelerC.resetPunten();

        checkTurn();

        checkVerlies();
        setActiveSpelerPlaatje();


        updateSpel();
        try {
            setNamen();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        setRollen();
        updatePunten();
        veldC.ImageSetterALL();
    }

    public void nieuwRook() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        vak = veldC.veldD.getVakken()[x][y];
        System.out.println("Het geselecteerde vak is: x:" + x + " y: " + y);
        if (vak.isNiks()) {
            //Wordt gehanteerd als het gekozen vak geen rook of vuur element heeft.
            vak.setNiks(false);
            vak.setRook(true);
            vak.setVuur(false);
            System.out.println("Spel: Ik spawn rook op; x: " + x + " y: " + y);
        } else if (vak.isRook()) {
            //Wordt gehandteerd als er rook op het gekozen vak staat.
            vak.setNiks(false);
            vak.setRook(false);
            vak.setVuur(true);
            System.out.println("Spel: Ik zet het rook om naar vuur op; x: " + x + " y: " + y);
        } else if (vak.isVuur()){
            //Wordt gehanteerd als er vuur op het gekozen vak staat.
            System.out.println("Spel: Ik zet een explosie op; x: " + x + " y:  " + y);
            checkExplosie(x,y);
        }
        checkBrandhaard();
    }

    public void checkBrandhaard() {
        if(vak.isHotspot()) {
            spawnBrandhaard = true;
            nieuwRook();
        } else if(spawnBrandhaard){
            if(spel.getHotspotCounter() > 0) {
                vak.setHotspot(true);
                spelC.spel.setHotspotCounter(spelC.spel.getHotspotCounter()-1);
            }
            spawnBrandhaard = false;
        }
    }

    public void checkStoffen() {
        Vak vak;
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 7; y++) {
                vak=veldC.veldD.getVakken()[x][y];
                if(vak.isStoffen() && vak.isVuur()) {
                    checkExplosie(x,y);
                    vak.setStoffen(false);
                }
            }
        }
    }

    public void checkExplosie(int x, int y) {
        boolean doorgaan;
        int teller;
        Vak vak;
        for (Richting richting: Richting.values()) {
            teller = 0;
            doorgaan = true;
            while (richting == Richting.BOVEN && doorgaan && ((y - teller) >= 1)) {
                vak = veldC.veldD.getVakken()[x][y-teller];
                vak.setVuur(true);
                if (!vak.boven.isBegaanbaar()){
                    veldC.doeBeschadiging(x, y-teller, richting);
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x][y-teller];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }

            while (richting == Richting.RECHTS && doorgaan && ((x + teller) <= 8)) {
                vak = veldC.veldD.getVakken()[x+teller][y];
                vak.setVuur(true);
                if (!vak.rechts.isBegaanbaar()){
                    veldC.doeBeschadiging((x+teller), y, richting);
                    doorgaan = false;
                } else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x+teller][y];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }

            while (richting == Richting.ONDER && doorgaan && ((y + teller) <= 6)) {
                vak = veldC.veldD.getVakken()[x][y+teller];
                vak.setVuur(true);
                if (!vak.onder.isBegaanbaar()) {
                    veldC.doeBeschadiging(x, (y + teller), richting);
                    doorgaan = false;
                } else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x][y+teller];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }

            while (richting == Richting.LINKS && doorgaan && ((x - teller) >= 1)) {
                vak = veldC.veldD.getVakken()[x-teller][y];
                vak.setVuur(true);
                if (!vak.links.isBegaanbaar()){
                    veldC.doeBeschadiging((x-teller), y, richting);
                    doorgaan = false;
                } else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x-teller][y];
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

    //Hanteerd de spelregels bij een rook en een vuur element die naast elkaar staan.
    public void checkVonkoverslag() {
        Vak vak;
        Vak vak2 = null;
        boolean loop = true;
        while(loop) {
            loop = false;
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 8; y++) {
                    vak = veldC.veldD.getVakken()[x][y];
                    if (vak.isVuur()) {
                        for (Richting richting: Richting.values()) {
                            if (vak.getObstakelRichting(richting).isBegaanbaar()) {
                                switch (richting) {
                                    case BOVEN:
                                        if (y > 0) {
                                            vak2 = veldC.veldD.getVakken()[x][y-1];
                                        }
                                        break;
                                    case RECHTS:
                                        if (x < 9) {
                                            vak2 = veldC.veldD.getVakken()[x+1][y];
                                        }
                                        break;
                                    case ONDER:
                                        if (y < 7) {
                                            vak2 = veldC.veldD.getVakken()[x][y+1];
                                        }
                                        break;
                                    case LINKS:
                                        if (x > 0) {
                                            vak2 = veldC.veldD.getVakken()[x-1][y];
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

    //Dit breekt wanneer het spel vol staat met vuur, maar dat is niet te behalen met de gebruikte spelregels.
    public void addPersoon() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        int[] locatie;
        int killSwitch = 0;
        boolean tweedekeer = false;
        vak = veldC.veldD.getVakken()[x][y];
        while(vak.isVuur() || !vak.getPersonen().isEmpty()){
            locatie = veldC.volgPijl(x,y);
            killSwitch++;
            x = locatie[0];
            y = locatie[1];
            if (killSwitch == 12){
                dobbelC.d6.gooi();
                dobbelC.d8.gooi();
                x = dobbelC.d8.getWaarde();
                y = dobbelC.d6.getWaarde();
                killSwitch = 0;
            }
            vak = veldC.veldD.getVakken()[x][y];
        }
        if(veldC.getVeldD().getPersonenlijst().size()>1 && vak.getPersonen() != null){

            vak.setPersonen(veldC.getVeldD().getPersonenlijst().get(0));
            veldC.getVeldD().getPersonenlijst().remove(0);
        }
    }

    //Zet de labels van de gebruikte fiches.
    public void updatePunten() {
        APLabel.setText(" " + Integer.toString(spelerC.getSpeler().getActiepunten()));
        EPLabel.setText(" " + Integer.toString(spelerC.getSpeler().getExtrapunten()));
        BeschadigingLabel.setText(" " + Integer.toString(spelC.spel.getBeschadigingCounter())+" / 24");
        HotspotLabel.setText(" " + Integer.toString(spelC.spel.getHotspotCounter())+" / 6");
        if(spelerC.getSpeler().getRol()== BRANDSPUITBEDIENER) spuitTxt.setText("2");
        else spuitTxt.setText(" 4");
        if(spelerC.getSpeler().getRol()==REDDINGSSPECIALIST) {
            hakTxt.setText(" 1");
            blusTxt.setText(" 2");
        } else {
            hakTxt.setText(" 2");
            blusTxt.setText(" 1");
        }
        GeredLabel.setText(Integer.toString(spel.getGeredCounter())+ " / 7");
        GeredLabel1.setText(Integer.toString(spel.getDoodCounter())+ " / 3");
        switch(spelerC.getUniekeSpeler().getRol()) {
            case VERKENNER: btnSpecial.setText("Verken (1AP)");
            break;
            case COMMANDANT: btnSpecial.setText("Commandeer (1 EP)");
            break;
            case DOKTER: btnSpecial.setText("Helen (1 AP)");
            break;
            case SPECSTOFFEN: btnSpecial.setText("Disarm (1 AP)");
            break;
            default: btnSpecial.setText("Special");
        }
    }

    // if(rol == VERKENNER || rol == COMMANDANT || rol == DOKTER || rol == SPECSTOFFEN) {

    // verwijderd personen die op vuur staan en vervangd deze met nieuwe.
    public void checkPersonen() {
        int count = 0;
        for(int x = 0; x < 10; x++) {
            for (int y = 0; y < 8; y++) {
                vak = veldC.veldD.getVakken()[x][y];
                if (vak.getPersonen().size() > 0 && vak.isVuur()) {
                    for(int i = 0; i < vak.getPersonen().size(); i++) {
                        if (vak.getPersonen().get(i) != Persoon.NOPE1 &&
                                vak.getPersonen().get(i) != Persoon.NOPE2 &&
                                vak.getPersonen().get(i) != Persoon.NOPE3 &&
                                vak.getPersonen().get(i) != Persoon.NOPE4 &&
                                vak.getPersonen().get(i) != Persoon.NOPE5) {
                            spel.addDood();
                        }
                    }
                    vak.getPersonen().clear();
                }
            }
        }
        for(int x = 0; x < 10; x++) {
            for (int y = 0; y < 8; y++) {
                vak = veldC.veldD.getVakken()[x][y];
                count += vak.getPersonen().size();
            }
        }
        for(int i = count; i< 3; i++) addPersoon();
    }
    // Veranderd de klasse voor de speler bij voldoende AP. Rollen die al in gebruik zijn kunnen niet worden gekozen.
    public void veranderKlasse() {
        if(spelerC.getSpeler().getActiepunten()>1) {
            List<String> choices = new ArrayList<>();
            Boolean[]booleans = new Boolean[8];
            for(int i = 0; i < 8; i++) {
                booleans[i] = true;
            }
            for(int i = 0; i <spel.getSpelers().size(); i++)
                switch(spel.getSpelers().get(i).getRol()) {
                    case COMMANDANT: booleans[0] = false;
                        break;
                    case VERKENNER: booleans[1] = false;
                        break;
                    case MANNETJESPUTTER: booleans[2] = false;
                        break;
                    case REDDINGSSPECIALIST: booleans[3] = false;
                        break;
                    case SPECSTOFFEN: booleans[4] = false;
                        break;
                    case BRANDSPUITBEDIENER: booleans[5] = false;
                        break;
                    case GASPAKDRAGER: booleans[6] = false;
                        break;
                    case DOKTER: booleans[7] = false;
                        break;
                }

            if(booleans[0])choices.add("Commandant");
            if(booleans[1])choices.add("Verkenner");
            if(booleans[2])choices.add("Mannetjesputter");
            if(booleans[3])choices.add("Reddingsspecialist");
            if(booleans[4])choices.add("SpecialistG.S");
            if(booleans[5])choices.add("BrandspuitBediener");
            if(booleans[6])choices.add("Gaspakdrager");
            if(booleans[7])choices.add("Dokter");

            //De choicedialog maken
            ChoiceDialog<String> dialog3 = new ChoiceDialog<>("Keuze", choices);
            dialog3.setTitle("Choice Dialog");
            dialog3.setHeaderText("Kies je klasse");
            dialog3.setContentText("Klasse:");

            Optional<String> keuzeKlasse = dialog3.showAndWait();
            if (keuzeKlasse.isPresent() && keuzeKlasse.get() != "Keuze") {
                String klasse = keuzeKlasse.get();
                System.out.println("Je hebt gekozen voor de klasse: " + klasse);
                switch (klasse) {
                    case "Commandant":
                        spelerC.getSpeler().setRol(COMMANDANT);
                        break;
                    case "Verkenner":
                        spelerC.getSpeler().setRol(VERKENNER);
                        break;
                    case "Mannetjesputter":
                        spelerC.getSpeler().setRol(MANNETJESPUTTER);
                        break;
                    case "Reddingsspecialist":
                        spelerC.getSpeler().setRol(REDDINGSSPECIALIST);
                        break;
                    case "SpecialistG.S":
                        spelerC.getSpeler().setRol(SPECSTOFFEN);
                        break;
                    case "BrandspuitBediener":
                        spelerC.getSpeler().setRol(BRANDSPUITBEDIENER);
                        break;
                    case "Gaspakdrager":
                        spelerC.getSpeler().setRol(GASPAKDRAGER);
                        break;
                    case "Dokter":
                        spelerC.getSpeler().setRol(DOKTER);
                        break;
                }
                spelerC.getSpeler().setActiepunten(spelerC.getSpeler().getActiepunten()-2);
                setRollen();
                updatePunten();
            }
        }
    }

    public void addBeschadigingCount() {
        spel.setBeschadigingCounter(spel.getBeschadigingCounter()+1);
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    Boolean lost = false;
    public void checkVerlies() {
        if(spel.getDoodCounter()>2) {
            alert.setContentText("Er zijn te veel mensen vermist");
            lost = true;
        }
        else if(spel.getBeschadigingCounter()>23) {
            alert.setContentText("Het huis is ingestort.");
            lost = true;

        }
        if(lost) {
            alert.setTitle("Helaas, je hebt verloren");
            alert.setHeaderText(null);
            alert.showAndWait();
            System.exit(0);
        }
    }

    public void setNamen() throws RemoteException {
        switch(spel.getSpelers().size()) {
            case 6 : user6.setText(" " + spel.getSpelers().get(5).getNaam());
            case 5 : user5.setText(" " + spel.getSpelers().get(4).getNaam());
            case 4 : user4.setText(" " + spel.getSpelers().get(3).getNaam());
            case 3 : user3.setText(" " + spel.getSpelers().get(2).getNaam());
            case 2 : user2.setText(" " + spel.getSpelers().get(1).getNaam());
            case 1 : user1.setText(" " + spel.getSpelers().get(0).getNaam());
        }
    }

    public void setActiveSpelerPlaatje() {
        switch(spel.getSpelers().size()) {
            case 6 :if(spel.getSpelers().get(5) == spel.getHuidigeSpeler()) {
                user6Img.setImage(veldC.veldI.getBrandweerZwart50pxActive());
            }   else user6Img.setImage(veldC.veldI.getBrandweerZwart50px());
            case 5 :if(spel.getSpelers().get(4) == spel.getHuidigeSpeler()) {
                user5Img.setImage(veldC.veldI.getBrandweerRood50pxActive());
            }   else user5Img.setImage(veldC.veldI.getBrandweerRood50px());
            case 4 :if(spel.getSpelers().get(3) == spel.getHuidigeSpeler()) {
                user4Img.setImage(veldC.veldI.getBrandweerOranje50pxActive());
            }   else user4Img.setImage(veldC.veldI.getBrandweerOranje50px());
            case 3 :if(spel.getSpelers().get(2) == spel.getHuidigeSpeler()) {
                user3Img.setImage(veldC.veldI.getBrandweerGroen50pxActive());
            }   else user3Img.setImage(veldC.veldI.getBrandweerGroen50px());
            case 2 :if(spel.getSpelers().get(1) == spel.getHuidigeSpeler()) {
                user2Img.setImage(veldC.veldI.getBrandweerGeel50pxActive());
            }   else user2Img.setImage(veldC.veldI.getBrandweerGeel50px());
            case 1 :if(spel.getSpelers().get(0) == spel.getHuidigeSpeler()) {
                user1Img.setImage(veldC.veldI.getBrandweerBlauw50pxActive());
            }   else user1Img.setImage(veldC.veldI.getBrandweerBlauw50px());
        }
    }

    private void toewijzenRollen() {
        switch(spel.getSpelers().size()) {
            case 6: spel.getSpelers().get(5).setRol(BRANDSPUITBEDIENER);
            case 5: spel.getSpelers().get(4).setRol(GASPAKDRAGER);
            case 4: spel.getSpelers().get(3).setRol(SPECSTOFFEN);
            case 3: spel.getSpelers().get(2).setRol(COMMANDANT);
            case 2: spel.getSpelers().get(1).setRol(VERKENNER);
            case 1: spel.getSpelers().get(0).setRol(DOKTER);
        }
    }

    public void setRollen() {
        switch(spel.getSpelers().size()) {
            case 6: rol6.setText(" " + spel.getSpelers().get(5).getRol());
            case 5: rol5.setText(" " + spel.getSpelers().get(4).getRol());
            case 4: rol4.setText(" " + spel.getSpelers().get(3).getRol());
            case 3: rol3.setText(" " + spel.getSpelers().get(2).getRol());
            case 2: rol2.setText(" " + spel.getSpelers().get(1).getRol());
            case 1: rol1.setText(" " + spel.getSpelers().get(0).getRol());
        }
    }

    public void checkWin() {
        if(spel.getGeredCounter()>6) {
            alert.setContentText(spel.getGeredCounter() + " personen zijn gered");
            alert.setTitle("Gefeliciteerd, je hebt gewonnen");
            alert.setHeaderText(null);
            alert.showAndWait();
            System.exit(0);
        }
    }
    public void refreshSpel() throws RemoteException {
        System.out.println("Spel: Ik refresh de view.");
        setSpel(clientStub.updateGetSpel());
        veldC.setVeldD(clientStub.updateGetData());
        updatePunten();
        veldC.ImageSetterALL();
        setActiveSpelerPlaatje();
        setRollen();
    }

    public void Lobby() {
        //Dialoog 1(ip adress)
        dialog.setHeaderText("Voer het IP-adres van de host in");
        dialog.setContentText("IP-adres:");
        Optional<String> ipadress = dialog.showAndWait();
        setHost(ipadress.get());

        //Dialoog 2(naam)
        dialog2.setHeaderText("Voer je naam in");
        dialog2.setContentText("Naam: ");
        Optional<String> naam = dialog2.showAndWait();
        setUsername(naam.get().substring(0, Math.min(naam.get().length(), 6)));
    }
    public void updateSpel() {
        try {
            clientStub.setSpelData(getSpel(), veldC.getVeldD());
            setActiveSpelerPlaatje();
            setRollen();
            updatePunten();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    String spelfile = "spel.ser";
    String veldfile =  "veld.ser";

    public void writeSpel() {
        try {
            //Write
            FileOutputStream fos = new FileOutputStream(spelfile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(spel);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeVeld(){
        try {
            FileOutputStream fos = new FileOutputStream(veldfile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(veldC.veldD);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Spel readSpel() {
        Spel ss = null;
        try {
            //Read spel
            FileInputStream fis = new FileInputStream(spelfile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Spel SpelSave = (Spel) ois.readObject();
            ss = SpelSave;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ss;
    }

    public SpeelveldData readVeld() {
        SpeelveldData svd = null;
        try {
            //Read veld
            FileInputStream fis = new FileInputStream(veldfile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SpeelveldData VeldSave = (SpeelveldData) ois.readObject();
            svd = VeldSave;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return svd;
    }

    public void save(){
        writeSpel();
        writeVeld();
    }

    public void read(){
        try {
            spelC.setSpel(readSpel());
            veldC.setVeldD(readVeld());
            clientStub.setSpelData(getSpel(), veldC.getVeldD());
            updateSpel();
            veldC.ImageSetterALL();
            updatePunten();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void checkTurn() {
        if(spel.getHuidigeSpeler().getKleur() != getKleur()) {
            disableKnoppen();
            myTurn = false;
        } else {
            enableKnoppen();
            myTurn = true;
        }
    }
    public void disableKnoppen() {
        imgHakken.setDisable(true);
        imgOpenendeur.setDisable(true);
        imgPickup.setDisable(true);
        imgPickup1.setDisable(true);
        imgBrandblusser.setDisable(true);
        imgRijden.setDisable(true);
        imgWagenblussen.setDisable(true);
        imgRolswap.setDisable(true);
        btnRIGHT.setDisable(true);
        btnUP.setDisable(true);
        btnDOWN.setDisable(true);
        btnLEFT.setDisable(true);
        btnET.setDisable(true);
        btnSpecial.setDisable(true);
    }
    public void enableKnoppen() {
        imgHakken.setDisable(false);
        imgOpenendeur.setDisable(false);
        imgPickup.setDisable(false);
        imgPickup1.setDisable(false);
        imgBrandblusser.setDisable(false);
        imgRijden.setDisable(false);
        imgWagenblussen.setDisable(false);
        imgRolswap.setDisable(false);
        btnRIGHT.setDisable(false);
        btnUP.setDisable(false);
        btnDOWN.setDisable(false);
        btnLEFT.setDisable(false);
        btnET.setDisable(false);
        Rol rol = spel.getHuidigeSpeler().getRol();
        if(rol == VERKENNER || rol == COMMANDANT || rol == DOKTER || rol == SPECSTOFFEN) {
            btnSpecial.setDisable(false);
        } else btnSpecial.setDisable(true);
    }
}


