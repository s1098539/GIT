package Model;

import java.util.ArrayList;

public class SpeelveldData {

    public SpeelveldData() {
    }

    Vak [][] vakken;
    Richting ambulance = Richting.ONDER;
    Richting brandweerwagen = Richting.RECHTS;
    ArrayList<Persoon> personenlijst = new ArrayList<>();

    public Vak[][] getVakken() {
        return vakken;
    }

    public void setVakken(Vak[][] vakken) {
        this.vakken = vakken;
    }

    public Richting getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Richting ambulance) {
        this.ambulance = ambulance;
    }

    public Richting getBrandweerwagen() {
        return brandweerwagen;
    }

    public void setBrandweerwagen(Richting brandweerwagen) {
        this.brandweerwagen = brandweerwagen;
    }

    public ArrayList<Persoon> getPersonenlijst() {
        return personenlijst;
    }

    public void setPersonenlijst(ArrayList<Persoon> personenlijst) {
        this.personenlijst = personenlijst;
    }
}