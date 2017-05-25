package flashpoint;

public class Deur {

	public int status = 3;  //3=gesloten, 4=open

    public Deur() {
    }

    public Deur(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void OpenSluiten(){
        if(status == 3){
            status = 4;
            System.out.println("Een deur is geopened");
        } else {
            status = 3;
            System.out.println("Een deur is gesloten");
        }
    }
}