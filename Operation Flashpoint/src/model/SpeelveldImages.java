package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class SpeelveldImages {

    public SpeelveldImages() {
    }

    private GridPane gridPane;
    private FlowPane[][]flowPanes = new FlowPane[10][8];
    private ImageView[][][]imageViews = new ImageView[10][8][9];
    private ImageView[]carViews = new ImageView[2];

    private Image BrandweerBlauw50pxActive = new Image("resources/gfx/Brandweerblauwselect.png");
    private Image BrandweerGeel50pxActive = new Image("resources/gfx/Brandweergeelselect.png");
    private Image BrandweerGroen50pxActive = new Image("resources/gfx/Brandweergroenselect.png");
    private Image BrandweerOranje50pxActive = new Image("resources/gfx/Brandweeroranjeselect.png");
    private Image BrandweerRood50pxActive = new Image("resources/gfx/Brandweerroodselect.png");
    private Image BrandweerZwart50pxActive = new Image("resources/gfx/Brandweerzwartselect.png");
    private Image brandBlusserSelect = new Image("resources/gfx/Brandblusserselect.png");
    private Image hakkenSelect = new Image("resources/gfx/Hakkenselect.png");
    private Image openenDeurSelect = new Image("resources/gfx/Openendeurselect.png");
    private Image pickIpSelect = new Image("resources/gfx/Pickupselect.png");
    private Image rijdenSelect = new Image("resources/gfx/Rijdenselect.png");
    private Image brandweerBlauw50px = new Image("resources/gfx/Brandweerblauw50px.png");
    private Image brandweerGeel50px = new Image("resources/gfx/Brandweergeel50px.png");
    private Image brandweerGroen50px = new Image("resources/gfx/Brandweergroen50px.png");
    private Image brandweerOranje50px = new Image("resources/gfx/Brandweeroranje50px.png");
    private Image brandweerRood50px = new Image("resources/gfx/Brandweerrood50px.png");
    private Image brandweerZwart50px = new Image("resources/gfx/Brandweerzwart50px.png");
    private Image pickup = new Image("resources/gfx/Pickup.png");
    private Image openenDeur = new Image("resources/gfx/Openendeur.png");
    private Image hakken = new Image("resources/gfx/Hakken.png");
    private Image brandBlusser = new Image("resources/gfx/Brandblusser.png");
    private Image rijden = new Image("resources/gfx/Rijden.png");
    private Image vraagteken = new Image("resources/gfx/Vraagteken.png",50,50,false,true);
    private Image empty = new Image("resources/gfx/Empty.png",20,20,false,true);
    private Image hotspot = new Image("resources/gfx/Hotspot.png",20,20,false,true);
    private Image persoon = new Image("resources/gfx/Vraagteken.png",20,20,false,true);
    private Image vlam = new Image("resources/gfx/Vlam.png");
    private Image rook = new Image("resources/gfx/Rook.png");
    private Image gevaarlijkeStof = new Image("resources/gfx/GevaarlijkeStof.png");
    private Image dichteDeurLinks = new Image("resources/gfx/DichteDeurLinks.png");
    private Image dichteDeurOnder = new Image("resources/gfx/DichteDeurOnder.png");
    private Image dichteDeurBoven = new Image("resources/gfx/DichteDeurBoven.png");
    private Image dichteDeurRechts = new Image("resources/gfx/DichteDeurRechts.png");
    private Image openDeurLinks = new Image("resources/gfx/OpenDeurLinks.png");
    private Image openDeurOnder = new Image("resources/gfx/OpenDeurOnder.png");
    private Image openDeurBoven = new Image("resources/gfx/OpenDeurBoven.png");
    private Image openDeurRechts = new Image("resources/gfx/OpenDeurRechts.png");
    private Image muurBoven = new Image("resources/gfx/MuurBoven.png");
    private Image muurLinks = new Image("resources/gfx/MuurLinks.png");
    private Image muurOnder = new Image("resources/gfx/MuurOnder.png");
    private Image muurRechts = new Image("resources/gfx/MuurRechts.png");
    private Image muur1kapotBoven = new Image("resources/gfx/Muur1kapotBoven.png");
    private Image muur1kapotLinks = new Image("resources/gfx/Muur1kapotLinks.png");
    private Image muur1kapotOnder = new Image("resources/gfx/Muur1kapotOnder.png");
    private Image muur1kapotRechts = new Image("resources/gfx/Muur1kapotRechts.png");
    private Image muur2kapotBoven = new Image("resources/gfx/Muur2kapotBoven.png");
    private Image muur2kapotLinks = new Image("resources/gfx/Muur2kapotLinks.png");
    private Image muur2kapotOnder = new Image("resources/gfx/Muur2kapotOnder.png");
    private Image muur2kapotRechts = new Image("resources/gfx/Muur2kapotRechts.png");
    private Image brandweerBlauw = new Image("resources/gfx/Brandweerblauw.png",20,20,false,true);
    private Image brandweerGeel = new Image("resources/gfx/Brandweergeel.png",20,20,false,true);
    private Image brandweerGroen = new Image("resources/gfx/Brandweergroen.png",20,20,false,true);
    private Image brandweerOranje = new Image("resources/gfx/Brandweeroranje.png",20,20,false,true);
    private Image brandweerRood = new Image("resources/gfx/Brandweerrood.png",20,20,false,true);
    private Image brandweerZwart = new Image("resources/gfx/Brandweerzwart.png",20,20,false,true);
    private Image oma = new Image("resources/gfx/Oma.png",20,20,false,true);
    private Image vis = new Image("resources/gfx/Vis.png",20,20,false,true);
    private Image egel = new Image("resources/gfx/Egel.png",20,20,false,true);
    private Image hond = new Image("resources/gfx/(zee)Hond.png",20,20,false,true);
    private Image snek = new Image("resources/gfx/Snek.png",20,20,false,true);
    private Image latifah = new Image("resources/gfx/Latifah.png",20,20,false,true);
    private Image roodhaar = new Image("resources/gfx/Roodhaar.png",20,20,false,true);
    private Image groenhaar = new Image("resources/gfx/Groenhaar.png",20,20,false,true);
    private Image obamanigua = new Image("resources/gfx/Obamanigua.png",20,20,false,true);
    private Image hipstersnor = new Image("resources/gfx/Hipstersnor.png",20,20,false,true);
    private Image medkit = new Image("resources/gfx/Medkit.png",20,20,false,true);
    private Image ambuBoven = new Image("resources/gfx/ambulanceLayerboven.png");
    private Image ambuLinks = new Image("resources/gfx/ambulanceLayerlinks.png");
    private Image ambuOnder = new Image("resources/gfx/ambulanceLayeronder.png");
    private Image ambuRechts = new Image("resources/gfx/ambulanceLayerrechts.png");
    private Image brandweerBoven = new Image("resources/gfx/brandweerlayerboven.png");
    private Image brandweerLinks = new Image("resources/gfx/brandweerlayerlinks.png");
    private Image brandweerOnder = new Image("resources/gfx/brandweerlayeronder.png");
    private Image brandweerRechts = new Image("resources/gfx/brandweerlayerrechts.png");

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public FlowPane[][] getFlowPanes() {
        return flowPanes;
    }

    public ImageView[][][] getImageViews() {
        return imageViews;
    }

    public ImageView[] getCarViews() {
        return carViews;
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

    public Image getMedkit() {
        return medkit;
    }

    public Image getAmbuBoven() {
        return ambuBoven;
    }

    public Image getAmbuLinks() {
        return ambuLinks;
    }

    public Image getAmbuOnder() {
        return ambuOnder;
    }

    public Image getAmbuRechts() {
        return ambuRechts;
    }

    public Image getBrandweerBoven() {
        return brandweerBoven;
    }

    public Image getBrandweerLinks() {
        return brandweerLinks;
    }

    public Image getBrandweerOnder() {
        return brandweerOnder;
    }

    public Image getBrandweerRechts() {
        return brandweerRechts;
    }

    public Image getVraagteken() {
        return vraagteken;
    }

    public Image getOpenenDeur() {
        return openenDeur;
    }

    public Image getHakken() {
        return hakken;
    }

    public Image getBrandBlusser() {
        return brandBlusser;
    }

    public Image getRijden() {
        return rijden;
    }

    public Image getPickup() {
        return pickup;
    }

    public Image getBrandweerBlauw50px() {
        return brandweerBlauw50px;
    }

    public Image getBrandweerGeel50px() {
        return brandweerGeel50px;
    }

    public Image getBrandweerGroen50px() {
        return brandweerGroen50px;
    }

    public Image getBrandweerOranje50px() {
        return brandweerOranje50px;
    }

    public Image getBrandweerRood50px() {
        return brandweerRood50px;
    }

    public Image getBrandweerZwart50px() {
        return brandweerZwart50px;
    }

    public Image getBrandBlusserSelect() {
        return brandBlusserSelect;
    }

    public Image getHakkenSelect() {
        return hakkenSelect;
    }

    public Image getOpenenDeurSelect() {
        return openenDeurSelect;
    }

    public Image getPickIpSelect() {
        return pickIpSelect;
    }

    public Image getRijdenSelect() {
        return rijdenSelect;
    }

    public Image getBrandweerBlauw50pxActive() {
        return BrandweerBlauw50pxActive;
    }

    public Image getBrandweerGeel50pxActive() {
        return BrandweerGeel50pxActive;
    }

    public Image getBrandweerGroen50pxActive() {
        return BrandweerGroen50pxActive;
    }

    public Image getBrandweerOranje50pxActive() {
        return BrandweerOranje50pxActive;
    }

    public Image getBrandweerRood50pxActive() {
        return BrandweerRood50pxActive;
    }

    public Image getBrandweerZwart50pxActive() {
        return BrandweerZwart50pxActive;
    }
}