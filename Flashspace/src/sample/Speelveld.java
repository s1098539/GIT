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
}