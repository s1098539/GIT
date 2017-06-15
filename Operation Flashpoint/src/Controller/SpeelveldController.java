package Controller;


import Model.*;

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
                System.out.println("Unexpected Richting input: " + richting);
                return false;
        }
    }

    //Lion/Joep, Zet alle muren en deuren op de goeie plek om het spel te beginnen
    public void setMap(){
        //buitenmuren horizontaal
        for(int x = 1; x <9; x++) {
            speelveld.getVakken()[x][0].setOnder(Status.MUUR);
            speelveld.getVakken()[x][1].setBoven(Status.MUUR);
            speelveld.getVakken()[x][6].setOnder(Status.MUUR);
            speelveld.getVakken()[x][7].setBoven(Status.MUUR);

        }
        //buitenmuren verticaal
        for (int y = 1; y < 7; y++) {
            speelveld.getVakken()[0][y].setRechts(Status.MUUR);
            speelveld.getVakken()[1][y].setLinks(Status.MUUR);
            speelveld.getVakken()[8][y].setRechts(Status.MUUR);
            speelveld.getVakken()[9][y].setLinks(Status.MUUR);

        }
        //scheidingswand woonkamer
        speelveld.getVakken()[1][2].setOnder(Status.MUUR);
        speelveld.getVakken()[1][3].setBoven(Status.MUUR);
        speelveld.getVakken()[2][2].setOnder(Status.MUUR);
        speelveld.getVakken()[2][3].setBoven(Status.MUUR);

        //muur tussen woonkamer en slaapkamer + keuken
        for (int j = 1; j<7;j++){
            speelveld.getVakken()[j][4].setOnder(Status.MUUR);
            speelveld.getVakken()[j][5].setBoven(Status.MUUR);
            speelveld.getVakken()[j][4].setOnder(Status.MUUR);
            speelveld.getVakken()[j][5].setBoven(Status.MUUR);
        }
        //muur tussen woonkamer en badkamer + bergruimte
        for (int k = 1; k<4;k++){
            speelveld.getVakken()[3][k].setRechts(Status.MUUR);
            speelveld.getVakken()[4][k].setLinks(Status.MUUR);
            speelveld.getVakken()[3][k].setRechts(Status.MUUR);
            speelveld.getVakken()[4][k].setLinks(Status.MUUR);
        }
        //muur tussen bergruimte en badkamer
        speelveld.getVakken()[4][1].setOnder(Status.MUUR);
        speelveld.getVakken()[4][2].setBoven(Status.MUUR);
        speelveld.getVakken()[5][1].setOnder(Status.MUUR);
        speelveld.getVakken()[5][2].setBoven(Status.MUUR);

        //overige horizontale muren
        speelveld.getVakken()[4][3].setOnder(Status.MUUR);
        speelveld.getVakken()[4][4].setBoven(Status.MUUR);
        speelveld.getVakken()[7][3].setOnder(Status.MUUR);
        speelveld.getVakken()[7][4].setBoven(Status.MUUR);
        speelveld.getVakken()[8][3].setOnder(Status.MUUR);
        speelveld.getVakken()[8][4].setBoven(Status.MUUR);

        //verticale muur tussen slaapkamer en keuken
        speelveld.getVakken()[3][5].setRechts(Status.MUUR);
        speelveld.getVakken()[4][5].setLinks(Status.MUUR);
        speelveld.getVakken()[3][6].setRechts(Status.MUUR);
        speelveld.getVakken()[4][6].setLinks(Status.MUUR);

        //verticale muur tussen slaapkamers
        speelveld.getVakken()[6][5].setRechts(Status.MUUR);
        speelveld.getVakken()[7][5].setLinks(Status.MUUR);
        speelveld.getVakken()[6][6].setRechts(Status.MUUR);
        speelveld.getVakken()[7][6].setLinks(Status.MUUR);

        //overige muur
        speelveld.getVakken()[5][2].setRechts(Status.MUUR);
        speelveld.getVakken()[6][2].setLinks(Status.MUUR);

        //verticale deuren
        speelveld.getVakken()[5][1].setRechts(Status.DEURD);
        speelveld.getVakken()[6][1].setLinks(Status.DEURD);
        speelveld.getVakken()[5][3].setRechts(Status.DEURD);
        speelveld.getVakken()[6][3].setLinks(Status.DEURD);
        speelveld.getVakken()[6][4].setRechts(Status.DEURD);
        speelveld.getVakken()[7][4].setLinks(Status.DEURD);

        //horizontale deuren
        speelveld.getVakken()[5][4].setBoven(Status.DEURD);
        speelveld.getVakken()[5][3].setOnder(Status.DEURD);
        speelveld.getVakken()[6][4].setBoven(Status.DEURD);
        speelveld.getVakken()[6][3].setOnder(Status.DEURD);
        speelveld.getVakken()[6][5].setBoven(Status.DEURD);
        speelveld.getVakken()[6][4].setOnder(Status.DEURD);
        speelveld.getVakken()[3][5].setBoven(Status.DEURD);
        speelveld.getVakken()[3][4].setOnder(Status.DEURD);

        //buitenmuren waar deuren horen leeg maken
        speelveld.getVakken()[0][3].setRechts(Status.LEEG);
        speelveld.getVakken()[1][3].setLinks(Status.LEEG);

        speelveld.getVakken()[3][7].setBoven(Status.LEEG);
        speelveld.getVakken()[3][6].setOnder(Status.LEEG);



    }

    // Lion, handeld obstakels voor explosies en hakken
    private void doeBeschadiging(int x, int y, Richting richting) {
        Vak vak = speelveld.getVakken()[x][y];
        if (y>0) {
            switch(vak.getBoven()) {
                case MUUR:  vak.setBoven(Status.MUUR1);
                            speelveld.getVakken()[x][y-1].setOnder(Status.MUUR1);
                    break;
                case MUUR1: vak.setBoven(Status.MUUR2);
                            speelveld.getVakken()[x][y-1].setOnder(Status.MUUR2);
                    break;
                case DEURD: vak.setBoven(Status.LEEG);
                            speelveld.getVakken()[x][y-1].setOnder(Status.LEEG);
                    break;
                default:
                    System.out.println("Unexpected obstakel");
            }
        }
        if (x<9) {
            switch(vak.getRechts()) {
                case MUUR:  vak.setRechts(Status.MUUR1);
                            speelveld.getVakken()[x+1][y].setLinks(Status.MUUR1);
                    break;
                case MUUR1: vak.setRechts(Status.MUUR2);
                            speelveld.getVakken()[x+1][y].setLinks(Status.MUUR2);
                    break;
                case DEURD: vak.setRechts(Status.LEEG);
                            speelveld.getVakken()[x+1][y].setLinks(Status.LEEG);
                    break;
                default:
                    System.out.println("Unexpected obstakel");
            }
        }
        if (y<7) {
            switch(vak.getOnder()) {
                case MUUR:  vak.setOnder(Status.MUUR1);
                            speelveld.getVakken()[x][y+1].setBoven(Status.MUUR1);
                    break;
                case MUUR1: vak.setOnder(Status.MUUR2);
                            speelveld.getVakken()[x][y+1].setBoven(Status.MUUR2);
                    break;
                case DEURD: vak.setOnder(Status.LEEG);
                            speelveld.getVakken()[x][y+1].setBoven(Status.LEEG);
                    break;
                default:
                    System.out.println("Unexpected obstakel");
            }
        }
        if (x>0) {
            switch(vak.getLinks()) {
                case MUUR:  vak.setLinks(Status.MUUR1);
                            speelveld.getVakken()[x-1][y].setRechts(Status.MUUR1);
                    break;
                case MUUR1: vak.setLinks(Status.MUUR2);
                            speelveld.getVakken()[x-1][y].setRechts(Status.MUUR2);
                    break;
                case DEURD: vak.setLinks(Status.LEEG);
                            speelveld.getVakken()[x-1][y].setRechts(Status.LEEG);
                    break;
                default:
                    System.out.println("Unexpected obstakel");
            }
        }
    }
}
