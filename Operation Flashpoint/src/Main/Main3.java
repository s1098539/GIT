package Main;

import Controller.DobbelsteenController;
import Controller.SpeelveldController;
import Controller.SpelController;
import Controller.SpelerController;

/**
 * Created by Lion on 15-6-2017.
 */
public class Main3 {
    public static void main(String[] args) {
        SpeelveldController speelveldController = new SpeelveldController();
        SpelController spelController = new SpelController();
        SpelerController spelerController = new SpelerController();
        DobbelsteenController dobbelsteenController = new DobbelsteenController();

        speelveldController.setControllers(spelController,spelerController,dobbelsteenController);
        spelController.setControllers(speelveldController,spelerController,dobbelsteenController);
        spelerController.setControllers(speelveldController,spelController,dobbelsteenController);
        dobbelsteenController.setControllers(speelveldController,spelController,spelerController);






    }
}
