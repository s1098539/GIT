package Main;

import Controller.SpeelveldController;
import Controller.SpelController;
import Model.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class InterfaceImpl implements Interface {
    //DONT GET RID OF THIS ---------------------------
    protected InterfaceImpl() throws RemoteException {
    }
    Server s = new Server();

    // --


    //--Speler
    Speler s2 = new Speler("DEBUG_SERVER", Kleur.ROOD);

    public Speler getSpeler() throws RemoteException{
        return s2;
    }

    public Speler getSpecificSpeler(Speler speler) throws RemoteException{
        return speler;
    }

    @Override
    public String getString() throws RemoteException{
        return s2.getNaam();
    }

    @Override
    public void setAP(int ap) throws RemoteException {
        getSpeler();
    }

    //--

    //--Speelveld & Vakken
    SpelController VeldC;
    //--x
}


