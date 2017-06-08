package sample;

/**
 * Created by Joep Oonk on 8-6-2017.
 */
public enum Personen {
    HOND(false, false), EGEL(false, false), GROENHAAR(false, false), HIPSTERSNOR(false, false), LATIFAH(false, false),
    OBAMANIGUA(false, false), OMA(false, false), ROODHAAR(false, false), SNEK(false, false),
    VIS(false, false), NOPE1(false), NOPE2(false), NOPE3(false), NOPE4(false), NOPE5(false);
    private boolean gered;
    private boolean omgedraaid;

    Personen(boolean omgedraaid, boolean gered) {
        this.gered = gered;
        this.omgedraaid = omgedraaid;
    }
    Personen(boolean omgedraaid){this.omgedraaid = omgedraaid;}

}
