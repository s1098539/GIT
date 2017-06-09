package Flashpoint;
import java.rmi.*;

/**
 * Interface for Server class
z
 * @author Koen Warner, 2016
 *
 */
public interface ChatServerInterface extends Remote {

    // send an message object to all other clients
    void notifyObservers(Message message) throws RemoteException;
    // registerObserver a listener (listener client)
    void registerObserver(ChatListenInterface listen) throws RemoteException;
	// unregisterObserver a listener  (listener client)
	void unregisterObserver(ChatListenInterface listen) throws RemoteException;
	// receive message from a client
	void receiveMessage(Message msg) throws RemoteException;
}
