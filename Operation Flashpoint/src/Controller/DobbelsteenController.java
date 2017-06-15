package Controller;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class DobbelsteenController {

    SpeelveldController speelveldController;
    SpelController spelController;
    SpelerController spelerController;

    public void setControllers(SpeelveldController speelveldController, SpelController spelController, SpelerController spelerController) {
        this.speelveldController = speelveldController;
        this.spelController = spelController;
        this.spelerController = spelerController;
    }

    public DobbelsteenController() {
    }
}
