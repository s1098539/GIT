package Main;

import Model.*;
import Enumerators.Kleur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interface extends Remote {
    public Kleur addSpeler(String naam) throws RemoteException;

    public ArrayList<Speler> GetSpeler() throws RemoteException;

    public Spel updateGetSpel() throws RemoteException;

    //public void notifyObservers(Spel spel) throws RemoteException;

    public void notifyObserversMessage(Message message) throws RemoteException;

    public void registerObserver(ListenInterface listener) throws RemoteException;

    public void registerObserverSpel(Interface listener) throws RemoteException;


    public void unregisterObserver(ListenInterface listener) throws RemoteException;

    public void unregisterObserver(Interface gameListener) throws RemoteException;

    //public void update(Spel spel) throws RemoteException;

    // public void updateMessage(Message message) throws RemoteException;

    public void sendMessageObject(String user, String message) throws RemoteException;

    //public void update (Message message) throws RemoteException;

    public void setSpelData(Spel spel, SpeelveldData veldD) throws RemoteException;

    //public void setFirstTimeSpel(Spel spel) throws RemoteException;

    //public void setFirstTimeData(SpeelveldData veldD) throws RemoteException;

    public SpeelveldData updateGetData() throws RemoteException;

    public void notifyObserversSpel() throws RemoteException;

    //public Map<Kleur, Speler> getmMap() throws RemoteException;
}