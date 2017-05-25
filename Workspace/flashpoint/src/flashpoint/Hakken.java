package flashpoint;

public class Hakken {

    public Hakken() {
    }

    public void run(int richting, Speler speler, Speelveld speelveld) {
		speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()].getMuren()[richting].schade();
        System.out.println("Hakken like a boss");
        switch (richting) {
            case 0:
                speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()-1].getMuren()[2].schade();
                break;
            case 1:
                speelveld.getVakken()[speler.getLocatieX()+1][speler.getLocatieY()].getMuren()[3].schade();
                break;
            case 2:
                speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()+1].getMuren()[0].schade();
                break;
            case 3:
                speelveld.getVakken()[speler.getLocatieX()-1][speler.getLocatieY()].getMuren()[1].schade();
                break;
        }
	}

}