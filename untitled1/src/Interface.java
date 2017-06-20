import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Lenovo on 6/20/2017.
 */
public interface Interface extends Remote {
    void print() throws RemoteException;
}
