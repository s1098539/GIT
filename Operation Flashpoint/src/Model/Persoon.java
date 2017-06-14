package Model;

/**
 * Created by lion on 14-06-17.
 */
public enum Persoon {
    HOND(false, false), EGEL(false, false), GROENHAAR(false, false), HIPSTERSNOR(false, false), LATIFAH(false, false),
    OBAMANIGUA(false, false), OMA(false, false), ROODHAAR(false, false), SNEK(false, false),
    VIS(false, false), NOPE1(false), NOPE2(false), NOPE3(false), NOPE4(false), NOPE5(false);
    private boolean gered;
    private boolean omgedraaid;

    Persoon(boolean omgedraaid, boolean gered) {
        this.gered = gered;
        this.omgedraaid = omgedraaid;
    }
    Persoon(boolean omgedraaid){this.omgedraaid = omgedraaid;}

}
