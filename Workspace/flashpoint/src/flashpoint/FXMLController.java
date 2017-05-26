package flashpoint;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXMLController {
    @FXML
    private Button btnUP;
    @FXML
    private Button btnLEFT;
    @FXML
    private Button btnRIGHT;
    @FXML
    private Button btnDOWN;

    @FXML
    private void initialize() {
        btnLEFT.setOnAction((event) -> {
            System.out.println("LEFT");
        });

        btnRIGHT.setOnAction((event) -> {
            System.out.println("RIGHT");
        });

        btnUP.setOnAction((event) -> {
            System.out.println("UP");
        });

        btnDOWN.setOnAction((event) -> {
            System.out.println("DOWN");
        });
    }
}

