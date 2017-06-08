package sample;
public class Speler {

	public String naam;
	public Rol rol;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Kleur getKleur() {
        return kleur;
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

    public void beweegwActie(Richting richting) {
        Vak vak = veld.getVak(x,y);
        switch(richting) {
            case BOVEN: if(y>0 && vak.boven.isBegaanbaar()) {
                y--;
            }   break;
            case RECHTS: if(x<9 && vak.rechts.isBegaanbaar()) {
                x++;
            }   break;
            case ONDER: if(y<7 && vak.onder.isBegaanbaar()) {
                y++;
            }   break;
            case LINKS: if(x>0 && vak.links.isBegaanbaar()) {
                x--;
            }   break;
        }
    }
    
        public void deurInteractie(Richting richting) {
            vak = veld.getVak(x,y);
            if (vak.getObstakelRichting(richting)==Status.DEURD){
                vak.setObstakelRichting(richting, Status.DEURO);
                obstakelInteractieloop(richting, Status.DEURO);
            }
            else if(vak.getObstakelRichting(richting)==Status.DEURO){
                vak.setObstakelRichting(richting, Status.DEURD);
                obstakelInteractieloop(richting, Status.DEURD);
            }
            else {
                System.out.println("404 deur not found");
            }
        }
    
        public void muurInteractie(Richting richting) {
            vak = veld.getVak(x,y);
            switch (vak.getObstakelRichting(richting)) {
                case MUUR:
                    vak.setObstakelRichting(richting, Status.MUUR1);
                    obstakelInteractieloop(richting, Status.MUUR1);
                    break;
                case MUUR1:
                    vak.setObstakelRichting(richting, Status.MUUR2);
                    obstakelInteractieloop(richting, Status.MUUR2);
                    break;
                default:
                    System.out.println("404 muur not found");
            }
        }
    
        private void obstakelInteractieloop(Richting richting, Status status) {
            switch (richting) {
                case BOVEN:
                    veld.getVak(x, y - 1).setObstakelRichting(Richting.ONDER,status);
                    break;
                case RECHTS:
                    veld.getVak(x + 1, y).setObstakelRichting(Richting.LINKS, status);
                    break;
                case ONDER:
                    veld.getVak(x, y + 1).setObstakelRichting(Richting.BOVEN, status);
                    break;
                case LINKS:
                    veld.getVak(x - 1, y).setObstakelRichting(Richting.RECHTS, status);
                    break;
            }
        }
    
        public void blusActie(Richting richting) {
            switch (richting) {
                case BOVEN:
                    vak = veld.getVak(x, y-1);
                    break;
                case RECHTS:
                    vak = veld.getVak(x+1, y);
                    break;
                case ONDER:
                    vak = veld.getVak(x, y+1);
                    break;
                case LINKS:
                    vak = veld.getVak(x-1, y);
                    break;
            }
            if(vak.isVuur()){
                vak.vuurPlaats(Fiche.ROOK);
            }
            if(vak.isRook()) {
                vak.vuurPlaats(Fiche.NIKS);
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
            for(Richting richting: Richting.values()) {
                if(vak.getObstakelRichting(richting).isBegaanbaar()) {
                    switch (richting) {
                        case BOVEN: veld.getVak(x,y-1).vuurPlaats(Fiche.NIKS);
                            break;
                        case RECHTS: veld.getVak(x+1,y).vuurPlaats(Fiche.NIKS);
                            break;
                        case ONDER: veld.getVak(x,y+1).vuurPlaats(Fiche.NIKS);
                            break;
                        case LINKS: veld.getVak(x-1,y).vuurPlaats(Fiche.NIKS);
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