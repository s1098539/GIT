package flashpoint;

public class Speler {

    public Speler(String naam, /*Character character,*/ Kleur kleur) {
        this.naam = naam;
       // this.character = character;
        this.kleur = kleur;
    }

    private String naam;
	private Character character;
	private  Kleur kleur;
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
}