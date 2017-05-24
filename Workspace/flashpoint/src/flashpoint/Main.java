package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        bewegen.run()

        Speler speler = new Speler("Joep", Kleur.ROOD);

    }
}
