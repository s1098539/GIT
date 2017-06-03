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
    ImageView imageView;

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
            case "Muur":
                Muur muur = new Muur();
        }
	}

	public void createObjects(String objectNaam, ImageView imageView) {
        Muur muur = new Muur(imageView);
    }

	public String getNaam() {
        return naam;
    }
    public ImageView getImageView() {
        return imageView;
    }

    static class Rook extends Object{
        ImageView imageView = new ImageView(new Image("sample/gfx/Rook.png"));
        String naam = "Rook";

        public String getNaam() {
            return naam;
        }

        public Rook() {
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    static class Muur extends Object {
        ImageView imageView;
        String naam = "Muur";

        @Override
        public ImageView getImageView() {
            return imageView;
        }

        public Muur(ImageView imageView) {
            this.imageView = imageView;
        }

        public Muur() {
        }
    }

    static class Vuur extends Object {
        ImageView imageView = new ImageView(new Image("sample/gfx/Vlam.png"));
        String naam = "Vuur";

        public String getNaam() {
            return naam;
        }

        public Vuur() {
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
    static class GevaarlijkeStof extends Object {
        ImageView imageView = new ImageView(new Image("sample/gfx/GevaarlijkeStof.png"));
        String naam = "GevaarlijkeStof";

        public String getNaam() {
            return naam;
        }

        public GevaarlijkeStof() {
        }
    }
    static class BrandHaard extends Object{
        ImageView imageView = new ImageView(new Image("sample/gfx/Hotspot.png",20,20,true,true));
        String naam = "Brandhaard";

        public String getNaam() {
            return naam;
        }

        @Override
        public ImageView getImageView() {
            return imageView;
        }

        public BrandHaard() {
        }
    }

    static class PersoonVanAandacht extends Object{
        String naam = "PersoonVanAandacht";
        boolean omgedraait =false ;
        ImageView imageView = new ImageView(new Image("sample/gfx/Vraagteken.png",20,20,true,true));

        public PersoonVanAandacht() {
        }

        public boolean isOmgedraait() {
            return omgedraait;
        }

        public void persoonVanAandachtOmdraaien() {
            omgedraait = true;
            imageView = new ImageView(new Image("sample/gfx/PersoonVanAandacht.png"));

        }
        public String getNaam() {
            return naam;
        }

        @Override
        public ImageView getImageView() {
            return imageView;
        }
    }

    static class Ziekenwagen extends Object{
        ImageView imageView = new ImageView(new Image("sample/gfx/Ziekenwagen.png"));
        String naam = "Ziekenwagen";

        public String getNaam() {
            return naam;
        }

        public Ziekenwagen() {
        }
    }


    static class Brandweerwagen extends Object{
        ImageView imageView = new ImageView(new Image("sample/gfx/Brandweerwagen.png"));
        String naam = "Brandweerwagen";

        public String getNaam() {
            return naam;
        }

        public Brandweerwagen() {
        }
    }

    }

