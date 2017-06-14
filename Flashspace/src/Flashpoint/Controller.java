package Flashpoint;

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
//    @FXML
//    private ImageView imgRolswap;
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

    Boolean hakken = false;
    Boolean deurinteractie = false;
    Boolean brandblusser = false;

    //
//    private FlowPane[][]fp = new FlowPane[10][8];
//    private Speelveld veld = new Speelveld();
//    ImageView[]ivarray = new ImageView[720];
//    private ViewSpeelveld view = new ViewSpeelveld(fp,veld);
//    private BeurtAfronding ba = new BeurtAfronding(veld);
////    private Object.Speler speler = new Object.Speler("Lion", Kleur.ZWART, 4,3);
////    SpelerActie sa = new SpelerActie(speler, veld);
//    private Boolean hakken = false;
//    private Boolean openendeur;
//
    @FXML
    public void initialize() throws Exception {
        Speelveld veld = new Speelveld();
/*        for(int x = 0; x<10; x++) {
            for(int y = 0; y<8; y++) {
                veld.getVak(x,y).vuurPlaats(Fiche.ROOK);
                veld.getVak(x,y).setHotspot(true);
                veld.getVak(x,y).setPersoon(true);
                veld.getVak(x,y).setStoffen(true);*/
//                veld.getVak(x,y).setBoven(Status.LEEG);
//                veld.getVak(x,y).setOnder(Status.LEEG);
//                veld.getVak(x,y).setLinks(Status.LEEG);
//                veld.getVak(x,y).setRechts(Status.LEEG);
        //}
        // }

        ViewSpeelveld view = new ViewSpeelveld();
        Speler speler = new Speler("Joep", Kleur.GROEN, 2,7, veld);
        Spel ba = new Spel(veld, 6);
        view.imageViewsFactory();
        System.out.println("hoi");
        view.flowPanesFactory();
        int teller = 0;
        for(int y = 0; y<8; y++) {
            for(int x = 0; x<10; x++) {
                gridpane.add(view.getFlowPanes()[teller],x,y);
                teller++;
            }
        }
        veld.getVak(5,5).setHotspot(true);
        veld.setMuren();
        veld.getVak(3,3).vuurPlaats(Fiche.VUUR);
        view.imageSetter(veld, speler);



////        veld.getVak(speler.getX(),speler.getY()).addObject(speler);
//
//
//        System.out.println("test");
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                fp[x][y] = new FlowPane();
//                gridpane.add(fp[x][y],x,y);
//            }
//        }
//        veld.setMuren();
//
//
//
////        for(int c=1; c<9; c++){
////            veld.getVakken()[c][2].setObstakel(0,1);
////        }
////
////        for(int x = 0; x <10; x++) {
////            for (int y = 0; y < 8; y++) {
////                veld.getVak(x, y).addObject(new Object.Vuur());
////            }
////        }
////
////        for(int x = 0; x <10; x++) {
////            for (int y = 0; y < 8; y++) {
////                veld.getVak(x, y).addObject(new Object.BrandHaard());
////            }
////        }
////
////        for(int x = 0; x <10; x++) {
////            for (int y = 0; y < 8; y++) {
////                veld.getVak(x, y).addObject(new Object.PersoonVanAandacht());
////            }
////        }
////
//
////        veld.getVak(2,2).addObject(new Object.GevaarlijkeStof());
//
//
//
//
//
//
//        //Vonko naar boven test (linker verticale lijn)
////        veld.getVak(9, 7).addObject(new Object.GevaarlijkeStof());
////        veld.getVak(3, 0).addObject(new Object.Rook());
////        veld.getVak(3, 1).addObject(new Object.Rook());
////        veld.getVak(3, 2).addObject(new Object.Rook());
////        veld.getVak(3,3).addObject(new Object.Rook());
////        veld.getVak(3, 4).addObject(new Object.Rook());
////        veld.getVak(3, 5).addObject(new Object.Vuur());
////
////        //Vonko naar beneden test (rechter verticale lijn)
////        veld.getVak(5, 0).addObject(new Object.Vuur());
////        veld.getVak(5, 1).addObject(new Object.Rook());
////        veld.getVak(5, 2).addObject(new Object.Rook());
////        veld.getVak(5,3).addObject(new Object.Rook());
////        veld.getVak(5, 4).addObject(new Object.Rook());
////        veld.getVak(5, 5).addObject(new Object.Rook());
////
////        //Vonko naar links test (linker horizontale lijn)
////        veld.getVak(0, 7).addObject(new Object.Rook());
////        veld.getVak(1, 7).addObject(new Object.Rook());
////        veld.getVak(2, 7).addObject(new Object.Rook());
////        veld.getVak(3, 7).addObject(new Object.Rook());
////        veld.getVak(4, 7).addObject(new Object.Vuur());
////
////        //Vonka naar rechts test (rechter horizontale lijn)
////        veld.getVak(6, 7).addObject(new Object.Vuur());
////        veld.getVak(7, 7).addObject(new Object.Rook());
////        veld.getVak(8, 7).addObject(new Object.Rook());
////        veld.getVak(9, 7).addObject(new Object.Rook());
//
//
//
//        // ba.handleVonkoverslag();
//        // ba.newRook();
//        view.update();
//        Vak vak = new Vak();
//        vak.setBoven(Vak.Status.MUUR1);
//        System.out.println(vak.getBoven());
//



        ChatServer chat = new ChatServer();

        chatArea.setEditable(false);
        chatArea.setScrollTop(Double.MAX_VALUE);

        //dialoog 1
        dialog.setHeaderText("Voer het IP-adres van de host in");
        dialog.setContentText("IP-adres:");
        Optional<String> ipadress = dialog.showAndWait();
        String host = ipadress.get();

        //dialoog 2
        dialog2.setHeaderText("Voer je naam in");
        dialog2.setContentText("Naam: ");
        Optional<String> naam = dialog2.showAndWait();
        String username = naam.get();

        ChatListen chatlisten = new ChatListen(host);
        ChatSend sender = new ChatSend(host, username, localMessage);

        //Keuzes toevoegen aan de arraylist die we gaan gebruiken voor de choicedialog.
        choices.add("Commandant");
        choices.add("Verkenner");
        choices.add("Mannetjesputter");
        choices.add("Reddingsspecialist");
        choices.add("SpecialistG.S");
        choices.add("BrandspuitBediener");
        choices.add("Gaspakdrager");
        choices.add("Dokter");

        //De choicedialog maken
        ChoiceDialog<String> dialog3 = new ChoiceDialog<>("Keuze", choices);
        dialog3.setTitle("Choice Dialog");
        dialog3.setHeaderText("Kies je klasse");
        dialog3.setContentText("Klasse:");

        //Klasse veranderen knop
        veranderKlasse.setOnAction(e -> {
            Optional<String> keuzeKlasse = dialog3.showAndWait();
            if (keuzeKlasse.isPresent() && keuzeKlasse.get() != "Keuze"){
                String klasse = keuzeKlasse.get();
                System.out.println("Je hebt gekozen voor de klasse: " + klasse);
            }
        });

        //Quit knop
        quit.setOnAction(e -> {
            System.exit(0);
        });

        //Chat groter maken
        groterChat.setOnAction(e -> {
            stuur.setPrefHeight(30);
            textInput.setPrefHeight(30);
            chatArea.setPrefHeight(500);
            chatArea.setScrollTop(Double.MAX_VALUE);
        });
        //Chat kleiner maken
        kleinerChat.setOnAction(e -> {
            stuur.setPrefHeight(0);
            textInput.setPrefHeight(0);
            chatArea.setPrefHeight(70);
            chatArea.setScrollTop(Double.MAX_VALUE);
        });

        //chat invoer
        textInput.setOnAction(e -> {
            String localMessage = textInput.getText();
            try {
                sender.sendMessageObject(username, localMessage);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            textInput.setText("");
        });
        //stuurknop chat
        stuur.setOnAction(e -> {
            String localMessage = textInput.getText();
            try {
                sender.sendMessageObject(username, localMessage);
            } catch (RemoteException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            textInput.setText("");
        });
        /*printwriter om alles wat in de console uitgeprint wordt in de chat te zetten. Messages worden returned via
        system.out.println en gameberichten ook dus zo kan je ze allebij in de chat zetten.*/
        System.setOut(new PrintStream(System.out) {
            @Override
            public void write(byte[] buf, int off, int len) {
                super.write(buf, off, len);

                String msg = new String(buf, off, len);

                chatArea.appendText(msg);
            }
        });

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

        imgPickup.setOnContextMenuRequested  (event -> {
            try{
                int sleepTimer = 4000;
                pickup.playOppakkenKostGeenAP();
                sleep(sleepTimer);
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        imgWagenblussen.setOnContextMenuRequested  (event -> {
            try{
                int sleepTimer = 4300;
                wagenblussen.playBrandspuitBedienen4AP();
                sleep(sleepTimer);
                wagenblussen.playBrandspuitbedienerKost2AP();
                sleep(sleepTimer);
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        imgRijden.setOnContextMenuRequested  (event -> {
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

        imgHakken.setOnContextMenuRequested  (event -> {
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

        imgOpenendeur.setOnContextMenuRequested  (event -> {
            try {
                int sleepTimer = 4500;
                deur.playDeurActies();
                sleep(sleepTimer);
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        imgBrandblusser.setOnContextMenuRequested  (event -> {
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

        btnUP.setOnContextMenuRequested  (event -> {
            try {
                up.playBewegen1AP();
                int sleepTimer = 2501;
                sleep(sleepTimer);
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        btnDOWN.setOnContextMenuRequested  (event -> {
            try {
                down.playBewegen1AP();
                int sleepTimer = 2502;
                sleep(sleepTimer);
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        btnLEFT.setOnContextMenuRequested(event -> {
            try{
                left.playBewegen1AP();
                int sleepTimer = 2503;
                sleep(sleepTimer);
            }   catch (Exception e){
        e.printStackTrace();
    }
});

        btnRIGHT.setOnContextMenuRequested(event -> {
        try{
        right.playBewegen1AP();
        int sleepTimer = 2504;
        sleep(sleepTimer);
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
