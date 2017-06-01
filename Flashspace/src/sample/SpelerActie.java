package sample;
public class SpelerActie {

//    Dit worden functies
//	private int BeweegActie;        Done (Lion)!!!
//	private int DeurInteractie;     Done (Lion)!!!
//	private int MuurInteractie;
//	private int BlusActie;
//	private int OppakActie;
//	private int RijActie;
//	private int FunctiewisselActie;
//	private int BrandweerwagenSpuitActie;
//	private int OppakkenPersoonVanAandachtActie;
//	private int OppakkenGevaarlijkeStofActie;

    Speler speler;
    Speelveld speelveld;

    public SpelerActie(Speler speler, Speelveld speelveld) {
    }

    public void Beweegwactie(int richting) {
        Vak vak = speelveld.getVak(speler.getX(), speler.getY());
        vak.removeSpeler(speler);
        switch(richting) {
            case 0: if(vak.checkObstakels(0)==2 || vak.checkObstakels(0)>3) {
                        speler.setY(speler.getY()-1);
            }   break;
            case 1: if(vak.checkObstakels(1)==2 || vak.checkObstakels(1)>3) {
                speler.setX(speler.getX()+1);
            }   break;
            case 2: if(vak.checkObstakels(2)==2 || vak.checkObstakels(2)>3) {
                speler.setY(speler.getY() + 1);
            }   break;
            case 3: if(vak.checkObstakels(3)==2 || vak.checkObstakels(3)>3) {
                speler.setX(speler.getX()-1);
            }   break;
        }
        speelveld.getVak(speler.getX(), speler.getY()).addSpeler(speler);
    }

    public void DeurInteractie(int richting) {
        Vak vak = speelveld.getVak(speler.getX(), speler.getY());
        switch (vak.checkObstakels(richting)) {
            case 3:
                vak.setObstakel(richting, 4);
                DeurInteractieloop(richting);
                break;
            case 4:
                vak.setObstakel(richting, 3);
                DeurInteractieloop(richting);
            default:
                System.out.println("404 deur not found");
        }
    }

    private void DeurInteractieloop(int richting) {
        switch (richting) {
            case 0:
                speelveld.getVak(speler.getX(), speler.getY() - 1).setObstakel(2, 4);
                break;
            case 1:
                speelveld.getVak(speler.getX() + 1, speler.getY()).setObstakel(2, 4);
                break;
            case 2:
                speelveld.getVak(speler.getX(), speler.getY() + 1).setObstakel(2, 4);
                break;
            case 3:
                speelveld.getVak(speler.getX() - 1, speler.getY()).setObstakel(2, 4);
                break;
            }
        }
}