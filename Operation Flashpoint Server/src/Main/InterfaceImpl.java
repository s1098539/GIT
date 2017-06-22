package Main;

import Model.*;

import java.rmi.RemoteException;

public class InterfaceImpl implements Interface {
    //DONT GET RID OF THIS ---------------------------
    protected InterfaceImpl() throws RemoteException {
    }

    Parse p = new Parse("SERVER SIDE");

    @Override
    public Parse getParse() throws RemoteException {
        return p;
    }

    @Override
    public String getMessage() throws RemoteException {
        return p.getMessage();
    }

    @Override
    public void setMessage(String string) throws RemoteException {
        p.setMessage(string);
    }


    // -----------------
}


