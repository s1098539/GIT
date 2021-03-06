import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Provides communication with the RMI clients.
 * <p>
 * CalculatorServer creates remote object Calculator and puts it in the RMI registry.
 * Client can ask for this remote object.
 * <p>
 * Running the CalculatorServer application
 * - start a termial
 * - go to the directory RMI_Calculator_Server
 * - on cmd line: java -cp bin nl.hsleiden.rmi.calculator.server.CalculatorServer
 *
 * @author Koen Warner
 * @version 0.1, May 2015
 */
public class Server {

    public Server() {}
    int port = 1099; //INPUT PORT HERE.

    private void runServer() {

        try {

            InterfaceImpl calcImpl = new InterfaceImpl(); // create calculator and treat as Calculator
            Interface serverSkeleton = (Interface) UnicastRemoteObject.exportObject(calcImpl, port); // cast to remote object
            System.out.println("Calculator skeleton created");
            Registry registry = LocateRegistry.createRegistry(1099); // default port 1099 // run RMI registry on local host
            System.out.println("RMI Registry starter ...");
            registry.rebind("Interface", serverSkeleton); // bind calculator to RMI registry
            System.out.println("Interface skeleton bound ...");
            System.out.println("Server running ...");

            // if you'd like to run rmiregistry from the commend line
            //	run it from the project's bin directory, so rmiregistry can find the necessary classes

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }

    }

    public static void main(String[] args) {
        new Server().runServer();
    }
}
