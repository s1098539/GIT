package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Object {

    //Dit worden classes
//	private int Vuur;
//	private int Rook;
//	private int GevaarlijkeStof;
//	private int Brandhaard;
//	private int PersoonVanAandacht;
//	private int Ziekenwagen;
//	private int Brandweerwagen;

    String naam;

    public Object() {
    }


	public void createObjects(String objectNaam) {
		switch(objectNaam) {
            case "Rook": Rook rook = new Rook();
                break;
            case "Vuur": Vuur vuur = new Vuur();
                break;
            case "GevaarlijkeStof": GevaarlijkeStof gevaarlijkeStof = new GevaarlijkeStof();
        }
	}

	public String getNaam() {
        return naam;
    }

	public void persoonVanAandachtOmdraaien() {
		// TODO - implement Object.persoonVanAandachtOmdraaien
		throw new UnsupportedOperationException();
	}

    static class Rook extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Rook.png"));
        String naam = "Rook";

        public String getNaam() {
            return naam;
        }

        public Rook() {
        }
    }

    static class Vuur extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Vuur.png"));
        String naam = "Vuur";

        public String getNaam() {
            return naam;
        }

        public Vuur() {
        }
    static class GevaarlijkeStof extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Vuur.png"));
        String naam = "GevaarlijkeStof";
    }

    static class BrandHaard extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Brandhaard.png"));
        String naam = "Brandhaard";
    }
    static class PersoonVanAandacht extends Object{
        ImageView imageView = new ImageView(new Image("gfx/PersoonVanAandacht.png"));
        String naam = "PersoonVanAandacht";
    }
    static class Ziekenwagen extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Ziekenwagen.png"));
        String naam = "Ziekenwagen";
    }
    static class Brandweerwagen extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Brandweerwagen.png"));
        String naam = "Brandweerwagen";
    }
    }

}