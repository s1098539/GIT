package Controller;

import Model.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for ChatClient
*/

public interface ListenInterface extends Remote {

	// Registry ChatClient with server, to be able to receive message from the server
	void update(Message message)  throws RemoteException;
}
