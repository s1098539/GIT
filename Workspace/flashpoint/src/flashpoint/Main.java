package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        Speler speler = new Speler("Joep", Kleur.ROOD);
        speelveld.getVakken()[4][2].addSpeler(speler);
        bewegen.run(3,speler,speelveld.getVakken());
        System.out.println(bewegen.vindSpeler(speler,speelveld.getVakken())[0]);
        System.out.println(bewegen.vindSpeler(speler,speelveld.getVakken())[1]);



    }
}
