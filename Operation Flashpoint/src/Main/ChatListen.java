package Main;

import Controller.SpeelveldController;
import Controller.SpelController;
import Model.Message;
import Model.SpeelveldData;
import Model.Spel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by School on 27-6-2017.
 */
public class ChatListen extends UnicastRemoteObject implements ChatListenInterface {
    SpelController spelC;
    SpeelveldController veldC;


    protected ChatListen(String host) throws RemoteException {
        Registry registry = null;


        try {
            registry = LocateRegistry.getRegistry("localhost");
            Interface clientStub = (Interface) registry.lookup("Main.Interface");
            clientStub.registerObserver(this);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {

    }

    @Override
    public void update(Message message) throws RemoteException {

        System.out.println(message.getSenderName() + ": " + message.getMessage());

    }

    @Override
    public void receiveGame(Spel spelServer, SpeelveldData veldServer) throws RemoteException {
        spelC.setSpel(spelServer);
        veldC.setVeldD(veldServer);
        veldC.ImageSetterALL();
    }
    }
