package Controller;


import Model.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

import static Model.Status.*;


public class SpeelveldController {
    FlowPane[][]flowPanes = new FlowPane[10][8];
    ImageView[][][]imageViews = new ImageView[10][8][9];
    Image empty = new Image("Resources/GFX/Empty.png",20,20,false,true);
    Image hotspot = new Image("Resources/GFX/Hotspot.png",20,20,false,true);
    Image persoon = new Image("Resources/GFX/Vraagteken.png",20,20,false,true);
    Image vlam = new Image("Resources/GFX/Vlam.png",20,20,false,true);
    Image rook = new Image("Resources/GFX/Rook.png",20,20,false,true);
    Image gevaarlijkeStof = new Image("Resources/GFX/GevaarlijkeStof.png",20,20,false,true);
    Image dichteDeurLinks = new Image("Resources/GFX/DichteDeurLinks.png",20,20,false,true);
    Image dichteDeurOnder = new Image("Resources/GFX/DichteDeurOnder.png",20,20,false,true);
    Image dichteDeurBoven = new Image("Resources/GFX/DichteDeurBoven.png",20,20,false,true);
    Image dichteDeurRechts = new Image("Resources/GFX/DichteDeurRechts.png",20,20,false,true);
    Image openDeurLinks = new Image("Resources/GFX/OpenDeurLinks.png",20,20,false,true);
    Image openDeurOnder = new Image("Resources/GFX/OpenDeurOnder.png",20,20,false,true);
    Image openDeurBoven = new Image("Resources/GFX/OpenDeurBoven.png",20,20,false,true);
    Image openDeurRechts = new Image("Resources/GFX/OpenDeurRechts.png",20,20,false,true);
    Image muurBoven = new Image("Resources/GFX/MuurBoven.png",20,20,false,true);
    Image muurLinks = new Image("Resources/GFX/MuurLinks.png",20,20,false,true);
    Image muurOnder = new Image("Resources/GFX/MuurOnder.png",20,20,false,true);
    Image muurRechts = new Image("Resources/GFX/MuurRechts.png",20,20,false,true);
    Image muur1kapotBoven = new Image("Resources/GFX/Muur1kapotBoven.png",20,20,false,true);
    Image muur1kapotLinks = new Image("Resources/GFX/Muur1kapotLinks.png",20,20,false,true);
    Image muur1kapotOnder = new Image("Resources/GFX/Muur1kapotOnder.png",20,20,false,true);
    Image muur1kapotRechts = new Image("Resources/GFX/Muur1kapotRechts.png",20,20,false,true);
    Image muur2kapotBoven = new Image("Resources/GFX/Muur2kapotBoven.png",20,20,false,true);
    Image muur2kapotLinks = new Image("Resources/GFX/Muur2kapotLinks.png",20,20,false,true);
    Image muur2kapotOnder = new Image("Resources/GFX/Muur2kapotOnder.png",20,20,false,true);
    Image muur2kapotRechts = new Image("Resources/GFX/Muur2kapotRechts.png",20,20,false,true);
    Image brandweerBlauw = new Image("Resources/GFX/Brandweerblauw.png",20,20,false,true);
    Image brandweerGeel = new Image("Resources/GFX/Brandweergeel.png",20,20,false,true);
    Image brandweerGroen = new Image("Resources/GFX/Brandweergroen.png",20,20,false,true);
    Image brandweerOranje = new Image("Resources/GFX/Brandweeroranje.png",20,20,false,true);
    Image brandweerRood = new Image("Resources/GFX/Brandweerrood.png",20,20,false,true);
    Image brandweerZwart = new Image("Resources/GFX/Brandweerzwart.png",20,20,false,true);
    Image oma = new Image("Resources/GFX/Oma.png",20,20,false,true);
    Image vis = new Image("Resources/GFX/Vis.png",20,20,false,true);
    Image egel = new Image("Resources/GFX/Egel.png",20,20,false,true);
    Image hond = new Image("Resources/GFX/(zee)Hond.png",20,20,false,true);
    Image snek = new Image("Resources/GFX/Snek.png",20,20,false,true);
    Image latifah = new Image("Resources/GFX/Latifah.png",20,20,false,true);
    Image roodhaar = new Image("Resources/GFX/Roodhaar.png",20,20,false,true);
    Image groenhaar = new Image("Resources/GFX/Groenhaar.png",20,20,false,true);
    Image obamanigue = new Image("Resources/GFX/Obamanigue.png",20,20,false,true);
    Image hipstersnor = new Image("Resources/GFX/Hipstersnor.png",20,20,false,true);



