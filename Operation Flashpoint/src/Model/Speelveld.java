package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Speelveld {
    Vak [][] vakken;
    GridPane gridPane;

    FlowPane[][]flowPanes = new FlowPane[10][8];
    ImageView[][][]imageViews = new ImageView[10][8][9];

    Image empty = new Image("Resources/GFX/Empty.png",20,20,false,true);
    Image hotspot = new Image("Resources/GFX/Hotspot.png",20,20,false,true);
    Image persoon = new Image("Resources/GFX/Vraagteken.png",20,20,false,true);
    Image vlam = new Image("Resources/GFX/Vlam.png");
    Image rook = new Image("Resources/GFX/Rook.png");
    Image gevaarlijkeStof = new Image("Resources/GFX/GevaarlijkeStof.png");
    Image dichteDeurLinks = new Image("Resources/GFX/DichteDeurLinks.png");
    Image dichteDeurOnder = new Image("Resources/GFX/DichteDeurOnder.png");
    Image dichteDeurBoven = new Image("Resources/GFX/DichteDeurBoven.png");
    Image dichteDeurRechts = new Image("Resources/GFX/DichteDeurRechts.png");
    Image openDeurLinks = new Image("Resources/GFX/OpenDeurLinks.png");
    Image openDeurOnder = new Image("Resources/GFX/OpenDeurOnder.png");
    Image openDeurBoven = new Image("Resources/GFX/OpenDeurBoven.png");
    Image openDeurRechts = new Image("Resources/GFX/OpenDeurRechts.png");
    Image muurBoven = new Image("Resources/GFX/MuurBoven.png");
    Image muurLinks = new Image("Resources/GFX/MuurLinks.png");
    Image muurOnder = new Image("Resources/GFX/MuurOnder.png");
    Image muurRechts = new Image("Resources/GFX/MuurRechts.png");
    Image muur1kapotBoven = new Image("Resources/GFX/Muur1kapotBoven.png");
    Image muur1kapotLinks = new Image("Resources/GFX/Muur1kapotLinks.png");
    Image muur1kapotOnder = new Image("Resources/GFX/Muur1kapotOnder.png");
    Image muur1kapotRechts = new Image("Resources/GFX/Muur1kapotRechts.png");
    Image muur2kapotBoven = new Image("Resources/GFX/Muur2kapotBoven.png");
    Image muur2kapotLinks = new Image("Resources/GFX/Muur2kapotLinks.png");
    Image muur2kapotOnder = new Image("Resources/GFX/Muur2kapotOnder.png");
    Image muur2kapotRechts = new Image("Resources/GFX/Muur2kapotRechts.png");
    Image brandweerBlauw = new Image("Resources/GFX/Brandweerblauw.png",20,20,false,true);
    Image brandweerGeel = new Image("Resources/GFX/Brandweergeel.png",20,20,false,true);
    Image brandweerGroen = new Image("Resources/GFX/Brandweergroen.png",20,20,false,true);
    Image brandweerOranje = new Image("Resources/GFX/Brandweeroranje.png",20,20,false,true);
    Image brandweerRood = new Image("Resources/GFX/Brandweerrood.png",20,20,false,true);
    Image brandweerZwart = new Image("Resources/GFX/Brandweerzwart.png",20,20,false,true);
    Image oma = new Image("Resources/GFX/Oma.png",20,20,false,true);
    Image vis = new Image("Resources/GFX/Vis.png",20,20,false,true);
    Image egel = new Image("Resources/GFX/Egel.png",20,20,false,true);
    Image hond = new Image("Resources/GFX/(zee)Hond.png",20,20,false,true);
    Image snek = new Image("Resources/GFX/Snek.png",20,20,false,true);
    Image latifah = new Image("Resources/GFX/Latifah.png",20,20,false,true);
    Image roodhaar = new Image("Resources/GFX/Roodhaar.png",20,20,false,true);
    Image groenhaar = new Image("Resources/GFX/Groenhaar.png",20,20,false,true);
    Image obamanigua = new Image("Resources/GFX/Obamanigua.png",20,20,false,true);
    Image hipstersnor = new Image("Resources/GFX/Hipstersnor.png",20,20,false,true);

    public FlowPane[][] getFlowPanes() {
        return flowPanes;
    }

    public ImageView[][][] getImageViews() {
        return imageViews;
    }

    public Image getEmpty() {
        return empty;
    }

    public Image getHotspot() {
        return hotspot;
    }

    public Image getPersoon() {
        return persoon;
    }

    public Image getVlam() {
        return vlam;
    }

    public Image getRook() {
        return rook;
    }

    public Image getGevaarlijkeStof() {
        return gevaarlijkeStof;
    }

    public Image getDichteDeurLinks() {
        return dichteDeurLinks;
    }

    public Image getDichteDeurOnder() {
        return dichteDeurOnder;
    }

    public Image getDichteDeurBoven() {
        return dichteDeurBoven;
    }

    public Image getDichteDeurRechts() {
        return dichteDeurRechts;
    }

    public Image getOpenDeurLinks() {
        return openDeurLinks;
    }

    public Image getOpenDeurOnder() {
        return openDeurOnder;
    }

    public Image getOpenDeurBoven() {
        return openDeurBoven;
    }

    public Image getOpenDeurRechts() {
        return openDeurRechts;
    }

    public Image getMuurBoven() {
        return muurBoven;
    }

    public Image getMuurLinks() {
        return muurLinks;
    }

    public Image getMuurOnder() {
        return muurOnder;
    }

    public Image getMuurRechts() {
        return muurRechts;
    }

    public Image getMuur1kapotBoven() {
        return muur1kapotBoven;
    }

    public Image getMuur1kapotLinks() {
        return muur1kapotLinks;
    }

    public Image getMuur1kapotOnder() {
        return muur1kapotOnder;
    }

    public Image getMuur1kapotRechts() {
        return muur1kapotRechts;
    }

    public Image getMuur2kapotBoven() {
        return muur2kapotBoven;
    }

    public Image getMuur2kapotLinks() {
        return muur2kapotLinks;
    }

    public Image getMuur2kapotOnder() {
        return muur2kapotOnder;
    }

    public Image getMuur2kapotRechts() {
        return muur2kapotRechts;
    }

    public Image getBrandweerBlauw() {
        return brandweerBlauw;
    }

    public Image getBrandweerGeel() {
        return brandweerGeel;
    }

    public Image getBrandweerGroen() {
        return brandweerGroen;
    }

    public Image getBrandweerOranje() {
        return brandweerOranje;
    }

    public Image getBrandweerRood() {
        return brandweerRood;
    }

    public Image getBrandweerZwart() {
        return brandweerZwart;
    }

    public Image getOma() {
        return oma;
    }

    public Image getVis() {
        return vis;
    }

    public Image getEgel() {
        return egel;
    }

    public Image getHond() {
        return hond;
    }

    public Image getSnek() {
        return snek;
    }

    public Image getLatifah() {
        return latifah;
    }

    public Image getRoodhaar() {
        return roodhaar;
    }

    public Image getGroenhaar() {
        return groenhaar;
    }

    public Image getObamanigua() {
        return obamanigua;
    }

    public Image getHipstersnor() {
        return hipstersnor;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public Speelveld() {

    }

    public void print() {
        System.out.println("SPEELVELD");
    }

    public Vak[][] getVakken() {
        return vakken;
    }

    public void setVakken(Vak[][] vakken) {
        this.vakken = vakken;
    }
}
