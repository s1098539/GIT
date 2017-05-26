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
        ImageView iv2 = new ImageView(new Image("http://icons.iconarchive.com/icons/kidaubis-design/cool-heroes/128/Ironman-icon.png"));

        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        Speler speler1 = new Speler("Joep", Kleur.ROOD, iv2);
        speler1.setLocatieAll(2,4);
        gridpane.add(iv2,speler1.getLocatieX(),speler1.getLocatieY());

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

