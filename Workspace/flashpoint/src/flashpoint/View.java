package flashpoint;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class View {
    ArrayList<ImageView>IVs = new ArrayList<ImageView>();

    public void update(Speelveld speelveld, GridPane gridpane, int x, int y, int z) {

        switch(speelveld.getVakken()[x][y].checkRichting(z)) {
            case 0:
                try {
                    IVs.add(new ImageView(new Image("GFX/Muur.png")));
                    IVs.get(IVs.size()-1).setFitHeight(30);
                    IVs.get(IVs.size()-1).setFitWidth(30);
                    gridpane.add(IVs.get(IVs.size()-1),x,y);
                    break;
                } catch (IllegalArgumentException e) {
                }
            case 1:
                try {
                    IVs.add(new ImageView(new Image("GFX/Muur 1kapot.png")));
                    IVs.get(IVs.size()-1).setFitHeight(30);
                    IVs.get(IVs.size()-1).setFitWidth(30);
                    gridpane.add(IVs.get(IVs.size()-1),x,y);
                    break;
                } catch (IllegalArgumentException e) {
                }
            case 2:
                try {
                    IVs.add(new ImageView(new Image("GFX/Muur 2kapot.png")));
                    IVs.get(IVs.size()-1).setFitHeight(30);
                    IVs.get(IVs.size()-1).setFitWidth(30);
                    gridpane.add(IVs.get(IVs.size()-1),x,y);
                    break;
                } catch (IllegalArgumentException e) {
                }

            case 3:
                try {
                    IVs.add(new ImageView(new Image("GFX/DichteDeur.png")));
                    IVs.get(IVs.size()-1).setFitHeight(30);
                    IVs.get(IVs.size()-1).setFitWidth(30);
                    gridpane.add(IVs.get(IVs.size()-1),x,y);
                    break;
                } catch (IllegalArgumentException e) {
                }
            case 4:
                try {
                    IVs.add(new ImageView(new Image("GFX/OpenDeur.png")));
                    IVs.get(IVs.size()-1).setFitHeight(30);
                    IVs.get(IVs.size()-1).setFitWidth(30);
                    gridpane.add(IVs.get(IVs.size()-1),x,y);
                    break;
                } catch (IllegalArgumentException e) {
                }
        }
    }










}




