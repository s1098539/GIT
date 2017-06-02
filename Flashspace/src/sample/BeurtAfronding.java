package sample;
public class BeurtAfronding {


    //Dit worden classes
//	private int NewRook;            done Joep
//	private int ExplosieHandler;    done Joep
//	private int VonkoverslagHandler;     done Lion
//	private int BrandhaardHandler;          working on it (Lion)
//	private int BrandweerliedenHandler;
//	private int PersoonVanAandachtHandler;
//	private int GevaarlijkeStofHandler;     Done Lion
//	private int PersoonVanAandachtAanvuller;
//	private int WinLoseConditionChecker;
    Speelveld veld;
    Vak vak;
	Dobbelsteen d6 = new Dobbelsteen(6);
    Dobbelsteen d8 = new Dobbelsteen(8);

    public BeurtAfronding(Speelveld veld) {
        this.veld = veld;
    }

//    public void handleBrandhaard() {
//        veld.getVak(d8.getWaarde())
//    }


    public void handleGevaarlijkeStof() {
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 7; x++) {
                if(veld.getVak(x,y).getObjecten()[8].getNaam().equals("GS")) {
                    handleExplosie(x,y);
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
                    vak = veld.getVak(x, y);
                    if (vak.getObjecten()[6].getNaam().equals("Vuur")) {
                        for (int i = 0; i < 4; i++)
                            if (vak.checkObstakels(i) == 2 || vak.checkObstakels(i) > 3) {
                                switch (i) {
                                    case 0:
                                        if (y > 0 && veld.getVak(x, y - 1).getObjecten()[6].equals("Rook")) {
                                            veld.getVak(x, y - 1).addObject(new Object.Vuur());
                                            loop = true;
                                        }
                                        break;
                                    case 1:
                                        if (x < 9 && veld.getVak(x + 1, y).getObjecten()[6].equals("Rook")) {
                                            veld.getVak(x, y - 1).addObject(new Object.Vuur());
                                        }
                                        break;
                                    case 2:
                                        if (y < 7 && veld.getVak(x, y + 1).getObjecten()[6].equals("Rook")) {
                                            veld.getVak(x, y - 1).addObject(new Object.Vuur());
                                        }
                                        break;
                                    case 3:
                                        if (x > 0 && veld.getVak(x - 1, y).getObjecten()[6].equals("Rook")) {
                                            veld.getVak(x, y - 1).addObject(new Object.Vuur());
                                            loop = true;
                                        }
                                        break;
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
//        int x = d8.getWaarde();
//        int y = d6.getWaarde();
        int x = 2;
        int y = 3;
        if (veld.getVak(x,y).getObjecten()[6] == null) {
            Object.Rook rook = new Object.Rook();
            veld.getVak(x,y).addObject(rook);
        } else if (veld.getVak(x,y).getObjecten()[6].getNaam().equals("Vuur")) {
            Object.Vuur vuur = new Object.Vuur();
            veld.getVak(x,y).addObject(vuur);
        } else if (veld.getVak(x,y).getObjecten()[6].getNaam().equals("Vuur")) {
            handleExplosie(x, y);
        }
    }

	public void handleExplosie(int x, int y) {// Joep
        boolean doorgaan;
        int teller;
        Vak vak;
        for (int richting = 0; richting < 4; richting++) {
            teller = 0;
            doorgaan = true;
            while (y - teller > 0 && doorgaan) {
                vak = veld.getVak(x, y - teller);
                if (vak.checkObstakels(richting) == 2 || vak.checkObstakels(richting) > 3) {
                    teller++;
                    if (!vak.getObjecten()[6].getNaam().equals("Vuur")) {
                        doorgaan = false;
                    }
                    vak.addObject(new Object.Vuur());
                }
                else {
                    schade(richting, x, (y - teller));
                    doorgaan = false;
                }
            }
            while (x + teller < 9 && doorgaan) {
                vak = veld.getVak(x+teller, y);
                if (vak.checkObstakels(richting) == 2 || vak.checkObstakels(richting) > 3) {
                    teller++;
                    if (!vak.getObjecten()[6].getNaam().equals("Vuur")) {
                        doorgaan = false;
                    }
                    vak.addObject(new Object.Vuur());
                }
                else {
                    schade(richting, x+teller, y);
                    doorgaan = false;
                }
            }
            while (y + teller < 7 && doorgaan) {
                vak = veld.getVak(x, y + teller);
                if (vak.checkObstakels(richting) == 2 || vak.checkObstakels(richting) > 3) {
                    teller++;
                    if (!vak.getObjecten()[6].getNaam().equals("Vuur")) {
                        doorgaan = false;
                    }
                    vak.addObject(new Object.Vuur());
                }
                else {
                    schade(richting, x, (y + teller));
                    doorgaan = false;
                }
            }
            while (x - teller > 0 && doorgaan) {
                vak = veld.getVak(x - teller, y);
                if (vak.checkObstakels(richting) == 2 || vak.checkObstakels(richting) > 3) {
                    teller++;
                    if (!vak.getObjecten()[6].getNaam().equals("Vuur")) {
                        doorgaan = false;
                    }
                    vak.addObject(new Object.Vuur());
                }
                else {
                    schade(richting, x - teller, y);
                    doorgaan = false;
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
                        veld.getVakken()[x][y - teller].addObject(new Object.Vuur());
                    }
                }
            }
            if (richting == 1){
                while ((x + teller < 9) && doorgaan) {
                    obstakel = veld.getVakken()[x + teller][y].checkObstakels(richting);
                    if (obstakel < 2 || obstakel == 3) {
                        schade(richting, x+teller, y);
                        doorgaan = false;
                    } else if (x+teller<9) {
                        teller++;
                        veld.getVakken()[x+teller][y].addObject(new Object.Vuur());
                    }
                }
            }
            if (richting == 2){
                while ((y + teller < 7) && doorgaan) {
                    obstakel = veld.getVakken()[x][y + teller].checkObstakels(richting);
                    if (obstakel < 2 || obstakel == 3) {
                        schade(richting, x, y+teller);
                        doorgaan = false;
                    } else if (y+teller>0) {
                        teller++;
                        veld.getVakken()[x][y + teller].addObject(new Object.Vuur());
                    }
                }
            }
            if (richting == 3){
                while ((x - teller > 0) && doorgaan) {
                    obstakel = veld.getVakken()[x + teller][y].checkObstakels(richting);
                    if (obstakel < 2 || obstakel == 3) {
                        schade(richting, x - teller, y);
                        doorgaan = false;
                    }
                    else if (x-teller>0) {
                        teller++;
                        veld.getVakken()[x-teller][y].addObject(new Object.Vuur());
                    }
                }
            }
        }
    }                               //its beautiful but useless made by joseph

    public void schade(int richting, int x, int y){
        int obstakel = veld.getVak(x,y).checkObstakels(richting);
        switch(obstakel) {
            case 0:
                veld.getVak(x,y).setObstakel(richting, 1);
                schadeLoop(richting,1,x,y);
                break;
            case 1:
                veld.getVak(x,y).setObstakel(richting, 1);
                schadeLoop(richting,2,x,y);
                break;
            case 3:
                veld.getVak(x,y).setObstakel(richting, 5);
                schadeLoop(richting,5,x,y);
                break;
        }

}

    private void schadeLoop(int richting, int obstakel, int x, int y) {
        switch(richting) {
            case 0:
                veld.getVak(x,y-1).setObstakel(2, obstakel);
                break;
            case 1:
                veld.getVak(x+1,y).setObstakel(3, obstakel);
                break;
            case 2:
                veld.getVak(x,y+1).setObstakel(4, obstakel);
                break;
            case 3:
                veld.getVak(x-1,y).setObstakel(1, obstakel);
                break;
        }
    }

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