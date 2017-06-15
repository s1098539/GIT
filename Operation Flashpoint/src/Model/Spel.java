package Model;

/**
 * Created by Sam van Schaik
 */

public class Spel {
    int hotspotCounter;
    int beschadigingCounter;
    int geredCounter;

    public int getHotspotCounter() {
        return hotspotCounter;
    }

    public void setHotspotCounter(int hotspotCounter) {
        this.hotspotCounter = hotspotCounter;
    }

    public int getBeschadigingCounter() {
        return beschadigingCounter;
    }

    public void setBeschadigingCounter(int beschadigingCounter) {
        this.beschadigingCounter = beschadigingCounter;
    }

    public int getGeredCounter() {
        return geredCounter;
    }

    public void setGeredCounter(int geredCounter) {
        this.geredCounter = geredCounter;
    }

    public Spel(int hotspotCounter, int beschadigingCounter, int geredCounter) {
        this.hotspotCounter = hotspotCounter;
        this.beschadigingCounter = beschadigingCounter;
        this.geredCounter = geredCounter;
    }


}
