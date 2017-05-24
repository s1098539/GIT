package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        System.out.println("1");
        Bewegen bewegen = new Bewegen();
        System.out.println("2");
        Speler speler = new Speler("Joep", Kleur.ROOD);
        System.out.println("3");
        speelveld.getVakken()[2][2].addSpeler(speler);
        bewegen.test(0,speler,speelveld.getVakken());
        System.out.println("4");

    }
}
