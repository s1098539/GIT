package Main;

import Controller.*;
import Model.*;
import View.SpelView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.PrintStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static javafx.application.Application.launch;


public class Main2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SpelController spelC = new SpelController();
        SpelView spelView = new SpelView(spelC);
        primaryStage.setScene(spelView.getScene());
        primaryStage.setTitle("Flash point");
        primaryStage.show();
        System.out.println("The Application has started.");

        SpeelveldController veldC = new SpeelveldController();
        SpelerController spelerC = new SpelerController();
        DobbelsteenController dobbelC = new DobbelsteenController();
        ChatController chatC = new ChatController();
        SpraakController spraakC = new SpraakController();
        LobbyController lobbyC = new LobbyController(spelerC, spelC);

        veldC.setControllers(spelC,spelerC,dobbelC,chatC);
        spelC.setControllers(veldC,spelerC,dobbelC,chatC,spelC,spraakC);
        spelerC.setControllers(veldC,spelC,dobbelC,chatC);
        dobbelC.setControllers(veldC,spelC,spelerC,chatC);
        chatC.setControllers(spelC,veldC,spelerC,dobbelC,chatC);

        spraakC.setControllers(spelC, spelerC);
        /*printwriter om alles wat in de console uitgeprint wordt in de chat te zetten. Messages worden returned via
        system.out.println en gameberichten ook dus zo kan je ze allebij in de chat zetten.*/
//        String serverAddress = "145.101.88.129";
//        String host = serverAddress;
//        String username = "test";
//        String localMessage = "";
//        try {
//            Server server = new Server();
//            Listen chatlisten = new Listen(host);
//            Send sender = new Send(host, username, localMessage);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        }
//

//        spraakC.setController(spelC);


//        System.setOut(new PrintStream(System.out) {
//            @Override
//            public void write(byte[] buf, int off, int len) {
//                super.write(buf, off, len);
//
//                String msg = new String(buf, off, len);
//
//                spelC.getChatArea().appendText(msg);
//            }
//        });

        veldC.run();

        //This is where the client makes a connection to the server.
        String naam = "Rafe"; //NAAM CLIENT
        String ip = "localhost"; //IP SERVER


        try {
            System.out.println("Getting access to the registry ...");
            Registry registry = LocateRegistry.getRegistry(ip);
            System.out.println("Getting the Main.Interface stub from registry ...");
            Interface clientStub = (Interface) registry.lookup("Main.Interface");

            //TODO DEBUGLINES
            System.out.println("DEBUGGING STARTED\n \n \nRESPONSES BELOW THIS LINE. \n............................." );
            clientStub.sendParse().setVeldD(veldC.getVeldD());
            System.out.println(clientStub.sendParse().getVeldD());
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }
}
