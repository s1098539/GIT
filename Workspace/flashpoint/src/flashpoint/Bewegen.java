package flashpoint;

public class Bewegen {

    public Bewegen() {
    }

    public void run(int richting, Speler speler, Speelveld speelveld) {
        speelveld.removeSpeler(speler);
        System.out.print(speler.getNaam() + " beweegt van x" + speler.getLocatieX() + " Y" +  speler.getLocatieY());
        switch (richting) {
            case 0: //vakken[speler.getLocatieX()][speler.getLocatieY()+1].addSpeler(speler);
            speler.setLocatieY(speler.getLocatieY()+1);
                break;
            case 1: //vakken[speler.getLocatieX()+1][speler.getLocatieY()].addSpeler(speler);
                speler.setLocatieX(speler.getLocatieX()+1);
                break;
            case 2: //vakken[speler.getLocatieX()][speler.getLocatieY()-1].addSpeler(speler);
                speler.setLocatieY(speler.getLocatieY()-1);
                break;
            case 3: //vakken[speler.getLocatieX()-1][speler.getLocatieY()].addSpeler(speler);
                speler.setLocatieX(speler.getLocatieX()-1);
                break;
        }
        speelveld.addSpeler(speler);
        System.out.println(" naar x" + speler.getLocatieX() + " Y" +  speler.getLocatieY());
    }

}