package flashpoint;

import javafx.application.Platform;
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
    @FXML private Button btnEndTurn;
    @FXML private GridPane gridpane;
    View view = new View();
    Speelveld speelveld = new Speelveld();

    private void doorEverywhere() {                         //Testing thing, zet op elke plek een deur
        for(int x=0; x<10; x++) {
            for(int y=0; y<8; y++) {
                for(int z=0; z<4; z++) {
                    speelveld.getVakken()[x][y].addDeur(z);
                }
            }
        }
    }

    private void muurEverywhere() {                         //Testing thing, zet op elke plek een muur
        for(int x=0; x<10; x++) {

            for(int y=0; y<8; y++) {
                for(int z=0; z<4; z++) {
                    speelveld.getVakken()[x][y].addMuur(z);
                }
            }
        }
    }

    private void update() {                                 //Might run in to memory problems (tried arraylist.clear() but made no difference
        for(int x=0; x<10; x++) {                           //If you want to test this, at the moment it crashes if you put a door everywhere and open 3
            for(int y=0; y<8; y++) {
                for(int z=0; z<4; z++) {
                    view.update(speelveld, gridpane, x,y,z);
                }
            }
        }
    }

    @FXML private void initialize() {
        ImageView iv2 = new ImageView(new Image("gfx/snek.png"));
        int x = 600;
        int y = 480;
        iv2.setFitHeight(y);
        iv2.setFitWidth(x);

        DeurOpenenSluiten deurOpenenSluiten = new DeurOpenenSluiten();
        Hakken hakken = new Hakken();


        Bewegen bewegen = new Bewegen();
        Speler speler1 = new Speler("Joep", Kleur.ROOD, iv2);
        speler1.setLocatieAll(2,4);
        gridpane.add(iv2,speler1.getLocatieX(),speler1.getLocatieY());


        speelveld.getVakken()[3][3].addDeur(0);
        speelveld.getVakken()[3][2].addDeur(2);


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

        btnSpecial.setOnAction((event) -> {
            System.out.println("Special");
            hakken.run(1,speler1,speelveld);
        });

        btnEndTurn.setOnAction((event) -> {
            System.out.println("End turn");
            update();
        });
    }
}

