package sample;

import java.util.ArrayList;

import static sample.Kleur.*;

public class Vak {
    boolean hotspot = false;
    boolean persoon = false;
    Speler[] spelers = new Speler[6];



    Status boven;
    Status rechts;
    Status onder;
    Status links;

    public Status getRechts() {
        return rechts;
    }

    public void setRechts(Status rechts) {
        this.rechts = rechts;
    }

    public Status getOnder() {
        return onder;
    }

    public void setOnder(Status onder) {
        this.onder = onder;
    }

    public Status getLinks() {
        return links;
    }

    public void setLinks(Status links) {
        this.links = links;
    }

    public Status getBoven() {
        return boven;
    }

    public void setBoven(Status boven) {
        this.boven = boven;
    }


    //    public enum onder {
//        MUUR, MUUR1, MUUR2, DEURO, DEURD, LEEG
//    }
//
//    public enum links {
//        MUUR, MUUR1, MUUR2, DEURO, DEURD, LEEG
//    }
//
//    public enum rechts {
//        MUUR, MUUR1, MUUR2, DEURO, DEURD, LEEG
//    }


    // Richtingen: obstakels[0] = boven, obstakels [1] = rechts etc.
    // obstakels: 0 = muur, 1 = muur(1schade), 2 = muur(2schade), 3=deur(gesloten), 4=deur(open), 5=empty
    public int[] obstakels;

    public Vak() {
        Object object = new Object();
        obstakels = new int[4];
        for (int i = 0; i < 4; i++) {
            obstakels[i] = 5;
        }
    }

    public void addSpeler(Speler speler) {
        switch (speler.getKleur()) {
            case BLAUW:
                spelers[0] = speler;
                break;
            case GEEL:
                spelers[1] = speler;
                break;
            case GROEN:
                spelers[2] = speler;
                break;
            case ORANJE:
                spelers[3] = speler;
                break;
            case ROOD:
                spelers[4] = speler;
                break;
            case ZWART:
                spelers[5] = speler;
                break;
        }
    }

//    public void removeSpeler(OSpeler speler) {
//        switch(speler.getKleur()) {
//            case BLAUW: spelers[0]=null;
//                break;
//            case GEEL: spelers[1]=null;
//                break;
//            case GROEN: spelers[2]=null;
//                break;
//            case ORANJE: spelers[3]=null;
//                break;
//            case ROOD: spelers[4]=null;
//                break;
//            case ZWART: spelers[5]=null;
//                break;
//        }
//    }

    public void setObstakel(int richting, int obstakel) {
        obstakels[richting] = obstakel;
    }

    public int checkObstakels(int richting) {
        return obstakels[richting];
    }
}

//    public Object[] getObjecten() {
//        return objecten;
//    }
//
//    public void addObject(Object object) {
//        switch(object.getNaam()){
//            case "Brandhaard": objecten[0] = object;
//                break;
//            case "Rook": objecten[6] = object;
//                break;
//            case "Vuur": objecten[6] = object;
//                break;
//            case "GevaarlijkeStof": objecten[8] = object;
//                break;
//            case "PersoonVanAandacht": objecten[2] = object;
//                break;
//            case "Speler": objecten[4] = object;
//        }
//    }
//
//    public void addMuur(Object object, int richting) {
//        switch(richting){
//            case 0: objecten[1] = object;
//                break;
//            case 1: objecten[5] = object;
//                break;
//            case 2: objecten[7] = object;
//                break;
//            case 3: objecten[3] = object;
//                break;
//        }
//
//    }
//
//    public void removeObject(int index) {
//        objecten[index] = null;
//    }
//}

//	private int Vuur;
//	private int Rook;
//	private int GevaarlijkeStof;
//	private int Brandhaard;
//	private int PersoonVanAandacht;
//	private int Ziekenwagen;
//	private int Brandweerwagen;