


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * Gets a Interface remote object from the CalculatorServer and uses the methods of this Interface object.
 *
 * Compiling the client application
 * To be able to compile the CalculatorClient class, it must have a reference to the Interface class in the server project
 * - R-click client project>Build Path>Configure Build Path>Java Build Path...>tab_Projects>Add...:
 * 	 - Select the server project
 * - Import the Interface class in this CalculatorClient class by adding the following import statement:
 * 	 - import nl.hsleiden.rmi.calculator.server.Interface;
 * - Under the RMI_Calculator_Client project
 * 	- Create directories bin/nl/hsleiden/rmi/calculator/server
 * 	- Add Interface.class to this directory (copy over from server project)
 *
 *
 * Running the CalculatorClient application
 * - go to the directory RMI_Calculator_Client
 * - on cmd line: java -cp bin nl.hsleiden.rmi.calculator.client.CalculatorClient
 *
 * @author Koen Warner
 * @version 0.1, May 2015
 */
public class Client {


    public static void main(String[] args){
        String naam = "Rafe";
        String ip = "145.101.73.221";

        try {
            System.out.println("Getting access to the registry ...");
            // get access to the RMI registry on the remote server
            Registry registry = LocateRegistry.getRegistry(ip); // if server on another machine: provide that machine's IP address. Default port  1099
            System.out.println("Getting the Interface stub from registry ...");
            Interface clientStub = (Interface) registry.lookup("Interface"); // get remote Interface object from registry

            clientStub.printConnected(naam);
            System.out.println(clientStub.returnTest());

            String txt;
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }
}
