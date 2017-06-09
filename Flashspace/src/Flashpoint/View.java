package Flashpoint;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class View{
    FlowPane[]flowPanes = new FlowPane[80];
    ImageView[]imageViews = new ImageView[720];

    Image empty = new Image("sample/gfx/Empty.png",20,20,false,true);
    Image hotspot = new Image("sample/gfx/Hotspot.png",20,20,false,true);
    Image persoon = new Image("sample/gfx/Vraagteken.png",20,20,false,true);
    Image vlam = new Image("sample/gfx/Vlam.png",20,20,false,true);
    Image rook = new Image("sample/gfx/Rook.png",20,20,false,true);
    Image gevaarlijkeStof = new Image("sample/gfx/GevaarlijkeStof.png",20,20,false,true);
    Image dichteDeurLinks = new Image("sample/gfx/DichteDeurLinks.png",20,20,false,true);
    Image dichteDeurOnder = new Image("sample/gfx/DichteDeurOnder.png",20,20,false,true);
    Image dichteDeurBoven = new Image("sample/gfx/DichteDeurBoven.png",20,20,false,true);
    Image dichteDeurRechts = new Image("sample/gfx/DichteDeurRechts.png",20,20,false,true);
    Image openDeurLinks = new Image("sample/gfx/OpenDeurLinks.png",20,20,false,true);
    Image openDeurOnder = new Image("sample/gfx/OpenDeurOnder.png",20,20,false,true);
    Image openDeurBoven = new Image("sample/gfx/OpenDeurBoven.png",20,20,false,true);
    Image openDeurRechts = new Image("sample/gfx/OpenDeurRechts.png",20,20,false,true);
    Image muurBoven = new Image("sample/gfx/MuurBoven.png",20,20,false,true);
    Image muurLinks = new Image("sample/gfx/MuurLinks.png",20,20,false,true);
    Image muurOnder = new Image("sample/gfx/MuurOnder.png",20,20,false,true);
    Image muurRechts = new Image("sample/gfx/MuurRechts.png",20,20,false,true);
    Image muur1kapotBoven = new Image("sample/gfx/Muur1kapotBoven.png",20,20,false,true);
    Image muur1kapotLinks = new Image("sample/gfx/Muur1kapotLinks.png",20,20,false,true);
    Image muur1kapotOnder = new Image("sample/gfx/Muur1kapotOnder.png",20,20,false,true);
    Image muur1kapotRechts = new Image("sample/gfx/Muur1kapotRechts.png",20,20,false,true);
    Image muur2kapotBoven = new Image("sample/gfx/Muur2kapotBoven.png",20,20,false,true);
    Image muur2kapotLinks = new Image("sample/gfx/Muur2kapotLinks.png",20,20,false,true);
    Image muur2kapotOnder = new Image("sample/gfx/Muur2kapotOnder.png",20,20,false,true);
    Image muur2kapotRechts = new Image("sample/gfx/Muur2kapotRechts.png",20,20,false,true);
    Image brandweerBlauw = new Image("sample/gfx/Brandweerblauw.png",20,20,false,true);
    Image brandweerGeel = new Image("sample/gfx/Brandweergeel.png",20,20,false,true);
    Image brandweerGroen = new Image("sample/gfx/Brandweergroen.png",20,20,false,true);
    Image brandweerOranje = new Image("sample/gfx/Brandweeroranje.png",20,20,false,true);
    Image brandweerRood = new Image("sample/gfx/Brandweerrood.png",20,20,false,true);
    Image brandweerZwart = new Image("sample/gfx/Brandweerzwart.png",20,20,false,true);



    void imageViewsFactory() {
        for(int i = 0; i<720; i++) {
            imageViews[i] = new ImageView();
        }
    }

    public FlowPane[] getFlowPanes() {
        return flowPanes;
    }

    public void flowPanesFactory() {
        int u = 0;
        for(int i = 0; i<80; i++) {
            flowPanes[i] = new FlowPane();
            for (int q = 0; q<9; q++) {
                flowPanes[i].getChildren().add(imageViews[u]);
                u++;
            }
        }
    }

    public void imageSetter(Speelveld veld, Speler speler) {
        int q = 0;
        for(int y = 0; y<8; y++) {
            for (int x = 0; x < 10; x++) {

                //Hotspot
                if(veld.getVak(x,y).isHotspot()) {
                    imageViews[q].setImage(hotspot);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;

                //Obstakel boven

                switch (veld.getVak(x,y).boven) {
                    case MUUR: imageViews[q].setImage(muurOnder);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotOnder);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotOnder);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurOnder);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurOnder);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }
                q++;

                //Persoon!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Deze wordt denk ik anders maar voor nu werkt die ff goed genoeg
                if(veld.getVak(x,y).isPersoon()) {

                    imageViews[q].setImage(persoon);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;

                //Obstakel links!

                switch (veld.getVak(x,y).links) {
                    case MUUR: imageViews[q].setImage(muurRechts);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotRechts);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotRechts);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurRechts);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurRechts);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }

                q++;

                //Spelers
                if(speler.getX()==x && speler.getY()==y) {
                    switch(speler.getKleur()) {
                        case GEEL: imageViews[q].setImage(brandweerGeel);
                            break;
                        case ROOD: imageViews[q].setImage(brandweerRood);
                            break;
                        case BLAUW: imageViews[q].setImage(brandweerBlauw);
                            break;
                        case GROEN: imageViews[q].setImage(brandweerGroen);
                            break;
                        case ZWART: imageViews[q].setImage(brandweerZwart);
                            break;
                        case ORANJE: imageViews[q].setImage(brandweerOranje);
                            break;
                        default:
                            System.out.println("How did this even happen :|");
                            break;
                    }
                } else {
                    imageViews[q].setImage(empty);
                }
