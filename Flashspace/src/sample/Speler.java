package sample;
public class Speler {

	public String naam;
	public Character character;
	public Kleur kleur;
	public int x;
	public int y;
    public Object rugtas;
    private Speelveld veld;
    Dobbelsteen d6 = new Dobbelsteen(6);
    Dobbelsteen d8 = new Dobbelsteen(8);
    Vak vak = null;

    public Speler(String naam, /*Character character,*/ Kleur kleur, int x, int y, Speelveld veld) {
        this.naam = naam;
//        this.character = character;
        this.kleur = kleur;
        this.x = x;
        this.y = y;
        this.veld = veld;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public void setKleur(Kleur kleur) {
        this.kleur = kleur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Object getRugtas() {
        return rugtas;
    }

    public void setRugtas(Object rugtas) {
        this.rugtas = rugtas;
    }

    public void beweegwActie(int richting) {
        Vak vak = veld.getVak(x,y);
        vak.removeSpeler(kleur);
        switch(richting) {
            case 0: if(y>0 && (vak.checkObstakels(0)==2 || vak.checkObstakels(0)>3)) {
                y--;
            }   break;
            case 1: if(getX()<9 && (vak.checkObstakels(1)==2 || vak.checkObstakels(1)>3)) {
                x++;
            }   break;
            case 2: if(y<7 && (vak.checkObstakels(2)==2 || vak.checkObstakels(2)>3)) {
                y++;
            }   break;
            case 3: if(x>0 && (vak.checkObstakels(3)==2 || vak.checkObstakels(3)>3)) {
                x--;
            }   break;
        }
        veld.getVak(x,y).addSpeler(kleur);
        }
    
        public void deurInteractie(int richting) {
            Vak vak = veld.getVak(x,y);
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
            Vak vak = veld.getVak(x,y);
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
                    veld.getVak(x, y - 1).setObstakel(2, obstakel);
                    break;
                case 1:
                    veld.getVak(x + 1, y).setObstakel(3, obstakel);
                    break;
                case 2:
                    veld.getVak(x, y + 1).setObstakel(0, obstakel);
                    break;
                case 3:
                    veld.getVak(x - 1, y).setObstakel(1, obstakel);
                    break;
            }
        }
    
        public void blusActie(int richting) {

            switch (richting) {
                case 0:
                    vak = veld.getVak(x, y-1);
                    break;
                case 1:
                    vak = veld.getVak(x+1, y);
                    break;
                case 2:
                    vak = veld.getVak(x, y+1);
                    break;
                case 3:
                    vak = veld.getVak(x-1, y);
                    break;
            }
            if(vak.isVuur()){
                vak.setRook(true);
                vak.setVuur(false);
            }
            if(vak.isRook()) {
                vak.setRook(false);
                vak.setNiks(true);
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
            vak = veld.getVak(x,y);
    
            vak.vuurPlaats(Fiche.NIKS);
            for(int i = 0; i < 4; i++) {
                if(vak.checkObstakels(i)==2 || vak.checkObstakels(i)>3) {
                    switch (i) {
                        case 0: veld.getVak(x,y-1).vuurPlaats(Fiche.NIKS);
                            break;
                        case 1: veld.getVak(x+1,y).vuurPlaats(Fiche.NIKS);
                            break;
                        case 2: veld.getVak(x,y+1).vuurPlaats(Fiche.NIKS);
                            break;
                        case 3: veld.getVak(x-1,y).vuurPlaats(Fiche.NIKS);
                    }
                }
            }
        }


    //work in progress
//        public void oppakActie(Fiche fiche){
//            Vak vak = veld.getVak(x,y);
//            if (getRugtas()== null){
//                switch(fiche){
//                    case PERSOON:
//                        break;
//                    case STOFFEN:
//                }
//            }
//            else if (getRugtas().getNaam().equals("GevaarlijkeStof")){
//                vak.addObject(new Object.GevaarlijkeStof());
//                speler.setRugtas(null);
//            }
//            else if (speler.getRugtas().getNaam().equals("PersoonVanAandacht")){
//                vak.addObject(new Object.PersoonVanAandacht());
//                speler.setRugtas(null);
//            }
//

}