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
    SpeelveldData veldD;
    Server s = new Server();
    Parse p = new Parse("DEBUG_SERVER",veldD);
    // --


    //--Speler
    //--

    //--Speelveld & Vakken
    //--

    //Message?
    @Override
    public Parse sendParse() throws RemoteException {
        return p;
    }
    //--
}


