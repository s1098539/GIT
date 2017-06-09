package Flashpoint;

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

    public void schade(int x, int y, Richting richting)  {
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
            getVak(x,0).setObstakelRichting(Richting.ONDER, Status.MUUR);
            getVak(x,1).setObstakelRichting(Richting.BOVEN, Status.MUUR);
            getVak(x,6).setObstakelRichting(Richting.ONDER, Status.MUUR);
            getVak(x,7).setObstakelRichting(Richting.BOVEN, Status.MUUR);

        }
        //buitenmuren verticaal
        for (int y = 1; y < 7; y++) {
            getVak(0,y).setObstakelRichting(Richting.RECHTS, Status.MUUR);
            getVak(1,y).setObstakelRichting(Richting.LINKS, Status.MUUR);
            getVak(8,y).setObstakelRichting(Richting.RECHTS, Status.MUUR);
            getVak(9,y).setObstakelRichting(Richting.LINKS, Status.MUUR);

        }
        //scheidingswand woonkamer
        getVak(1,2).setObstakelRichting(Richting.ONDER, Status.MUUR);
        getVak(1,3).setObstakelRichting(Richting.BOVEN, Status.MUUR);
        getVak(2,2).setObstakelRichting(Richting.ONDER, Status.MUUR);
        getVak(2,3).setObstakelRichting(Richting.BOVEN, Status.MUUR);

        //muur tussen woonkamer en slaapkamer + keuken
        for (int j = 1; j<7;j++){
            getVak(j,4).setObstakelRichting(Richting.ONDER, Status.MUUR);
            getVak(j,5).setObstakelRichting(Richting.BOVEN, Status.MUUR);
            getVak(j,4).setObstakelRichting(Richting.ONDER, Status.MUUR);
            getVak(j,5).setObstakelRichting(Richting.BOVEN, Status.MUUR);
        }
        //muur tussen woonkamer en badkamer + bergruimte
        for (int k = 1; k<4;k++){
            getVak(3,k).setObstakelRichting(Richting.RECHTS, Status.MUUR);
            getVak(4,k).setObstakelRichting(Richting.LINKS, Status.MUUR);
            getVak(3,k).setObstakelRichting(Richting.RECHTS, Status.MUUR);
            getVak(4,k).setObstakelRichting(Richting.LINKS, Status.MUUR);
        }
        //muur tussen bergruimte en badkamer
        getVak(4,1).setObstakelRichting(Richting.ONDER, Status.MUUR);
        getVak(4,2).setObstakelRichting(Richting.BOVEN, Status.MUUR);
        getVak(5,1).setObstakelRichting(Richting.ONDER, Status.MUUR);
        getVak(5,2).setObstakelRichting(Richting.BOVEN, Status.MUUR);

        //overige horizontale muren
        getVak(4,3).setObstakelRichting(Richting.ONDER, Status.MUUR);
        getVak(4,4).setObstakelRichting(Richting.BOVEN, Status.MUUR);
        getVak(7,3).setObstakelRichting(Richting.ONDER, Status.MUUR);
        getVak(7,4).setObstakelRichting(Richting.BOVEN, Status.MUUR);
        getVak(8,3).setObstakelRichting(Richting.ONDER, Status.MUUR);
        getVak(8,4).setObstakelRichting(Richting.BOVEN, Status.MUUR);

        //verticale muur tussen slaapkamer en keuken
        getVak(3,5).setObstakelRichting(Richting.RECHTS, Status.MUUR);
        getVak(4,5).setObstakelRichting(Richting.LINKS, Status.MUUR);
        getVak(3,6).setObstakelRichting(Richting.RECHTS, Status.MUUR);
        getVak(4,6).setObstakelRichting(Richting.LINKS, Status.MUUR);

        //verticale muur tussen slaapkamers
        getVak(6,5).setObstakelRichting(Richting.RECHTS, Status.MUUR);
        getVak(7,5).setObstakelRichting(Richting.LINKS, Status.MUUR);
        getVak(6,6).setObstakelRichting(Richting.RECHTS, Status.MUUR);
        getVak(7,6).setObstakelRichting(Richting.LINKS, Status.MUUR);

        //overige muur
        getVak(5,2).setObstakelRichting(Richting.RECHTS, Status.MUUR);
        getVak(6,2).setObstakelRichting(Richting.LINKS, Status.MUUR);

        //verticale deuren
        getVak(5,1).setObstakelRichting(Richting.RECHTS, Status.DEURD);
        getVak(6,1).setObstakelRichting(Richting.LINKS, Status.DEURD);
        getVak(5,3).setObstakelRichting(Richting.RECHTS, Status.DEURD);
        getVak(6,3).setObstakelRichting(Richting.LINKS, Status.DEURD);
        getVak(6,4).setObstakelRichting(Richting.RECHTS, Status.DEURD);
        getVak(7,4).setObstakelRichting(Richting.LINKS, Status.DEURD);

        //horizontale deuren
        getVak(5,4).setObstakelRichting(Richting.BOVEN, Status.DEURD);
        getVak(5,3).setObstakelRichting(Richting.ONDER, Status.DEURD);
        getVak(6,4).setObstakelRichting(Richting.BOVEN, Status.DEURD);
        getVak(6,3).setObstakelRichting(Richting.ONDER, Status.DEURD);
        getVak(6,5).setObstakelRichting(Richting.BOVEN, Status.DEURD);
        getVak(6,4).setObstakelRichting(Richting.ONDER, Status.DEURD);
        getVak(3,5).setObstakelRichting(Richting.BOVEN, Status.DEURD);
        getVak(3,4).setObstakelRichting(Richting.ONDER, Status.DEURD);

        //buitenmuren waar deuren horen leeg maken
        getVak(0,3).setObstakelRichting(Richting.RECHTS, Status.LEEG);
        getVak(1,3).setObstakelRichting(Richting.LINKS, Status.LEEG);

        getVak(3,7).setObstakelRichting(Richting.BOVEN, Status.LEEG);
        getVak(3,6).setObstakelRichting(Richting.ONDER, Status.LEEG);



    }

    public int[] volgPijl(int x, int y){
        if(y==1 && x < 9 && x > 0){
            y = 2;
        }
        else if(y==6 && x < 9 && x > 0){
            y = 5;
        }
        if(x==1 && y < 6 && y > 1){
            x = 2;
        }
        if(x==8 && y < 6 && y > 1){
            x = 7;
        }
        else if (y==2 || y==5){
            if (x == 3){
                x--;
            }
            else if (x==6){
                x++;
            }
            else if (y == 2 && (x==4 || x == 5)){
                y++;
            }
            else if (y == 5 && (x==4 || x == 5)){
                y--;
            }
        }
        else if (x==2 || x==7){
            if (y==3){
                y--;
            }
            else if (y == 4){
                y++;
            }
            else if (x==2 && y==2){
                x++;
                y++;
            }
            else if (x==2 && y==5){
                x++;
                y--;
            }
            else if (x==5 && y==2){
                x--;
                y++;
            }
            else if (x==5 && y==5){
                x--;
                y--;
            }
        }
        else if (y==3 && x < 7 && x > 3) {
            x--;
        }
        else if (y==4 && x < 6 && x > 2) {
            x++;
        }
        else if (y==3 && x==3){
            y++;
        }
        else if (y==4 && x==6){
            y--;
        }
        return new int[]{x,y};
    }
}