package sample;
public class BeurtAfronding {


    //Dit worden classes
//	private int NewRook;
//	private int ExplosieHandler;
//	private int VonkoverslagHandler;
//	private int BrandhaardHandler;
//	private int BrandweerliedenHandler;
//	private int PersoonVanAandachtHandler;
//	private int GevaarlijkeStofHandler;
//	private int PersoonVanAandachtAanvuller;
//	private int WinLoseConditionChecker;
    Speelveld veld;
	Dobbelsteen d6 = new Dobbelsteen(6);
    Dobbelsteen d8 = new Dobbelsteen(8);

    public BeurtAfronding(Speelveld veld) {
        this.veld = veld;
    }

    public void newRook() {
        d6.gooi();
        d8.gooi();
        int x = d8.getWaarde();
        int y = d6.getWaarde();
        if(veld.getVakken()[x][y].getObjecten()[6] == null){
            Object.Rook rook = new Object.Rook();
            veld.getVakken()[x][y].addObject(rook);
        }
        else if(veld.getVakken()[x][y].getObjecten()[6].getNaam() == "Rook"){
            Object.Vuur vuur = new Object.Vuur();
            veld.getVakken()[x][y].addObject(vuur);
        }
        else if(veld.getVakken()[x][y].getObjecten()[6].getNaam() == "Vuur"){
            handleExplosie(x, y);
        }

//        if(veld.getVakken()[x][y].getObjecten()[6].getNaam() == "Rook")




    }

	public void createBeurtAfrondingen() {
		// TODO - implement BeurtAfronding.createBeurtAfrondingen
		throw new UnsupportedOperationException();
	}


	public void handleExplosie(int x, int y) {
        int obstakel;
        for(int i=0; i<4; i++) {
            obstakel = veld.getVakken()[x][y].checkObstakels(i);
                switch(obstakel){
                    case 0 : veld.getVakken()[x][y].setObstakel(i, 1);
                             switch(i){
                                 case 0: veld.getVakken()[x][y-1].setObstakel(2, 1);
                                 case 1: veld.getVakken()[x+1][y].setObstakel(3, 1);
                                 case 2: veld.getVakken()[x][y+1].setObstakel(4, 1);
                                 case 3: veld.getVakken()[x-1][y].setObstakel(1, 1);
                             }
                        break;
                    case 1 : veld.getVakken()[x][y].setObstakel(i, 1);
                             switch(i){
                                 case 0: veld.getVakken()[x][y-1].setObstakel(2, 2);
                                 case 1: veld.getVakken()[x+1][y].setObstakel(3, 2);
                                 case 2: veld.getVakken()[x][y+1].setObstakel(4, 2);
                                 case 3: veld.getVakken()[x-1][y].setObstakel(1, 2);
                             }
                        break;
                    default:
                        break;
//                    case 2 : veld
                }

            }
        }


	public void handleVonkoverslag() {
		// TODO - implement BeurtAfronding.handleVonkoverslag
		throw new UnsupportedOperationException();
	}

	public void handleBrandhaard() {
		// TODO - implement BeurtAfronding.handleBrandhaard
		throw new UnsupportedOperationException();
	}

	public void handleBrandweerlieden() {
		// TODO - implement BeurtAfronding.handleBrandweerlieden
		throw new UnsupportedOperationException();
	}

	public void handlePersoonVanAandacht() {
		// TODO - implement BeurtAfronding.handlePersoonVanAandacht
		throw new UnsupportedOperationException();
	}

	public void handleGevaarlijkeStof() {
		// TODO - implement BeurtAfronding.handleGevaarlijkeStof
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