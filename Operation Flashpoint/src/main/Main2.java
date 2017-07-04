package main;

import controller.*;
import view.SpelView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.PrintStream;
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

        //This is where the client makes a connection to the server.
        try {
        Listen listen = new Listen(spelC.getHost(), spelC.getPort(), spelC, veldC, spelerC);
        spelC.setListen(listen);

        Registry registry = LocateRegistry.getRegistry(spelC.getHost());
        Interface clientStub = (Interface) registry.lookup("main.Interface");

        veldC.run();

            //clients setten de spel en speelvelddata voor iedereen op server
            clientStub.setSpelData(spelC.getSpel(), veldC.getVeldD());
            spelC.setSpel(clientStub.updateGetSpel());
            veldC.ImageSetterALL();
            spelC.setNamen();

            //Verbind interface met de implementatie.
            InterfaceImpl impl = new InterfaceImpl();
            spelC.setImpl(impl);
            clientStub.registerObserverSpel(spelC.getImpl());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(":^)");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }

}
