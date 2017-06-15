package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SpelView {
Scene scene;

    public SpelView() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SpelView.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(root, 1200, 700);
    }

    public Scene getScene() {
        return scene;
    }
}