//                for(int i = 0; i<6; i++) {
//                    if(veld.getVak(x,y).getKleuren(i) != null) {
//                        switch(veld.getVak(x,y).getKleuren(i)) {
//                            case GEEL: imageViews[q].setImage(brandweerGeel);
//                                break;
//                            case ROOD: imageViews[q].setImage(brandweerRood);
//                                break;
//                            case BLAUW: imageViews[q].setImage(brandweerBlauw);
//                                break;
//                            case GROEN: imageViews[q].setImage(brandweerGroen);
//                                break;
//                            case ZWART: imageViews[q].setImage(brandweerZwart);
//                                break;
//                            case ORANJE: imageViews[q].setImage(brandweerOranje);
//                                break;
//                            default:
//                                System.out.println("How did this even happen :|");
//                                break;
//                        }
//                    }
//                }
                q++;

                //Obstakel rechts
                switch (veld.getVak(x,y).rechts) {
                    case MUUR: imageViews[q].setImage(muurLinks);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotLinks);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotLinks);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurLinks);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurLinks);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }

                q++;

                //Vuur plaats
                if(veld.getVak(x,y).isVuur()) {
                   imageViews[q].setImage(vlam);
                } else if(veld.getVak(x,y).isRook()) {
                    imageViews[q].setImage(rook);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;

                //Obstakel onder
                switch (veld.getVak(x,y).onder) {
                    case MUUR: imageViews[q].setImage(muurBoven);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotBoven);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotBoven);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurBoven);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurBoven);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }
                q++;

                //Stoffen
                if(veld.getVak(x,y).isStoffen()) {
                    imageViews[q].setImage(gevaarlijkeStof);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;
            }
        }
    }



















//    ImageView[]ivarray = new ImageView[720];
//    FlowPane[][]fp;
//    Speelveld veld;
//    Image muurOnder;
//    Image muurLinks;
//    Image muurBoven;
//    Image muurRechts;
//
//
//    public View(FlowPane[][] fp, Speelveld veld) {
//        this.fp = fp;
//        this.veld = veld;
//        for (int i = 0; i<720; i++) {
//            ivarray[i] = new ImageView(new Image("sample/gfx/Empty.png", 20, 20, false, true));
//        }
//    }
//
//    public void update() {
//        makeObstakels();
//        int count = 0;
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                for (int z = 0; z < 9; z++) {
//                    if (z == 0) {
//                        fp[x][y].getChildren().clear();
//                    }
//                    if (veld.getVak(x,y).getObjecten()[z] != null) {
//                        fp[x][y].getChildren().add(veld.getVak(x, y).getObjecten()[z].getImageView());
//                    }
//                    else {
//                        fp[x][y].getChildren().add(ivarray[count]);
//                        count++;
//                    }
//
//                }
//            }
//        }
//    }
//
//    public void makeObstakels() {
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                for (int z = 0; z < 4; z++) {
//                    switch(veld.getVak(x,y).checkObstakels(z)) {
//                        case 0:
//                            switch(z) {
//                                case 0:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurOnder.png");
//                                    break;
//                                case 1:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurLinks.png");
//                                    break;
//                                case 2:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurBoven.png");
//                                    break;
//                                case 3:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/MuurRechts.png");
//                                    break;
//                            }
//                            break;
//                        case 1:
//                            switch(z) {
//                                case 0:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotOnder.png");
//                                    break;
//                                case 1:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotLinks.png");
//                                    break;
//                                case 2:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotBoven.png");
//                                    break;
//                                case 3:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur1kapotRechts.png");
//                                    break;
//                            }
//                            break;
//                        case 2:
//                            switch(z) {
//                                case 0:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotOnder.png");
//                                    break;
//                                case 1:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotLinks.png");
//                                    break;
//                                case 2:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotBoven.png");
//                                    break;
//                                case 3:
//                                    makeWallsAssistent(x, y, z, "sample/gfx/Muur2kapotRechts.png");
//                                    break;
//                            }
//                            break;
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
//                            break;
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
//                            break;
//                    }
//                }
//            }
//        }
//    }
//
//    private void makeWallsAssistent(int x, int y, int z, String png) {
//        if (z ==0) {
//            veld.getVak(x,y).removeObject(1);
//            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//        if (z ==1) {
//            veld.getVak(x,y).removeObject(5);
//            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//        if (z ==2) {
//            veld.getVak(x,y).removeObject(7);
//            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//        if (z ==3) {
//            veld.getVak(x,y).removeObject(3);
//            veld.getVak(x,y).addMuur(new Object.Muur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//    }
//
//    private void makeDoorsAssistent(int x, int y, int z, String png) {
//        if (z ==0) {
//            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//        if (z ==1) {
//            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//        if (z ==2) {
//            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//        if (z ==3) {
//            veld.getVak(x,y).addMuur(new Object.Deur(new ImageView(new Image(png,20,20,false,true))),z);
//        }
//    }
}
