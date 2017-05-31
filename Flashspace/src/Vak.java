package flashpoint;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


import java.util.ArrayList;

public class Vak {

	ArrayList<Object>objecten = new ArrayList<Object>();
    Deur[]deuren = new Deur[4];
    Muur[]muren = new Muur[4];
    ArrayList<Speler>spelers = new ArrayList<Speler>();

    public Vak() {
    }

    public Muur[] getMuren() {
        for (int i = 0; i<muren.length; i++) {
            System.out.println(muren[i]);
        }
        return muren;
    }

    public Muur getMuren(int richting) {
        return muren[richting];
    }

    public Deur[] getDeuren() {
        return deuren;
    }

    public void addSpeler(Speler speler) {
        spelers.add(speler);
    }

    public void removeSpeler(Speler speler) {
        spelers.remove(speler);
    }

    public void addMuur(int richting) {
        muren[richting] = new Muur();
    }

    public ImageView addDeur(int richting) {
        deuren[richting] = new Deur();
        ImageView x = new ImageView(new Image("GFX/DichteDeur.png"));
        x.setFitHeight(30);
        x.setFitWidth(30);
        return x;
    }

    public int checkRichting(int richting) {
        //return int betekend:
        //0=muur, 1=muur(1schade), 2=muur(2schade)
        //3=deur(gesloten), 4=deur(open), 5=null
        switch (richting) {
            case 0:
                try {
                    return muren[0].getStatus();
                }catch(NullPointerException e) {
                    try {
                        return deuren[0].getStatus();
                    } catch (NullPointerException el) {
                        return 5;
                    }
                }
            case 1:
                try {
                    return muren[1].getStatus();
                }catch(NullPointerException e) {
                    try {
                        return deuren[1].getStatus();
                    } catch (NullPointerException el) {
                        return 5;
                    }
                }
            case 2:
                try {
                    return muren[2].getStatus();
                }catch(NullPointerException e) {
                    try {
                        return deuren[2].getStatus();
                    } catch (NullPointerException el) {
                        return 5;
                    }
                }
            case 3:
                try {
                    return muren[3].getStatus();
                }catch(NullPointerException e) {
                    try {
                        return deuren[3].getStatus();
                    } catch (NullPointerException el) {
                        return 5;
                    }
                }
        }
        return 4;
    }


}