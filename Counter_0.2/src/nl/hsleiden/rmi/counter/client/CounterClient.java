package nl.hsleiden.rmi.counter.client;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import nl.hsleiden.rmi.counter.server.Countable;

/**
 * Gets a Teller remote object from the CalculatorServer and uses the methods of this Calculator object.
 * 
 * Thanks to Koen Warner. This example is based on his Calculator example.
 * 
 * @author Alex van Manen
 * @version 0.2, June 2015	
 */
public class CounterClient {
	
	public static void main(String[] args){

			try {
				for (int i = 0; i < 5; i++) {
					
				
				System.out.println("Getting access to the registry");
				// get access to the RMI registry on the remote server
				Registry registry = LocateRegistry.getRegistry("127.0.0.1"); // if server on another machine: provide that machine's IP address. Default port  1099				
				System.out.println("Getting the Calculator stub from registry");
	            Countable c= (Countable) registry.lookup("Counter"); // get remote Calculator object from registry
				
	            System.out.println("Performing arithmetics");
				
	            CounterController cc = new CounterController(c);
	            CounterView tv = new CounterView(cc, c);
				System.out.println("Done!");
				}
			} catch (Exception e) {
				System.out.println("EXCEPTION: " + e);
			}
	}

}
