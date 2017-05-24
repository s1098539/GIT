package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        Speler speler = new Speler("Joep", Kleur.ROOD);
        bewegen.run(0,speler,speelveld.getVakken());

    }
}