    Speelveld speelveld = new Speelveld();

    SpelController spelC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;

    public void setControllers(SpelController spelC, SpelerController spelerC, DobbelsteenController dobbelC) {
        this.spelC = spelC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
    }

    public SpeelveldController() {
    }

    //Lion, zet in elke gridpane spot(op het speelveld) een flowpane, en in elke flowpane 9 image views
    private void flowpanesAndImageViewsFactory() {
        for(int y = 0; y<8; y++) {
            for(int x = 0; x<10; x++) {
                spelC.getGridpane().add(flowPanes[x][y],x,y);
                for (int z = 0; z<9; z++) {
                    flowPanes[x][y].getChildren().add(z,imageViews[x][y][z]);
                }
            }
        }
    }

    // Lion, gaat de eigenschappen af van een bepaald vak en laad het goede plaatje in de image View
    private void ImageSetter(int x, int y) {
        // Hotspot
        if(speelveld.getVakken()[x][y].isHotspot()) {
            imageViews[x][y][0].setImage(hotspot);
        } else {
            imageViews[x][y][0].setImage(empty);
        }

        // Obstakel boven
        ImageSetterObstakelLoop(x,y,1,speelveld.getVakken()[x][y].getBoven());

        // Persoon
        if(speelveld.getVakken()[x][y].getPersonen().isEmpty()) {
            imageViews[x][y][2].setImage(empty);
        } else {
            if (!speelveld.getVakken()[x][y].getPersonen().get(0).isOmgedraaid()) {
                imageViews[x][y][2].setImage(empty);
            } else {
                switch(speelveld.getVakken()[x][y].getPersonen().get(0)) {
                    case OMA: imageViews[x][y][2].setImage(oma);
                    break;
                    case VIS: imageViews[x][y][2].setImage(vis);
                    break;
                    case EGEL: imageViews[x][y][2].setImage(egel);
                    break;
                    case HOND: imageViews[x][y][2].setImage(hond);
                    break;
                    case SNEK: imageViews[x][y][2].setImage(snek);
                    break;
                    case LATIFAH: imageViews[x][y][2].setImage(latifah);
                    break;
                    case ROODHAAR: imageViews[x][y][2].setImage(roodhaar);
                    break;
                    case GROENHAAR: imageViews[x][y][2].setImage(groenhaar);
                    break;
                    case OBAMANIGUA: imageViews[x][y][2].setImage(obamanigue);
                    break;
                    case HIPSTERSNOR: imageViews[x][y][2].setImage(hipstersnor);
                    break;
                    default: imageViews[x][y][2].setImage(empty);
                }
            }
        }

        // Obstakel links
        ImageSetterObstakelLoop(x,y,3,speelveld.getVakken()[x][y].getLinks());

        // Spelers
        for(int i = 0; i < 6; i++) {
            if (speelveld.getVakken()[x][y].getKleuren()[i]!=null) {
                switch(speelveld.getVakken()[x][y].getKleuren()[i]) {
                    case GEEL: imageViews[x][y][4].setImage(brandweerGeel);
                        i+=5;
                        break;
                    case ROOD: imageViews[x][y][4].setImage(brandweerRood);
                        i+=5;
                        break;
                    case BLAUW: imageViews[x][y][4].setImage(brandweerBlauw);
                        i+=5;
                        break;
                    case GROEN: imageViews[x][y][4].setImage(brandweerGroen);
                        i+=5;
                        break;
                    case ZWART: imageViews[x][y][4].setImage(brandweerZwart);
                        i+=5;
                        break;
                    case ORANJE: imageViews[x][y][4].setImage(brandweerOranje);
                        i+=5;
                        break;
                }
            }
        }

        // Obstakel rechts
        ImageSetterObstakelLoop(x,y,5,speelveld.getVakken()[x][y].getRechts());

        // Vuur plaats
        if(speelveld.getVakken()[x][y].isVuur()) {
            imageViews[x][y][6].setImage(vlam);
        } else if(speelveld.getVakken()[x][y].isRook()) {
            imageViews[x][y][6].setImage(rook);
        } else {
            imageViews[x][y][6].setImage(empty);
        }

        // Obstakel onder
        ImageSetterObstakelLoop(x,y,7,speelveld.getVakken()[x][y].getOnder());

        // Stoffen
        if(speelveld.getVakken()[x][y].isStoffen()) {
            imageViews[x][y][8].setImage(gevaarlijkeStof);
        } else {
            imageViews[x][y][8].setImage(empty);
        }

    }
    private void ImageSetterObstakelLoop(int x, int y, int z, Status status) {
        switch (status) {
            case MUUR: imageViews[x][y][z].setImage(muurOnder);
                break;
            case MUUR1: imageViews[x][y][z].setImage(muur1kapotOnder);
                break;
            case MUUR2: imageViews[x][y][z].setImage(muur2kapotOnder);
                break;
            case DEURO: imageViews[x][y][z].setImage(openDeurOnder);
                break;
            case DEURD: imageViews[x][y][z].setImage(dichteDeurOnder);
                break;
            case LEEG: imageViews[x][y][z].setImage(empty);
                break;
        }
    }

