package Controller;
import java.rmi.*;
import Model.Message;

/**
 * Interface for ChatClient
z
 * @author Koen Warner, 2016
 *
 */

public interface ListenInterface extends Remote {

	// Registry ChatClient with server, to be able to receive message from the server
	void update(Message message)  throws RemoteException;
}
