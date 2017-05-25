package flashpoint;

public class Main {


    public static void main(String[] args) {
        Speelveld speelveld = new Speelveld();
        Bewegen bewegen = new Bewegen();
        Speler speler1 = new Speler("Joep", Kleur.ROOD);
        Speler speler2 = new Speler("Norddin", Kleur.BLAUW);
        speler1.setLocatieAll(2,3);
        speler2.setLocatieAll(4,7);
        speelveld.addSpeler(speler1);
        speelveld.addSpeler(speler2);

        speelveld.getVakken()[2][2].addDeur(0);
        speelveld.getVakken()[2][1].addDeur(2);
        speelveld.getVakken()[4][1].addMuur(1);
        speelveld.getVakken()[5][1].addMuur(3);

        DeurOpenenSluiten deurOpenenSluiten = new DeurOpenenSluiten();

        bewegen.run(0,speler1, speelveld);
        bewegen.run(0,speler1, speelveld);
        deurOpenenSluiten.run(0,speler1,speelveld);
        bewegen.run(0,speler1, speelveld);

        Hakken hakken = new Hakken();



        bewegen.run(1,speler1, speelveld);
        bewegen.run(1,speler1, speelveld);
        bewegen.run(1,speler1, speelveld);
        hakken.run(1,speler1, speelveld);
        bewegen.run(1,speler1, speelveld);
        hakken.run(1,speler1, speelveld);
        bewegen.run(1,speler1, speelveld);











    }
}
