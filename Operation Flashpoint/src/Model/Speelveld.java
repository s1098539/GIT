package Model;

import javafx.scene.layout.GridPane;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class Speelveld {
    FactoryVakken factoryVakken = new FactoryVakken();
    Vak [][] vakken = factoryVakken.getVakken();

    public Speelveld() {

    }

    public Vak[][] getVakken() {
        return vakken;
    }

    public void setVakken(Vak[][] vakken) {
        this.vakken = vakken;
    }
}
