package main;
import model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by School on 27-6-2017.
 */
public interface ChatListenInterface extends Remote {

    // Registry ChatClient with server, to be able to receive message from the server
    void update(Message message)  throws RemoteException;
    void receiveGame(Spel spelServer, SpeelveldData veldServer) throws RemoteException;
}
