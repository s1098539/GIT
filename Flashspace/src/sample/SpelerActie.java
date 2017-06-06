package sample;
public class SpelerActie {

//    Dit worden functies
//	private int BeweegActie;        Done (Lion)!!!
//	private int DeurInteractie;     Done (Lion)!!!
//	private int MuurInteractie;     Done (Lion)!!!
//	private int BlusActie;          Done (Lion)!!!
//	private int OppakActie;         busy (joep)
//	private int RijActie;
//	private int FunctiewisselActie; Done (Lion)!!!
//	private int BrandweerwagenSpuitActie;       Done (Lion)!!!  Getest door Lion (10/10)
//	private int OppakkenPersoonVanAandachtActie;
//	private int OppakkenGevaarlijkeStofActie;

    Object.Speler speler;
    Speelveld speelveld;
    Vak vak;
    Dobbelsteen d6 = new Dobbelsteen(6);
    Dobbelsteen d8 = new Dobbelsteen(8);

    public SpelerActie(Object.Speler speler, Speelveld speelveld) {
        this.speler = speler;
        this.speelveld = speelveld;
    }



    public Vak spelerLocatieVak() {
        return speelveld.getVak(speler.getX(),speler.getY());
    }

    public void functiewisselActie(Character character) {
        speler.setCharacter(character);
    }

    public void beweegwActie(int richting) {
        Vak vak = spelerLocatieVak();
        vak.removeSpeler(speler);
        switch(richting) {
            case 0: if(speler.getY()>0 && (vak.checkObstakels(0)==2 || vak.checkObstakels(0)>3)) {
                speler.setY(speler.getY()-1);
            }   break;
            case 1: if(speler.getX()<9 && (vak.checkObstakels(1)==2 || vak.checkObstakels(1)>3)) {
                speler.setX(speler.getX()+1);
            }   break;
            case 2: if(speler.getY()<7 && (vak.checkObstakels(2)==2 || vak.checkObstakels(2)>3)) {
                speler.setY(speler.getY() + 1);
            }   break;
            case 3: if(speler.getX()>0 && (vak.checkObstakels(3)==2 || vak.checkObstakels(3)>3)) {
                speler.setX(speler.getX()-1);
            }   break;
        }
        speelveld.getVak(speler.getX(),speler.getY()).addSpeler(speler);
    }

    public void deurInteractie(int richting) {
        Vak vak = spelerLocatieVak();
        switch (vak.checkObstakels(richting)) {
            case 3:
                vak.setObstakel(richting, 4);
                obstakelInteractieloop(richting,4);
                break;
            case 4:
                vak.setObstakel(richting, 3);
                obstakelInteractieloop(richting,3);
            default:
                System.out.println("404 deur not found");
        }
    }

    public void muurInteractie(int richting) {
        Vak vak = spelerLocatieVak();
        switch (vak.checkObstakels(richting)) {
            case 0:

                vak.setObstakel(richting, 1);
                obstakelInteractieloop(richting,1);
                break;
            case 1:
                vak.setObstakel(richting, 2);
                obstakelInteractieloop(richting,2);
                break;
            default:
                System.out.println("404 muur not found");
        }
    }

    private void obstakelInteractieloop(int richting, int obstakel) {
        switch (richting) {
            case 0:
                speelveld.getVak(speler.getX(), speler.getY() - 1).setObstakel(2, obstakel);
                break;
            case 1:
                speelveld.getVak(speler.getX() + 1, speler.getY()).setObstakel(3, obstakel);
                break;
            case 2:
                speelveld.getVak(speler.getX(), speler.getY() + 1).setObstakel(0, obstakel);
                break;
            case 3:
                speelveld.getVak(speler.getX() - 1, speler.getY()).setObstakel(1, obstakel);
                break;
        }
    }

    public void blusActie(int richting) {
        switch (richting) {
            case 0:
                vak = speelveld.getVak(speler.getX(), speler.getY()-1);
                break;
            case 1:
                vak = speelveld.getVak(speler.getX()+1, speler.getY());
                break;
            case 2:
                vak = speelveld.getVak(speler.getX(), speler.getY()+1);
                break;
            case 3:
                vak = speelveld.getVak(speler.getX()-1, speler.getY());
                break;
        }
        if(vak.getObjecten()[6].getNaam().equals("Vuur")){
            vak.addObject(new Object.Rook());
        }
        if(vak.getObjecten()[6].getNaam().equals("Rook")) {
            vak.getObjecten()[6] = null;
        }
    }

    public void BrandweerwagenSpuitActie(int kwadrant) {
        d6.gooi();
        d8.gooi();
        switch(kwadrant) {
            case 2: if(d6.getWaarde()<4) {
                d6.flip();
            }
                if(d8.getWaarde()<5) {
                    d8.flip();
                }

                break;
            case 3: if(d6.getWaarde()<4) {
                d6.flip();
            }
                if(d8.getWaarde()>4) {
                    d8.flip();
                }
                break;
            case 0: if(d6.getWaarde()>3) {
                d6.flip();
            }
                if(d8.getWaarde()>4) {
                    d8.flip();
                }
                break;
            case 1: if(d6.getWaarde()>3) {
                d6.flip();
            }
                if(d8.getWaarde()<5) {
                    d8.flip();
                }
                break;
        }
        int x = d8.getWaarde();
        int y = d6.getWaarde();
        System.out.println(x);
        System.out.println(y);
        vak = speelveld.getVak(x,y);

        vak.removeObject(6);
        for(int i = 0; i < 4; i++) {
            if(vak.checkObstakels(i)==2 || vak.checkObstakels(i)>3) {
                switch (i) {
                    case 0: speelveld.getVak(x,y-1).removeObject(6);
                        break;
                    case 1: speelveld.getVak(x+1,y).removeObject(6);
                        break;
                    case 2: speelveld.getVak(x,y+1).removeObject(6);
                        break;
                    case 3: speelveld.getVak(x-1,y).removeObject(6);
                }
            }
        }
    }

    public void oppakActie(String object){
        int x =speler.getX();
        int y = speler.getY();
        Vak vak = speelveld.getVak(x,y);
        if (speler.getRugtas()== null){
            switch(object){
                case "PersoonVanAandacht": speler.setRugtas(vak.getObjecten()[8]);
                    break;
                case "GevaarlijkeStof": speler.setRugtas(vak.getObjecten()[8]);
            }
        }
        else if (speler.getRugtas().getNaam().equals("GevaarlijkeStof")){
            vak.addObject(new Object.GevaarlijkeStof());
            speler.setRugtas(null);
        }
        else if (speler.getRugtas().getNaam().equals("PersoonVanAandacht")){
            vak.addObject(new Object.PersoonVanAandacht());
            speler.setRugtas(null);
        }

    }
}


