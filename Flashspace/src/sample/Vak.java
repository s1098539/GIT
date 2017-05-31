package sample;

import java.util.ArrayList;

public class Vak {

    public Object[] objecten = new Object[9];
	public int[] obstakels;

    public Vak() {
        Object object = new Object();
    }

    public void addObject(Object object) {
        switch(object.getNaam()){

            case "Rook": objecten[6] = object;
                System.out.println(objecten[6]);
        }
//        objecten[2] = ;
    }
}

//	private int Vuur;
//	private int Rook;
//	private int GevaarlijkeStof;
//	private int Brandhaard;
//	private int PersoonVanAandacht;
//	private int Ziekenwagen;
//	private int Brandweerwagen;