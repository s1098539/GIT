package flashpoint;


import javafx.scene.layout.GridPane;

public class Speelveld {

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

    public void addSpeler(Speler speler, GridPane gridPane) {
        vakken[speler.getLocatieX()][speler.getLocatieY()].addSpeler(speler);
        gridPane.add(speler.getImageView(),speler.getLocatieX(),speler.getLocatieY());
    }

    public void removeSpeler(Speler speler, GridPane gridPane) {
        vakken[speler.getLocatieX()][speler.getLocatieY()].removeSpeler(speler);
        gridPane.getChildren().remove(speler.getImageView());
    }

}