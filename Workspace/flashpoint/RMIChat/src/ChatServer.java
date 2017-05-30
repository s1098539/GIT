import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.util.ArrayList;

/**
 * Receives message objects from send clients and sends the message object to all registered
 * listen clients
 *
 * Here the server object is the remote object itself (UnicastRemoteObject)
 *
 * Usage:
 * 	java -cp bin ChatServer
 * 	vanuit project directory RMIChat
 *
 * @author Koen Warner, 2016
 *
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerInterface{

	private static final long serialVersionUID = 1L;
	// A list of registered listener clients
	private ArrayList<ChatListenInterface> chatListeners = new ArrayList<ChatListenInterface>();
	// Port where RMI Registry listens
	private int port = 1099;


	public ChatServer() throws RemoteException {

		System.out.println("Server: ChatServer v2.0 starting up...");

		try {
			// Connect to RMI Registry
			LocateRegistry.createRegistry(port);
			System.out.println("Server: connected to RMI registry.");
			// Register this server object in the RMI Registry
			Naming.rebind("ChatService", this);
			System.out.println("Server: server registered as \'ChatService\' in RMI registry.");
		} catch (MalformedURLException mfue) {
			System.out.println(mfue);
		} catch (RemoteException re){
			System.out.println(re);
		}
	}

	/**
	 *	Start up server
	 */
	public static void main(String args[]) throws Exception {

		System.out.println("Server: ChatServer running.");
	}

	/**
	 *	Receive message from ChatSend object and resent to all registered ChatListen objects
	 */
	public synchronized void notifyObservers(Message message) throws RemoteException {
	    for (ChatListenInterface client : chatListeners) {
	    	client.update(message);

	    }
	}

	/**
	 *	Register a ChatListen object as an observer
	 */
	public synchronized void registerObserver(ChatListenInterface listener) throws RemoteException {
		this.chatListeners.add(listener);
	}


	/**
	 *	Unregister a ChatListen object as an observer
	 */
	public synchronized void unregisterObserver(ChatListenInterface listener) throws RemoteException {
		System.out.println("Server: removinglistener");
		this.chatListeners.remove(listener);
		System.out.println("Server: listener removed");
	}

	/**
	 *	Receive message from send client and notify all listeners
	 */
	public synchronized void receiveMessage(Message msg){

		try {
			this.notifyObservers(msg);

		} catch (RemoteException re) {

		}

	}
}
