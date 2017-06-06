//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import sample.Object.GevaarlijkeStof;
import sample.Object.Speler;

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
    private Button btnSpecial;
    private FlowPane[][] fp = new FlowPane[10][8];
    private Speelveld veld = new Speelveld();
    ImageView[] ivarray = new ImageView[720];
    private View view;
    private BeurtAfronding ba;
    private Speler speler;
    SpelerActie sa;
    private Boolean hakken;

    public Controller() {
        this.view = new View(this.fp, this.veld);
        this.ba = new BeurtAfronding(this.veld);
        this.speler = new Speler("Lion", Kleur.ZWART, 4, 3);
        this.sa = new SpelerActie(this.speler, this.veld);
        this.hakken = Boolean.valueOf(false);
    }

    @FXML
    public void initialize() {
        this.veld.getVak(this.speler.getX(), this.speler.getY()).addObject(this.speler);
        System.out.println("test");

        int x;
        int y;
        for(x = 0; x < 10; ++x) {
            for(y = 0; y < 8; ++y) {
                this.fp[x][y] = new FlowPane();
                this.gridpane.add(this.fp[x][y], x, y);
            }
        }

        for(x = 0; x < 10; ++x) {
            for(y = 0; y < 8; ++y) {
                for(int z = 0; z < 4; ++z) {
                    this.veld.getVak(x, y).setObstakel(z, 0);
                }
            }
        }

        this.veld.getVak(2, 2).addObject(new GevaarlijkeStof());
        this.veld.getVak(9, 7).addObject(new GevaarlijkeStof());
        this.view.update();
        this.btnUP.setOnAction((event) -> {
            if(this.hakken.booleanValue()) {
                this.sa.muurInteractie(0);
            } else {
                this.veld.getVak(this.speler.getX(), this.speler.getY()).removeObject(4);
                this.sa.beweegwActie(0);
                this.veld.getVak(this.speler.getX(), this.speler.getY()).addObject(this.speler);
            }

            this.view.update();
        });
        this.btnLEFT.setOnAction((event) -> {
            if(this.hakken.booleanValue()) {
                this.sa.muurInteractie(3);
            } else {
                this.veld.getVak(this.speler.getX(), this.speler.getY()).removeObject(4);
                this.sa.beweegwActie(3);
                this.veld.getVak(this.speler.getX(), this.speler.getY()).addObject(this.speler);
            }

            this.view.update();
        });
        this.btnRIGHT.setOnAction((event) -> {
            if(this.hakken.booleanValue()) {
                this.sa.muurInteractie(1);
            } else {
                this.veld.getVak(this.speler.getX(), this.speler.getY()).removeObject(4);
                this.sa.beweegwActie(1);
                this.veld.getVak(this.speler.getX(), this.speler.getY()).addObject(this.speler);
            }

            this.view.update();
        });
        this.btnDOWN.setOnAction((event) -> {
            if(this.hakken.booleanValue()) {
                this.sa.muurInteractie(2);
            } else {
                this.veld.getVak(this.speler.getX(), this.speler.getY()).removeObject(4);
                this.sa.beweegwActie(2);
                this.veld.getVak(this.speler.getX(), this.speler.getY()).addObject(this.speler);
            }

            this.view.update();
        });
        this.imgHakken.setOnMouseClicked((event) -> {
            if(this.hakken.booleanValue()) {
                this.hakken = Boolean.valueOf(false);
            } else {
                this.hakken = Boolean.valueOf(true);
            }

            System.out.println(this.hakken);
        });
        this.btnSpecial.setOnAction((event) -> {
            for(int vaak = 0; vaak < 3; ++vaak) {
                this.ba.newRook();
                this.ba.handleVonkoverslag();
                this.ba.handleGevaarlijkeStof();
                this.view.update();
            }

        });
    }
}
