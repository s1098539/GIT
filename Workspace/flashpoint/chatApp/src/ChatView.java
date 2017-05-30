import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChatView extends Application {

	private BorderPane borderPane = new BorderPane();
	private FlowPane flowPane = new FlowPane();
	private HBox hbox = new HBox(5);

	private Label bericht = new Label("Bericht:");
	private TextField textInput = new TextField();
	private TextArea chatArea = new TextArea();
	private Button stuurBericht = new Button("Stuur");
	private Button quit = new Button("quit");
	ChatSend sender;
	String message;
	String berichtServer = null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		borderPane.setCenter(chatArea);
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.getChildren().addAll(bericht, textInput);

		borderPane.setTop(hbox);
		flowPane.setAlignment(Pos.CENTER);
		flowPane.getChildren().addAll(textInput, stuurBericht, quit);
		borderPane.setTop(hbox);
		borderPane.setBottom(flowPane);
		chatArea.setEditable(false);
		ChatServer chat = new ChatServer();
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setHeaderText("Voer het IP-adres van de host in");
		dialog.setContentText("IP-adres:");

		TextInputDialog dialog2 = new TextInputDialog("");
		dialog2.setHeaderText("Voer je naam in");
		dialog2.setContentText("Naam: ");

		Optional<String> ipadress = dialog.showAndWait();
		    String host = ipadress.get();

		Optional<String> naam = dialog2.showAndWait();
		String username = naam.get();
		String serverAddress = host;

		ChatListen chatlisten = new ChatListen(serverAddress);


			sender = new ChatSend(host, username, message);

		quit.setOnAction(e -> {
									System.exit(0);
								});

		textInput.setOnAction(e -> {
			String message = textInput.getText();


			try {
						sender.sendMessageObject(username, message);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						textInput.setText("");
				});

		stuurBericht.setOnAction(e -> {
			String message = textInput.getText();

						try {
							sender.sendMessageObject(username, message);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

			textInput.setText("");
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
		primaryStage.setTitle("Chat");
		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);

		}

	}



