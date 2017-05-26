package flashpoint;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class View {

    int check;
    ImageView muur = new ImageView(new Image("GFX/Muur.png"));
    ImageView muur1kapot = new ImageView(new Image("GFX/Muur 1kapot.png"));
    ImageView muur2kapot = new ImageView(new Image("GFX/Muur 2kapot.png"));
    ImageView dichteDeur = new ImageView(new Image("GFX/DichteDeur.png"));
    ImageView openDeur = new ImageView(new Image("GFX/OpenDeur.png"));



    public void update(Speelveld speelveld, GridPane gridpane, int x, int y, int z) {

        switch(speelveld.getVakken()[x][y].checkRichting(z)) {
            case 0:
                try {
                    muur.setFitHeight(30);
                    muur.setFitWidth(30);
                    gridpane.add(muur,x,y);
                    break;
                } catch (IllegalArgumentException e) {
                }
            case 1:
                try {
                    muur1kapot.setFitHeight(30);
                    muur1kapot.setFitWidth(30);
                    gridpane.getChildren().add(muur1kapot);
                    break;
                } catch (IllegalArgumentException e) {
                }
            case 2:
                try {
                    muur2kapot.setFitHeight(30);
                    muur2kapot.setFitWidth(30);
                    gridpane.getChildren().add(muur2kapot);
                    break;
                } catch (IllegalArgumentException e) {
                }

            case 3:
                try {
                    dichteDeur.setFitHeight(30);
                    dichteDeur.setFitWidth(30);
                    gridpane.getChildren().add(dichteDeur);
                    break;
                } catch (IllegalArgumentException e) {
                }
            case 4:
                try {
                    openDeur.setFitHeight(30);
                    openDeur.setFitWidth(30);
                    gridpane.getChildren().add(openDeur);
                    break;
                } catch (IllegalArgumentException e) {
                }
        }
    }










}




