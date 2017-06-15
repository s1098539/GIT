package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class Lobby {
    private String ip;
    private Kleur[] kleur;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Lobby (){
        kleur = new Kleur[6];
        for(int i=0; i<kleur.length; i++){
            for (Kleur k: Kleur.values()){
                kleur[i] = k;
            }
        }

    }
}
