package nl.hsleiden.rmi.counter.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nl.hsleiden.rmi.counter.client.CounterObserver;

/**
 * The remote interface to a Countable implementation.
 * 
 * Contains the method declarations which a class must implement. These methods
 * will be called by the client over RMI.
 * 
 * We must extends the Remote interface because this interface will be called
 * remotely in between the client and server.
 * 
 * Thanks to: java2all,
 * http://java2all.com/technology/rmi/rmi-program/rmi-example, though this code
 * has been slightly changed.
 * 
 * And thanks to Koen Warner. This example is based on his Calculator example.
 * 
 * @author Alex van Manen
 * @version 0.1, June 2015
 * 
 */
public interface Countable extends Remote {

	// The RemoteException is an exception that can occur when a failure occurs
	// in the RMI process.
	/**
	 * Increments the Counter value variable with 1.
	 * 
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public void addOne() throws RemoteException;

	/**
	 * @return the value of the attribute value
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public int getValue() throws RemoteException;

	/**
	 * Adds an observer to the set of observers for this object
	 * 
	 * @param co
	 *            an observer to be added
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public void addObserver(CounterObserver co) throws RemoteException;

}