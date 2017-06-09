package nl.hsleiden.rmi.counter.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nl.hsleiden.rmi.counter.server.Countable;

/**
 * The interface for the CounterView that receives the callback.
 * 
 * @author Alex van Manen
 * @version 0.2, June 2015
 *
 */
public interface CounterObserver extends Remote {

	/**
	 * @since 0.1
	 * @param t
	 *            the model that is changed
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public void modelChanged(Countable t) throws RemoteException;

	/**
	 * @since 0.2
	 * @return whether this object is enabled or disabled to send a message to the CounterController
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public boolean isEnabled() throws RemoteException;

	/**
	 * since 0.2
	 * 
	 * @param enabled enabling or disabling this object to send a message to the CounterController
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public void setEnabled(boolean enabled) throws RemoteException;
}
