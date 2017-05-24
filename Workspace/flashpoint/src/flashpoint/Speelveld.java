package flashpoint;

import java.util.ArrayList;

public class Speelveld {
    //test
    public Vak[][]vakken = new Vak[10][8];

    public Speelveld() {
        newVakken();
    }

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

}