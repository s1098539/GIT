package sample;

import java.util.ArrayList;

public class Vak {

    public Object[] objecten = new Object[9];
    public Speler[] spelers = new Speler[6];
    // Richtingen: obstakels[0] = boven, obstakels [1] = rechts etc.
    // obstakels: 0 = muur, 1 = muur(1schade), 2 = muur(2schade), 3=deur(gesloten), 4=deur(open), 5=empty
	public int[] obstakels;

    public Vak() {
        Object object = new Object();
        obstakels = new int[4];
        for(int i = 0 ; i < 4 ; i++){
            obstakels[i] = 5;
        }
    }

    public void addSpeler(Speler speler) {
        switch(speler.getKleur()) {
            case Blauw: spelers[0]=speler;
                break;
            case Geel: spelers[1]=speler;
                break;
            case Groen: spelers[2]=speler;
                break;
            case Oranje: spelers[3]=speler;
                break;
            case Rood: spelers[4]=speler;
                break;
            case Zwart: spelers[5]=speler;
                break;
        }
    }

    public void removeSpeler(Speler speler) {
        switch(speler.getKleur()) {
            case Blauw: spelers[0]=null;
                break;
            case Geel: spelers[1]=null;
                break;
            case Groen: spelers[2]=null;
                break;
            case Oranje: spelers[3]=null;
                break;
            case Rood: spelers[4]=null;
                break;
            case Zwart: spelers[5]=null;
                break;
        }
    }

    public void setObstakel(int richting, int obstakel) {
        obstakels[richting] = obstakel;
    }

    public int checkObstakels(int richting) {
        return obstakels[richting];
    }

    public Object[] getObjecten() {
        return objecten;
    }

    public void addObject(Object object) {
        switch(object.getNaam()){

            case "Rook": objecten[6] = object;
                System.out.println(objecten[6]);
                break;
            case "Vuur": objecten[6] = object;
                System.out.println(objecten[6]);
                break;
        }
//        objecten[2] = ;
    }
}

//	private int Vuur;
//	private int Rook;
//	private int GevaarlijkeStof;
//	private int Brandhaard;
//	private int PersoonVanAandacht;
//	private int Ziekenwagen;
//	private int Brandweerwagen;