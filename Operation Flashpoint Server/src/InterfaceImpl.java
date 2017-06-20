import java.rmi.RemoteException;

/**
 * Provide: addition, subtraction, multiplication and division of two numbers.
 *
 * CalculatorImpl implements the methods of the Calculator remote interface.
 * This class will be used to create a skeleton on the server
 *
 * @author Koen Warner
 * @version 0.1, May 2015
 *
 */
public class InterfaceImpl implements Interface {
    Model m = new Model(0,0,0,"TEST");
    protected InterfaceImpl() throws RemoteException {
    }
    //THIS IS WHERE THE ACTUAL LOGIC GOES.

    @Override
    public void printConnected(String naam) throws RemoteException{
        System.out.println("Client connected: " + naam);
    }

    @Override
    public String returnTest() throws RemoteException{
        return m.txt;
    }
}
