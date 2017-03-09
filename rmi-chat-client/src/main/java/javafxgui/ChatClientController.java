package javafxgui;

import java.net.URL;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import chatclient.ChatServiceManager;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ChatClientController {
	@FXML
	// The reference of inputText will be injected by the FXML loader
	private TextField inputText;

	@FXML
	private TextArea chatTextArea;

	// The reference of outputText will be injected by the FXML loader
	@FXML
	private static TextArea outputText;
	@FXML
	private Button okBtn;

	// location and resources will be automatically injected by the FXML loader
	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	// Add a public no-args constructor
	public ChatClientController() {
	}

	ChatServiceManager service;

	@FXML
	private void initialize() throws AccessException, RemoteException, NotBoundException {
		service = new ChatServiceManager();

		chatTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent keyEvent) {
		        if (keyEvent.getCode() == KeyCode.ENTER)  {
		        	try {
						sendMessage();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
		        }
		    }
		});
	}

	private String username;

	@FXML
	private void printJoinChatroom() throws AccessException, RemoteException, NotBoundException {
		String serverMessage, username;
		username = inputText.getText();
		serverMessage = service.registerUser(username);
		if (serverMessage.equals(service.getWelcomeMessage())) {
			this.username = username;
			okBtn.setDisable(true);
			chatTextArea.requestFocus();
		}
		outputText.setText(serverMessage);
	}

	@FXML
	private void sendMessage() throws RemoteException {
		String text = chatTextArea.getText();
		if (text.equals("exit")) {
			Platform.exit();
		} 
		
		service.sendMessage(new String[] { username, text });
		chatTextArea.clear();
		
	}

	public static void updateChatBox(final String broadcastMessage) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				outputText.appendText("\n" + broadcastMessage);
			}
		});

	}
}