    // Lion, geeft terug of een vak een bepaalde eigenschap heeft of niet.
    private boolean checkVakEigenschappen(int x, int y, Fiche fiche) {
        switch(fiche) {
            case STOFFEN: return speelveld.getVakken()[x][y].isStoffen();
            case HOTSPOT: return speelveld.getVakken()[x][y].isHotspot();
            case VUUR: return speelveld.getVakken()[x][y].isVuur();
            case ROOK: return speelveld.getVakken()[x][y].isRook();
            case NIKS: return speelveld.getVakken()[x][y].isNiks();
            case PERSOON: if(speelveld.getVakken()[x][y].getPersonen().isEmpty()) {return false;}
                            return true;
            default:
                System.out.println("Unexpected Fiche input: " + fiche + " SpeelveldController.checkVakEigenschappen");
                return false;
        }

    }

    // Lion, geeft terug welke obstakels een vak heeft in een gegeven richting
    private Status checkVakObstakel(int x, int y, Richting richting) {
        switch(richting) {
            case BOVEN: return speelveld.getVakken()[x][y].getBoven();
            case LINKS: return speelveld.getVakken()[x][y].getLinks();
            case ONDER: return speelveld.getVakken()[x][y].getOnder();
            case RECHTS: return speelveld.getVakken()[x][y].getRechts();
            default:
                System.out.println("Unexpected Richting input: " + richting + " SpeelveldController.checkVakObstakel");
                return null;
        }
    }

