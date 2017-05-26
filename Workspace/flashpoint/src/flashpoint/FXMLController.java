package flashpoint;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FXMLController {
    @FXML private Button btnUP;
    @FXML private Button btnLEFT;
    @FXML private Button btnRIGHT;
    @FXML private Button btnDOWN;
    @FXML private Button btnSpecial;
    @FXML private GridPane gridpane;
    View view = new View();
    Speelveld speelveld = new Speelveld();

    private void update() {                     //ArrayIndexOutOfBoundsException please fix me
        for(int x=0; x<10; x++) {
            for(int y=0; y<8; x++) {
                for(int z=0; z<4; z++) {
                    view.update(speelveld, gridpane, x,y,z);
                }
            }
        }
    }

    @FXML private void initialize() {
        ImageView iv2 = new ImageView(new Image("GFX/(zee)Hond.png"));
        int x = 75;
        iv2.setFitHeight(x);
        iv2.setFitWidth(x);

        DeurOpenenSluiten deurOpenenSluiten = new DeurOpenenSluiten();


        Bewegen bewegen = new Bewegen();
        Speler speler1 = new Speler("Joep", Kleur.ROOD, iv2);
        speler1.setLocatieAll(2,4);
        gridpane.add(iv2,speler1.getLocatieX(),speler1.getLocatieY());

        gridpane.add(speelveld.getVakken()[2][2].addDeur(0),2,2);
        gridpane.add(speelveld.getVakken()[2][1].addDeur(2),2,1);


        speelveld.getVakken()[4][1].addMuur(1);
        speelveld.getVakken()[5][1].addMuur(3);



        btnLEFT.setOnAction((event) -> {
            System.out.println("LEFT");
            bewegen.run(3,speler1,speelveld,gridpane);
//            update();
        });

        btnRIGHT.setOnAction((event) -> {
            System.out.println("RIGHT");
            bewegen.run(1,speler1,speelveld,gridpane);
//            update();
        });

        btnUP.setOnAction((event) -> {
            System.out.println("UP");
            bewegen.run(0,speler1,speelveld,gridpane);
//            update();
        });

        btnDOWN.setOnAction((event) -> {
            System.out.println("DOWN");
            bewegen.run(2,speler1,speelveld,gridpane);
//            update();
        });

        btnSpecial.setOnAction((event) -> {
            System.out.println("Special");
            deurOpenenSluiten.run(0,speler1,speelveld);
//            update();
        });
    }
}

