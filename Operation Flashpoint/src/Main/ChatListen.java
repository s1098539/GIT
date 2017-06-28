package Main;

import Controller.*;
import Model.Message;
import Model.SpeelveldData;
import Model.Spel;

import java.io.IOException;
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
    Registry registry = null;
    String host;
    int port;

    public String getHost() {return host;}
    public void setHost(String host) {this.host = host;    }
    public int getPort() {return port;}
    public void setPort(int port) {this.port = port;}

    public ChatListen(String host, int port) throws RemoteException {

        setHost(host);
        setPort(port);

        try {
            registry = LocateRegistry.getRegistry(host,port);
            Interface clientStub = (Interface) registry.lookup("Main.Interface");
            clientStub.registerObserver(this);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        try {
            spelC = new SpelController();
            veldC = new SpeelveldController();
        } catch (IOException e) {
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
    public void receiveGame() throws RemoteException {

spelC.updateSpel();

    }
    }

