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
        if(veld.getVakken()[x][y].


        Object.Rook rook = new Object.Rook();
        veld.getVakken()[x][y].addObject(rook);

    }

	public void createBeurtAfrondingen() {
		// TODO - implement BeurtAfronding.createBeurtAfrondingen
		throw new UnsupportedOperationException();
	}


	public void handleExplosie() {
		// TODO - implement BeurtAfronding.handleExplosie
		throw new UnsupportedOperationException();
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