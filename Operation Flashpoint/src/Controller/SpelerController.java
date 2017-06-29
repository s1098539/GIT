package Controller;

import Model.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static Model.Kleur.*;
import static Model.Richting.*;
import static Model.Rol.*;


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

    // verbind deze controller met 3 andere
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
            System.out.println("rijden");
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
            System.out.println("rijden");
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
            System.out.println("rijden");
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
            System.out.println("rijden");
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
            default: System.out.println("Mom thinks im special :(");
        }
        spelC.updatePunten();
    }


    // Als een commandant op special klikt kan hij een andere spelC.spel.getHuidigeSpeler() kiezen om te bewegen
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

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Kies een mede spelC.spel.getHuidigeSpeler()", choices);
                dialog.setTitle("Commandant special");
                dialog.setHeaderText("De commandant kan een andere spelC.spel.getHuidigeSpeler() commanderen te bewegen");
                dialog.setContentText("Kies een mede spelC.spel.getHuidigeSpeler():");

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
        System.out.println("BLUS BLUS");
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

    // L (dialog template gejat van Norddin), speciale actie van de verkenner, geeft een popup met alle niet ? personen en draait de gekeuze persoon om.
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
                    veldC.veldD.setAmbulance(richting);
                    spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() - 2);
                    veldC.carSetter();
                }


            } else if (wagen.equals("Brandweerwagen")) {
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
                    veldC.veldD.setBrandweerwagen(richting);
                    spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() - 2);
                    veldC.carSetter();
                }

            }
        }
    }
    private void brandweerwagenActie(){
        System.out.println("Actie: Gebruik brandweerwagen");
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
            System.out.println("hier zit een muur oid");
        }

    }

    private boolean draagt() {
        if(spelC.spel.getHuidigeSpeler().isStof()) return true;
        if(spelC.spel.getHuidigeSpeler().getPersoon() != null) return true;
        return false;
    }

    private void beweegActieKosten() {
        if (spelC.spel.getHuidigeSpeler().getRol() == REDDINGSSPECIALIST && (spelC.spel.getHuidigeSpeler().getExtrapunten() > 1 || (spelC.spel.getHuidigeSpeler().getExtrapunten() > 0 && !draagt()))) {
            spelC.spel.getHuidigeSpeler().setExtraPunten(spelC.spel.getHuidigeSpeler().getExtrapunten() - 1);
            if(draagt()) spelC.spel.getHuidigeSpeler().setExtraPunten(spelC.spel.getHuidigeSpeler().getExtrapunten() - 1);
            if(spelC.spel.getHuidigeSpeler().getPersoon()!=null && spelC.spel.getHuidigeSpeler().getPersoon().isGeheeld()) spelC.spel.getHuidigeSpeler().setExtraPunten(spelC.spel.getHuidigeSpeler().getExtrapunten()+1);
        } else {
            spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() - 1);
            if(draagt())spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten() - 1);
            if(spelC.spel.getHuidigeSpeler().getPersoon()!=null && spelC.spel.getHuidigeSpeler().getPersoon().isGeheeld()) spelC.spel.getHuidigeSpeler().setActiepunten(spelC.spel.getHuidigeSpeler().getActiepunten()+1);
        }
    }

    // verplaats de spelC.spel.getHuidigeSpeler() in de gewenste richting indien mogelijk.
    private boolean beweegActie(Richting richting) {
        boolean returnValue = false;
        Vak vak = veldC.veldD.getVakken()[spelC.spel.getHuidigeSpeler().getX()][spelC.spel.getHuidigeSpeler().getY()];
        veldC.removeSpeler(spelC.spel.getHuidigeSpeler().getKleur(), spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY());
        veldC.ImageSetter(spelC.spel.getHuidigeSpeler().getX(), spelC.spel.getHuidigeSpeler().getY());
        if ((spelC.spel.getHuidigeSpeler().getActiepunten() > 0 && !draagt()) || (spelC.spel.getHuidigeSpeler().getRol() == REDDINGSSPECIALIST && spelC.spel.getHuidigeSpeler().getExtrapunten() > 0 && !draagt()) ||
                (spelC.spel.getHuidigeSpeler().getActiepunten() > 1 && draagt()) || (spelC.spel.getHuidigeSpeler().getRol() == REDDINGSSPECIALIST && spelC.spel.getHuidigeSpeler().getExtrapunten() > 0 && !draagt())  ||
                (spelC.spel.getHuidigeSpeler().getActiepunten() > 0 && spelC.spel.getHuidigeSpeler().getPersoon() != null && spelC.spel.getHuidigeSpeler().getPersoon().isGeheeld()) || (spelC.spel.getHuidigeSpeler().getRol() == REDDINGSSPECIALIST && spelC.spel.getHuidigeSpeler().getExtrapunten() > 0 && spelC.spel.getHuidigeSpeler().getPersoon() != null && spelC.spel.getHuidigeSpeler().getPersoon().isGeheeld())) {
            switch (richting) {
                case BOVEN:
                    if (spelC.spel.getHuidigeSpeler().getY() > 0 && vak.boven.isBegaanbaar()) {
                        beweegActieKosten();
                        spelC.spel.getHuidigeSpeler().setY(spelC.spel.getHuidigeSpeler().getY() - 1);
                        System.out.println("*De spelC.spel.getHuidigeSpeler() loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
                        returnValue = true;
                    }
                    break;
                case RECHTS:
                    if (spelC.spel.getHuidigeSpeler().getX() < 9 && vak.rechts.isBegaanbaar()) {
                        beweegActieKosten();
                        spelC.spel.getHuidigeSpeler().setX(spelC.spel.getHuidigeSpeler().getX() + 1);
                        System.out.println("*De spelC.spel.getHuidigeSpeler() loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
                        returnValue = true;
                    }
                    break;
                case ONDER:
                    if (spelC.spel.getHuidigeSpeler().getY() < 7 && vak.onder.isBegaanbaar()) {
                        beweegActieKosten();
                        spelC.spel.getHuidigeSpeler().setY(spelC.spel.getHuidigeSpeler().getY() + 1);
                        System.out.println("*De spelC.spel.getHuidigeSpeler() loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
                        returnValue = true;
                    }
                    break;
                case LINKS:
                    if (spelC.spel.getHuidigeSpeler().getX() > 0 && vak.links.isBegaanbaar()) {
                        beweegActieKosten();
                        spelC.spel.getHuidigeSpeler().setX(spelC.spel.getHuidigeSpeler().getX() - 1);
                        System.out.println("*De spelC.spel.getHuidigeSpeler() loopt naar: " + spelC.spel.getHuidigeSpeler().getX() + "," + spelC.spel.getHuidigeSpeler().getY() + "*");
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

    private void persoonOmdraaien(int x, int y) {
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

    private void persoonOmdraaien() {
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

        Image gebruikershandleiding = new Image("Resources/GFX/GebruikersHandleiding.jpg",2390,796,true,true);
        ImageView imageview = new ImageView(gebruikershandleiding);
        scrollpane.setContent(imageview);
        borderPane.setCenter(scrollpane);
        Scene scene = new Scene(borderPane, 1190, 815);
        stage.setScene(scene);
        stage.setTitle("Gebruikershandleiding");
        stage.show();
    }
    public Speler getSpeler() {
        return spelC.spel.getHuidigeSpeler();
    }

}