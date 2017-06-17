package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Sam van Schaik on 14-6-2017.
 */
public class SpelerController {
    Speler test2 = new Speler("Sam", Kleur.ROOD, "127", 0, 0, 0, 0, Rol.COMMANDANT, true);

    public SpelerController() {
    }

    SpeelveldController veldC;
    SpelController spelC;
    DobbelsteenController dobbelC;

    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelController spelC, DobbelsteenController dobbelC) {
        this.veldC = veldC;
        this.spelC = spelC;
        this.dobbelC = dobbelC;
    }

    @FXML private Button hakken;


    //TODO Beweeg Acties
    public void beweegNoord(){
        System.out.println("Beweeg: Noord");
        beweegwActie(Richting.BOVEN);
    }

    public void beweegWest(){
        System.out.println("Beweeg: West");
        beweegwActie(Richting.LINKS);
    }

    public void beweegZuid(){
        System.out.println("Beweeg: Zuid");
        beweegwActie(Richting.ONDER);
    }

    public void beweegOost(){
        System.out.println("Beweeg: Oost");
        beweegwActie(Richting.RECHTS);
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

    public void beweegwActie(Richting richting) {
        Vak vak = veldC.veld.getVakken()[test2.getX()][test2.getY()];
        switch(richting) {
            case BOVEN: if(test2.getY()>0 && vak.boven.isBegaanbaar()) {
                test2.setY(test2.getY()-1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
            case RECHTS: if(test2.getX()<9 && vak.rechts.isBegaanbaar()) {
                test2.setX(test2.getX()+1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
            case ONDER: if(test2.getY()<7 && vak.onder.isBegaanbaar()) {
                test2.setY(test2.getY()+1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
            case LINKS: if(test2.getX()>0 && vak.links.isBegaanbaar()) {
                test2.setX(test2.getX()-1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
        }
        veldC.ImageSetterALL();
    }
}
