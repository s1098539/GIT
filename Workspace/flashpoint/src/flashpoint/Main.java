package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        Speler speler = new Speler("Joep", Kleur.ROOD);
        speler.setLocatieAll(2,2);
        speelveld.addSpeler(speler);

        bewegen.run(2,speler, speelveld);
        System.out.println("x" + speler.getLocatieX() + " Y" +  speler.getLocatieY());




    }
}
