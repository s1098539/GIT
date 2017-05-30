import java.rmi.*;

/**
 * Interface for ChatClient
 * 
 * @author Koen Warner, 2016
 *
 */

public interface ChatListenInterface extends Remote {

	// Registry ChatClient with server, to be able to receive message from the server
	void update(Message message)  throws RemoteException;
}
