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

        veldC.setControllers(spelC, spelerC, dobbelC, chatC);
        spelC.setControllers(veldC, spelerC, dobbelC, chatC, spelC, spraakC);
        spelerC.setControllers(veldC, spelC, dobbelC, chatC);
        dobbelC.setControllers(veldC, spelC, spelerC, chatC);
        chatC.setControllers(spelC, veldC, spelerC, dobbelC, chatC);

        spraakC.setControllers(spelC, spelerC);
        spelC.Lobby();

        //Prints everything in console to the game chat.
        System.setOut(new PrintStream(System.out) {
            @Override
            public void write(byte[] buf, int off, int len) {
                super.write(buf, off, len);

                String msg = new String(buf, off, len);

                spelC.getChatArea().appendText(msg);
            }
        });
        ChatListen listen = new ChatListen(spelC.getHost(), spelC.getPort(), spelC, veldC, spelerC);
        veldC.run();

        //This is where the client makes a connection to the server.
        try {
            Registry registry = LocateRegistry.getRegistry(spelC.getHost());
            Interface clientStub = (Interface) registry.lookup("Main.Interface");

            //Eerste client set de spel en speelvelddata op server
            clientStub.setSpelData(spelC.getSpel(), veldC.getVeldD());
            spelC.setSpel(clientStub.updateGetSpel());
            veldC.setVeldD(clientStub.updateGetData());
            veldC.ImageSetterALL();

            //Verbind interface met de implementatie.
            InterfaceImpl impl = new InterfaceImpl();
            clientStub.registerObserverSpel(impl);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(":^)");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }
}
