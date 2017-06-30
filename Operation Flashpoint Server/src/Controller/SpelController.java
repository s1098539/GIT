package Controller;

import Model.*;
import javafx.fxml.Initializable;

import java.io.Serializable;
import java.net.URL;
import java.util.*;

public class SpelController implements Initializable, Serializable {
    Spel spel;

    public Spel getSpel() {
        return spel;
    }

    public void setSpel(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

