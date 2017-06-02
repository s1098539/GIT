package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    private GridPane gridpane;

    FlowPane[][]fp = new FlowPane[10][8];
    Speelveld veld = new Speelveld();

    @FXML
    public void initialize() {
        System.out.println("test");
//        ImageView iv = new Object.Vuur().getImageView();
//        iv.setFitWidth(20);
//        iv.setFitHeight(20);
//        fp.getChildren().add(iv);

        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                fp[x][y] = new FlowPane();
                gridpane.add(fp[x][y],x,y);
            }
        }

        BeurtAfronding ba = new BeurtAfronding(veld);
        Speler speler = new Speler("Lion", Kleur.BLAUW, 4,3);

        veld.getVak(5,5).addObject(new Object.Vuur());
        veld.getVak(5,6).addObject(new Object.Rook());

            update();
    }

    public void update() {
        for(int x = 0; x <10; x++) {
            for (int y = 0; y < 8; y++) {
                for (int z = 0; z < 9; z++) {

                        try {
                            fp[x][y].getChildren().remove(z);
                        } catch (RuntimeException e) {}
                    try {
                        fp[x][y].getChildren().add(veld.getVak(x, y).getObjecten()[z].getImageView());
                    } catch (NullPointerException e) {}

                }
            }
        }
    }
}
