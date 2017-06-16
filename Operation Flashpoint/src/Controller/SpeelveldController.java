package Controller;


import Model.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

import static Model.Status.*;

public class SpeelveldController {


    Speelveld veld;

    SpelController spelC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;

    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpelController spelC, SpelerController spelerC, DobbelsteenController dobbelC) {
        this.spelC = spelC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
    }

    public SpeelveldController() {

    }

    public SpeelveldController(SpelController spelC, SpelerController spelerC, DobbelsteenController dobbelC) {
        this.spelC = spelC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
    }

    // Lion, dit is het eerste wat deze controller doet, dit stond eerst in de constructor maar dit gaf problemen
    //          aangezien de controller bij het aanmaken nog niet was verbonden met de andere controllers
    public void run() {
        FactoryVakken fv = new FactoryVakken();
        fv.createVakken();
        veld = new Speelveld();
        veld.setVakken(fv.getVakken());
        veld.setGridPane(new GridPane());
        veld.getGridPane().setPrefWidth(700);
        veld.getGridPane().setPrefHeight(640);
        flowpanesAndImageViewsFactory();
        flowpanesAndImageViewsPlaatser();
        setMap();
        for(int y = 0; y<8; y++) {
            for (int x = 0; x < 10; x++) {
                ImageSetter(x,y);
            }
        }
        spelC.run();
    }


    // Lion, maakt alle flowpanes en imageviews aan
    private void flowpanesAndImageViewsFactory() {
        for(int y = 0; y<8; y++) {
            for (int x = 0; x < 10; x++) {
                veld.getFlowPanes()[x][y]=new FlowPane();
                for(int z = 0; z < 9 ; z++) {
                    veld.getImageViews()[x][y][z] = new ImageView();
                }
            }
        }
    }

    //Lion, zet in elke gridpane spot(op het veld) een flowpane, en in elke flowpane 9 image views
    private void flowpanesAndImageViewsPlaatser() {
        for(int y = 0; y<8; y++) {
            for(int x = 0; x<10; x++) {
                veld.getGridPane().add(veld.getFlowPanes()[x][y],x,y);
                for (int z = 0; z<9; z++) {
                    veld.getFlowPanes()[x][y].getChildren().add(z,veld.getImageViews()[x][y][z]);
                }
            }
        }
    }

    // Lion, gaat de eigenschappen af van een bepaald vak en laad het goede plaatje in de image View
    private void ImageSetter(int x, int y) {
        // Hotspot
        if(veld.getVakken()[x][y].isHotspot()) {
            veld.getImageViews()[x][y][0].setImage(veld.getHotspot());
        } else {
            veld.getImageViews()[x][y][0].setImage(veld.getEmpty());
        }

        // Obstakel boven
        switch (veld.getVakken()[x][y].getBoven()) {
            case MUUR: veld.getImageViews()[x][y][1].setImage(veld.getMuurOnder());
                break;
            case MUUR1: veld.getImageViews()[x][y][1].setImage(veld.getMuur1kapotOnder());
                break;
            case MUUR2: veld.getImageViews()[x][y][1].setImage(veld.getMuur2kapotOnder());
                break;
            case DEURO: veld.getImageViews()[x][y][1].setImage(veld.getOpenDeurOnder());
                break;
            case DEURD: veld.getImageViews()[x][y][1].setImage(veld.getDichteDeurOnder());
                break;
            case LEEG: veld.getImageViews()[x][y][1].setImage(veld.getEmpty());
                break;
        }

        // Persoon
        if(veld.getVakken()[x][y].getPersonen().isEmpty()) {
            veld.getImageViews()[x][y][2].setImage(veld.getEmpty());
        } else {
            if (!veld.getVakken()[x][y].getPersonen().get(0).isOmgedraaid()) {
                veld.getImageViews()[x][y][2].setImage(veld.getPersoon());
            } else {
                switch(veld.getVakken()[x][y].getPersonen().get(0)) {
                    case OMA: veld.getImageViews()[x][y][2].setImage(veld.getOma());
                    break;
                    case VIS: veld.getImageViews()[x][y][2].setImage(veld.getVis());
                    break;
                    case EGEL: veld.getImageViews()[x][y][2].setImage(veld.getEgel());
                    break;
                    case HOND: veld.getImageViews()[x][y][2].setImage(veld.getHond());
                    break;
                    case SNEK: veld.getImageViews()[x][y][2].setImage(veld.getSnek());
                    break;
                    case LATIFAH: veld.getImageViews()[x][y][2].setImage(veld.getLatifah());
                    break;
                    case ROODHAAR: veld.getImageViews()[x][y][2].setImage(veld.getRoodhaar());
                    break;
                    case GROENHAAR: veld.getImageViews()[x][y][2].setImage(veld.getGroenhaar());
                    break;
                    case OBAMANIGUA: veld.getImageViews()[x][y][2].setImage(veld.getObamanigua());
                    break;
                    case HIPSTERSNOR: veld.getImageViews()[x][y][2].setImage(veld.getHipstersnor());
                    break;
                    default: veld.getImageViews()[x][y][2].setImage(veld.getEmpty());
                }
            }
        }

        // Obstakel links
        switch (veld.getVakken()[x][y].getLinks()) {
            case MUUR: veld.getImageViews()[x][y][3].setImage(veld.getMuurRechts());
                break;
            case MUUR1: veld.getImageViews()[x][y][3].setImage(veld.getMuur1kapotRechts());
                break;
            case MUUR2: veld.getImageViews()[x][y][3].setImage(veld.getMuur2kapotRechts());
                break;
            case DEURO: veld.getImageViews()[x][y][3].setImage(veld.getOpenDeurRechts());
                break;
            case DEURD: veld.getImageViews()[x][y][3].setImage(veld.getDichteDeurRechts());
                break;
            case LEEG: veld.getImageViews()[x][y][3].setImage(veld.getEmpty());
                break;
        }

        // Spelers
        veld.getImageViews()[x][y][4].setImage(veld.getEmpty());
        for(int i = 0; i < 6; i++) {
            if (veld.getVakken()[x][y].getKleuren()[i]!=null) {
                switch(veld.getVakken()[x][y].getKleuren()[i]) {
                    case GEEL: veld.getImageViews()[x][y][4].setImage(veld.getBrandweerGeel());
                        i+=5;
                        break;
                    case ROOD: veld.getImageViews()[x][y][4].setImage(veld.getBrandweerRood());
                        i+=5;
                        break;
                    case BLAUW: veld.getImageViews()[x][y][4].setImage(veld.getBrandweerBlauw());
                        i+=5;
                        break;
                    case GROEN: veld.getImageViews()[x][y][4].setImage(veld.getBrandweerGroen());
                        i+=5;
                        break;
                    case ZWART: veld.getImageViews()[x][y][4].setImage(veld.getBrandweerZwart());
                        i+=5;
                        break;
                    case ORANJE: veld.getImageViews()[x][y][4].setImage(veld.getBrandweerOranje());
                        i+=5;
                        break;
                }
            }
        }

        // Obstakel rechts
        switch (veld.getVakken()[x][y].getRechts()) {
            case MUUR: veld.getImageViews()[x][y][5].setImage(veld.getMuurLinks());
                break;
            case MUUR1: veld.getImageViews()[x][y][5].setImage(veld.getMuur1kapotLinks());
                break;
            case MUUR2: veld.getImageViews()[x][y][5].setImage(veld.getMuur2kapotLinks());
                break;
            case DEURO: veld.getImageViews()[x][y][5].setImage(veld.getOpenDeurLinks());
                break;
            case DEURD: veld.getImageViews()[x][y][5].setImage(veld.getDichteDeurLinks());
                break;
            case LEEG: veld.getImageViews()[x][y][5].setImage(veld.getEmpty());
                break;
        }

        // Vuur plaats
        if(veld.getVakken()[x][y].isVuur()) {
            veld.getImageViews()[x][y][6].setImage(veld.getVlam());
        } else if(veld.getVakken()[x][y].isRook()) {
            veld.getImageViews()[x][y][6].setImage(veld.getRook());
        } else {
            veld.getImageViews()[x][y][6].setImage(veld.getEmpty());
        }

        // Obstakel onder
        switch (veld.getVakken()[x][y].getOnder()) {
            case MUUR: veld.getImageViews()[x][y][7].setImage(veld.getMuurBoven());
                break;
            case MUUR1: veld.getImageViews()[x][y][7].setImage(veld.getMuur1kapotBoven());
                break;
            case MUUR2: veld.getImageViews()[x][y][7].setImage(veld.getMuur2kapotBoven());
                break;
            case DEURO: veld.getImageViews()[x][y][7].setImage(veld.getOpenDeurBoven());
                break;
            case DEURD: veld.getImageViews()[x][y][7].setImage(veld.getDichteDeurBoven());
                break;
            case LEEG: veld.getImageViews()[x][y][7].setImage(veld.getEmpty());
                break;
        }

        // Stoffen
        if(veld.getVakken()[x][y].isStoffen()) {
            veld.getImageViews()[x][y][8].setImage(veld.getGevaarlijkeStof());
        } else {
            veld.getImageViews()[x][y][8].setImage(veld.getEmpty());
        }

    }

    // Lion, geeft terug of een vak een bepaalde eigenschap heeft of niet.
    private boolean checkVakEigenschappen(int x, int y, Fiche fiche) {
        switch(fiche) {
            case STOFFEN: return veld.getVakken()[x][y].isStoffen();
            case HOTSPOT: return veld.getVakken()[x][y].isHotspot();
            case VUUR: return veld.getVakken()[x][y].isVuur();
            case ROOK: return veld.getVakken()[x][y].isRook();
            case NIKS: return veld.getVakken()[x][y].isNiks();
            case PERSOON: if(veld.getVakken()[x][y].getPersonen().isEmpty()) {return false;}
                            return true;
            default:
                System.out.println("Unexpected Fiche input: " + fiche + " SpeelveldController.checkVakEigenschappen");
                return false;
        }

    }

    // Lion, geeft terug welke obstakels een vak heeft in een gegeven richting
    private Status checkVakObstakel(int x, int y, Richting richting) {
        switch(richting) {
            case BOVEN: return veld.getVakken()[x][y].getBoven();
            case LINKS: return veld.getVakken()[x][y].getLinks();
            case ONDER: return veld.getVakken()[x][y].getOnder();
            case RECHTS: return veld.getVakken()[x][y].getRechts();
            default:
                System.out.println("Unexpected Richting input: " + richting + " SpeelveldController.checkVakObstakel");
                return null;
        }
    }

    // Lion, kijkt of een speler zich op een bepaald vak bevind en geeft al die speler kleuren terug in een arraylist
    private ArrayList<Kleur> checkVakSpeler(int x, int y) {
        ArrayList<Kleur> kleuren= new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if(veld.getVakken()[x][y].getKleuren()[i] != null) {
                kleuren.add(veld.getVakken()[x][y].getKleuren()[i]);
            }
        }
        return kleuren;
    }

    // Lion, geeft true als de gekozen richting geen hinderend obstakel bevat.
    private boolean checkDoorgaanbaar(int x, int y, Richting richting) {
        switch(richting) {
            case BOVEN:
                return veld.getVakken()[x][y].getBoven().isBegaanbaar();
            case LINKS:
                return veld.getVakken()[x][y].getLinks().isBegaanbaar();
            case ONDER:
                return veld.getVakken()[x][y].getOnder().isBegaanbaar();
            case RECHTS:
                return veld.getVakken()[x][y].getRechts().isBegaanbaar();
            default:
                System.out.println("Unexpected Richting input: " + richting + " SpeelveldController.checkDoorgaanbaar");
                return false;
        }
    }

    //Lion/Joep, Zet alle muren en deuren op de goeie plek om het spel te beginnen
    public void setMap(){
        //buitenmuren horizontaal
        veld.getVakken()[9][7].setHotspot(true);
        veld.getVakken()[9][7].setStoffen(true);
        veld.getVakken()[9][7].setVuur(true);
        for(int x = 1; x <9; x++) {
            veld.getVakken()[x][0].setOnder(MUUR);
            veld.getVakken()[x][1].setBoven(MUUR);
            veld.getVakken()[x][6].setOnder(MUUR);
            veld.getVakken()[x][7].setBoven(MUUR);

        }
        //buitenmuren verticaal
        for (int y = 1; y < 7; y++) {
            veld.getVakken()[0][y].setRechts(MUUR);
            veld.getVakken()[1][y].setLinks(MUUR);
            veld.getVakken()[8][y].setRechts(MUUR);
            veld.getVakken()[9][y].setLinks(MUUR);

        }
        //scheidingswand woonkamer
        veld.getVakken()[1][2].setOnder(MUUR);
        veld.getVakken()[1][3].setBoven(MUUR);
        veld.getVakken()[2][2].setOnder(MUUR);
        veld.getVakken()[2][3].setBoven(MUUR);

        //muur tussen woonkamer en slaapkamer + keuken
        for (int j = 1; j<7;j++){
            veld.getVakken()[j][4].setOnder(MUUR);
            veld.getVakken()[j][5].setBoven(MUUR);
            veld.getVakken()[j][4].setOnder(MUUR);
            veld.getVakken()[j][5].setBoven(MUUR);
        }
        //muur tussen woonkamer en badkamer + bergruimte
        for (int k = 1; k<4;k++){
            veld.getVakken()[3][k].setRechts(MUUR);
            veld.getVakken()[4][k].setLinks(MUUR);
            veld.getVakken()[3][k].setRechts(MUUR);
            veld.getVakken()[4][k].setLinks(MUUR);
        }
        //muur tussen bergruimte en badkamer
        veld.getVakken()[4][1].setOnder(MUUR);
        veld.getVakken()[4][2].setBoven(MUUR);
        veld.getVakken()[5][1].setOnder(MUUR);
        veld.getVakken()[5][2].setBoven(MUUR);

        //overige horizontale muren
        veld.getVakken()[4][3].setOnder(MUUR);
        veld.getVakken()[4][4].setBoven(MUUR);
        veld.getVakken()[7][3].setOnder(MUUR);
        veld.getVakken()[7][4].setBoven(MUUR);
        veld.getVakken()[8][3].setOnder(MUUR);
        veld.getVakken()[8][4].setBoven(MUUR);

        //verticale muur tussen slaapkamer en keuken
        veld.getVakken()[3][5].setRechts(MUUR);
        veld.getVakken()[4][5].setLinks(MUUR);
        veld.getVakken()[3][6].setRechts(MUUR);
        veld.getVakken()[4][6].setLinks(MUUR);

        //verticale muur tussen slaapkamers
        veld.getVakken()[6][5].setRechts(MUUR);
        veld.getVakken()[7][5].setLinks(MUUR);
        veld.getVakken()[6][6].setRechts(MUUR);
        veld.getVakken()[7][6].setLinks(MUUR);

        //overige muur
        veld.getVakken()[5][2].setRechts(MUUR);
        veld.getVakken()[6][2].setLinks(MUUR);

        //verticale deuren
        veld.getVakken()[5][1].setRechts(DEURD);
        veld.getVakken()[6][1].setLinks(DEURD);
        veld.getVakken()[5][3].setRechts(DEURD);
        veld.getVakken()[6][3].setLinks(DEURD);
        veld.getVakken()[6][4].setRechts(DEURD);
        veld.getVakken()[7][4].setLinks(DEURD);

        //horizontale deuren
        veld.getVakken()[5][4].setBoven(DEURD);
        veld.getVakken()[5][3].setOnder(DEURD);
        veld.getVakken()[6][4].setBoven(DEURD);
        veld.getVakken()[6][3].setOnder(DEURD);
        veld.getVakken()[6][5].setBoven(DEURD);
        veld.getVakken()[6][4].setOnder(DEURD);
        veld.getVakken()[3][5].setBoven(DEURD);
        veld.getVakken()[3][4].setOnder(DEURD);

        //buitenmuren waar deuren horen leeg maken
        veld.getVakken()[0][3].setRechts(LEEG);
        veld.getVakken()[1][3].setLinks(LEEG);

        veld.getVakken()[3][7].setBoven(LEEG);
        veld.getVakken()[3][6].setOnder(LEEG);



    }

    // Lion, handeld obstakels voor explosies en hakken
    private void doeBeschadiging(int x, int y, Richting richting) {
        Vak vak = veld.getVakken()[x][y];
        switch(richting) {
            case BOVEN:
                if (y>0) {
                    switch(vak.getBoven()) {
                        case MUUR:  vak.setBoven(MUUR1);
                            veld.getVakken()[x][y-1].setOnder(MUUR1);
                            break;
                        case MUUR1: vak.setBoven(MUUR2);
                            veld.getVakken()[x][y-1].setOnder(MUUR2);
                            break;
                        case DEURD: vak.setBoven(LEEG);
                            veld.getVakken()[x][y-1].setOnder(LEEG);
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
                            veld.getVakken()[x+1][y].setLinks(MUUR1);
                            break;
                        case MUUR1: vak.setRechts(MUUR2);
                            veld.getVakken()[x+1][y].setLinks(MUUR2);
                            break;
                        case DEURD: vak.setRechts(LEEG);
                            veld.getVakken()[x+1][y].setLinks(LEEG);
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
                            veld.getVakken()[x][y+1].setBoven(MUUR1);
                            break;
                        case MUUR1: vak.setOnder(MUUR2);
                            veld.getVakken()[x][y+1].setBoven(MUUR2);
                            break;
                        case DEURD: vak.setOnder(LEEG);
                            veld.getVakken()[x][y+1].setBoven(LEEG);
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
                            veld.getVakken()[x-1][y].setRechts(MUUR1);
                            break;
                        case MUUR1: vak.setLinks(MUUR2);
                            veld.getVakken()[x-1][y].setRechts(MUUR2);
                            break;
                        case DEURD: vak.setLinks(LEEG);
                            veld.getVakken()[x-1][y].setRechts(LEEG);
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

    public Speelveld getVeld() {
        return veld;
    }
}
