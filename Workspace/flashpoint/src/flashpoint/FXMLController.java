package flashpoint;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FXMLController {
    @FXML private Button btnUP;
    @FXML private Button btnLEFT;
    @FXML private Button btnRIGHT;
    @FXML private Button btnDOWN;
    @FXML private GridPane gridpane;

    @FXML private void initialize() {
        //ImageView iv2 = new ImageView(new Image("http://www.i2symbol.com/images/cool-letters/katakana/katakana_middle_dot_u30FB_icon_256x256.png"));
        ImageView iv2 = new ImageView(new Image("GFX/(zee)Hond.png"));
        int x = 75;
        iv2.setFitHeight(x);
        iv2.setFitWidth(x);


        Dobbelsteen dobbelsteen = new Dobbelsteen(8);
        dobbelsteen.gooi();
        System.out.println(dobbelsteen.getWaarde());
        dobbelsteen.flip();
        System.out.println(dobbelsteen.getWaarde());

        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        Speler speler1 = new Speler("Joep", Kleur.ROOD, iv2);
        speler1.setLocatieAll(2,4);
        gridpane.add(iv2,speler1.getLocatieX(),speler1.getLocatieY());

        speelveld.getVakken()[2][2].addDeur(0);
        speelveld.getVakken()[2][1].addDeur(2);
        speelveld.getVakken()[4][1].addMuur(1);
        speelveld.getVakken()[5][1].addMuur(3);

        btnLEFT.setOnAction((event) -> {
            System.out.println("LEFT");
            bewegen.run(3,speler1,speelveld,gridpane);
        });

        btnRIGHT.setOnAction((event) -> {
            System.out.println("RIGHT");
            bewegen.run(1,speler1,speelveld,gridpane);
        });

        btnUP.setOnAction((event) -> {
            System.out.println("UP");
            bewegen.run(0,speler1,speelveld,gridpane);
        });

        btnDOWN.setOnAction((event) -> {
            System.out.println("DOWN");
            bewegen.run(2,speler1,speelveld,gridpane);
        });
    }
}

