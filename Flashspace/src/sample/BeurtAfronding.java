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


    public void handleGevaarlijkeStof() {
        Vak vak;
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 7; y++) {
                vak=veld.getVak(x,y);
                if(vak.isStoffen() && vak.isVuur()) {
                    handleExplosie(x,y);
                    vak.setStoffen(false);
                }
            }
        }
    }

    public void handleVonkoverslag() {
        boolean loop = true;
        while(loop) {
            loop = false;
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 8; y++) {
                    vak = veld.getVak(x,y);
                    obj = vak.getObjecten()[6];
                    if (obj != null && obj.getNaam().equals("Vuur")) {
                        for (int i = 0; i < 4; i++) {
                            if (vak.checkObstakels(i) == 2 || vak.checkObstakels(i) > 3) {
                                switch (i) {
                                    case 0:
                                        if (y > 0) {
                                            vak2 = veld.getVak(x, y - 1);
                                        }
                                        break;
                                    case 1:
                                        if (x < 9) {
                                            vak2 = veld.getVak(x + 1, y);
                                        }
                                        break;
                                    case 2:
                                        if (y < 7) {
                                            vak2 = veld.getVak(x, y + 1);
                                        }
                                        break;
                                    case 3:
                                        if (x > 0) {
                                            vak2 = veld.getVak(x - 1, y);
                                        }
                                        break;
                                }
                                obj = vak2.getObjecten()[6];
                                if (obj != null && obj.getNaam().equals("Rook")) {
                                    vak2.addObject(new Object.Vuur());
                                    if (i%3==0) {
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

    public void newRook() {
        d6.gooi();
        d8.gooi();
        int x = d8.getWaarde();
        int y = d6.getWaarde();
        vak = veld.getVak(x,y);
        if (vak.isNiks()) {
            vak.vuurPlaats(Fiche.ROOK);
            System.out.println("newrook"+x+"\t"+y);
        } else if (vak.isRook()) {
            vak.vuurPlaats(Fiche.VUUR);
            System.out.println("newVuur"+x+"\t"+y);
        } else {
            System.out.println("newrookexplosie"+x+"\t"+y);
            handleExplosie(x,y);
        }
    }

    public void handleExplosie(int x, int y) {// Joep
        boolean doorgaan;
        int teller;
        Vak vak;
        for (int richting = 0; richting < 4; richting++) {
            teller = 0;
            doorgaan = true;
            while (richting == 0 && doorgaan && ((y - teller) >= 1)) {
                vak = veld.getVak(x, (y - teller));
                if (!vak.boven.isBegaanbaar()){
                    schade(richting, x, (y - teller));
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
            while (richting == 1 && doorgaan && ((x + teller) <= 8)) {
                vak = veld.getVak((x+teller), y);
                if (!vak.rechts.isBegaanbaar()){
                    schade(richting, (x+teller), y);
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
            while (richting == 2 && doorgaan && ((y + teller) <= 6)) {
                vak = veld.getVak(x, (y + teller));
                if (!vak.onder.isBegaanbaar()){
                    schade(richting, x, (y + teller));
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
            while (richting == 3 && doorgaan && ((x - teller) >= 1)) {
                vak = veld.getVak((x-teller), y);
                if (!vak.links.isBegaanbaar()){
                    schade(richting, (x-teller), y);
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
        for(int richting = 0; richting<4; richting++) {
            teller = 0;
            doorgaan = true;
            if (richting == 0){
                while ((y - teller > 0) && doorgaan) {
                    obstakel = veld.getVakken()[x][y - teller].checkObstakels(richting);
                    if (obstakel < 2 || obstakel == 3) {
                        schade(richting, x, y);
                        doorgaan = false;
                    } else if (y-teller>0) {
                        teller++;
                        veld.getVakken()[x][y - teller].vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == 1){
                while ((x + teller < 9) && doorgaan) {
                    obstakel = veld.getVakken()[x + teller][y].checkObstakels(richting);
                    if (obstakel < 2 || obstakel == 3) {
                        schade(richting, x+teller, y);
                        doorgaan = false;
                    } else if (x+teller<9) {
                        teller++;
                        veld.getVakken()[x+teller][y].vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == 2){
                while ((y + teller < 7) && doorgaan) {
                    obstakel = veld.getVakken()[x][y + teller].checkObstakels(richting);
                    if (obstakel < 2 || obstakel == 3) {
                        schade(richting, x, y+teller);
                        doorgaan = false;
                    } else if (y+teller>0) {
                        teller++;
                        veld.getVakken()[x][y + teller].vuurPlaats(Fiche.VUUR);
                    }
                }
            }
            else if (richting == 3){
                while ((x - teller > 0) && doorgaan) {
                    obstakel = veld.getVakken()[x + teller][y].checkObstakels(richting);
                    if (obstakel < 2 || obstakel == 3) {
                        schade(richting, x - teller, y);
                        doorgaan = false;
                    }
                    else if (x-teller>0) {
                        teller++;
                        veld.getVakken()[x-teller][y].vuurPlaats(Fiche.VUUR);
                    }
                }
            }
        }
    }                               //its beautiful but useless made by joseph


    public void handleBrandweerlieden() {
        // TODO - implement BeurtAfronding.handleBrandweerlieden
        throw new UnsupportedOperationException();
    }

    public void handlePersoonVanAandacht() {
        // TODO - implement BeurtAfronding.handlePersoonVanAandacht
        throw new UnsupportedOperationException();
    }

    public void vulPersoonVanAandachtAan() {
        // TODO - implement BeurtAfronding.vulPersoonVanAandachtAan
        throw new UnsupportedOperationException();
    }

    public void checkWinLoseCondition() {
        // TODO - implement BeurtAfronding.checkWinLoseCondition
        throw new UnsupportedOperationException();
    }

}