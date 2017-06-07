package sample;

public class Speelveld {

    public Speelveld() {
        newVakken();
    }

    public Vak[][]vakken = new Vak[10][8];

    public void newVak(int x, int y) {
        vakken[x][y] = new Vak();
    }

    public void newVakken() {
        for(int x=0; x<10; x++) {
            for(int y=0; y<8; y++) {
                newVak(x,y);
            }
        }
    }

    public Vak[][] getVakken() {
        return vakken;
    }

    public Vak getVak(int x, int y) {
        return vakken[x][y];
    }

    public void schade(int x, int y, Richting richting) {
        Vak vak = getVak(x,y);
        switch (richting) {
            case BOVEN:
                vak.schadeStatus(richting);
                getVak(x,y-1).schadeStatus(Richting.ONDER);
                break;
            case RECHTS:
                vak.schadeStatus(richting);
                getVak(x+1,y).schadeStatus(Richting.LINKS);
                break;
            case ONDER:
                vak.schadeStatus(richting);
                getVak(x,y+1).schadeStatus(Richting.BOVEN);
                break;
            case LINKS:
                vak.schadeStatus(richting);
                getVak(x-1,y).schadeStatus(Richting.RECHTS);
                break;
        }
    }

    public void setMuren(){
        //buitenmuren horizontaal
        for(int x = 1; x <9; x++) {
            getVak(x,0).setObstakel(2,0);
            getVak(x,1).setObstakel(0,0);
            getVak(x,6).setObstakel(2,0);
            getVak(x,7).setObstakel(0,0);

        }
        //buitenmuren verticaal
        for (int y = 1; y < 7; y++) {
            getVak(0,y).setObstakel(1,0);
            getVak(1,y).setObstakel(3,0);
            getVak(8,y).setObstakel(1,0);
            getVak(9,y).setObstakel(3,0);

        }
        //scheidingswand woonkamer
        getVak(1,2).setObstakel(2,0);
        getVak(1,3).setObstakel(0,0);
        getVak(2,2).setObstakel(2,0);
        getVak(2,3).setObstakel(0,0);

        //muur tussen woonkamer en slaapkamer + keuken
        for (int j = 1; j<7;j++){
            getVak(j,4).setObstakel(2,0);
            getVak(j,5).setObstakel(0,0);
            getVak(j,4).setObstakel(2,0);
            getVak(j,5).setObstakel(0,0);
        }
        //muur tussen woonkamer en badkamer + bergruimte
        for (int k = 1; k<4;k++){
            getVak(3,k).setObstakel(1,0);
            getVak(4,k).setObstakel(3,0);
            getVak(3,k).setObstakel(1,0);
            getVak(4,k).setObstakel(3,0);
        }
        //muur tussen bergruimte en badkamer
        getVak(4,1).setObstakel(2,0);
        getVak(4,2).setObstakel(0,0);
        getVak(5,1).setObstakel(2,0);
        getVak(5,2).setObstakel(0,0);

        //overige horizontale muren
        getVak(4,3).setObstakel(2,0);
        getVak(4,4).setObstakel(0,0);
        getVak(7,3).setObstakel(2,0);
        getVak(7,4).setObstakel(0,0);
        getVak(8,3).setObstakel(2,0);
        getVak(8,4).setObstakel(0,0);

        //verticale muur tussen slaapkamer en keuken
        getVak(3,5).setObstakel(1,0);
        getVak(4,5).setObstakel(3,0);
        getVak(3,6).setObstakel(1,0);
        getVak(4,6).setObstakel(3,0);

        //verticale muur tussen slaapkamers
        getVak(6,5).setObstakel(1,0);
        getVak(7,5).setObstakel(3,0);
        getVak(6,6).setObstakel(1,0);
        getVak(7,6).setObstakel(3,0);

        //overige muur
        getVak(5,2).setObstakel(1,0);
        getVak(6,2).setObstakel(3,0);

        //verticale deuren
        getVak(5,1).setObstakel(1,3);
        getVak(6,1).setObstakel(3,3);
        getVak(5,3).setObstakel(1,3);
        getVak(6,3).setObstakel(3,3);
        getVak(6,4).setObstakel(1,3);
        getVak(7,4).setObstakel(3,3);

        //horizontale deuren
        getVak(5,4).setObstakel(0,3);
        getVak(5,3).setObstakel(2,3);
        getVak(6,4).setObstakel(0,3);
        getVak(6,3).setObstakel(2,3);
        getVak(6,5).setObstakel(0,3);
        getVak(6,4).setObstakel(2,3);
        getVak(3,5).setObstakel(0,3);
        getVak(3,4).setObstakel(2,3);

        //buitenmuren waar deuren horen leeg maken
        getVak(0,3).setObstakel(1,5);
        getVak(1,3).setObstakel(3,5);

        getVak(3,7).setObstakel(0,5);
        getVak(3,6).setObstakel(2,5);



    }
}