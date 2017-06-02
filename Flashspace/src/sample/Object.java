package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Object {
//mee bezig norddin

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
            case "Rook":
                Rook rook = new Rook();
                break;
            case "Vuur":
                Vuur vuur = new Vuur();
                break;
            case "GevaarlijkeStof":
                GevaarlijkeStof gevaarlijkeStof = new GevaarlijkeStof();
                break;
            case "Brandhaard":
                BrandHaard brandHaard = new BrandHaard();
                break;
            case "PersoonVanAandacht":
                PersoonVanAandacht persoonVanAandacht = new PersoonVanAandacht();
                break;
            case "Ziekenwagen":
                Ziekenwagen ziekenwagen = new Ziekenwagen();
                break;
            case "brandweerwagen":
                Brandweerwagen brandweerwagen = new Brandweerwagen();
        }
	}

	public String getNaam() {
        return naam;
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

    static class Vuur extends Object {
        ImageView imageView = new ImageView(new Image("gfx/Vuur.png"));
        String naam = "Vuur";

        public String getNaam() {
            return naam;
        }

        public Vuur() {
        }
    }
    static class GevaarlijkeStof extends Object {
        ImageView imageView = new ImageView(new Image("gfx/GevaarlijkeStof.png"));
        String naam = "GevaarlijkeStof";

        public String getNaam() {
            return naam;
        }

        public GevaarlijkeStof() {
        }
    }
    static class BrandHaard extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Brandhaard.png"));
        String naam = "Brandhaard";

        public String getNaam() {
            return naam;
        }

        public BrandHaard() {
        }
    }

    static class PersoonVanAandacht extends Object{
        String naam = "PersoonVanAandacht";
        boolean omgedraait =false ;
        ImageView imageView = new ImageView(new Image("gfx/PersoonVanAandachtVerborgen.png"));

        public PersoonVanAandacht() {
        }

        public boolean isOmgedraait() {
            return omgedraait;
        }

        public void persoonVanAandachtOmdraaien() {
            omgedraait = true;
            imageView = new ImageView(new Image("gfx/PersoonVanAandacht.png"));

        }
        public String getNaam() {
            return naam;
        }

    }

    static class Ziekenwagen extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Ziekenwagen.png"));
        String naam = "Ziekenwagen";

        public String getNaam() {
            return naam;
        }

        public Ziekenwagen() {
        }
    }


    static class Brandweerwagen extends Object{
        ImageView imageView = new ImageView(new Image("gfx/Brandweerwagen.png"));
        String naam = "Brandweerwagen";

        public String getNaam() {
            return naam;
        }

        public Brandweerwagen() {
        }
    }

    }

