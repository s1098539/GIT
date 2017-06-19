package Main;

import Controller.*;
import Model.Kleur;
import Model.Rol;
import Model.Spel;
import Model.Speler;
import View.SpelView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.PrintStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
        LobbyController lobbyC = new LobbyController(spelerC);

        veldC.setControllers(spelC,spelerC,dobbelC,chatC);
        spelC.setControllers(veldC,spelerC,dobbelC,chatC,spelC,spraakC);
        spelerC.setControllers(veldC,spelC,dobbelC,chatC);
        dobbelC.setControllers(veldC,spelC,spelerC,chatC);
        chatC.setControllers(spelC,veldC,spelerC,dobbelC,chatC);
        spraakC.setController(spelC);

        /*printwriter om alles wat in de console uitgeprint wordt in de chat te zetten. Messages worden returned via
        system.out.println en gameberichten ook dus zo kan je ze allebij in de chat zetten.*/
        String serverAddress = "145.101.88.129";
        String host = serverAddress;
        String username = "test";
        String localMessage = "";
        try {
            Server server = new Server();
            Listen chatlisten = new Listen(host);
            Send sender = new Send(host, username, localMessage);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        System.setOut(new PrintStream(System.out) {
            @Override
            public void write(byte[] buf, int off, int len) {
                super.write(buf, off, len);

                String msg = new String(buf, off, len);

                spelC.getChatArea().appendText(msg);
            }
        });

        veldC.run();

//        Speler test = new Speler("Sam", Kleur.ROOD, "127", 0, 0, 0, 0, Rol.COMMANDANT, true);

    }

}
