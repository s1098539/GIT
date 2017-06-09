package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controller{


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

    public Controller(View view/*, BeurtAfronding beurtAfronding, Speelveld speelveld, Speler speler*/) {
        this.view = view;
        //this.beurtAfronding = beurtAfronding;
        //this.speelveld = speelveld;
        //this.speler = speler;

        this.view.addListener(new Listener());


    }
    public class Listener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("It works");
        }

    }
}

