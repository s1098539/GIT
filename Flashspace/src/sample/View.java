package sample;
;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class View{
    @FXML
    private GridPane gridpane;
    @FXML
    private Button btnUP;
    @FXML
    private Button btnLEFT;
    @FXML
    private Button btnRIGHT;
    @FXML
    private Button btnDOWN;
    @FXML
    private ImageView imgHakken;
    @FXML
    private ImageView imgOpenendeur;
    @FXML
    private ImageView imgBrandblusser;
    @FXML
    private Button btnSpecial;

    FlowPane[]flowPanes = new FlowPane[80];
    ImageView[]imageViews = new ImageView[720];
    Speelveld veld = new Speelveld();
    Speler speler2 = new Speler("Norddin",Kleur.ORANJE,3,4,veld);

    public View() {
//        imageViewsFactory();
//        flowPanesFactory();
    }

    public void initialize() {
//        imageSetter(veld,speler2);
//        addListener(new Listener());
    }

    public void addListener(EventHandler<ActionEvent> listenForbtnUP) {
        System.out.println("I got to this part1");
        btnUP.setOnAction(listenForbtnUP);
        System.out.println("I got to this part2");
    }

//    public class Listener implements EventHandler<ActionEvent> {
//        @Override
//        public void handle(ActionEvent event) {
//            System.out.println("It works1");
//        }
//    }




    Image empty = new Image("sample/gfx/Empty.png", 20, 20, false, true);
    Image hotspot = new Image("sample/gfx/Hotspot.png", 20, 20, false, true);
    Image persoon = new Image("sample/gfx/Vraagteken.png", 20, 20, false, true);
    Image vlam = new Image("sample/gfx/Vlam.png", 20, 20, false, true);
    Image rook = new Image("sample/gfx/Rook.png", 20, 20, false, true);
    Image gevaarlijkeStof = new Image("sample/gfx/GevaarlijkeStof.png", 20, 20, false, true);
    Image dichteDeurLinks = new Image("sample/gfx/DichteDeurLinks.png", 20, 20, false, true);
    Image dichteDeurOnder = new Image("sample/gfx/DichteDeurOnder.png", 20, 20, false, true);
    Image dichteDeurBoven = new Image("sample/gfx/DichteDeurBoven.png", 20, 20, false, true);
    Image dichteDeurRechts = new Image("sample/gfx/DichteDeurRechts.png", 20, 20, false, true);
    Image openDeurLinks = new Image("sample/gfx/OpenDeurLinks.png", 20, 20, false, true);
    Image openDeurOnder = new Image("sample/gfx/OpenDeurOnder.png", 20, 20, false, true);
    Image openDeurBoven = new Image("sample/gfx/OpenDeurBoven.png", 20, 20, false, true);
    Image openDeurRechts = new Image("sample/gfx/OpenDeurRechts.png", 20, 20, false, true);
    Image muurBoven = new Image("sample/gfx/MuurBoven.png", 20, 20, false, true);
    Image muurLinks = new Image("sample/gfx/MuurLinks.png", 20, 20, false, true);
    Image muurOnder = new Image("sample/gfx/MuurOnder.png", 20, 20, false, true);
    Image muurRechts = new Image("sample/gfx/MuurRechts.png", 20, 20, false, true);
    Image muur1kapotBoven = new Image("sample/gfx/Muur1kapotBoven.png", 20, 20, false, true);
    Image muur1kapotLinks = new Image("sample/gfx/Muur1kapotLinks.png", 20, 20, false, true);
    Image muur1kapotOnder = new Image("sample/gfx/Muur1kapotOnder.png", 20, 20, false, true);
    Image muur1kapotRechts = new Image("sample/gfx/Muur1kapotRechts.png", 20, 20, false, true);
    Image muur2kapotBoven = new Image("sample/gfx/Muur2kapotBoven.png", 20, 20, false, true);
    Image muur2kapotLinks = new Image("sample/gfx/Muur2kapotLinks.png", 20, 20, false, true);
    Image muur2kapotOnder = new Image("sample/gfx/Muur2kapotOnder.png", 20, 20, false, true);
    Image muur2kapotRechts = new Image("sample/gfx/Muur2kapotRechts.png", 20, 20, false, true);
    Image brandweerBlauw = new Image("sample/gfx/Brandweerblauw.png", 20, 20, false, true);
    Image brandweerGeel = new Image("sample/gfx/Brandweergeel.png", 20, 20, false, true);
    Image brandweerGroen = new Image("sample/gfx/Brandweergroen.png", 20, 20, false, true);
    Image brandweerOranje = new Image("sample/gfx/Brandweeroranje.png", 20, 20, false, true);
    Image brandweerRood = new Image("sample/gfx/Brandweerrood.png", 20, 20, false, true);
    Image brandweerZwart = new Image("sample/gfx/Brandweerzwart.png", 20, 20, false, true);

    void imageViewsFactory() {
        for(int i = 0; i<720; i++) {
            imageViews[i] = new ImageView();
        }
    }

    public FlowPane[] getFlowPanes() {
        return flowPanes;
    }

    public void flowPanesFactory() {
        int u = 0;
        for(int i = 0; i<80; i++) {
            flowPanes[i] = new FlowPane();
            for (int q = 0; q<9; q++) {
                flowPanes[i].getChildren().add(imageViews[u]);
                u++;
            }
        }
    }

    public void imageSetter(Speelveld veld, Speler speler) {
        int q = 0;
        for(int y = 0; y<8; y++) {
            for (int x = 0; x < 10; x++) {

                //Hotspot
                if(veld.getVak(x,y).isHotspot()) {
                    imageViews[q].setImage(hotspot);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;

                //Obstakel boven

                switch (veld.getVak(x,y).boven) {
                    case MUUR: imageViews[q].setImage(muurOnder);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotOnder);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotOnder);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurOnder);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurOnder);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }
                q++;

                //Persoon!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Deze wordt denk ik anders maar voor nu werkt die ff goed genoeg
                if(veld.getVak(x,y).isPersoon()) {
                    imageViews[q].setImage(persoon);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;

                //Obstakel links!

                switch (veld.getVak(x,y).links) {
                    case MUUR: imageViews[q].setImage(muurRechts);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotRechts);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotRechts);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurRechts);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurRechts);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }

                q++;

                //Spelers
                if(speler.getX()==x && speler.getY()==y) {
                    switch(speler.getKleur()) {
                        case GEEL: imageViews[q].setImage(brandweerGeel);
                            break;
                        case ROOD: imageViews[q].setImage(brandweerRood);
                            break;
                        case BLAUW: imageViews[q].setImage(brandweerBlauw);
                            break;
                        case GROEN: imageViews[q].setImage(brandweerGroen);
                            break;
                        case ZWART: imageViews[q].setImage(brandweerZwart);
                            break;
                        case ORANJE: imageViews[q].setImage(brandweerOranje);
                            break;
                        default:
                            System.out.println("How did this even happen :|");
                            break;
                    }
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;

                //Obstakel rechts
                switch (veld.getVak(x,y).rechts) {
                    case MUUR: imageViews[q].setImage(muurLinks);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotLinks);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotLinks);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurLinks);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurLinks);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }

                q++;

                //Vuur plaats
                if(veld.getVak(x,y).isVuur()) {
                   imageViews[q].setImage(vlam);
                } else if(veld.getVak(x,y).isRook()) {
                    imageViews[q].setImage(rook);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;

                //Obstakel onder
                switch (veld.getVak(x,y).onder) {
                    case MUUR: imageViews[q].setImage(muurBoven);
                        break;
                    case MUUR1: imageViews[q].setImage(muur1kapotBoven);
                        break;
                    case MUUR2: imageViews[q].setImage(muur2kapotBoven);
                        break;
                    case DEURO: imageViews[q].setImage(openDeurBoven);
                        break;
                    case DEURD: imageViews[q].setImage(dichteDeurBoven);
                        break;
                    case LEEG: imageViews[q].setImage(empty);
                        break;
                }
                q++;

                //Stoffen
                if(veld.getVak(x,y).isStoffen()) {
                    imageViews[q].setImage(gevaarlijkeStof);
                } else {
                    imageViews[q].setImage(empty);
                }
                q++;
            }
        }
    }
}
