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


public class Main2 extends Application {
    SpelController spelC;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        spelC = new SpelController();
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

        veldC.setControllers(spelC, spelerC, dobbelC, chatC);
        spelC.setControllers(veldC, spelerC, dobbelC, chatC, spelC, spraakC);
        spelerC.setControllers(veldC, spelC, dobbelC, chatC);
        dobbelC.setControllers(veldC, spelC, spelerC, chatC);
        chatC.setControllers(spelC, veldC, spelerC, dobbelC, chatC);

        spraakC.setControllers(spelC, spelerC);
        spelC.Lobby();
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

 /*printwriter om alles wat in de console uitgeprint wordt in de chat te zetten. Messages worden returned via
  system.out.println en gameberichten ook dus zo kan je ze allebij in de chat zetten.*/
        System.setOut(new PrintStream(System.out) {
            @Override
            public void write(byte[] buf, int off, int len) {
                super.write(buf, off, len);

                String msg = new String(buf, off, len);

                spelC.getChatArea().appendText(msg);
            }
        });
        ChatListen listen = new ChatListen(spelC.getHost(), spelC.getPort(), spelC, veldC);
        veldC.run();

        //This is where the client makes a connection to the server.


//        String naam = "Rafe"; //NAAM CLIENT
//        String ip = "localhost"; //IP SERVER
        try {
            Registry registry = LocateRegistry.getRegistry(spelC.getHost());
            Interface clientStub = (Interface) registry.lookup("Main.Interface");


           // clientStub.registerObserver(impl);


            String naam = spelC.getUsername();
//            String naam2 = "Norddin2";
//            String naam3 = "Norddin3";
//            String naam4 = "Norddin4";
//            String naam5 = "Norddin5";
//            String naam6 = "Norddin6";

            //clientStub.addSpeler(naam);
            //Kleur kleur = clientStub.addSpeler(naam);
            //System.out.println(clientStub.GetSpeler(kleur).getNaam());
            //clientStub.GetSpeler(kleur);
            //spelC.getSpel().setSpelers(clientStub.GetSpeler(kleur));
//            Kleur kleur1 = clientStub.addSpeler(naam2);
//            Kleur kleur2 = clientStub.addSpeler(naam3);
//            Kleur kleur3 = clientStub.addSpeler(naam4);
//            Kleur kleur4 = clientStub.addSpeler(naam5);
//            Kleur kleur5 = clientStub.addSpeler(naam6);

//            System.out.println(clientStub.GetSpeler(kleur));
            ////System.out.println("Je naam is " + clientStub.GetSpeler(kleur).getNaam() + " en je kleur is " + kleur + ".");
//            System.out.println(kleur2);
//            System.out.println(clientStub.GetSpeler(kleur3));
//            System.out.println(kleur3);
//            System.out.println(clientStub.GetSpeler(kleur4));
//            System.out.println(kleur4);
//            System.out.println(clientStub.GetSpeler(kleur5));
//            System.out.println(kleur5);
            //System.out.println(clientStub.getmMap().values());
            //System.out.println(clientStub.getmMap().size());



            InterfaceImpl impl = new InterfaceImpl();
            clientStub.registerObserverSpel(impl);

            //Eerste client set de spel en speelvelddata op server
            clientStub.setFirstTimeSpel(spelC.getSpel());
            clientStub.setFirstTimeData(veldC.getVeldD());
            spelC.setSpel(clientStub.updateGetSpel());
            veldC.setVeldD(clientStub.updateGetData());
            veldC.ImageSetterALL();

            //System.out.println(clientStub.getmMap());

            //TODO DEBUGLINES
//            System.out.println("DEBUGGING STARTED\n \n \nRESPONSES BELOW THIS LINE. \n.............................");
            //System.out.println(clientStub.updateGetSpel());
//            clientStub.updateSetSpel(spelC.getSpel());
//            System.out.println(clientStub.updateGetSpel());
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }
}
