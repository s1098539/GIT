package sample;

/**
 * Created by lion on 06-06-17.
 */
public enum Status {
    MUUR(false, 0), MUUR1(false, 1), MUUR2(true, 2), DEURO(true, 3), DEURD(false, 4), LEEG(true, 5);
    private final boolean begaanbaar;
    private final int index;

    public boolean isBegaanbaar() {
        return begaanbaar;
    }
    //
    Status(boolean begaanbaar, int index) {
        this.begaanbaar = begaanbaar;
        this.index = index;
    }
}