    // Lion, kijkt of een speler zich op een bepaald vak bevind en geeft al die speler kleuren terug in een arraylist
    private ArrayList<Kleur> checkVakSpeler(int x, int y) {
        ArrayList<Kleur> kleuren= new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if(speelveld.getVakken()[x][y].getKleuren()[i] != null) {
                kleuren.add(speelveld.getVakken()[x][y].getKleuren()[i]);
            }
        }
        return kleuren;
    }

    // Lion, geeft true als de gekozen richting geen hinderend obstakel bevat.
    private boolean checkDoorgaanbaar(int x, int y, Richting richting) {
        switch(richting) {
            case BOVEN:
                return speelveld.getVakken()[x][y].getBoven().isBegaanbaar();
            case LINKS:
                return speelveld.getVakken()[x][y].getLinks().isBegaanbaar();
            case ONDER:
                return speelveld.getVakken()[x][y].getOnder().isBegaanbaar();
            case RECHTS:
                return speelveld.getVakken()[x][y].getRechts().isBegaanbaar();
            default:
                System.out.println("Unexpected Richting input: " + richting + " SpeelveldController.checkDoorgaanbaar");
                return false;
        }
    }

    //Lion/Joep, Zet alle muren en deuren op de goeie plek om het spel te beginnen
    public void setMap(){
        //buitenmuren horizontaal
        for(int x = 1; x <9; x++) {
            speelveld.getVakken()[x][0].setOnder(MUUR);
            speelveld.getVakken()[x][1].setBoven(MUUR);
            speelveld.getVakken()[x][6].setOnder(MUUR);
            speelveld.getVakken()[x][7].setBoven(MUUR);

        }
        //buitenmuren verticaal
        for (int y = 1; y < 7; y++) {
            speelveld.getVakken()[0][y].setRechts(MUUR);
            speelveld.getVakken()[1][y].setLinks(MUUR);
            speelveld.getVakken()[8][y].setRechts(MUUR);
            speelveld.getVakken()[9][y].setLinks(MUUR);

        }
        //scheidingswand woonkamer
        speelveld.getVakken()[1][2].setOnder(MUUR);
        speelveld.getVakken()[1][3].setBoven(MUUR);
        speelveld.getVakken()[2][2].setOnder(MUUR);
        speelveld.getVakken()[2][3].setBoven(MUUR);

        //muur tussen woonkamer en slaapkamer + keuken
        for (int j = 1; j<7;j++){
            speelveld.getVakken()[j][4].setOnder(MUUR);
            speelveld.getVakken()[j][5].setBoven(MUUR);
            speelveld.getVakken()[j][4].setOnder(MUUR);
            speelveld.getVakken()[j][5].setBoven(MUUR);
        }
        //muur tussen woonkamer en badkamer + bergruimte
        for (int k = 1; k<4;k++){
            speelveld.getVakken()[3][k].setRechts(MUUR);
            speelveld.getVakken()[4][k].setLinks(MUUR);
            speelveld.getVakken()[3][k].setRechts(MUUR);
            speelveld.getVakken()[4][k].setLinks(MUUR);
        }
        //muur tussen bergruimte en badkamer
        speelveld.getVakken()[4][1].setOnder(MUUR);
        speelveld.getVakken()[4][2].setBoven(MUUR);
        speelveld.getVakken()[5][1].setOnder(MUUR);
        speelveld.getVakken()[5][2].setBoven(MUUR);

        //overige horizontale muren
        speelveld.getVakken()[4][3].setOnder(MUUR);
        speelveld.getVakken()[4][4].setBoven(MUUR);
        speelveld.getVakken()[7][3].setOnder(MUUR);
        speelveld.getVakken()[7][4].setBoven(MUUR);
        speelveld.getVakken()[8][3].setOnder(MUUR);
        speelveld.getVakken()[8][4].setBoven(MUUR);

        //verticale muur tussen slaapkamer en keuken
        speelveld.getVakken()[3][5].setRechts(MUUR);
        speelveld.getVakken()[4][5].setLinks(MUUR);
        speelveld.getVakken()[3][6].setRechts(MUUR);
        speelveld.getVakken()[4][6].setLinks(MUUR);

        //verticale muur tussen slaapkamers
        speelveld.getVakken()[6][5].setRechts(MUUR);
        speelveld.getVakken()[7][5].setLinks(MUUR);
        speelveld.getVakken()[6][6].setRechts(MUUR);
        speelveld.getVakken()[7][6].setLinks(MUUR);

        //overige muur
        speelveld.getVakken()[5][2].setRechts(MUUR);
        speelveld.getVakken()[6][2].setLinks(MUUR);

        //verticale deuren
        speelveld.getVakken()[5][1].setRechts(DEURD);
        speelveld.getVakken()[6][1].setLinks(DEURD);
        speelveld.getVakken()[5][3].setRechts(DEURD);
        speelveld.getVakken()[6][3].setLinks(DEURD);
        speelveld.getVakken()[6][4].setRechts(DEURD);
        speelveld.getVakken()[7][4].setLinks(DEURD);

        //horizontale deuren
        speelveld.getVakken()[5][4].setBoven(DEURD);
        speelveld.getVakken()[5][3].setOnder(DEURD);
        speelveld.getVakken()[6][4].setBoven(DEURD);
        speelveld.getVakken()[6][3].setOnder(DEURD);
        speelveld.getVakken()[6][5].setBoven(DEURD);
        speelveld.getVakken()[6][4].setOnder(DEURD);
        speelveld.getVakken()[3][5].setBoven(DEURD);
        speelveld.getVakken()[3][4].setOnder(DEURD);

        //buitenmuren waar deuren horen leeg maken
        speelveld.getVakken()[0][3].setRechts(LEEG);
        speelveld.getVakken()[1][3].setLinks(LEEG);

        speelveld.getVakken()[3][7].setBoven(LEEG);
        speelveld.getVakken()[3][6].setOnder(LEEG);



    }

    // Lion, handeld obstakels voor explosies en hakken
    private void doeBeschadiging(int x, int y, Richting richting) {
        Vak vak = speelveld.getVakken()[x][y];
        switch(richting) {
            case BOVEN:
                if (y>0) {
                    switch(vak.getBoven()) {
                        case MUUR:  vak.setBoven(MUUR1);
                            speelveld.getVakken()[x][y-1].setOnder(MUUR1);
                            break;
                        case MUUR1: vak.setBoven(MUUR2);
                            speelveld.getVakken()[x][y-1].setOnder(MUUR2);
                            break;
                        case DEURD: vak.setBoven(LEEG);
                            speelveld.getVakken()[x][y-1].setOnder(LEEG);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Boven)");
                    }
                }
                break;
            case RECHTS:
                if (x<9) {
                    switch(vak.getRechts()) {
                        case MUUR:  vak.setRechts(MUUR1);
                            speelveld.getVakken()[x+1][y].setLinks(MUUR1);
                            break;
                        case MUUR1: vak.setRechts(MUUR2);
                            speelveld.getVakken()[x+1][y].setLinks(MUUR2);
                            break;
                        case DEURD: vak.setRechts(LEEG);
                            speelveld.getVakken()[x+1][y].setLinks(LEEG);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Rechts)");
                    }
                }
                break;
            case LINKS:
                if (y<7) {
                    switch(vak.getOnder()) {
                        case MUUR:  vak.setOnder(MUUR1);
                            speelveld.getVakken()[x][y+1].setBoven(MUUR1);
                            break;
                        case MUUR1: vak.setOnder(MUUR2);
                            speelveld.getVakken()[x][y+1].setBoven(MUUR2);
                            break;
                        case DEURD: vak.setOnder(LEEG);
                            speelveld.getVakken()[x][y+1].setBoven(LEEG);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Links)");
                    }
                }
                break;
            case ONDER:
                if (x>0) {
                    switch(vak.getLinks()) {
                        case MUUR:  vak.setLinks(MUUR1);
                            speelveld.getVakken()[x-1][y].setRechts(MUUR1);
                            break;
                        case MUUR1: vak.setLinks(MUUR2);
                            speelveld.getVakken()[x-1][y].setRechts(MUUR2);
                            break;
                        case DEURD: vak.setLinks(LEEG);
                            speelveld.getVakken()[x-1][y].setRechts(LEEG);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Onder)");
                    }
                }
                break;
            default:
                System.out.println("Unexpected Richting: " + richting + "SpeelveldController.doeBeschadiging.default");
        }




    }
}
