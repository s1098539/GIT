package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

/**
 * Created by Lion on 4-6-2017.
 */
public class View {
    ImageView[]ivarray = new ImageView[720];
    FlowPane[][]fp;
    Speelveld veld;


    public View(FlowPane[][] fp, Speelveld veld) {
        this.fp = fp;
        this.veld = veld;
        for (int i = 0; i<720; i++) {
            ivarray[i] = new ImageView(new Image("sample/gfx/Empty.png", 20, 20, false, true));
        }
    }

    public void update() {
        makeObstakels();
        int count = 0;
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
                        fp[x][y].getChildren().add(ivarray[count]);
                        count++;
                    }

                }
            }
        }
    }

    public void makeObstakels() {
        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 4; z++) {
                    switch(veld.getVak(x,y).checkObstakels(z)) {
                        case 0:
                            switch(z) {
                                case 0:
                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurOnder.png");
                                    break;
                                case 1:
                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurLinks.png");
                                    break;
                                case 2:
                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurBoven.png");
                                    break;
                                case 3:
                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurRechts.png");
                                    break;
                            }
                            break;
                        case 1:
                            switch(z) {
                                case 0:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotOnder.png");
                                    break;
                                case 1:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotLinks.png");
                                    break;
                                case 2:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotBoven.png");
                                    break;
                                case 3:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotRechts.png");
                                    break;
                            }
                            break;
                        case 2:
                            switch(z) {
                                case 0:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotOnder.png");
                                    break;
                                case 1:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotLinks.png");
                                    break;
                                case 2:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotBoven.png");
                                    break;
                                case 3:
                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotRechts.png");
                                    break;
                            }
//                        case 3:
//                            switch(z) {
//                                case 0:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/DichteDeurOnder.png");
//                                    break;
//                                case 1:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/DichteDeurLinks.png");
//                                    break;
//                                case 2:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/DichteDeurBoven.png");
//                                    break;
//                                case 3:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/DichteDeurRechts.png");
//                                    break;
//                            }
//                        case 4:
//                            switch(z) {
//                                case 0:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/OpenDeurOnder.png");
//                                    break;
//                                case 1:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/OpenDeurLinks.png");
//                                    break;
//                                case 2:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/OpenDeurBoven.png");
//                                    break;
//                                case 3:
//                                    makeDoorsAssistent(x, y, z, "sample/gfx/OpenDeurRechts.png");
//                                    break;
//                            }
                    }
                }
            }
        }
    }

    private void makeWallsAssistent(int x, int y, int z, String png) {
        if (z ==0) {
            veld.getVak(x,y).removeObject(1);
            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
        }
        if (z ==1) {
            veld.getVak(x,y).removeObject(5);
            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
        }
        if (z ==2) {
            veld.getVak(x,y).removeObject(7);
            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
        }
        if (z ==3) {
            veld.getVak(x,y).removeObject(3);
            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
        }
    }

    private void makeDoorsAssistent(int x, int y, int z, String png) {
        if (z ==0) {
            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
        }
        if (z ==1) {
            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
        }
        if (z ==2) {
            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
        }
        if (z ==3) {
            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
        }
    }
}
