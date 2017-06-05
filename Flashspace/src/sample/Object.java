package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static sample.Kleur.BLAUW;

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

    static class Deur extends Object {
        ImageView imageView;
        String naam = "Deur";

        @Override
        public ImageView getImageView() {
            return imageView;
        }

        public Deur(ImageView imageView) {
            this.imageView = imageView;
        }

        public Deur() {
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

    static class Speler extends Object{

        public String naam;
        public String spelerNaam;
        public Character character;
        public Kleur kleur;
        public int x;
        public int y;
        public Object rugtas;

        public Speler(String spelerNaam, /*Character character,*/ Kleur kleur, int x, int y) {
            this.spelerNaam = spelerNaam;
//        this.character = character;
            this.kleur = kleur;
            this.x = x;
            this.y = y;
            String naam = "Speler";
            ImageView imageView = new ImageView();
            switch(getKleur()) {
                case BLAUW: imageView.setImage(new Image("sample/gfx/Brandweerblauw.png"));
                    break;
                case GEEL: imageView.setImage(new Image("sample/gfx/Brandweergeel.png"));
                    break;
                case GROEN: imageView.setImage(new Image("sample/gfx/Brandweergroen.png"));
                    break;
                case ORANJE: imageView.setImage(new Image("sample/gfx/Brandweeroranje.png"));
                    break;
                case ROOD: imageView.setImage(new Image("sample/gfx/Brandweerrood.png"));
                    break;
                case ZWART: imageView.setImage(new Image("sample/gfx/Brandweerzwart.png"));
                    break;
            }
        }

        public String getNaam() {
            return naam;
        }

        public void setNaam(String naam) {
            this.naam = naam;
        }

        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        public Kleur getKleur() {
            return kleur;
        }

        public void setKleur(Kleur kleur) {
            this.kleur = kleur;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Object getRugtas() {
            return rugtas;
        }

        public void setRugtas(Object rugtas) {
            this.rugtas = rugtas;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

}

