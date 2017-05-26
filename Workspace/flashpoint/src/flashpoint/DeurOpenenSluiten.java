package flashpoint;

public class DeurOpenenSluiten {

    public DeurOpenenSluiten() {
    }

    public void run(int richting, Speler speler, Speelveld speelveld) {
        try {
            speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()].getDeuren()[richting].OpenSluiten();

        } catch (NullPointerException e) {
            System.out.println("Op het huidige veld geen deur");
        }
        System.out.println("Deuren openen en sluiten like a boss");
        try {
            switch (richting) {
                case 0:
                    speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()-1].getDeuren()[2].OpenSluiten();
                    break;
                case 1:
                    speelveld.getVakken()[speler.getLocatieX()+1][speler.getLocatieY()].getDeuren()[3].OpenSluiten();
                    break;
                case 2:
                    speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()+1].getDeuren()[0].OpenSluiten();
                    break;
                case 3:
                    speelveld.getVakken()[speler.getLocatieX()-1][speler.getLocatieY()].getDeuren()[1].OpenSluiten();
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println("Op het andere veld is geen deur");
        }
    }

}