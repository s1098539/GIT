package Controller;

import Model.*;
import Enumerators.Kleur;
import Enumerators.Persoon;
import Enumerators.Richting;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static Enumerators.Kleur.*;
import static Enumerators.Richting.*;
import static Enumerators.Rol.*;


public class SpelerController {
    Vak vak;

    // Toggles waar door de richting toetsen voor andere functies kunnen worden gebruikt.
    boolean openendeur = false;
    boolean brandblusser = false;
    boolean hakken = false;
    boolean rijden = false;
    boolean commandeer = false;

    public SpelerController() {
    }

    SpeelveldController veldC;
    DobbelsteenController dobbelC;
    ChatController chatC;
    SpelController spelC;

    // verbind deze Controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelController spelC, DobbelsteenController dobbelC, ChatController chatC) {
        this.veldC = veldC;
        this.spelC = spelC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;
    }

    public void noord(){
        if(commandeer) {
            commandeerActie(BOVEN);
        }
        else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: Noord");
            beweegActie(BOVEN);

        }
        else if(openendeur) {
            System.out.println("DeurOS: Noord");
            deurActie(BOVEN);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Noord");
            blussenActie(BOVEN);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Noord");
            hakActie(BOVEN);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(rijden){
            System.out.println("Actie: Rijden");
            rijden(BOVEN);
        }
        spelC.updatePunten();
    }

    public void west(){
        if(commandeer) {
            commandeerActie(LINKS);
        }
        else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: West");
            beweegActie(LINKS);
        }
        else if(openendeur) {
            System.out.println("DeurOS: West");
            deurActie(LINKS);
        }
        else if(brandblusser) {
            System.out.println("Blussen: West");
            blussenActie(LINKS);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(hakken) {
            System.out.println("Hakken: West");
            hakActie(LINKS);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(rijden){
            System.out.println("Actie: Rijden");
            rijden(LINKS);
        }
        spelC.updatePunten();
    }

    public void zuid(){
        if(commandeer) {
            commandeerActie(ONDER);
        }
        else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: Zuid");
            beweegActie(ONDER);
        }
        else if(openendeur) {
            System.out.println("DeurOS: Zuid");
            deurActie(ONDER);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Zuid");
            blussenActie(ONDER);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Zuid");
            hakActie(ONDER);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(rijden){
            System.out.println("Actie: Rijden");
            rijden(ONDER);
        }
        spelC.updatePunten();
    }

    public void oost(){
        if(commandeer) {
            commandeerActie(RECHTS);
        }
        else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: Oost");
            beweegActie(RECHTS);
        }
        else if(openendeur) {
            System.out.println("DeurOS: Oost");
            deurActie(RECHTS);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Oost");
            blussenActie(RECHTS);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Oost");
            hakActie(RECHTS);
            veldC.ImageSetterAround(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
        }
        else if(rijden){
            System.out.println("Actie: Rijden");
            rijden(RECHTS);
        }
        spelC.updatePunten();
    }

    // Als in SpelC op de special knop word gedrukt gaat deze functie lopen
    // Er word gekeken welke rol een spelC.spel.getHuidigeSpeler() heeft en verwijst verolgens door naar de bijpassende specla methode.
    public void special() {
        switch(spelC.spel.getHuidigeSpeler().getRol()) {
            case VERKENNER:     verken();
                break;
            case COMMANDANT:    commandeer();
                break;
            case DOKTER:        helen();
                break;
            case SPECSTOFFEN: onschadelijkMaken();
                break;
            default: System.out.println("-- Spel: Jouw rol heeft geen speciale actie.");
        }
        spelC.updatePunten();
    }


    // Als een commandant op special klikt kan hij een andere speler kiezen om te bewegen
    Kleur commandKeuze;
    public void commandeer() {
        if (spelC.spel.getHuidigeSpeler().getExtrapunten() > 0) {
            commandeer ^= true;
            if(commandeer) {
                List<String> choices = new ArrayList<>();
                Speler speler2;
                for (int i = 0; i < spelC.spel.getSpelers().size(); i++) {
                    speler2 = spelC.spel.getSpelers().get(i);
                    if (spelC.spel.getHuidigeSpeler() != speler2) choices.add(speler2.getKleur().getString());
                }

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Kies een mede speler", choices);
                dialog.setTitle("Commandant special");
                dialog.setHeaderText("De commandant kan een andere speler commanderen te bewegen");
                dialog.setContentText("Kies een mede speler:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    System.out.println("Your choice: " + result.get());
                    switch (result.get()) {
                        case "Blauw":
                            commandKeuze = BLAUW;
                            break;
                        case "Geel":
                            commandKeuze = GEEL;
                            break;
                        case "Groen":
                            commandKeuze = GROEN;
                            break;
                        case "Oranje":
                            commandKeuze = ORANJE;
                            break;
                        case "Rood":
                            commandKeuze = ROOD;
                            break;
                        case "Zwart":
                            commandKeuze = ZWART;
                    }
                }
            }
        }
    }

    // De daadwerkelijke beweeg actie van de commandant word hier afgehandeld.
    private void commandeerActie(Richting richting) {
        Speler spelerhuidig = spelC.spel.getHuidigeSpeler();
        for(int i = 0; i < spelC.spel.getSpelers().size(); i++) {
            if(spelC.spel.getSpelers().get(i).getKleur() == commandKeuze) {
                spelC.spel.setHuidigeSpeler(spelC.spel.getSpelers().get(i));
            }
        }
        if(spelC.spel.getHuidigeSpeler().getRol() == REDDINGSSPECIALIST) spelC.spel.getHuidigeSpeler().setExtraPunten(spelC.spel.getHuidigeSpeler().getExtrapunten()+1);
        else spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()+1);
        boolean bewogen = beweegActie(richting);
        if(!bewogen && spelC.spel.getHuidigeSpeler().getRol() != REDDINGSSPECIALIST) spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-1);
        spelC.spel.setHuidigeSpeler(spelerhuidig);
        if(bewogen) spelC.spel.getHuidigeSpeler().setExtraPunten(spelC.spel.getHuidigeSpeler().getExtrapunten()-1);
        if(spelC.spel.getHuidigeSpeler().getExtrapunten()<1) {
            commandeer = false;
        }
    }

    public void BrandweerwagenSpuitActie() {
        System.out.println("-- Spel: De brandweerwagen blust in zijn kwadrant. ");
        Boolean opBWagen = false;
        switch(veldC.getVeldD().getBrandweerwagen()) {
            case BOVEN: if(spelC.spel.getHuidigeSpeler().getY()==0 && (spelC.spel.getHuidigeSpeler().getX() == 3|| spelC.spel.getHuidigeSpeler().getX() == 4)) {
                opBWagen = true;
            }
                break;
            case ONDER: if(spelC.spel.getHuidigeSpeler().getY()==7 && (spelC.spel.getHuidigeSpeler().getX() == 5|| spelC.spel.getHuidigeSpeler().getX() == 6)) {
                opBWagen = true;
            }
                break;
            case LINKS: if(spelC.spel.getHuidigeSpeler().getX()==0 && (spelC.spel.getHuidigeSpeler().getY() == 4|| spelC.spel.getHuidigeSpeler().getY() == 5))
                opBWagen = true;
                break;
            case RECHTS: if(spelC.spel.getHuidigeSpeler().getX()==9 && (spelC.spel.getHuidigeSpeler().getY() == 2|| spelC.spel.getHuidigeSpeler().getY() == 3))
                opBWagen = true;
                break;
        }
        if(opBWagen) {
            Boolean eersteLoop = true;
            Boolean loop = true;
            Boolean asignX = true;
            Boolean asignY = true;
            int x = 0;
            int y = 0;
            System.out.println("Ik ga nu blussen");
            if (spelC.spel.getHuidigeSpeler().getActiepunten() > 3 || (spelC.spel.getHuidigeSpeler().getRol() == BRANDSPUITBEDIENER && spelC.spel.getHuidigeSpeler().getActiepunten() > 1)) {
                spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() - 4);
                if (spelC.spel.getHuidigeSpeler().getRol() == BRANDSPUITBEDIENER) spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() + 2);
                Richting kwadrant = veldC.getVeldD().getBrandweerwagen();
                while(loop) {
                    loop = false;
                    dobbelC.d6.gooi();
                    dobbelC.d8.gooi();
                    switch (kwadrant) {
                        case ONDER:
                            if (dobbelC.d6.getWaarde() < 4) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() < 5) {
                                dobbelC.d8.flip();
                            }

                            break;
                        case LINKS:
                            if (dobbelC.d6.getWaarde() < 4) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() > 4) {
                                dobbelC.d8.flip();
                            }
                            break;
                        case BOVEN:
                            if (dobbelC.d6.getWaarde() > 3) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() > 4) {
                                dobbelC.d8.flip();
                            }
                            break;
                        case RECHTS:
                            if (dobbelC.d6.getWaarde() > 3) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() < 5) {
                                dobbelC.d8.flip();
                            }
                            break;
                    }
                    if (spelC.spel.getHuidigeSpeler().getRol() == BRANDSPUITBEDIENER && eersteLoop) {
                        eersteLoop = false;
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Opnieuw gooien");
                        alert.setHeaderText("Je hebt " + dobbelC.d8.getWaarde() + " en " + dobbelC.d6.getWaarde() + " gegooid.");
                        alert.setContentText("Wil je opnieuw gooien?");

                        ButtonType buttonTypeOne = new ButtonType("X");
                        ButtonType buttonTypeTwo = new ButtonType("Y");
                        ButtonType buttonTypeThree = new ButtonType("Allebei");
                        ButtonType buttonTypeCancel = new ButtonType("Blus", ButtonBar.ButtonData.CANCEL_CLOSE);

                        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == buttonTypeOne) {
                            asignY = false;
                            y = dobbelC.d6.getWaarde();
                            loop = true;
                        } else if (result.get() == buttonTypeTwo) {
                            asignX = false;
                            x = dobbelC.d8.getWaarde();
                            loop = true;
                        } else if (result.get() == buttonTypeThree) {
                            loop = true;
                        } else {
                            loop = false;
                        }
                    }
                }

                if(asignX) x = dobbelC.d8.getWaarde();
                if(asignY) y = dobbelC.d6.getWaarde();

                System.out.println(x);
                System.out.println(y);

                vak = veldC.getVeldD().getVakken()[x][y];

                vak.setNiks(true);
                vak.setRook(false);
                vak.setVuur(false);
                for (Richting richting : Richting.values()) {
                    if (vak.getObstakelRichting(richting).isBegaanbaar()) {
                        switch (richting) {
                            case BOVEN:
                                setNiks(x, y - 1);
                                break;
                            case RECHTS:
                                setNiks(x + 1, y);
                                break;
                            case ONDER:
                                setNiks(x, y + 1);
                                break;
                            case LINKS:
                                setNiks(x - 1, y);
                        }
                    }
                }
                veldC.ImageSetterALL();
                spelC.updatePunten();
            }
        }
    }

    private void setNiks(int x, int y) {
        veldC.getVeldD().getVakken()[x][y].setNiks(true);
        veldC.getVeldD().getVakken()[x][y].setRook(false);
        veldC.getVeldD().getVakken()[x][y].setVuur(false);
    }

    // Speciale actie van de verkenner, geeft een popup met alle niet ? personen en draait de gekeuze persoon om.
    private void verken() {
        if(spelC.spel.getHuidigeSpeler().getActiepunten()>0) {
            ArrayList<String> keuzes = new ArrayList<>();
            ArrayList<Persoon> personen = new ArrayList<>();
            int[][] xEnY = new int[3][2];
            int count = 0;
            for (int y = 1; y < 7; y++) {
                for (int x = 1; x < 9; x++) {
                    personen = veldC.getVeldD().getVakken()[x][y].getPersonen();
                    if (!personen.isEmpty()) {
                        for (int i = 0; i < personen.size(); i++) {
                            if (!personen.get(i).isOmgedraaid()) {
                                keuzes.add("PVA: X: " + Integer.toString(x) + " Y: " + Integer.toString(y));
                                xEnY[count][0] = x;
                                xEnY[count][1] = y;
                                count++;
                            }
                        }
                    }
                }
            }

            //De choicedialog maken
            ChoiceDialog<String> dialog = new ChoiceDialog<>("Keuze", keuzes);
            dialog.setTitle("Choice Dialog");
            dialog.setHeaderText("Kies de PVA die je wilt omdraaien");
            dialog.setContentText("Persoon:");

            Optional<String> keuzePersoon = dialog.showAndWait();
            if (keuzePersoon.isPresent() && keuzePersoon.get() != "Keuze") {
                for (int i = 0; i < keuzes.size(); i++) {
                    if (keuzePersoon.get() == keuzes.get(i)) {
                        persoonOmdraaien(xEnY[i][0], xEnY[i][1]);
                        veldC.ImageSetter(xEnY[i][0], xEnY[i][1]);
                        spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-1);

                    }
                }
            }
        }
    }

    private void helen(){
        vak = veldC.getVeldD().getVakken()[spelC.spel.getHuidigeSpeler().getX()][spelC.spel.getHuidigeSpeler().getY()];
        if (!vak.getPersonen().isEmpty()){
            vak.getPersonen().get(0).setGeheeld();
        }
        veldC.ImageSetter(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
    }
    // dit is de special methode van specStoffen, indien mogelijk word een stoffen fiche verwijderd.
    private void onschadelijkMaken() {
        int x = spelC.spel.getHuidigeSpeler().getX();
        int y = spelC.spel.getHuidigeSpeler().getY();
        if(spelC.spel.getHuidigeSpeler().getActiepunten()>1 && veldC.getVeldD().getVakken()[x][y].isStoffen()) {
            veldC.getVeldD().getVakken()[x][y].setStoffen(false);
            spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-2);
            spelC.updatePunten();
            veldC.ImageSetter(x,y);
        }
    }

    public void togglesOff() {
        openendeur = false;
        brandblusser = false;
        hakken = false;
        rijden = false;
        spelC.toggleViewUpdate();
    }

    public void btnOpenenDeur() {
        openendeur ^= true;
        brandblusser = false;
        hakken = false;
        rijden = false;
    }

    public void btnRijden() {
        openendeur = false;
        brandblusser = false;
        hakken = false;
        rijden ^= true;
    }

    public void btnBrandblusser() {
        openendeur = false;
        brandblusser ^= true;
        hakken = false;
        rijden = false;
    }

    public void btnHakken() {
        openendeur = false;
        brandblusser = false;
        hakken ^= true;
        rijden = false;
    }

    private String kiezenVoertuig(){
        ArrayList<String> keuzes = new ArrayList<>();
        keuzes.add("Brandweerwagen");
        keuzes.add("Ambulance");
        //De choicedialog maken
        ChoiceDialog<String> oppakkeus = new ChoiceDialog<>("Kies een voertuig", keuzes);
        oppakkeus.setTitle("Voertuig kiezen");
        oppakkeus.setHeaderText("Kies het voertuig dat je wilt verplaatsen");
        oppakkeus.setContentText("Voertuig");

        Optional<String> keuzeObject = oppakkeus.showAndWait();
        if (keuzeObject.isPresent() && keuzeObject.get() != "Kies een Voertuig"){
            if (keuzeObject.get() == "Ambulance"){
                return keuzeObject.get();
            }
            else {
                return keuzeObject.get();
            }
        }
        return ("als je dit ziet is er iets mis met voertuig kiezen");
    }
    public void rijden(Richting richting) {
        if(spelC.spel.getHuidigeSpeler().getActiepunten()>1) {
            String wagen = kiezenVoertuig();
            System.out.println(wagen);
            Richting kant;
            Vak vak1 = null;
            Vak vak2 = null;
            boolean verkeerdeKant = false;
            if (wagen.equals("Ambulance")) {
                kant = veldC.veldD.getAmbulance();
                switch (kant) {
                    case BOVEN:
                        if (richting == Richting.ONDER && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case RECHTS:
                        if (richting == Richting.LINKS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case ONDER:
                        if (richting == Richting.BOVEN && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case LINKS:
                        if (richting == Richting.RECHTS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                }
                if (!verkeerdeKant) {
                    spelC.meerijden(richting, wagen);
                    veldC.veldD.setAmbulance(richting);
                    spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() - 2);
                    veldC.carSetter();
                    switch(richting){
                        case BOVEN:
                            vak1 = veldC.veldD.getVakken()[5][0];
                            vak2 = veldC.veldD.getVakken()[6][0];
                            break;
                        case RECHTS:
                            vak1 = veldC.veldD.getVakken()[9][4];
                            vak2 = veldC.veldD.getVakken()[9][5];
                            break;
                        case ONDER:
                            vak1 = veldC.veldD.getVakken()[3][7];
                            vak2 = veldC.veldD.getVakken()[4][7];
                            break;
                        case LINKS:
                            vak1 = veldC.veldD.getVakken()[0][2];
                            vak2 = veldC.veldD.getVakken()[0][3];
                            break;
                    }
                    while(vak1.getPersonen().size()>0) {
                        vak1.getPersonen().remove(0);
                        spelC.spel.addGered();
                    }
                    while(vak2.getPersonen().size()>0) {
                        vak2.getPersonen().remove(0);
                        spelC.spel.addGered();
                    }


                }


            }
            else if (wagen.equals("Brandweerwagen")) {
                kant = veldC.veldD.getBrandweerwagen();
                switch (kant) {
                    case BOVEN:
                        if (richting == Richting.ONDER && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case RECHTS:
                        if (richting == Richting.LINKS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case ONDER:
                        if (richting == Richting.BOVEN && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case LINKS:
                        if (richting == Richting.RECHTS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                }

                if (!verkeerdeKant) {
                    spelC.meerijden(richting, wagen);
                    veldC.veldD.setBrandweerwagen(richting);
                    spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() - 2);
                    veldC.carSetter();
                }

            }
        }
    }
    public void dropItem(){
        if(spelC.spel.getHuidigeSpeler().isStof()){
            if(spelC.spel.getHuidigeSpeler().getX()==0 || spelC.spel.getHuidigeSpeler().getX()==9 || spelC.spel.getHuidigeSpeler().getY()==0 || spelC.spel.getHuidigeSpeler().getY()== 7){
                spelC.spel.getHuidigeSpeler().setStof(false);
                vak.setStoffen(false);
            }
            else{
                spelC.spel.getHuidigeSpeler().setStof(false);
                vak.setStoffen(true);
            }

        }
        else if (spelC.spel.getHuidigeSpeler().getPersoon() != null){
            Richting kant = veldC.veldD.getAmbulance();
            boolean opAmbulance= false;
            switch(kant){
                case BOVEN:
                    if(spelC.spel.getHuidigeSpeler().getY()==0 && (spelC.spel.getHuidigeSpeler().getX()== 5 || spelC.spel.getHuidigeSpeler().getX()== 6) ){
                        opAmbulance = true;
                    }
                    break;
                case RECHTS:
                    if(spelC.spel.getHuidigeSpeler().getX()==9 && (spelC.spel.getHuidigeSpeler().getY()== 4 || spelC.spel.getHuidigeSpeler().getY()== 5) ){
                        opAmbulance = true;
                    }
                    break;
                case ONDER:
                    if(spelC.spel.getHuidigeSpeler().getY()==7 && (spelC.spel.getHuidigeSpeler().getX()== 3 || spelC.spel.getHuidigeSpeler().getX()== 4) ){
                        opAmbulance = true;
                    }
                    break;
                case LINKS:
                    if(spelC.spel.getHuidigeSpeler().getX()==0 && (spelC.spel.getHuidigeSpeler().getY()== 2 || spelC.spel.getHuidigeSpeler().getY()== 3) ){
                        opAmbulance = true;
                    }
                    break;
            }
            if(opAmbulance){
                spelC.spel.getHuidigeSpeler().setPersoon(null);
                spelC.spel.addGered();
            }
            else {
                vak.setPersonen(spelC.spel.getHuidigeSpeler().getPersoon());
                spelC.spel.getHuidigeSpeler().setPersoon(null);
            }
            spelC.updatePunten();
        }

    }
    public void oppakkenActie(){
        vak = veldC.getVeldD().getVakken()[spelC.spel.getHuidigeSpeler().getX()][spelC.spel.getHuidigeSpeler().getY()];
        if(spelC.spel.getHuidigeSpeler().isStof() || spelC.spel.getHuidigeSpeler().getPersoon() !=null){
            dropItem();
        }

        else if(vak.isStoffen() && !vak.getPersonen().isEmpty()){
            ArrayList<String> keuzes = new ArrayList<>();
            keuzes.add("Gevaarlijke stoffen");
            keuzes.add("Persoon van aandacht");
            //De choicedialog maken
            ChoiceDialog<String> oppakkeus = new ChoiceDialog<>("Oppak object", keuzes);
            oppakkeus.setTitle("Object kiezen");
            oppakkeus.setHeaderText("Kies het object dat je wilt oppakken");
            oppakkeus.setContentText("Object:");

            Optional<String> keuzeObject = oppakkeus.showAndWait();
            if (keuzeObject.isPresent() && keuzeObject.get() != "Oppak object"){
                if (keuzeObject.get() == "Gevaarlijke stoffen"){
                    spelC.spel.getHuidigeSpeler().setStof(true);
                    vak.setStoffen(false);
                }
                else {
                    spelC.spel.getHuidigeSpeler().setPersoon(vak.getPersonen().get(0));
                    vak.getPersonen().remove(0);
                }
            }
        }
        else if (vak.isStoffen()){
            spelC.spel.getHuidigeSpeler().setStof(true);
            vak.setStoffen(false);
        }
        else if (!vak.getPersonen().isEmpty()){
            spelC.spel.getHuidigeSpeler().setPersoon(vak.getPersonen().get(0));
            vak.getPersonen().remove(0);
        }
        veldC.ImageSetter(spelC.spel.getHuidigeSpeler().getX(),spelC.spel.getHuidigeSpeler().getY());
    }

    private void hakActie(Richting richting) {
        if(spelC.spel.getHuidigeSpeler().getRol()==REDDINGSSPECIALIST) {
            if(spelC.spel.getHuidigeSpeler().getActiepunten()>0 && veldC.doeBeschadiging(spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY(), richting)) {
                spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-1);
            }
        } else if(spelC.spel.getHuidigeSpeler().getActiepunten()>1 && veldC.doeBeschadiging(spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY(), richting)) {
            spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-2);
        }
    }

    private void deurActie(Richting richting) {
        int x = spelC.spel.getHuidigeSpeler().getX();
        int y = spelC.spel.getHuidigeSpeler().getY();
        if(spelC.spel.getHuidigeSpeler().getActiepunten()>0) {
            if(veldC.doeDeur(x,y,richting)) {
                spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-1);
            }
        }
    }

    public void blussenActie(Richting richting) {
        int x = spelC.spel.getHuidigeSpeler().getX();
        int y = spelC.spel.getHuidigeSpeler().getY();
        vak = veldC.veldD.getVakken()[x][y];
        if (vak.getObstakelRichting(richting).isBegaanbaar() && (spelC.spel.getHuidigeSpeler().getActiepunten()>0 ||
                (spelC.spel.getHuidigeSpeler().getRol()== GASPAKDRAGER && spelC.spel.getHuidigeSpeler().getExtrapunten()>0)) && ((spelC.spel.getHuidigeSpeler().getRol()!=REDDINGSSPECIALIST
                && spelC.spel.getHuidigeSpeler().getRol()!=DOKTER) || spelC.spel.getHuidigeSpeler().getActiepunten()>1)){
            if(spelC.spel.getHuidigeSpeler().getRol()==REDDINGSSPECIALIST || spelC.spel.getHuidigeSpeler().getRol()==DOKTER) spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-1);
            if(spelC.spel.getHuidigeSpeler().getRol()==GASPAKDRAGER && spelC.spel.getHuidigeSpeler().getExtrapunten()>0) spelC.spel.getHuidigeSpeler().setExtraPunten(spelC.spel.getHuidigeSpeler().getExtrapunten()-1);
            else spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-1);

            switch (richting) {
                case BOVEN:
                    vak = veldC.veldD.getVakken()[x][y-1];
                    break;
                case RECHTS:
                    vak = veldC.veldD.getVakken()[x+1][y];
                    break;
                case ONDER:
                    vak = veldC.veldD.getVakken()[x][y+1];
                    break;
                case LINKS:
                    vak = veldC.veldD.getVakken()[x-1][y];
                    break;
            }
            if(vak.isRook()) {
                vak.setNiks(true);
                vak.setRook(false);
                vak.setVuur(false);
            }
            else if(vak.isVuur()){
                vak.setNiks(false);
                vak.setRook(true);
                vak.setVuur(false);
            }
        }
        else{
            System.out.println("-- Spel: Er staat hier een muur.");
        }

    }

    private boolean draagt() {
        if(spelC.spel.getHuidigeSpeler().isStof()) return true;
        if(spelC.spel.getHuidigeSpeler().getPersoon() != null) return true;
        return false;
    }

    private void reduceAP(int AP) {
        spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-AP);
    }

    private void reduceEP(int EP) {
        spelC.spel.getHuidigeSpeler().setExtraPunten(spelC.spel.getHuidigeSpeler().getExtrapunten()-EP);
    }

    private void beweegActieKosten(Richting richting) {
        Speler speler = spelC.spel.getHuidigeSpeler();
        int AP = speler.getActiepunten();
        int EP = speler.getExtrapunten();

        Vak[][]vakken = veldC.getVeldD().getVakken();
        Boolean naarVuur = false;
        switch(richting) {
            case BOVEN: naarVuur = vakken[speler.getX()][speler.getY()-1].isVuur();
                break;
            case ONDER: naarVuur = vakken[speler.getX()][speler.getY()+1].isVuur();
                break;
            case LINKS: naarVuur = vakken[speler.getX()-1][speler.getY()].isVuur();
                break;
            case RECHTS: naarVuur = vakken[speler.getX()+1][speler.getY()].isVuur();
                break;
        }

        if(speler.getRol() == REDDINGSSPECIALIST) {
            if(naarVuur) {
                if(speler.isStof()) {
                    if (EP > 2) reduceEP(3);
                    else if (EP > 1) {
                        reduceEP(2);
                        reduceAP(1);
                    } else if (EP > 0) {
                        reduceEP(1);
                        reduceAP(2);
                    } else reduceAP(3);
                }
                else if(speler.getPersoon()==null) {
                    if(EP>1) reduceEP(2);
                    else if(EP>0) {
                        reduceEP(1);
                        reduceAP(1);
                    }else reduceAP(2);
                }
            }
            else if(speler.isStof()) {
                if(EP>1) reduceEP(2);
                else if(EP>0) {
                    reduceEP(1);
                    reduceAP(1);
                } else reduceAP(2);
            }
            else if(speler.getPersoon()==null) {
                if(EP>0) reduceEP(1);
                else reduceAP(1);
            } else if(speler.getPersoon().isGeheeld()) {
                if(EP>0) reduceEP(1);
                else reduceAP(1);
            } else {
                if(EP>1) reduceEP(2);
                else if(EP>0) {
                    reduceEP(1);
                    reduceAP(1);
                } else reduceAP(2);

            }
        } else {

            if (naarVuur) {
                if (speler.isStof()) {
                    reduceAP(3);
                }
                else if (speler.getPersoon() == null) {
                    reduceAP(2);
                }
            }else if (speler.isStof()) {
                reduceAP(2);
            }
            else if (speler.getPersoon() == null) {
                reduceAP(1);
            } else if (speler.getPersoon().isGeheeld()) {
                reduceAP(1);
            } else {
                reduceAP(2);
            }
        }
    }

    private boolean beweegActieKostenCheck(Richting richting) {
        Speler speler = spelC.spel.getHuidigeSpeler();
        int AP = speler.getActiepunten();
        int EP = speler.getExtrapunten();
        EP+=AP;

        Vak[][]vakken = veldC.getVeldD().getVakken();
        Boolean naarVuur = false;
        switch(richting) {
            case BOVEN: if(speler.getY()>0) {
                naarVuur = vakken[speler.getX()][speler.getY() - 1].isVuur();
            } else return false;
                break;
            case ONDER: if(speler.getY()<7) {
                naarVuur = vakken[speler.getX()][speler.getY()+1].isVuur();
            } else return false;
                break;
            case LINKS: if(speler.getX()>0) {
                naarVuur = vakken[speler.getX()-1][speler.getY()].isVuur();
            } else return false;
                break;
            case RECHTS: if(speler.getX()<9) {
                naarVuur = vakken[speler.getX()+1][speler.getY()].isVuur();
            } else return false;
                break;
        }

        if(speler.getRol() == REDDINGSSPECIALIST) {
            if(naarVuur) {
                if(speler.isStof()) {
                    if(EP>2) return true;
                    return false;
                }
                if(speler.getPersoon()==null) {
                    if(EP>1) return true;
                }
                return false;
            }
            if(speler.isStof()) {
                if(EP>1) return true;
                return false;
            }
            if(speler.getPersoon()==null) {
                if(EP>0) return true;
            } else if(speler.getPersoon().isGeheeld()) {
                if(EP>0) return true;
            } else {
                if(EP>1) return true;
            }
            return false;
        }

        if(naarVuur) {
            if(speler.isStof()) {
                if(AP>2) return true;
                return false;
            }
            if(speler.getPersoon()==null) {
                if(AP>1) return true;
            }
            return false;
        }
        if(speler.isStof()) {
            if(AP>1) return true;
            return false;
        }
        if(speler.getPersoon()==null) {
            if(AP>0) return true;
        } else if(speler.getPersoon().isGeheeld()) {
            if(AP>0) return true;
        } else {
            if(AP>1) return true;
        }
        return false;
    }

    // verplaats de spelC.spel.getHuidigeSpeler() in de gewenste richting indien mogelijk.
    private boolean beweegActie(Richting richting) {
        boolean returnValue = false;
        Vak vak = veldC.veldD.getVakken()[spelC.spel.getHuidigeSpeler().getX()][spelC.spel.getHuidigeSpeler().getY()];
        veldC.removeSpeler(spelC.spel.getHuidigeSpeler().getKleur(), spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY());
        veldC.ImageSetter(spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY());
        if (beweegActieKostenCheck(richting)) {
            switch (richting) {
                case BOVEN:
                    if (spelC.spel.getHuidigeSpeler().getY() > 0 && vak.boven.isBegaanbaar()) {
                        beweegActieKosten(BOVEN);
                        spelC.spel.getHuidigeSpeler().setY(spelC.spel.getHuidigeSpeler().getY() - 1);
                        System.out.println("De " + spelC.spel.getHuidigeSpeler().getNaam()+ " loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
                        returnValue = true;
                    }
                    break;
                case RECHTS:
                    if (spelC.spel.getHuidigeSpeler().getX() < 9 && vak.rechts.isBegaanbaar()) {
                        beweegActieKosten(RECHTS);
                        spelC.spel.getHuidigeSpeler().setX(spelC.spel.getHuidigeSpeler().getX() + 1);
                        System.out.println("De " + spelC.spel.getHuidigeSpeler().getNaam()+ " loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
                        returnValue = true;
                    }
                    break;
                case ONDER:
                    if (spelC.spel.getHuidigeSpeler().getY() < 7 && vak.onder.isBegaanbaar()) {
                        beweegActieKosten(ONDER);
                        spelC.spel.getHuidigeSpeler().setY(spelC.spel.getHuidigeSpeler().getY() + 1);
                        System.out.println("De " + spelC.spel.getHuidigeSpeler().getNaam()+ " loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
                        returnValue = true;
                    }
                    break;
                case LINKS:
                    if (spelC.spel.getHuidigeSpeler().getX() > 0 && vak.links.isBegaanbaar()) {
                        beweegActieKosten(LINKS);
                        spelC.spel.getHuidigeSpeler().setX(spelC.spel.getHuidigeSpeler().getX() - 1);
                        System.out.println("De " + spelC.spel.getHuidigeSpeler().getNaam()+ " loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
                        returnValue = true;
                    }
                    break;
            }
        }
        veldC.addSpeler(spelC.spel.getHuidigeSpeler().getKleur(), spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY());
        persoonOmdraaien();
        veldC.ImageSetter(spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY());
        return returnValue;
    }

    public void persoonOmdraaien(int x, int y) {
        int oudX = spelC.spel.getHuidigeSpeler().getX();
        int oudY = spelC.spel.getHuidigeSpeler().getY();
        spelC.spel.getHuidigeSpeler().setX(x);
        spelC.spel.getHuidigeSpeler().setY(y);
        persoonOmdraaien();
        spelC.updateSpel();
        spelC.spel.getHuidigeSpeler().setX(oudX);
        spelC.spel.getHuidigeSpeler().setY(oudY);
    }


    public void persoonOmdraaien() {
        int x = spelC.spel.getHuidigeSpeler().getX();
        int y = spelC.spel.getHuidigeSpeler().getY();
        vak = veldC.getVeldD().getVakken()[x][y];
        if(!vak.getPersonen().isEmpty()) {
            for(int i = 0; i < vak.getPersonen().size(); i++) {
                vak.getPersonen().get(0).setOmgedraaid(true);
            }
        }
        ArrayList<Persoon> personen = veldC.getVeldD().getVakken()[x][y].getPersonen();
        for(int i = 0; i < personen.size(); i++) {
            if (personen.get(i) == Persoon.NOPE1 || personen.get(i) == Persoon.NOPE2 ||
                    personen.get(i) == Persoon.NOPE3 || personen.get(i) == Persoon.NOPE4 ||
                    personen.get(i) == Persoon.NOPE5) {
                personen.remove(i);
                i--;
            }
        }

    }

    // reset AP en EP bij het eindigen van een beurt.
    public void resetPunten() {
        spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()+4);
        if(spelC.spel.getHuidigeSpeler().getActiepunten()>8) spelC.spel.getHuidigeSpeler().setActiepunten(8);
        if(spelC.spel.getHuidigeSpeler().getRol()==GASPAKDRAGER || spelC.spel.getHuidigeSpeler().getRol() == REDDINGSSPECIALIST) spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()-1);
        if(spelC.spel.getHuidigeSpeler().getRol()==MANNETJESPUTTER) spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()+1);
        if(spelC.spel.getHuidigeSpeler().getRol()==GODMODE) spelC.spel.getHuidigeSpeler().setActiepunten(9001);

        switch(spelC.spel.getHuidigeSpeler().getRol()) {
            case REDDINGSSPECIALIST: spelC.spel.getHuidigeSpeler().setExtraPunten(3);
                break;
            case GASPAKDRAGER: spelC.spel.getHuidigeSpeler().setExtraPunten(3);
                break;
            case COMMANDANT: spelC.spel.getHuidigeSpeler().setExtraPunten(2);
                break;
            default: spelC.spel.getHuidigeSpeler().setExtraPunten(0);
        }
        spelC.updatePunten();
    }

    public void openHandleiding() {
        Stage stage = new Stage();
        BorderPane borderPane = new BorderPane();
        ScrollPane scrollpane = new ScrollPane();

        Image gebruikershandleiding = new Image("resources/GFX/GebruikersHandleiding.jpg",2390,796,true,true);
        ImageView imageview = new ImageView(gebruikershandleiding);
        scrollpane.setContent(imageview);
        borderPane.setCenter(scrollpane);
        Scene scene = new Scene(borderPane, 1190, 815);
        stage.setScene(scene);
        stage.setTitle("Gebruikershandleiding");
        stage.show();
    }
    public Speler getUniekeSpeler() {
        for (Speler speler : spelC.getSpel().getSpelers()) {
            if (speler.getKleur() == spelC.getKleur()) {
                return speler;
            }
        } return null;
    }
//    public void removeSpeler() {
//       for (Speler speler : spelC.getSpel().getSpelers()) {
//           if (speler.getKleur() == spelC.getKleur()) {
//               spelC.getSpel().getSpelers().remove(speler);
//
//           }
//       }
//    }


    public Speler getSpeler() {
        return spelC.spel.getHuidigeSpeler();
    }

}