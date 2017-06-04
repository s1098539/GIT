package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    private GridPane gridpane;

    private FlowPane[][]fp = new FlowPane[10][8];
    private Speelveld veld = new Speelveld();
    ImageView[]ivarray = new ImageView[720];
    private View view = new View(fp,veld);
    private BeurtAfronding ba = new BeurtAfronding(veld);
    private Speler speler = new Speler("Lion", Kleur.BLAUW, 4,3);
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

//        for(int c=1; c<9; c++){
//            veld.getVakken()[c][2].setObstakel(0,1);
//        }
//
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                veld.getVak(x, y).addObject(new Object.Vuur());
//            }
//        }
//
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                veld.getVak(x, y).addObject(new Object.BrandHaard());
//            }
//        }
//
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                veld.getVak(x, y).addObject(new Object.PersoonVanAandacht());
//            }
//        }
//
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                for (int z = 0; z < 4; z++) {
//                    veld.getVak(x, y).setObstakel(z, 0);
//                }
//            }
//        }

//        view.makeWalls();




        //Vonko naar boven test (linker verticale lijn)
        veld.getVak(3, 0).addObject(new Object.Rook());
        veld.getVak(3, 1).addObject(new Object.Rook());
        veld.getVak(3, 2).addObject(new Object.Rook());
        veld.getVak(3,3).addObject(new Object.Rook());
        veld.getVak(3, 4).addObject(new Object.Rook());
        veld.getVak(3, 5).addObject(new Object.Vuur());

        //Vonko naar beneden test (rechter verticale lijn)
        veld.getVak(5, 0).addObject(new Object.Vuur());
        veld.getVak(5, 1).addObject(new Object.Rook());
        veld.getVak(5, 2).addObject(new Object.Rook());
        veld.getVak(5,3).addObject(new Object.Rook());
        veld.getVak(5, 4).addObject(new Object.Rook());
        veld.getVak(5, 5).addObject(new Object.Rook());

        //Vonko naar links test (linker horizontale lijn)
        veld.getVak(0, 7).addObject(new Object.Rook());
        veld.getVak(1, 7).addObject(new Object.Rook());
        veld.getVak(2, 7).addObject(new Object.Rook());
        veld.getVak(3, 7).addObject(new Object.Rook());
        veld.getVak(4, 7).addObject(new Object.Vuur());

        //Vonka naar rechts test (rechter horizontale lijn)
        veld.getVak(6, 7).addObject(new Object.Vuur());
        veld.getVak(7, 7).addObject(new Object.Rook());
        veld.getVak(8, 7).addObject(new Object.Rook());
        veld.getVak(9, 7).addObject(new Object.Rook());


        ba.handleVonkoverslag();

        view.update();


    }
}
