package flashpoint;

public class Bewegen {

    public Bewegen() {
    }
    public static void main(String[] args) {

    }
    public Vak[][] run(int richting, Speler speler, Vak[][]vakken) {
        int[]positie = vindSpeler(speler, vakken);
        vakken[positie[0]][positie[1]].removeSpeler(speler);
        switch (richting) {
            case 0: vakken[positie[0]][positie[1]+1].addSpeler(speler);
                break;
            case 1: vakken[positie[0]+1][positie[1]].addSpeler(speler);
                break;
            case 2: vakken[positie[0]][positie[1]-1].addSpeler(speler);
                break;
            case 3: vakken[positie[0]-1][positie[1]].addSpeler(speler);
                break;
        }
        return vakken;
	}

    public int[] vindSpeler(Speler speler, Vak[][]vakken) {
        int[] positie = new int[2];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (vakken[x][y].spelers.contains(speler)) {
                    positie[0] = x;
                    positie[1] = y;
                }
            }
        }
        return positie;
    }
}