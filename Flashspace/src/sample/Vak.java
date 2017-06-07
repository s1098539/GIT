package sample;

import java.util.ArrayList;

import static sample.Kleur.*;

public class Vak {
    boolean hotspot = false;
    boolean persoon = false;
    boolean vuur = false;
    boolean rook = false;
    boolean stoffen = false;
    boolean niks = false;
    Kleur[] kleuren = new Kleur[6];

    Status boven;
    Status rechts;
    Status onder;
    Status links;

    public boolean isHotspot() {
        return hotspot;
    }

    public void setHotspot(boolean hotspot) {
        this.hotspot = hotspot;
    }

    public boolean isPersoon() {
        return persoon;
    }

    public void setPersoon(boolean persoon) {
        this.persoon = persoon;
    }

    public boolean isVuur() {
        return vuur;
    }

    public boolean isRook() {
        return rook;
    }

    public boolean isNiks() {
        return niks;
    }

    public void vuurPlaats(Fiche fiche) {
        switch(fiche) {
            case ROOK:
                this.rook=true;
                this.vuur=false;
                this.niks=false;
                break;
            case VUUR:
                this.rook=false;
                this.vuur=true;
                this.niks=false;
                break;
            case NIKS:
                this.rook=false;
                this.vuur=false;
                this.niks=true;
                break;
        }
    }

    public boolean isStoffen() {
        return stoffen;
    }

    public void setStoffen(boolean stoffen) {
        this.stoffen = stoffen;
    }

    public void schadeStatus(Richting richting) {
        switch(richting) {
            case BOVEN:
                switch(boven) {
                    case MUUR: setBoven(Status.MUUR1);
                        break;
                    case MUUR1: setBoven(Status.MUUR2);
                        break;
                    case DEURD: setBoven(Status.LEEG);
                        break;
                    default:
                        System.out.println("Stop breaking my code thanks.");
                        break;
                }
            case RECHTS:
                switch(rechts) {
                    case MUUR: setRechts(Status.MUUR1);
                        break;
                    case MUUR1: setRechts(Status.MUUR2);
                        break;
                    case DEURD: setRechts(Status.LEEG);
                        break;
                    default:
                        System.out.println("Stop breaking my code thanks.");
                        break;
                }
            case ONDER:
                switch(onder) {
                    case MUUR: setOnder(Status.MUUR1);
                        break;
                    case MUUR1: setOnder(Status.MUUR2);
                        break;
                    case DEURD: setOnder(Status.LEEG);
                        break;
                    default:
                        System.out.println("Stop breaking my code thanks.");
                        break;
                }
            case LINKS:
                switch(links) {
                    case MUUR: setLinks(Status.MUUR1);
                        break;
                    case MUUR1: setLinks(Status.MUUR2);
                        break;
                    case DEURD: setLinks(Status.LEEG);
                        break;
                    default:
                        System.out.println("Stop breaking my code thanks.");
                        break;
                }
            default:
                System.out.println("Still trying to break my code aren't you?");
                break;
        }
    }

    public Status getRechts() {
        return rechts;
    }

    public void setRechts(Status rechts) {this.rechts = rechts;}

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

    public void addSpeler(Kleur kleur) {
        switch (kleur) {
            case BLAUW:
                kleuren[0] = kleur;
                break;
            case GEEL:
                kleuren[1] = kleur;
                break;
            case GROEN:
                kleuren[2] = kleur;
                break;
            case ORANJE:
                kleuren[3] = kleur;
                break;
            case ROOD:
                kleuren[4] = kleur;
                break;
            case ZWART:
                kleuren[5] = kleur;
                break;
        }
    }

    public void removeSpeler(Kleur kleur) {
        switch(kleur) {
            case BLAUW: kleuren[0]=null;
                break;
            case GEEL: kleuren[1]=null;
                break;
            case GROEN: kleuren[2]=null;
                break;
            case ORANJE: kleuren[3]=null;
                break;
            case ROOD: kleuren[4]=null;
                break;
            case ZWART: kleuren[5]=null;
                break;
        }
    }

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