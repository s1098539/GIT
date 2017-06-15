package Controller;

import Model.Rol;
import Model.Speler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Sam van Schaik on 14-6-2017.
 */
public class SpelerController {
    @FXML private Button hakken;


    //Beweeg Acties
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

    //Spel Acties
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

    @FXML private void brandweerwagenActie{
        System.out.println("Actie: Gebruik brandweerwagen");
    }

    @FXML private void veranderRol(){
        System.out.println("Actie: Verander rol");
    }

    //Speciale Acties
    //TODO THIS NEEDS TO REQUEST THE CURRENT PLAYER HIS ROLE AND ASIGN THE CORRECT ACTION
    @FXML private void specialeActie(){

    }

    @FXML private void commandeerActie(){

    }


}
