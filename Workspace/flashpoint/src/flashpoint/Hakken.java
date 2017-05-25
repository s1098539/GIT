package flashpoint;

public class Hakken {

    public Hakken() {
    }

    public void run(int richting, Speler speler, Speelveld speelveld) {
        try {
            speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()].getMuren()[richting].schade();
        } catch (NullPointerException e) {
            System.out.println("Op het huidige veld is geen muur");
        }
        System.out.println("Hakken like a boss");
        try {
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
        } catch (NullPointerException e) {
            System.out.println("Op het andere veld is geen muur");
        }
    }

}