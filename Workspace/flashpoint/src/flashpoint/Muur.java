package flashpoint;

public class Muur {

	public int status = 0;

    public Muur() {
    }

    public void schade(){

        try {
            if (status < 2) {
                status++;
            } else {
                System.out.println("De muur is al kapot");
            }
        } catch (NullPointerException e) {
            System.out.println("Hier is geen muur");
        }
    }




    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}