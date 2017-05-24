package flashpoint;

public class Bewegen {

    public Bewegen() {
    }

    public Vak[][] run(int richting, Vak[][]vakken, Speler speler, int x, int y) {


        switch (richting) {
            case 0: vakken[x][y].removeSpeler(speler);
            vakken[x][y+1].addSpeler(speler);
            break;
            case 1:

        }
        return vakken;
	}


	public Vak[][] veranderPositie(Vak[][]vakken,Speler speler, int x, int y) {
        vakken[x][y].removeSpeler(speler);

        return vakken;
    }

    public int[] vindSpeler(Vak[][]vakken) {
        int[]positie = new int [2];
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 8 ; y++) {
                if (vakken[x][y])
            }
        }



        return positie;
    }

}