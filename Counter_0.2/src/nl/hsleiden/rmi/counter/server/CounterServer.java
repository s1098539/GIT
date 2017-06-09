package nl.hsleiden.rmi.counter.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Provides communication with the RMI clients.
 * 
 * CounterServer creates remote object Teller and puts it in the RMI registry.
 * Client can ask for this remote object.
 * 
 * 
 * Thanks to Koen Warner. This code is based on his Calculator example.
 * 
 * @author Alex van Manen
 * @version 0.1, June 2015
 */
public class CounterServer {

	public CounterServer() {
	}
	
	/** 
	 * Run the server functions
	 */
	private void runServer() {
		
		try {
			
			Counter counter = new Counter(); // create calculator and treat as Counter
			Countable counterSkeleton = 	(Countable) UnicastRemoteObject.exportObject(counter, 0); // cast to remote object
			System.out.println("Counter skeleton created");
			Registry registry = LocateRegistry.createRegistry(1099); // default port 1099 // run RMI registry on local host
			System.out.println("RMI Registry starter");
			registry.rebind("Counter", counterSkeleton); // bind calculator to RMI registry
            System.out.println("Calculator skeleton bound");
            System.out.println("Server running...");
            
			// if you'd like to run rmiregistry from the command line
			//	run it from the project's bin directory, so rmiregistry can find the necessary classes
			
		} catch (Exception e) {
			System.out.println("EXCEPTION: " + e);
		}
		
	}
	
	public static void main(String[] args){

		new CounterServer().runServer();
	}
}
