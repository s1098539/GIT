package flashpoint;

public class Bewegen {

    public Bewegen() {
    }

    public void run(int richting, Speler speler, Speelveld speelveld) {
        speelveld.removeSpeler(speler);
        System.out.println(speler.getNaam() + " start locatie: X" + speler.getLocatieX() + " Y" +  speler.getLocatieY());
        int check;
        switch (richting) {
            case 0:
                check = speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()].checkRichting(0);
                if (check == 2 || check > 3) speler.setLocatieY(speler.getLocatieY()-1);
                else System.out.println("Er staat iets in de weg");
                break;
            case 1:
                check = speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()].checkRichting(1);
                if (check == 2 || check > 3) speler.setLocatieX(speler.getLocatieX()+1);
                else System.out.println("Er staat iets in de weg");
                break;
            case 2:
                check = speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()].checkRichting(2);
                if (check == 2 || check > 3) speler.setLocatieY(speler.getLocatieY()+1);
                else System.out.println("Er staat iets in de weg");
                break;
            case 3:
                check = speelveld.getVakken()[speler.getLocatieX()][speler.getLocatieY()].checkRichting(3);
                if (check == 2 || check > 3)speler.setLocatieX(speler.getLocatieX()-1);
                else System.out.println("Er staat iets in de weg");
                break;
            default:
                System.out.println("De richting "+richting+" is niet toegestaan");
        }
        speelveld.addSpeler(speler);
        System.out.println(speler.getNaam() + " eind locatie X" + speler.getLocatieX() + " Y" +  speler.getLocatieY());
    }

}