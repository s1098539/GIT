package Controller;


import Model.Fiche;
import Model.Richting;
import Model.Speelveld;
import Model.Status;
import Model.Kleur;

import java.util.ArrayList;

public class SpeelveldController {
    Speelveld speelveld = new Speelveld();

    public SpeelveldController() {

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
                System.out.println("Unexpected Fiche input: " + fiche);
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
                System.out.println("Unexpected Richting input: " + richting);
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

}
