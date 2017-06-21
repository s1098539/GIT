package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static Model.Rol.BRANDSPUITBEDIENER;
import static Model.Rol.REDDINGSSPECIALIST;

public class SpelController implements Initializable {

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
    @FXML private Button gebruikershandleiding;
    @FXML private Label BeschadigingLabel;
    @FXML private Label HotspotLabel;
    @FXML private Label GeredLabel;
    @FXML private Label GeredLabel1;

    Vak vak;
    boolean spawnBrandhaard;
    int hotspots = 6;
    String localMessage = "";
    String host = "127.0.0.1";
    String username = "";
    Send sender;

    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;
    ChatController chatC;
    SpraakController spraakC;
    SpelController spelC;

    public Send getSender() {
        return sender;
    }

    public void setSender(Send sender) {
        this.sender = sender;
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

    }

    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC, ChatController chatC, SpelController spelC, SpraakController spraakC) {
        this.veldC = veldC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;
        this.spelC = spelC;
        this.spraakC = spraakC;
    }

    // Lion, dit is de eerste methode die deze klasse runt, de stackpane wordt uit de fxml view gehaald en een gridpane word toegevoegd.
    public void run() {
        stackPane.getChildren().add(veldC.getVeldI().getGridPane());
        spelerC.resetPunten();

        try {
            Send sender = new Send(host, username, localMessage);
            setSender(sender);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        for(Persoon persoon: Persoon.values()){
            veldC.getVeldD().getPersonenlijst().add(persoon);
        }
        long seed = System.nanoTime();
        Collections.shuffle(veldC.getVeldD().getPersonenlijst(), new Random(seed));
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
            spelerC.noord();
        });

        btnRIGHT.setOnAction(event -> {
            spelerC.oost();
        });

        btnDOWN.setOnAction(event -> {
            spelerC.zuid();
        });

        btnLEFT.setOnAction(event -> {
            spelerC.west();
        });

        imgOpenendeur.setOnMouseClicked(event -> {
            spelerC.btnOpenenDeur();
        });

        imgBrandblusser.setOnMouseClicked(event -> {
            spelerC.btnBrandblusser();
        });

        imgHakken.setOnMouseClicked(event -> {
            spelerC.btnhakken();
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
        });

        imgRolswap.setOnMouseClicked(event -> {
            veranderKlasse();
        });
        quit.setOnAction(event -> {
            System.exit(0);
        });
        imgPickup.setOnMouseClicked(event -> {
            spelerC.oppakkenActie();
        });

    }
    //Door: Sam, don't hate if its wrong ok
    Spel spel = new Spel(6,0,0);

    // Lion, word aangeroepen als op de end turn knop word gedrukt en handeld alle relevante methodes hier voor af.
    public void endTurn() {
        for(int i = 0; i<3; i++) {
            nieuwRook();
        }
        checkVonkoverslag();
        checkStoffen();
        if (spelerC.speler.getPersoon() != null){
            veldC.veldD.getVakken()[spelerC.speler.getX()][spelerC.speler.getY()].setPersonen(spelerC.speler.getPersoon());
            spelerC.speler.setPersoon(null);
        }
        checkPersonen();
        veldC.ImageSetterALL();
        spelerC.resetPunten();
    }

    public void nieuwRook() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        vak = veldC.veldD.getVakken()[x][y];
        System.out.println(x+" "+y);
        if (vak.isNiks()) {
            vak.setNiks(false);
            vak.setRook(true);
            vak.setVuur(false);
            System.out.println("nieuwRook " + x + " " + y);
        } else if (vak.isRook()) {
            vak.setNiks(false);
            vak.setRook(false);
            vak.setVuur(true);
            System.out.println("nieuwVuur " + x + " " + y);
        } else if (vak.isVuur()){
            System.out.println("newExplosie " + x + " " + y);
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

    public void checkExplosie(int x, int y) {// Joep
        boolean doorgaan;
        int teller;
        Vak vak;
        for (Richting richting: Richting.values()) {
            teller = 0;
            doorgaan = true;
            while (richting == Richting.BOVEN && doorgaan && ((y - teller) >= 1)) {
                vak = veldC.veldD.getVakken()[x][y-teller];
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
                if (!vak.rechts.isBegaanbaar()){
                    veldC.doeBeschadiging((x+teller), y, richting);
                    doorgaan = false;
                }

                else {
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
                if (!vak.onder.isBegaanbaar()){
                    veldC.doeBeschadiging(x, (y + teller), richting);
                    doorgaan = false;
                }

                else {
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
                if (!vak.links.isBegaanbaar()){
                    veldC.doeBeschadiging((x-teller), y, richting);
                    doorgaan = false;
                }

                else {
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

    public void addPersoon() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        int[] locatie;
        boolean tweedekeer = false;
        vak = veldC.veldD.getVakken()[x][y];
        while(vak.isVuur()){
            locatie = veldC.volgPijl(x,y);
            x = locatie[0];
            y = locatie[1];
            if (x == 3 && y == 3){
                if (tweedekeer){
                    dobbelC.d6.gooi();
                    dobbelC.d8.gooi();
                    x = dobbelC.d8.getWaarde();
                    y = dobbelC.d6.getWaarde();
                    tweedekeer = false;
                }
                tweedekeer = true;
            }
            vak = veldC.veldD.getVakken()[x][y];
        }
        vak.getPersonen().add(veldC.getVeldD().getPersonenlijst().get(0));
        veldC.getVeldD().getPersonenlijst().remove(0);
    }

    public void updatePunten() {
        APLabel.setText(" " + Integer.toString(spelerC.getSpeler().getActiepunten()));
        EPLabel.setText(" " + Integer.toString(spelerC.getSpeler().getExtrapunten()));
        BeschadigingLabel.setText(" " + Integer.toString((int)spelC.spel.getBeschadigingCounter())+" / 24");
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



    }
    public void maakSpeler(String naam, Kleur kleur){
        spel.setSpelers(new Speler(naam, kleur));
    }
    public Speler getHuidigeSpeler(){
        return spel.getHuidigeSpeler();
    }
    public void setHuidigeSpeler(Speler speler){
        spel.setHuidigeSpeler(speler);
    }
    public ArrayList<Speler> getSpelers(){
        return spel.getSpelers();
    }

    // L, verwijderd personen die op vuur staan en vervangd deze met nieuwe.
    public void checkPersonen() {
        int count = 0;
        for(int x = 0; x < 10; x++) {
            for (int y = 0; y < 8; y++) {
                vak = veldC.veldD.getVakken()[x][y];
                if (vak.getPersonen().size() > 0 && vak.isVuur()) {
                    for(int i = 0; i < vak.getPersonen().size(); i++) {
                        if (vak.getPersonen().get(i) != Persoon.NOPE1 ||
                                vak.getPersonen().get(i) != Persoon.NOPE2 ||
                                vak.getPersonen().get(i) != Persoon.NOPE3 ||
                                vak.getPersonen().get(i) != Persoon.NOPE4 ||
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

    public void veranderKlasse() {
        List<String> choices = new ArrayList<>();

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

        Optional<String> keuzeKlasse = dialog3.showAndWait();
        if (keuzeKlasse.isPresent() && keuzeKlasse.get() != "Keuze"){
            String klasse = keuzeKlasse.get();
            System.out.println("Je hebt gekozen voor de klasse: " + klasse);
        }
    }
    public void addBeschadigingCount() {
        spel.setBeschadigingCounter(spel.getBeschadigingCounter()+.5);
    }
}

    // checkWin()

    //TODO checkVerlies()
