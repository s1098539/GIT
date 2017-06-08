package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {


    private View view;
    private BeurtAfronding beurtAfronding;
    private Speelveld speelveld;
    private Speler speler;

    public Speelveld getSpeelveld() {
        return speelveld;
    }

    public Speler getSpeler() {
        return speler;
    }

    public Controller(View view, BeurtAfronding beurtAfronding, Speelveld speelveld, Speler speler) {
        this.view = view;
        this.beurtAfronding = beurtAfronding;
        this.speelveld = speelveld;
        this.speler = speler;
        this.view.addCalculationListener(listenForCalcButton);
    }

    public class CalculateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }



    EventHandler listenForCalcButton = event -> System.out.println("Works?");

}
