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
        BeurtAfronding ba = new BeurtAfronding(veld);
        Speler speler = new Speler("Lion", Kleur.BLAUW, 4,3);
        SpelerActie sa = new SpelerActie(speler, veld);


        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                veld.getVak(x, y).addObject(new Object.Vuur());
            }
        }

//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                veld.getVak(x, y).addObject(new Object.BrandHaard());
//            }
//        }

//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                veld.getVak(x, y).addObject(new Object.PersoonVanAandacht());
//            }
//        }

//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                for (int z = 0; z < 4; z++) {
//                    veld.getVak(x, y).setObstakel(z, 0);
//                }
//            }
//        }

        for (int i = 0; i < 1; i++) {
            ba.newRook();
        }
        makeWalls();
        sa.BrandweerwagenSpuitActie(1);
        update();
    }

    public void makeWalls() {
        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 4; z++) {
                    switch(veld.getVak(x,y).checkObstakels(z)) {
                        case 0:
                            if (z ==0) {
                                veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image("sample/gfx/MuurOnder.png",20,20,false,true))),z);
                            }
                            if (z ==1) {
                                veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image("sample/gfx/MuurLinks.png",20,20,false,true))),z);
                            }
                            if (z ==2) {
                                veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image("sample/gfx/MuurBoven.png",20,20,false,true))),z);
                            }
                            if (z ==3) {
                                veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image("sample/gfx/MuurRechts.png",20,20,false,true))),z);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void update() {
        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 9; z++) {
                    if (z == 0) {
                        fp[x][y].getChildren().clear();
                    }
                    if (veld.getVak(x,y).getObjecten()[z] != null) {
                        fp[x][y].getChildren().add(veld.getVak(x, y).getObjecten()[z].getImageView());
                        }
                        else {
                        fp[x][y].getChildren().add(new ImageView(new Image("sample/gfx/Empty.png", 20, 20, false, true)));
                    }

                }
            }
        }
    }
}
