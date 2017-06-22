package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sam van Schaik
 */

public class Spel implements Serializable {
    int hotspotCounter;
    double beschadigingCounter;
    int geredCounter;
    ArrayList<Speler> spelers = new ArrayList<>();
    Speler huidigeSpeler;

    public Speler getHuidigeSpeler() {
        return huidigeSpeler;
    }

    public void setHuidigeSpeler(Speler huidigeSpeler) {
        this.huidigeSpeler = huidigeSpeler;
    }

    public void setSpelers(Speler speler) {
        if (spelers.size()<7) {
            this.spelers.add(speler);
        }
    }
    public ArrayList<Speler> getSpelers(){
        return spelers;
    }
    int doodCounter;

    int hotspots;

    public int getDoodCounter() {
        return doodCounter;
    }

    public void setDoodCounter(int doodCounter) {
        this.doodCounter = doodCounter;
    }

    public void addDood(){
        doodCounter ++;
    }

    public void addHotspot(){
        hotspotCounter ++;
    }

    public void deductHotspot(){
        hotspotCounter --;
    }

    public int getHotspotCounter() {
        return hotspotCounter;
    }

    public void setHotspotCounter(int hotspotCounter) {
        this.hotspotCounter = hotspotCounter;
    }

    public double getBeschadigingCounter() {
        return beschadigingCounter;
    }

    public void setBeschadigingCounter(double beschadigingCounter) {
        this.beschadigingCounter = beschadigingCounter;
    }

    public int getGeredCounter() {
        return geredCounter;
    }

    public void setGeredCounter(int geredCounter) {
        this.geredCounter = geredCounter;
    }

    public void addGered(){

    }

    public Spel(int hotspotCounter, int beschadigingCounter, int geredCounter) {
        this.hotspotCounter = hotspotCounter;
        this.beschadigingCounter = beschadigingCounter;
        this.geredCounter = geredCounter;
    }


}
