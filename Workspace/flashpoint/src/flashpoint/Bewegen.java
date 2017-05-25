package flashpoint;

public class Bewegen {

    public Bewegen() {
    }

    public void run(int richting, Speler speler, Speelveld speelveld) {
        speelveld.removeSpeler(speler);
        System.out.print(speler.getNaam() + " beweegt van x" + speler.getLocatieX() + " Y" +  speler.getLocatieY());
        switch (richting) {
            case 0:
                speler.setLocatieY(speler.getLocatieY()+1);
                break;
            case 1: speler.setLocatieX(speler.getLocatieX()+1);
                break;
            case 2: speler.setLocatieY(speler.getLocatieY()-1);
                break;
            case 3: speler.setLocatieX(speler.getLocatieX()-1);
                break;
            default:
                System.out.println("De richting "+richting+" is niet toegestaan");
        }
        speelveld.addSpeler(speler);
        System.out.println(" naar x" + speler.getLocatieX() + " Y" +  speler.getLocatieY());
    }

}