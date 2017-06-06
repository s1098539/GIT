package sample;
public class Speler {

	public String naam;
	public Character character;
	public Kleur kleur;
	public int x;
	public int y;
    public Object rugtas;

    public Speler(String naam, /*Character character,*/ Kleur kleur, int x, int y) {
        this.naam = naam;
//        this.character = character;
        this.kleur = kleur;
        this.x = x;
        this.y = y;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public void setKleur(Kleur kleur) {
        this.kleur = kleur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Object getRugtas() {
        return rugtas;
    }

    public void setRugtas(Object rugtas) {
        this.rugtas = rugtas;
    }
}