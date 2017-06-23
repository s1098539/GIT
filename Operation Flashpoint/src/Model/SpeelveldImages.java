package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class SpeelveldImages {

    public SpeelveldImages() {
    }

    GridPane gridPane;
    FlowPane[][]flowPanes = new FlowPane[10][8];
    ImageView[][][]imageViews = new ImageView[10][8][9];
    ImageView[]carViews = new ImageView[2];

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
    Image medkit = new Image("Resources/GFX/Medkit.png",20,20,false,true);
    Image ambuBoven = new Image("Resources/GFX/ambulanceLayerboven.png");
    Image ambuLinks = new Image("Resources/GFX/ambulanceLayerlinks.png");
    Image ambuOnder = new Image("Resources/GFX/ambulanceLayeronder.png");
    Image ambuRechts = new Image("Resources/GFX/ambulanceLayerrechts.png");
    Image brandweerBoven = new Image("Resources/GFX/brandweerlayerboven.png");
    Image brandweerLinks = new Image("Resources/GFX/brandweerlayerlinks.png");
    Image brandweerOnder = new Image("Resources/GFX/brandweerlayeronder.png");
    Image brandweerRechts = new Image("Resources/GFX/brandweerlayerrechts.png");

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public FlowPane[][] getFlowPanes() {
        return flowPanes;
    }

    public void setFlowPanes(FlowPane[][] flowPanes) {
        this.flowPanes = flowPanes;
    }

    public ImageView[][][] getImageViews() {
        return imageViews;
    }

    public void setImageViews(ImageView[][][] imageViews) {
        this.imageViews = imageViews;
    }

    public ImageView[] getCarViews() {
        return carViews;
    }

    public void setCarViews(ImageView[] carViews) {
        this.carViews = carViews;
    }

    public Image getEmpty() {
        return empty;
    }

    public void setEmpty(Image empty) {
        this.empty = empty;
    }

    public Image getHotspot() {
        return hotspot;
    }

    public void setHotspot(Image hotspot) {
        this.hotspot = hotspot;
    }

    public Image getPersoon() {
        return persoon;
    }

    public void setPersoon(Image persoon) {
        this.persoon = persoon;
    }

    public Image getVlam() {
        return vlam;
    }

    public void setVlam(Image vlam) {
        this.vlam = vlam;
    }

    public Image getRook() {
        return rook;
    }

    public void setRook(Image rook) {
        this.rook = rook;
    }

    public Image getGevaarlijkeStof() {
        return gevaarlijkeStof;
    }

    public void setGevaarlijkeStof(Image gevaarlijkeStof) {
        this.gevaarlijkeStof = gevaarlijkeStof;
    }

    public Image getDichteDeurLinks() {
        return dichteDeurLinks;
    }

    public void setDichteDeurLinks(Image dichteDeurLinks) {
        this.dichteDeurLinks = dichteDeurLinks;
    }

    public Image getDichteDeurOnder() {
        return dichteDeurOnder;
    }

    public void setDichteDeurOnder(Image dichteDeurOnder) {
        this.dichteDeurOnder = dichteDeurOnder;
    }

    public Image getDichteDeurBoven() {
        return dichteDeurBoven;
    }

    public void setDichteDeurBoven(Image dichteDeurBoven) {
        this.dichteDeurBoven = dichteDeurBoven;
    }

    public Image getDichteDeurRechts() {
        return dichteDeurRechts;
    }

    public void setDichteDeurRechts(Image dichteDeurRechts) {
        this.dichteDeurRechts = dichteDeurRechts;
    }

    public Image getOpenDeurLinks() {
        return openDeurLinks;
    }

    public void setOpenDeurLinks(Image openDeurLinks) {
        this.openDeurLinks = openDeurLinks;
    }

    public Image getOpenDeurOnder() {
        return openDeurOnder;
    }

    public void setOpenDeurOnder(Image openDeurOnder) {
        this.openDeurOnder = openDeurOnder;
    }

    public Image getOpenDeurBoven() {
        return openDeurBoven;
    }

    public void setOpenDeurBoven(Image openDeurBoven) {
        this.openDeurBoven = openDeurBoven;
    }

    public Image getOpenDeurRechts() {
        return openDeurRechts;
    }

    public void setOpenDeurRechts(Image openDeurRechts) {
        this.openDeurRechts = openDeurRechts;
    }

    public Image getMuurBoven() {
        return muurBoven;
    }

    public void setMuurBoven(Image muurBoven) {
        this.muurBoven = muurBoven;
    }

    public Image getMuurLinks() {
        return muurLinks;
    }

    public void setMuurLinks(Image muurLinks) {
        this.muurLinks = muurLinks;
    }

    public Image getMuurOnder() {
        return muurOnder;
    }

    public void setMuurOnder(Image muurOnder) {
        this.muurOnder = muurOnder;
    }

    public Image getMuurRechts() {
        return muurRechts;
    }

    public void setMuurRechts(Image muurRechts) {
        this.muurRechts = muurRechts;
    }

    public Image getMuur1kapotBoven() {
        return muur1kapotBoven;
    }

    public void setMuur1kapotBoven(Image muur1kapotBoven) {
        this.muur1kapotBoven = muur1kapotBoven;
    }

    public Image getMuur1kapotLinks() {
        return muur1kapotLinks;
    }

    public void setMuur1kapotLinks(Image muur1kapotLinks) {
        this.muur1kapotLinks = muur1kapotLinks;
    }

    public Image getMuur1kapotOnder() {
        return muur1kapotOnder;
    }

    public void setMuur1kapotOnder(Image muur1kapotOnder) {
        this.muur1kapotOnder = muur1kapotOnder;
    }

    public Image getMuur1kapotRechts() {
        return muur1kapotRechts;
    }

    public void setMuur1kapotRechts(Image muur1kapotRechts) {
        this.muur1kapotRechts = muur1kapotRechts;
    }

    public Image getMuur2kapotBoven() {
        return muur2kapotBoven;
    }

    public void setMuur2kapotBoven(Image muur2kapotBoven) {
        this.muur2kapotBoven = muur2kapotBoven;
    }

    public Image getMuur2kapotLinks() {
        return muur2kapotLinks;
    }

    public void setMuur2kapotLinks(Image muur2kapotLinks) {
        this.muur2kapotLinks = muur2kapotLinks;
    }

    public Image getMuur2kapotOnder() {
        return muur2kapotOnder;
    }

    public void setMuur2kapotOnder(Image muur2kapotOnder) {
        this.muur2kapotOnder = muur2kapotOnder;
    }

    public Image getMuur2kapotRechts() {
        return muur2kapotRechts;
    }

    public void setMuur2kapotRechts(Image muur2kapotRechts) {
        this.muur2kapotRechts = muur2kapotRechts;
    }

    public Image getBrandweerBlauw() {
        return brandweerBlauw;
    }

    public void setBrandweerBlauw(Image brandweerBlauw) {
        this.brandweerBlauw = brandweerBlauw;
    }

    public Image getBrandweerGeel() {
        return brandweerGeel;
    }

    public void setBrandweerGeel(Image brandweerGeel) {
        this.brandweerGeel = brandweerGeel;
    }

    public Image getBrandweerGroen() {
        return brandweerGroen;
    }

    public void setBrandweerGroen(Image brandweerGroen) {
        this.brandweerGroen = brandweerGroen;
    }

    public Image getBrandweerOranje() {
        return brandweerOranje;
    }

    public void setBrandweerOranje(Image brandweerOranje) {
        this.brandweerOranje = brandweerOranje;
    }

    public Image getBrandweerRood() {
        return brandweerRood;
    }

    public void setBrandweerRood(Image brandweerRood) {
        this.brandweerRood = brandweerRood;
    }

    public Image getBrandweerZwart() {
        return brandweerZwart;
    }

    public void setBrandweerZwart(Image brandweerZwart) {
        this.brandweerZwart = brandweerZwart;
    }

    public Image getOma() {
        return oma;
    }

    public void setOma(Image oma) {
        this.oma = oma;
    }

    public Image getVis() {
        return vis;
    }

    public void setVis(Image vis) {
        this.vis = vis;
    }

    public Image getEgel() {
        return egel;
    }

    public void setEgel(Image egel) {
        this.egel = egel;
    }

    public Image getHond() {
        return hond;
    }

    public void setHond(Image hond) {
        this.hond = hond;
    }

    public Image getSnek() {
        return snek;
    }

    public void setSnek(Image snek) {
        this.snek = snek;
    }

    public Image getLatifah() {
        return latifah;
    }

    public void setLatifah(Image latifah) {
        this.latifah = latifah;
    }

    public Image getRoodhaar() {
        return roodhaar;
    }

    public void setRoodhaar(Image roodhaar) {
        this.roodhaar = roodhaar;
    }

    public Image getGroenhaar() {
        return groenhaar;
    }

    public void setGroenhaar(Image groenhaar) {
        this.groenhaar = groenhaar;
    }

    public Image getObamanigua() {
        return obamanigua;
    }

    public void setObamanigua(Image obamanigua) {
        this.obamanigua = obamanigua;
    }

    public Image getHipstersnor() {
        return hipstersnor;
    }

    public void setHipstersnor(Image hipstersnor) {
        this.hipstersnor = hipstersnor;
    }

    public Image getMedkit() {
        return medkit;
    }

    public void setMedkit(Image medkit) {
        this.medkit = medkit;
    }

    public Image getAmbuBoven() {
        return ambuBoven;
    }

    public void setAmbuBoven(Image ambuBoven) {
        this.ambuBoven = ambuBoven;
    }

    public Image getAmbuLinks() {
        return ambuLinks;
    }

    public void setAmbuLinks(Image ambuLinks) {
        this.ambuLinks = ambuLinks;
    }

    public Image getAmbuOnder() {
        return ambuOnder;
    }

    public void setAmbuOnder(Image ambuOnder) {
        this.ambuOnder = ambuOnder;
    }

    public Image getAmbuRechts() {
        return ambuRechts;
    }

    public void setAmbuRechts(Image ambuRechts) {
        this.ambuRechts = ambuRechts;
    }

    public Image getBrandweerBoven() {
        return brandweerBoven;
    }

    public void setBrandweerBoven(Image brandweerBoven) {
        this.brandweerBoven = brandweerBoven;
    }

    public Image getBrandweerLinks() {
        return brandweerLinks;
    }

    public void setBrandweerLinks(Image brandweerLinks) {
        this.brandweerLinks = brandweerLinks;
    }

    public Image getBrandweerOnder() {
        return brandweerOnder;
    }

    public void setBrandweerOnder(Image brandweerOnder) {
        this.brandweerOnder = brandweerOnder;
    }

    public Image getBrandweerRechts() {
        return brandweerRechts;
    }

    public void setBrandweerRechts(Image brandweerRechts) {
        this.brandweerRechts = brandweerRechts;
    }
}