package Model;

/**
 * Created by Sam van Schaik
 */
public class Speler {
    //Speler informatie
    String naam;
    Kleur kleur;
    String ip;

    //Positie
    int x;
    int y;

    //Punten
    int actiepunten;
    int extrapunten;

    Rol rol;

    boolean slechtziendmodus;

    //Constructors
    public Speler(String naam, Kleur kleur, String ip, int x, int y, int actiepunten, int extrapunten, Rol rol, boolean slechtziendmodus) {
        this.naam = naam;
        this.kleur = kleur;
        this.ip = ip;
        this.x = x;
        this.y = y;
        this.actiepunten = actiepunten;
        this.extrapunten = extrapunten;
        this.rol = rol;
        this.slechtziendmodus = slechtziendmodus;
    }

    //Getters
    public String getNaam() {
        return naam;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public String getIp() {
        return ip;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getActiepunten() {
        return actiepunten;
    }

    public int getExtrapunten() {
        return extrapunten;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean isSlechtziendmodus() {
        return slechtziendmodus;
    }

    //Setters
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setKleur(Kleur kleur) {
        this.kleur = kleur;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setActiepunten(int actiepunten) {
        this.actiepunten = actiepunten;
    }

    public void setExtrapunten(int extrapunten) {
        this.extrapunten = extrapunten;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setSlechtziendmodus(boolean slechtziendmodus) {
        this.slechtziendmodus = slechtziendmodus;
    }


}
