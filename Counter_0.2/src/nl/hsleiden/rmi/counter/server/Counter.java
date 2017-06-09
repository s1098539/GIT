package nl.hsleiden.rmi.counter.server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nl.hsleiden.rmi.counter.client.CounterObserver;

/**
 * 
 * Counter implements the methods of the Countable remote interface. This class
 * will be used to create a skeleton on the server
 * 
 * @author Alex van Manen
 * @version 0.2, June 2015
 *
 */
public class Counter implements Countable {

	private int value;
	private ArrayList<CounterObserver> observers = new ArrayList<CounterObserver>();
	private int observerIndex;


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.hsleiden.rmi.calculator.server.Counter#addObserver(nl.hsleiden.rmi
	 * .calculator.client.CounterObserver)
	 */
	public void addObserver(CounterObserver co) throws RemoteException {
		nextCounterObserver();
		observers.add(co);
		try {
			notifyObservers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.hsleiden.rmi.calculator.server.Counter#addOne()
	 */
	public void addOne() throws RemoteException {
		if (value < 5) {
			value++;
		}
		nextCounterObserver();
		notifyObservers();
	}

	/**
	 * @since 0.2
	 * 
	 * Disables the current CounterObserver in the ArrayList observers and
	 * enables the next CounterObserver in the list. This way the turn of one
	 * CounterObserver ends and the other one starts
	 * 
	 * @throws RemoteException
	 *             RemoteException when the connection between RMI client and
	 *             server is compromised
	 * 
	 */
	private void nextCounterObserver() throws RemoteException {
		if (observers.size() > 0) {
			observers.get(observerIndex).setEnabled(false);
			observerIndex++;
			if (observerIndex >= observers.size()) {
				observerIndex = 0;
			}
			observers.get(observerIndex).setEnabled(true);
		}
	}

	/**
	 * Notifies all the Observers that the model is changed.
	 * 
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public void notifyObservers() throws RemoteException {
		for (CounterObserver co : observers) {
			co.modelChanged(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.hsleiden.rmi.calculator.server.Counter#getValue()
	 */
	@Override
	public int getValue() throws RemoteException {
		return value;
	}
}
