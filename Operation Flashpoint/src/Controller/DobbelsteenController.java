package Controller;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class DobbelsteenController {

    SpeelveldController veldC;
    SpelController spelC;
    SpelerController spelerC;

    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelController spelC, SpelerController spelerC) {
        this.veldC = veldC;
        this.spelC = spelC;
        this.spelerC = spelerC;
    }

    public DobbelsteenController() {
    }
}
