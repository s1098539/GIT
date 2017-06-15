package Controller;

import Model.Kleur;
import Model.Rol;
import Model.Spel;
import Model.Speler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Sam van Schaik on 14-6-2017.
 */
public class SpelerController {
    Speler test2 = new Speler("Sam", Kleur.ROOD, "127", 0, 0, 0, 0, Rol.COMMANDANT, true);

    SpeelveldController speelveldController;
    SpelController spelController;
    DobbelsteenController dobbelsteenController;

    public void setControllers(SpeelveldController speelveldController, SpelController spelController, DobbelsteenController dobbelsteenController) {
        this.speelveldController = speelveldController;
        this.spelController = spelController;
        this.dobbelsteenController = dobbelsteenController;
    }

    @FXML private Button hakken;


    //TODO Beweeg Acties
    @FXML private void beweegNoord(){
        System.out.println("Beweeg: Noord");


    }

    @FXML private void beweegWest(){
        System.out.println("Beweeg: West");
    }

    @FXML private void beweegZuid(){
        System.out.println("Beweeg: Zuid");
    }

    @FXML private void beweegOost(){
        System.out.println("Beweeg: Oost");
    }

    //TODO Spel Acties
    @FXML private void hakActie(){
        System.out.println("Actie: Hakken");
    }

    @FXML private void deurActie(){
        System.out.println("Actie: Deur");
    }

    @FXML private void oppakkenActie(){
        System.out.println("Actie: Oppakken");
    }

    @FXML private void blussenActie(){
        System.out.println("Actie: Blussen");
    }

    @FXML private void beweegVoertuig(){
        System.out.println("Actie: Beweeg Voertuig");
    }

    @FXML private void brandweerwagenActie(){
        System.out.println("Actie: Gebruik brandweerwagen");
    }
}
