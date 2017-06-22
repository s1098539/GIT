package Main;

import Model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    //-- Speler (Naam, Kleur, x, y, ap, ep, rol, slechtziendmodus, stof, persoon)
    public Speler getSpeler() throws RemoteException;

    public Speler getSpecificSpeler(Speler speler) throws RemoteException;

    public String getString() throws RemoteException;

    public void setAP(int ap, Speler speler) throws RemoteException;
    //--

    //-- Speelveld
    //--
}