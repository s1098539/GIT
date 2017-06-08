package sample;
public class BeurtAfronding {


    //Dit worden classes
//	private int NewRook;            done Joep
//	private int ExplosieHandler;    done Joep           tested by Lion (niet te veel moeite in gestoken in t testen maar denk dat t met die 2 foutjes die ik heb gevonden moet werken)
//	private int VonkoverslagHandler;     done Lion      tested by Lion (10/10)
//	private int BrandhaardHandler;          working on it (Lion)
//	private int BrandweerliedenHandler;
//	private int PersoonVanAandachtHandler;
//	private int GevaarlijkeStofHandler;     Done Lion
//	private int PersoonVanAandachtAanvuller;
//	private int WinLoseConditionChecker;
    Speelveld veld;
    Vak vak;
    Vak vak2;
    Object obj;
    Dobbelsteen d6 = new Dobbelsteen(6);
    Dobbelsteen d8 = new Dobbelsteen(8);

    public BeurtAfronding(Speelveld veld) {
        this.veld = veld;
    }

//    public void handleBrandhaard() {
//        veld.getVak(d8.getWaarde())
//    }


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
                    if (!vak.boven.isBegaanbaar()) {
                        veld.schade(x, y-teller, richting);
                        doorgaan = false;
                    } else if (y-teller>0) {
                        teller++;
                        veld.getVak(x,y - teller).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == Richting.RECHTS){
                while ((x + teller < 9) && doorgaan) {
                    if (!vak.rechts.isBegaanbaar()) {
                        veld.schade(x+teller, y, richting);
                        doorgaan = false;
                    } else if (x+teller<9) {
                        teller++;
                        veld.getVak(x+teller,y).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == Richting.ONDER){
                while ((y + teller < 7) && doorgaan) {
                    if (!vak.onder.isBegaanbaar()) {
                        veld.schade(x, y+teller, richting);
                        doorgaan = false;
                    } else if (y+teller>0) {
                        teller++;
                        veld.getVak(x,y + teller).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == Richting.LINKS){
                while ((x - teller > 0) && doorgaan) {
                    if (!vak.links.isBegaanbaar()) {
                        veld.schade(x - teller, y, richting);
                        doorgaan = false;
                    }
                    else if (x-teller>0) {
                        teller++;
                        veld.getVak(x-teller,y).vuurPlaats(Fiche.VUUR);
                    }
                }
            }
        }
    }                               //its beautiful but useless made by joseph


    public void hanteerBrandweerlieden() {
        // TODO - implement BeurtAfronding.handleBrandweerlieden
        throw new UnsupportedOperationException();
    }

    public void hanteerPersoon() {
        // TODO - implement BeurtAfronding.handlePersoonVanAandacht
        throw new UnsupportedOperationException();
    }

    public void nieuwPersoon() {
        // TODO - implement BeurtAfronding.vulPersoonVanAandachtAan
        throw new UnsupportedOperationException();
    }

    public void winControle() {
        // TODO - implement BeurtAfronding.checkWinLoseCondition
        throw new UnsupportedOperationException();
    }

}