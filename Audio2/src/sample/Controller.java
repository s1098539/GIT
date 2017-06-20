package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.PrintStream;

import java.rmi.RemoteException;

import static java.lang.Thread.sleep;

public class Controller {
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
    private Button btnET;
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


    List<String> choices = new ArrayList<>();

    String localMessage = "";


    public GridPane getGridpane() {
        return gridpane;
    }

    public void setGridpane(GridPane gridpane) {
        this.gridpane = gridpane;
    }

    public void disableAudio(){
        btnLEFT.setDisable(true);
    }

    Audio up = new Audio();
    Audio down = new Audio();
    Audio left = new Audio();
    Audio right = new Audio();
    Audio hak = new Audio();
    Audio deur = new Audio();
    Audio blussen = new Audio();
    Audio rijden = new Audio();
    Audio wagenblussen = new Audio();
    Audio pickup = new Audio();
    Audio rolswap = new Audio();
    Audio special = new Audio();
    Audio et = new Audio();

        btnET.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer = 3000;
            et.playEindigtZetKnop();
            sleep(sleepTimer);
            et.playEindigZetAPOvergebleven();
            sleep(sleepTimer);
            et.playEindigZetVolgendeSpelerKrijgtBeurt();
            sleep(sleepTimer);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        btnSpecial.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer = 4000;
            special.playKlasseSpecial();
            sleep(sleepTimer);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        imgRolswap.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer = 4000;
            rolswap.playRolWisselen2AP();
            sleep(sleepTimer);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        imgPickup.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer = 4000;
            pickup.playOppakkenKostGeenAP();
            sleep(sleepTimer);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        imgWagenblussen.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer = 4300;
            int sleepTimer2= 6000;
            wagenblussen.playBrandspuitBedienen4AP();
            sleep(sleepTimer);
            wagenblussen.playBrandspuitbedienerKost2AP();
            sleep(sleepTimer);
            wagenblussen.playBrandspuitbedienerReroll();
            sleep(sleepTimer2);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        imgRijden.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer = 4500;
            int sleepTimer2 = 5500;
            rijden.playRijdenKost2AP();
            sleep(sleepTimer);
            rijden.playRijdenMeerijdenKostGeenAP();
            sleep(sleepTimer2);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        imgHakken.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer = 3000;
            hak.playHakken2AP();
            sleep(sleepTimer);
            hak.playHakken1APReddingsspecialist();
            sleep(sleepTimer);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        imgOpenendeur.setOnContextMenuRequested(event -> {
        try {
            int sleepTimer = 4500;
            deur.playDeurOpenenSluiten1AP();
            sleep(sleepTimer);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        imgBrandblusser.setOnContextMenuRequested(event -> {
        try {
            int sleepTimer = 3000;
            blussen.playVuurBlussen2AP();
            sleep(sleepTimer);
            blussen.playVuurNaarRook1AP();
            sleep(sleepTimer);
            blussen.playRookBlussen1AP();
            sleep(sleepTimer);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        btnUP.setOnContextMenuRequested(event -> {
        try {
            int sleepTimer1 = 2501;
            int sleepTimer2 = 7500;
            int sleepTimer3 = 9500;
            int sleepTimer4 = 3500;
            up.playBewegen1AP();
            sleep(sleepTimer1);
            up.playBewegenPvaGS2AP();
            sleep(sleepTimer2);
            up.playBewegenReddingsspecialist3EP();
            sleep(sleepTimer2);
            up.playDokterBehandelenBewegenGeenExtraAP();
            sleep(sleepTimer3);
            up.playVuurBewegen2AP();
            sleep(sleepTimer4);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        btnDOWN.setOnContextMenuRequested(event -> {
        try {
            int sleepTimer1 = 2501;
            int sleepTimer2 = 7500;
            int sleepTimer3 = 9500;
            int sleepTimer4 = 3500;
            down.playBewegen1AP();
            sleep(sleepTimer1);
            down.playBewegenPvaGS2AP();
            sleep(sleepTimer2);
            down.playBewegenReddingsspecialist3EP();
            sleep(sleepTimer2);
            down.playDokterBehandelenBewegenGeenExtraAP();
            sleep(sleepTimer3);
            down.playVuurBewegen2AP();
            sleep(sleepTimer4);
        } catch (Exception e){
            e.printStackTrace();
        }
    });

        btnLEFT.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer1 = 2501;
            int sleepTimer2 = 7500;
            int sleepTimer3 = 9500;
            int sleepTimer4 = 3500;
            left.playBewegen1AP();
            sleep(sleepTimer1);
            left.playBewegenPvaGS2AP();
            sleep(sleepTimer2);
            left.playBewegenReddingsspecialist3EP();
            sleep(sleepTimer2);
            left.playDokterBehandelenBewegenGeenExtraAP();
            sleep(sleepTimer3);
            left.playVuurBewegen2AP();
            sleep(sleepTimer4);
        }   catch (Exception e){
            e.printStackTrace();
        }
    });

        btnRIGHT.setOnContextMenuRequested(event -> {
        try{
            int sleepTimer1 = 2501;
            int sleepTimer2 = 7500;
            int sleepTimer3 = 9500;
            int sleepTimer4 = 3500;
            right.playBewegen1AP();
            sleep(sleepTimer1);
            right.playBewegenPvaGS2AP();
            sleep(sleepTimer2);
            right.playBewegenReddingsspecialist3EP();
            sleep(sleepTimer2);
            right.playDokterBehandelenBewegenGeenExtraAP();
            sleep(sleepTimer3);
            right.playVuurBewegen2AP();
            sleep(sleepTimer4);
        }   catch (Exception e){
            e.printStackTrace();
        }
    });

        btnUP.setOnAction(event -> {
        if(hakken) {
            speler.muurInteractie(Richting.BOVEN);
        }else if(deurinteractie){
            speler.deurInteractie(Richting.BOVEN);
        }else if(brandblusser){
            speler.blusActie(Richting.BOVEN);
        } else {
            speler.beweegwActie(Richting.BOVEN);
        }
        view.imageSetter(veld,speler);
    });

        btnLEFT.setOnAction(event -> {
        if(hakken) {
            speler.muurInteractie(Richting.LINKS);
        }else if(deurinteractie){
            speler.deurInteractie(Richting.LINKS);
        }else if(brandblusser){
            speler.blusActie(Richting.LINKS);
        } else {
            speler.beweegwActie(Richting.LINKS);
        }
        view.imageSetter(veld,speler);
    });

        btnRIGHT.setOnAction(event -> {
        if(hakken) {
            speler.muurInteractie(Richting.RECHTS);
        }else if(deurinteractie){
            speler.deurInteractie(Richting.RECHTS);
        }else if(brandblusser){
            speler.blusActie(Richting.RECHTS);
        } else {
            speler.beweegwActie(Richting.RECHTS);
        }
        view.imageSetter(veld,speler);
    });

        btnDOWN.setOnAction(event -> {
        if(hakken) {
            speler.muurInteractie(Richting.ONDER);
        }else if(deurinteractie){
            speler.deurInteractie(Richting.ONDER);
        }else if(brandblusser){
            speler.blusActie(Richting.ONDER);
        } else {
            speler.beweegwActie(Richting.ONDER);
        }
        view.imageSetter(veld,speler);
    });

        imgHakken.setOnMouseClicked(event -> {
        if(hakken) {
            hakken = false;
            System.out.println("Hakken is uitgeschakeld");
        } else {
            hakken = true;
            deurinteractie = false;
            brandblusser = false;
            System.out.println("Hakken is ingeschakeld");
        }

    });

        imgOpenendeur.setOnMouseClicked(event -> {
        if(deurinteractie) {
            deurinteractie = false;
        } else {
            hakken = false;
            deurinteractie = true;
            brandblusser = false;
        }
        System.out.println(deurinteractie);
    });

        imgBrandblusser.setOnMouseClicked(event -> {
        if(brandblusser) {
            brandblusser = false;
        } else {
            hakken = false;
            deurinteractie = false;
            brandblusser = true;
        }
        System.out.println(deurinteractie);
    });

        btnSpecial.setOnAction(event -> {
//            for (int vaak = 0; vaak < 3; vaak++) {
//
//                ba.nieuwRook();
//                ba.hanteerVonkoverslag();
//                ba.hanteerStoffen();
//                view.imageSetter(veld,speler);
//            }
        ba.nieuwRook();
        view.imageSetter(veld,speler);
    });



}
}
