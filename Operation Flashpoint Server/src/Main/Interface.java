package Main;

import Model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    //-- Speler (Naam, Kleur, x, y, ap, ep, rol, slechtziendmodus, stof, persoon)
    public Parse sendParse() throws RemoteException;
    //--

    //-- Speelveld

    //--
}