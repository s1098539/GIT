package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.PrintStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Application {

    public Server() {}
    private BorderPane borderPane = new BorderPane();
    private FlowPane flowPane = new FlowPane();
    private TextArea chatArea = new TextArea();
    private Button quit = new Button("quit");

    @Override
    public void start(Stage primaryStage) throws Exception {
        borderPane.setCenter(chatArea);

        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().addAll(quit);
        borderPane.setBottom(flowPane);
        chatArea.setEditable(false);

        quit.setOnAction(e -> {
            System.exit(0);
        });

        System.setOut(new PrintStream(System.out) {
            @Override
            public void write(byte[] buf, int off, int len) {
                super.write(buf, off, len);

                String msg = new String(buf, off, len);

                chatArea.appendText(msg);
            }
        });
        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Server console");
        primaryStage.show();
    }



    int port = 1099;
        private void runServer() {
        try {
            //Basically, don't touch this unless you know what you're doing.
            InterfaceImpl impl = new InterfaceImpl();
            Interface serverSkeleton = (Interface) UnicastRemoteObject.exportObject(impl, port);
            System.out.println("Calculator skeleton created");
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("RMI Registry starter ...");
            registry.rebind("main.Interface", serverSkeleton);
            System.out.println("main.Interface skeleton bound ...");
            System.out.println("main.Server running ...");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }
    public static void main(String[] args) {

            new Server().runServer();
            launch(args);
    }

}
