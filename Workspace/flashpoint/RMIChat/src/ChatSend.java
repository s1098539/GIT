import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 *
 * Send a message to the server.
 *
 * Sending a serializable object
 * Usage:
 * 	java ChatSend [host] [username] [nessage]
 * 	vanuit project directory RMIChat
 * 	host is optioneel: default is "127.0.0.1"
 * 	username is optioneel: default is "Unknown"
 * 	message is optioneel: default is "no message"
 *
 * @author Koen Warner, 2016
 */
public class ChatSend {

	private ChatServerInterface server = null;

	/**
	 * args[0] is server address or ip
	 * args[1] is user name
	 * args[1] is message to send
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("ChatSend: Chat sender v2.0 starting up...");

		ChatSend sender;
		String host;
		String username;
		String message;

		try {
			if ( args.length == 0 ){
				host = "145.101.91.10";
				username = "Unknown";
				message = "no message";

			} else {
				host = args[0];
				username = args[1];
				message = args[2];
			}

			System.out.println("ChatSend: Create chat sender object");
			sender = new ChatSend(host, username, message);
			System.out.println("ChatSend: sender object created");

			System.out.println("ChatSend: send message");
			sender.sendMessageObject(username, message);


		} catch (RemoteException re){
			System.out.println("An exception occured");
			re.printStackTrace();
		} catch (Exception e){
			System.out.println("An exception occured");
			e.printStackTrace();
		}
	}

	/**
	 * Constructor
	 *
	 * Create remote reference to server object.
	 */
	public ChatSend(String host, String usernamej, String message) throws RemoteException, MalformedURLException, NotBoundException  {
		// Get reference to remote object, i.e. the server object (which will consume the message)
		this.server = (ChatServerInterface) Naming.lookup("//" + host +"/ChatService");
		System.out.println("ChatSend: looked up server in RMI Registry; \'ChatService\'");
	}

	/**
	 * Send message object to server
	 */
	void sendMessageObject(String user, String  message) throws RemoteException {

		Message messageObject = new Message(user,  message); // serialized object
		this.server.receiveMessage( messageObject );

	}


}
