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
        speelveld.getVakken()[4][1].addMuur(1);

        bewegen.run(0,speler1, speelveld);
        bewegen.run(0,speler1, speelveld);
        speelveld.getVakken()[2][2].getDeuren()[0].OpenSluiten();
        bewegen.run(0,speler1, speelveld);


        bewegen.run(1,speler1, speelveld);
        bewegen.run(1,speler1, speelveld);
        bewegen.run(1,speler1, speelveld);
        speelveld.getVakken()[4][1].getMuren()[1].schade();
        bewegen.run(1,speler1, speelveld);
        speelveld.getVakken()[4][1].getMuren()[1].schade();
        bewegen.run(1,speler1, speelveld);











    }
}
