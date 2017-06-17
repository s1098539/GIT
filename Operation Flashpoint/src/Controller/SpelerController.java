package Controller;

import Model.*;

import static Model.Richting.*;
import static Model.Rol.GASPAKDRAGER;
import static Model.Rol.MANNETJESPUTTER;
import static Model.Rol.REDDINGSSPECIALIST;


/**
 * Created by Sam van Schaik on 14-6-2017.
 */
public class SpelerController {
    Speler test2 = new Speler("Sam", Kleur.ROOD, "127", 0, 0, REDDINGSSPECIALIST, true);
    Vak vak;


    // Toggles waar door de richting toetsen voor andere functies kunnen worden gebruikt.
    boolean openendeur = false;
    boolean brandblusser = false;
    boolean hakken = false;

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

    public void noord(){
        if(!openendeur && !brandblusser && !hakken) {
            System.out.println("Beweeg: Noord");
            beweegwActie(BOVEN);
        }
        else if(openendeur) {
            System.out.println("DeurOS: Noord");
            deurActie(BOVEN);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Noord");
            blussenActie(BOVEN);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Noord");
            hakActie(BOVEN);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        spelC.updatePunten();
    }

    public void west(){
        if(!openendeur && !brandblusser && !hakken) {
            System.out.println("Beweeg: West");
            beweegwActie(LINKS);
        }
        else if(openendeur) {
            System.out.println("DeurOS: West");
            deurActie(LINKS);
        }
        else if(brandblusser) {
            System.out.println("Blussen: West");
            blussenActie(LINKS);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: West");
            hakActie(LINKS);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        spelC.updatePunten();
    }

    public void zuid(){
        if(!openendeur && !brandblusser && !hakken) {
            System.out.println("Beweeg: Zuid");
            beweegwActie(ONDER);
        }
        else if(openendeur) {
            System.out.println("DeurOS: Zuid");
            deurActie(ONDER);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Zuid");
            blussenActie(ONDER);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Zuid");
            hakActie(ONDER);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        spelC.updatePunten();
    }

    public void oost(){
        if(!openendeur && !brandblusser && !hakken) {
            System.out.println("Beweeg: Oost");
            beweegwActie(RECHTS);
        }
        else if(openendeur) {
            System.out.println("DeurOS: Oost");
            deurActie(RECHTS);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Oost");
            blussenActie(RECHTS);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Oost");
            hakActie(RECHTS);
            veldC.ImageSetterAround(test2.getX(),test2.getY());
        }
        spelC.updatePunten();
    }

    public void btnOpenenDeur() {
        openendeur ^= true;
        brandblusser = false;
        hakken = false;
    }

    public void btnBrandblusser() {
        openendeur = false;
        brandblusser ^= true;
        hakken = false;
    }

    public void btnhakken() {
        openendeur = false;
        brandblusser = false;
        hakken ^= true;
    }

    //TODO beweegVoertuig, brandweerwagenActie, oppakkenActie
    private void beweegVoertuig(){
        System.out.println("Actie: Beweeg Voertuig");
    }
    private void brandweerwagenActie(){
        System.out.println("Actie: Gebruik brandweerwagen");
    }
    private void oppakkenActie(){
        System.out.println("Actie: Oppakken");
    }

    private void hakActie(Richting richting) {
        veldC.doeBeschadiging(test2.getX(),test2.getY(),richting);
    }

    private void deurActie(Richting richting) {
        int x = test2.getX();
        int y = test2.getY();
        veldC.doeDeur(x,y,richting);
    }



    public void blussenActie(Richting richting) {
        int x = test2.getX();
        int y = test2.getY();
        vak = veldC.veld.getVakken()[x][y];
        if (vak.getObstakelRichting(richting).isBegaanbaar() && (test2.getActiepunten()>0 || (test2.getRol()== GASPAKDRAGER && test2.getExtrapunten()>0)) && (test2.getRol()!=REDDINGSSPECIALIST || test2.getActiepunten()>1)){
            if(test2.getRol()==REDDINGSSPECIALIST) test2.setActiepunten(test2.getActiepunten()-1);
            if(test2.getRol()==GASPAKDRAGER && test2.getExtrapunten()>0) test2.setExtraPunten(test2.getExtrapunten()-1);
            else test2.setActiepunten(test2.getActiepunten()-1);

            switch (richting) {
                case BOVEN:
                    vak = veldC.veld.getVakken()[x][y-1];
                    break;
                case RECHTS:
                    vak = veldC.veld.getVakken()[x+1][y];
                    break;
                case ONDER:
                    vak = veldC.veld.getVakken()[x][y+1];
                    break;
                case LINKS:
                    vak = veldC.veld.getVakken()[x-1][y];
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

    // Lion, verplaats de speler in de gewenste richting indien mogelijk.
    private void beweegwActie(Richting richting) {
        Vak vak = veldC.veld.getVakken()[test2.getX()][test2.getY()];
        veldC.removeSpeler(test2.getKleur(),test2.getX(),test2.getY());
        veldC.ImageSetter(test2.getX(),test2.getY());
        switch(richting) {
            case BOVEN: if(test2.getY()>0 && vak.boven.isBegaanbaar() && (test2.getActiepunten()>0 || (test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0))) {
                if(test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0) {
                    test2.setExtraPunten(test2.getExtrapunten()-1);
                } else test2.setActiepunten(test2.getActiepunten()-1);
                test2.setY(test2.getY()-1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
            case RECHTS: if(test2.getX()<9 && vak.rechts.isBegaanbaar() && (test2.getActiepunten()>0 || (test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0))) {
                if(test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0) {
                    test2.setExtraPunten(test2.getExtrapunten()-1);
                } else test2.setActiepunten(test2.getActiepunten()-1);
                test2.setX(test2.getX()+1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
            case ONDER: if(test2.getY()<7 && vak.onder.isBegaanbaar() && (test2.getActiepunten()>0 || (test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0))) {
                if(test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0) {
                    test2.setExtraPunten(test2.getExtrapunten()-1);
                } else test2.setActiepunten(test2.getActiepunten()-1);
                test2.setY(test2.getY()+1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
            case LINKS: if(test2.getX()>0 && vak.links.isBegaanbaar() && (test2.getActiepunten()>0 || (test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0))) {
                if(test2.getRol()== REDDINGSSPECIALIST && test2.getExtrapunten()>0) {
                    test2.setExtraPunten(test2.getExtrapunten()-1);
                } else test2.setActiepunten(test2.getActiepunten()-1);
                test2.setX(test2.getX()-1);
                System.out.println("*De speler loopt naar: " + test2.getX() + "," + test2.getY() + "*");
            }   break;
        }
        veldC.addSpeler(test2.getKleur(),test2.getX(),test2.getY());
        veldC.ImageSetter(test2.getX(),test2.getY());
    }

    // Lion, reset AP en EP bij het eindigen van een beurt.
    public void resetPunten() {
        test2.setActiepunten(test2.getActiepunten()+4);
        if(test2.getActiepunten()>7) test2.setActiepunten(7);
        if(test2.getRol()==GASPAKDRAGER) test2.setActiepunten(test2.getActiepunten()-1);
        if(test2.getRol()==MANNETJESPUTTER) test2.setActiepunten(test2.getActiepunten()+1);

        switch(test2.getRol()) {
            case REDDINGSSPECIALIST: test2.setExtraPunten(3);
                break;
            case GASPAKDRAGER: test2.setExtraPunten(3);
                break;
            case COMMANDANT: test2.setExtraPunten(2);
                break;
            default: test2.setExtraPunten(0);
        }


        spelC.updatePunten();
    }

    public Speler getTest2() {
        return test2;
    }
}
