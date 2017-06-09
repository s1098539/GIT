package nl.hsleiden.rmi.counter.client;

import java.rmi.RemoteException;

import nl.hsleiden.rmi.counter.server.Countable;

/**
 * Responsible for coordinating the commands from the UI to the appropiate
 * model(s).
 * 
 * @author Alex van Manen
 * @version 0.1, June 2015
 *
 */
public class CounterController {

	Countable t;

	/**
	 * 
	 * @param t
	 *            counter object where the commands are need to be send to
	 */
	public CounterController(Countable t) {
		this.t = t;
	}

	/**
	 * Executing addOne on the counter object that is defined when creating the
	 * constructor.
	 * 
	 * @throws RemoteException when the connection between RMI client and server is
	 *             compromised
	 */
	public void cmdAddOne() throws RemoteException {
		t.addOne();
	}

}
