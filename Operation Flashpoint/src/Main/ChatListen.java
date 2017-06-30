package Main;

import Controller.*;
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
    Registry registry = null;
    String host;
    int port;
    SpelController spelC1;
    SpeelveldController veldC1;
    SpelerController spelerC1;


    public SpelController getSpelC1() {
        return spelC1;
    }

    public void setSpelC1(SpelController spelC1) {
        this.spelC1 = spelC1;
    }

    public SpeelveldController getVeldC1() {
        return veldC1;
    }

    public void setVeldC1(SpeelveldController veldC1) {
        this.veldC1 = veldC1;
    }

    public String getHost() {return host;}
    public void setHost(String host) {this.host = host;    }
    public int getPort() {return port;}
    public void setPort(int port) {this.port = port;}
    public SpelerController getSpelerC1() {
        return spelerC1;
    }

    public void setSpelerC1(SpelerController spelerC1) {
        this.spelerC1 = spelerC1;
    }

    public ChatListen(String host, int port, SpelController spelC, SpeelveldController veldC, SpelerController spelerC) throws RemoteException {

        setHost(host);
        setPort(port);

        try {
            registry = LocateRegistry.getRegistry(host,port);
            Interface clientStub = (Interface) registry.lookup("Main.Interface");
            clientStub.registerObserver(this);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
            setSpelC1(spelC);
            setVeldC1(veldC);
            setSpelerC1(spelerC);
    }

    public static void main(String[] args) throws Exception {

    }

    @Override
    public void update(Message message) throws RemoteException {

        System.out.println(message.getSenderName() + ": " + message.getMessage());

    }

    @Override
    public void receiveGame(Spel spelServer, SpeelveldData veldServer) throws RemoteException {

        spelC1.setSpel(spelServer);
        veldC1.setVeldD(veldServer);
        spelerC1.persoonOmdraaien();
        veldC1.ImageSetterALL();
        spelC1.setActiveSpelerPlaatje();
        spelC1.setRollen();
        spelC1.checkTurn();



        // spelC.updateSpel();

    }
}

