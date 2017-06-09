package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Spel {


    //Dit worden classes
//	private int NewRook;            done Joep
//	private int ExplosieHandler;    done Joep           tested by Lion (niet te veel moeite in gestoken in t testen maar denk dat t met die 2 foutjes die ik heb gevonden moet werken)
//	private int VonkoverslagHandler;     done Lion      tested by Lion (10/10)
//	private int BrandhaardHandler;          done Lion
//	private int BrandweerliedenHandler;     joep work in progress
//	private int PersoonVanAandachtHandler;
//	private int GevaarlijkeStofHandler;     Done Lion
//	private int PersoonVanAandachtAanvuller;
//	private int WinLoseConditionChecker;
//  addspeler done Joep
    Speelveld veld;
    Vak vak;
    Vak vak2;
    boolean spawnBrandhaard = false;
    Dobbelsteen d6 = new Dobbelsteen(6);
    Dobbelsteen d8 = new Dobbelsteen(8);
    int hotspots;
    ArrayList<Speler> spelers = new ArrayList<Speler>();
    int murenkapot = 0;
    ArrayList<Persoon> personenlijst = new ArrayList<Persoon>();


    public Spel(Speelveld veld, int hotspots) {
        this.veld = veld;
        this.hotspots = hotspots;
        for(Persoon persoon: Persoon.values()){
            personenlijst.add(persoon);
        }
        long seed = System.nanoTime();
        Collections.shuffle(personenlijst, new Random(seed));
    }

    public void addSpeler(Speler speler) throws Throwable{
        if(spelers.size()<7) {
            spelers.add(speler);
        }
        else{
            throw new Exception("Limit reached");
        }
    }

    public void hanteerBrandhaard() {
        if(vak.isHotspot()) {
            spawnBrandhaard = true;
            nieuwRook();
        } else if(spawnBrandhaard){
            if(hotspots>0) {
                vak.setHotspot(true);
                hotspots--;
            }
            spawnBrandhaard = false;
        }
    }

    public void hanteerStoffen() {
        Vak vak;
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 7; y++) {
                vak=veld.getVak(x,y);
                if(vak.isStoffen() && vak.isVuur()) {
                    hanteerExplosie(x,y);
                    vak.setStoffen(false);
                }
            }
        }
    }

    public void hanteerVonkoverslag() {
        boolean loop = true;
        while(loop) {
            loop = false;
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 8; y++) {
                    vak = veld.getVak(x,y);
                    if (vak.isVuur()) {
                        for (Richting richting: Richting.values()) {
                            if (vak.getObstakelRichting(richting).isBegaanbaar()) {
                                switch (richting) {
                                    case BOVEN:
                                        if (y > 0) {
                                            vak2 = veld.getVak(x, y - 1);
                                        }
                                        break;
                                    case RECHTS:
                                        if (x < 9) {
                                            vak2 = veld.getVak(x + 1, y);
                                        }
                                        break;
                                    case ONDER:
                                        if (y < 7) {
                                            vak2 = veld.getVak(x, y + 1);
                                        }
                                        break;
                                    case LINKS:
                                        if (x > 0) {
                                            vak2 = veld.getVak(x - 1, y);
                                        }
                                        break;
                                }
                                if (vak2.isRook()) {
                                    vak2.vuurPlaats(Fiche.VUUR);
                                    if (richting==Richting.BOVEN || richting==Richting.LINKS) {
                                        loop = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void nieuwRook() {
        d6.gooi();
        d8.gooi();
        int x = d8.getWaarde();
        int y = d6.getWaarde();
        vak = veld.getVak(x,y);
        System.out.println(x+" "+y);
        if (vak.isNiks()) {
            vak.vuurPlaats(Fiche.ROOK);
            System.out.println("newrook"+x+"\t"+y);
        } else if (vak.isRook()) {
            vak.vuurPlaats(Fiche.VUUR);
            System.out.println("newVuur"+x+"\t"+y);
        } else if (vak.isVuur()){
            System.out.println("newrookexplosie"+x+"\t"+y);
            hanteerExplosie(x,y);
        }
        hanteerBrandhaard();
    }

    public void hanteerExplosie(int x, int y) {// Joep
        boolean doorgaan;
        int teller;
        Vak vak;
        for (Richting richting: Richting.values()) {
            teller = 0;
            doorgaan = true;
            while (richting == Richting.BOVEN && doorgaan && ((y - teller) >= 1)) {
                vak = veld.getVak(x, (y - teller));
                if (!vak.boven.isBegaanbaar()){
                    veld.schade(x, y-teller, richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veld.getVak(x, (y - teller));
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            while (richting == Richting.RECHTS && doorgaan && ((x + teller) <= 8)) {
                vak = veld.getVak((x+teller), y);
                if (!vak.rechts.isBegaanbaar()){
                    veld.schade((x+teller), y, richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veld.getVak((x+teller), y);
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            while (richting == Richting.ONDER && doorgaan && ((y + teller) <= 6)) {
                vak = veld.getVak(x, (y + teller));
                if (!vak.onder.isBegaanbaar()){
                    veld.schade(x, (y + teller), richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veld.getVak(x, (y + teller));
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            while (richting == Richting.LINKS && doorgaan && ((x - teller) >= 1)) {
                vak = veld.getVak((x-teller), y);
                if (!vak.links.isBegaanbaar()){
                    veld.schade((x-teller), y, richting);
                    murenkapot++;
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veld.getVak((x-teller), y);
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.vuurPlaats(Fiche.VUUR);
                    }
                }
            }
        }
    }

    public void bomberMan(int x, int y) {//Work in progress - Joep
        int obstakel;
        boolean doorgaan;
        int teller;
        for(Richting richting: Richting.values()) {
            teller = 0;
            doorgaan = true;
            if (richting == Richting.BOVEN){
                while ((y - teller > 0) && doorgaan) {
                    vak = veld.getVak(x,y-teller);
                    if (!vak.boven.isBegaanbaar()) {
                        veld.schade(x, y-teller, richting);
                        doorgaan = false;
                    } else {
                        teller++;
                        veld.getVak(x,y - teller).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == Richting.RECHTS){
                while ((x + teller < 9) && doorgaan) {
                    vak = veld.getVak(x+teller,y);
                    if (!vak.rechts.isBegaanbaar()) {
                        veld.schade(x+teller, y, richting);
                        doorgaan = false;
                    } else {
                        teller++;
                        veld.getVak(x+teller,y).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == Richting.ONDER){
                while ((y + teller < 7) && doorgaan) {
                    vak = veld.getVak(x,y+teller);
                    if (!vak.onder.isBegaanbaar()) {
                        veld.schade(x, y+teller, richting);
                        doorgaan = false;
                    } else {
                        teller++;
                        veld.getVak(x,y + teller).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == Richting.LINKS){
                while ((x - teller > 0) && doorgaan) {
                    vak = veld.getVak(x-teller,y);
                    if (!vak.links.isBegaanbaar()) {
                        veld.schade(x - teller, y, richting);
                        doorgaan = false;
                    }
                    else {
                        teller++;
                        veld.getVak(x-teller,y).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
        }
    }                               //its beautiful but useless made by joseph

    public void hanteerBrandweerlieden() {
    }

    public void hanteerPersoon() {
    }

    public void nieuwPersoon() {
        d6.gooi();
        d8.gooi();
        int x = d8.getWaarde();
        int y = d6.getWaarde();
        int[] locatie = new int[2];
        vak = veld.getVak(x,y);
        while(vak.isVuur()){
            locatie = veld.volgPijl(x,y);
            x = locatie[0];
            y = locatie[1];
            vak = veld.getVak(x,y);
        }


    }

    public void winControle() {
        // TODO - implement BeurtAfronding.checkWinLoseCondition
        throw new UnsupportedOperationException();
    }

}