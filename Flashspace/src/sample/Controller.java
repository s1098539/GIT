package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    private GridPane gridpane;

    FlowPane[][]fp = new FlowPane[10][8];
    Speelveld veld = new Speelveld();
    ImageView[]ivarray = new ImageView[720];
    View view = new View(fp,veld);
    BeurtAfronding ba = new BeurtAfronding(veld);
    Speler speler = new Speler("Lion", Kleur.BLAUW, 4,3);
    SpelerActie sa = new SpelerActie(speler, veld);

    @FXML
    public void initialize() {
        System.out.println("test");

        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                fp[x][y] = new FlowPane();
                gridpane.add(fp[x][y],x,y);
            }
        }

        for(int c=1; c<9; c++){
            veld.getVakken()[c][2].setObstakel(0,1);
        }

        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                veld.getVak(x, y).addObject(new Object.Vuur());
            }
        }

        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                veld.getVak(x, y).addObject(new Object.BrandHaard());
            }
        }

        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                veld.getVak(x, y).addObject(new Object.PersoonVanAandacht());
            }
        }

        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 4; z++) {
                    veld.getVak(x, y).setObstakel(z, 0);
                }
            }
        }
        view.makeWalls();

        for (int i = 0; i < 100000; i++) {
            view.update();
        }

    }
}
