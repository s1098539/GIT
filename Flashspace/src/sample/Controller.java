package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {
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
    @FXML
    private Button btnEndTurn;

    public GridPane getGridpane() {
        return gridpane;
    }

    public void setGridpane(GridPane gridpane) {
        this.gridpane = gridpane;
    }

    Boolean hakken = false;
    Boolean deurinteractie = false;
    Boolean brandblusser = false;

    //
//    private FlowPane[][]fp = new FlowPane[10][8];
//    private Speelveld veld = new Speelveld();
//    ImageView[]ivarray = new ImageView[720];
//    private View view = new View(fp,veld);
//    private BeurtAfronding ba = new BeurtAfronding(veld);
////    private Object.Speler speler = new Object.Speler("Lion", Kleur.ZWART, 4,3);
////    SpelerActie sa = new SpelerActie(speler, veld);
//    private Boolean hakken = false;
//    private Boolean openendeur;
//
    @FXML
    public void initialize() {
        Speelveld veld = new Speelveld();
/*        for(int x = 0; x<10; x++) {
            for(int y = 0; y<8; y++) {
                veld.getVak(x,y).vuurPlaats(Fiche.ROOK);
                veld.getVak(x,y).setHotspot(true);
                veld.getVak(x,y).setPersoon(true);
                veld.getVak(x,y).setStoffen(true);*/
//                veld.getVak(x,y).setBoven(Status.LEEG);
//                veld.getVak(x,y).setOnder(Status.LEEG);
//                veld.getVak(x,y).setLinks(Status.LEEG);
//                veld.getVak(x,y).setRechts(Status.LEEG);
            //}
       // }

        View view = new View();
        Speler speler = new Speler("Joep", Kleur.GROEN, 2,7, veld);
        Spel ba = new Spel(veld, 6);
        view.imageViewsFactory();
        System.out.println("hoi");
        view.flowPanesFactory();
        int teller = 0;
        for(int y = 0; y<8; y++) {
            for(int x = 0; x<10; x++) {
                gridpane.add(view.getFlowPanes()[teller],x,y);
                teller++;
            }
        }
        veld.getVak(5,5).setHotspot(true);
        veld.setMuren();
        veld.getVak(3,3).vuurPlaats(Fiche.VUUR);
        view.imageSetter(veld, speler);



////        veld.getVak(speler.getX(),speler.getY()).addObject(speler);
//
//
//        System.out.println("test");
//        for(int x = 0; x <10; x++) {
//            for (int y = 0; y < 8; y++) {
//                fp[x][y] = new FlowPane();
//                gridpane.add(fp[x][y],x,y);
//            }
//        }
//        veld.setMuren();
//
//
//
////        for(int c=1; c<9; c++){
////            veld.getVakken()[c][2].setObstakel(0,1);
////        }
////
////        for(int x = 0; x <10; x++) {
////            for (int y = 0; y < 8; y++) {
////                veld.getVak(x, y).addObject(new Object.Vuur());
////            }
////        }
////
////        for(int x = 0; x <10; x++) {
////            for (int y = 0; y < 8; y++) {
////                veld.getVak(x, y).addObject(new Object.BrandHaard());
////            }
////        }
////
////        for(int x = 0; x <10; x++) {
////            for (int y = 0; y < 8; y++) {
////                veld.getVak(x, y).addObject(new Object.PersoonVanAandacht());
////            }
////        }
////
//
////        veld.getVak(2,2).addObject(new Object.GevaarlijkeStof());
//
//
//
//
//
//
//        //Vonko naar boven test (linker verticale lijn)
////        veld.getVak(9, 7).addObject(new Object.GevaarlijkeStof());
////        veld.getVak(3, 0).addObject(new Object.Rook());
////        veld.getVak(3, 1).addObject(new Object.Rook());
////        veld.getVak(3, 2).addObject(new Object.Rook());
////        veld.getVak(3,3).addObject(new Object.Rook());
////        veld.getVak(3, 4).addObject(new Object.Rook());
////        veld.getVak(3, 5).addObject(new Object.Vuur());
////
////        //Vonko naar beneden test (rechter verticale lijn)
////        veld.getVak(5, 0).addObject(new Object.Vuur());
////        veld.getVak(5, 1).addObject(new Object.Rook());
////        veld.getVak(5, 2).addObject(new Object.Rook());
////        veld.getVak(5,3).addObject(new Object.Rook());
////        veld.getVak(5, 4).addObject(new Object.Rook());
////        veld.getVak(5, 5).addObject(new Object.Rook());
////
////        //Vonko naar links test (linker horizontale lijn)
////        veld.getVak(0, 7).addObject(new Object.Rook());
////        veld.getVak(1, 7).addObject(new Object.Rook());
////        veld.getVak(2, 7).addObject(new Object.Rook());
////        veld.getVak(3, 7).addObject(new Object.Rook());
////        veld.getVak(4, 7).addObject(new Object.Vuur());
////
////        //Vonka naar rechts test (rechter horizontale lijn)
////        veld.getVak(6, 7).addObject(new Object.Vuur());
////        veld.getVak(7, 7).addObject(new Object.Rook());
////        veld.getVak(8, 7).addObject(new Object.Rook());
////        veld.getVak(9, 7).addObject(new Object.Rook());
//
//
//
//        // ba.handleVonkoverslag();
//        // ba.newRook();
//        view.update();
//        Vak vak = new Vak();
//        vak.setBoven(Vak.Status.MUUR1);
//        System.out.println(vak.getBoven());
//
        btnUP.setOnAction(event -> {
            if(hakken) {
                speler.muurInteractie(Richting.BOVEN);
            }else if(deurinteractie){
                speler.deurInteractie(Richting.BOVEN);
            }else if(brandblusser){
                speler.blusActie(Richting.BOVEN);
            } else {
                speler.beweegwActie(Richting.BOVEN);
            }
            view.imageSetter(veld,speler);
        });

        btnLEFT.setOnAction(event -> {
            if(hakken) {
                speler.muurInteractie(Richting.LINKS);
            }else if(deurinteractie){
                speler.deurInteractie(Richting.LINKS);
            }else if(brandblusser){
                speler.blusActie(Richting.LINKS);
            } else {
                speler.beweegwActie(Richting.LINKS);
            }
            view.imageSetter(veld,speler);
        });

        btnRIGHT.setOnAction(event -> {
            if(hakken) {
                speler.muurInteractie(Richting.RECHTS);
            }else if(deurinteractie){
                speler.deurInteractie(Richting.RECHTS);
            }else if(brandblusser){
                speler.blusActie(Richting.RECHTS);
            } else {
                speler.beweegwActie(Richting.RECHTS);
            }
            view.imageSetter(veld,speler);
        });

        btnDOWN.setOnAction(event -> {
            if(hakken) {
                speler.muurInteractie(Richting.ONDER);
            }else if(deurinteractie){
                speler.deurInteractie(Richting.ONDER);
            }else if(brandblusser){
                speler.blusActie(Richting.ONDER);
            } else {
                speler.beweegwActie(Richting.ONDER);
            }
            view.imageSetter(veld,speler);
        });

        imgHakken.setOnMouseClicked(event -> {
            if(hakken) {
                hakken = false;
            } else {
                hakken = true;
                deurinteractie = false;
                brandblusser = false;
            }
            System.out.println(hakken);
        });

        imgOpenendeur.setOnMouseClicked(event -> {
            if(deurinteractie) {
                deurinteractie = false;
            } else {
                hakken = false;
                deurinteractie = true;
                brandblusser = false;
            }
            System.out.println(deurinteractie);
        });

        imgBrandblusser.setOnMouseClicked(event -> {
            if(brandblusser) {
                brandblusser = false;
            } else {
                hakken = false;
                deurinteractie = false;
                brandblusser = true;
            }
            System.out.println(deurinteractie);
        });

        btnSpecial.setOnAction(event -> {
//            for (int vaak = 0; vaak < 3; vaak++) {
//
//                ba.nieuwRook();
//                ba.hanteerVonkoverslag();
//                ba.hanteerStoffen();
//                view.imageSetter(veld,speler);
//            }
            ba.nieuwRook();
            ba.hanteerVonkoverslag();
            ba.hanteerStoffen();
            view.imageSetter(veld,speler);
        });
        btnEndTurn.setOnAction(event -> {
            ba.nieuwPersoon();
            view.imageSetter(veld,speler);
        });



    }
}
