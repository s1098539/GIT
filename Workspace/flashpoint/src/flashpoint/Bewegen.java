package flashpoint;

public class Bewegen extends Speelveld{

    public Bewegen() {
    }

    public void run(int richting, Speler speler) {
        super.removeSpeler(speler);
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
        super.addSpeler(speler);
	}

}