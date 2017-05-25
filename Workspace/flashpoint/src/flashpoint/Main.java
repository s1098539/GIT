package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        Speler speler1 = new Speler("Joep", Kleur.ROOD);
        Speler speler2 = new Speler("Norddin", Kleur.BLAUW);
        speler1.setLocatieAll(2,2);
        speler2.setLocatieAll(4,7);
        speelveld.addSpeler(speler1);
        speelveld.addSpeler(speler2);

        bewegen.run(2,speler1, speelveld);
        bewegen.run(1,speler2, speelveld);

        Vak vak = new Vak();
        vak.addMuur(3);
        System.out.println(vak.checkRichting(3));
        vak.getMuren()[3].schade();
        System.out.println(vak.checkRichting(3));
        vak.getMuren()[3].schade();
        System.out.println(vak.checkRichting(3));
        vak.getMuren()[3].schade();






    }
}
