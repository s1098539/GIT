package flashpoint;


import javafx.scene.image.ImageView;

public class Speler {

    public Speler(String naam, /*Character character,*/ Kleur kleur, ImageView imageView) {
        this.naam = naam;
        // this.character = character;
        this.kleur = kleur;
        this.imageView = imageView;
    }

    private String naam;
    private Character character;
    private Kleur kleur;
    private ImageView imageView;
    public int locatieX;
    public int locatieY;

    public int getLocatieX() {
        return locatieX;
    }

    public void setLocatieX(int locatieX) {
        this.locatieX = locatieX;
    }

    public int getLocatieY() {
        return locatieY;
    }

    public void setLocatieY(int locatieY) {
        this.locatieY = locatieY;
    }

    public void setLocatieAll(int locatieX, int locatieY) {
        this.locatieX = locatieX;
        this.locatieY = locatieY;
    }

    public String getNaam() {
        return naam;
    }

    public ImageView getImageView() {
        return imageView;
    }
}