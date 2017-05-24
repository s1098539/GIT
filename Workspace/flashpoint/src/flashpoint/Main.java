package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        SpelerActie spelerActie = new SpelerActie();
        spelerActie.createSpelerActies();
        Speler speler = new Speler("Joep", Kleur.ROOD);

    }
}
