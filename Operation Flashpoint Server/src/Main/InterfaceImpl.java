package Main;

import Model.*;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class InterfaceImpl implements Interface {
    //DONT GET RID OF THIS ---------------------------
    protected InterfaceImpl() throws RemoteException {
    }

    Parse p = new Parse("SERVER SIDE");
    Map<Kleur, Speler> mMap = new HashMap<Kleur, Speler>();
    int i = 1;

    public Kleur addSpeler(String naam) throws RemoteException {
        Kleur kleur;
        switch (i) {
            case 1:
                Speler speler = new Speler(naam, Kleur.GROEN);
                mMap.put(Kleur.GROEN, speler);
                i++;
                kleur = Kleur.GROEN;
                break;
            case 2:
                Speler speler2 = new Speler(naam, Kleur.ZWART);
                mMap.put(Kleur.ZWART, speler2);
                i++;
                kleur = Kleur.ZWART;
                break;
            case 3:
                Speler speler3 = new Speler(naam, Kleur.GEEL);
                mMap.put(Kleur.GEEL, speler3);
                i++;
                kleur = Kleur.GEEL;
                break;
            case 4:
                Speler speler4 = new Speler(naam, Kleur.BLAUW);
                mMap.put(Kleur.BLAUW, speler4);
                i++;
                kleur = Kleur.BLAUW;
                break;
            case 5:
                Speler speler5 = new Speler(naam, Kleur.ORANJE);
                mMap.put(Kleur.ORANJE, speler5);
                i++;
                kleur = Kleur.ORANJE;
                break;
            case 6:
                Speler speler6 = new Speler(naam, Kleur.ROOD);
                mMap.put(Kleur.ROOD, speler6);
                i++;
                kleur = Kleur.ROOD;
                break;
            default:
                return null;
        }
        return kleur;
    }


    public Speler GetSpeler(Kleur kleur) throws RemoteException {
        return mMap.get(kleur);
    }


    @Override
    public Parse getParse() throws RemoteException {
        return p;
    }

    @Override
    public String getMessage() throws RemoteException {
        return p.getMessage();
    }

    @Override
    public void setMessage(String string) throws RemoteException {
        p.setMessage(string);
    }


    // -----------------
}


