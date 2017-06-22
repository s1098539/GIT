package Main;

import Controller.SpelController;
import Model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    public Parse getParse() throws RemoteException;

    public String getMessage() throws RemoteException;

    public void setMessage(String string) throws RemoteException;
}