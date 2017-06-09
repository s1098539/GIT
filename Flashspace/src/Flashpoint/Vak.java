package Flashpoint;

import java.util.ArrayList;

public class Vak {
    boolean hotspot = false;
    boolean persoon = false;
    boolean vuur = false;
    boolean rook = false;
    boolean stoffen = false;
    boolean niks = true;
    Kleur[] kleuren = new Kleur[6];
    ArrayList<Persoon>personen = new ArrayList<>();

    public Persoon getPersoon() {
        Persoon tempPers = personen.get(0);
        personen.remove(0);
        return tempPers;
    }



    public void setPersonen(Persoon persoon) {
        if(personen.size()<4) {
            personen.add(persoon);
        } else {
            System.out.println("Limit reached");
        }
    }

    Status boven = Status.LEEG;
    Status rechts = Status.LEEG;
    Status onder = Status.LEEG;
    Status links = Status.LEEG;

    public Status getObstakelRichting (Richting richting){
        switch(richting){
            case BOVEN: return boven;
            case RECHTS: return rechts;
            case ONDER: return onder;
            case LINKS: return links;
            default: return null;
        }
    }
    public void setObstakelRichting(Richting richting, Status status){
        switch(richting){
            case BOVEN: boven = status;
                break;
            case RECHTS: rechts = status;
                break;
            case ONDER: onder = status;
                break;
            case LINKS: links = status;
                break;
        }
    }

    public Kleur getKleuren(int index) {
        return kleuren[index];
    }

    public void setKleuren(Kleur kleur, int index) {
        this.kleuren[index] = kleur;
    }

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
        switch(getObstakelRichting(richting)) {

            case MUUR:
                setObstakelRichting(richting, Status.MUUR1);
                break;
            case MUUR1:
                setObstakelRichting(richting, Status.MUUR2);
                break;
            case DEURD:
                setObstakelRichting(richting, Status.LEEG);
                break;
        }
    }



    public Vak() {

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


}

