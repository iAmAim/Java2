package chatclient;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import factory.ClientFactory;
import interfaces.ChatClient;
import interfaces.ChatServer;

public class ChatServiceManager {
	private ChatServer server;

	public ChatServiceManager() throws AccessException, RemoteException, NotBoundException {
		server = (ChatServer) LocateRegistry.getRegistry().lookup("chatServer");
	}

	public String registerUser(String username) throws RemoteException, NotBoundException {

		if (isExistingUser(username)) {
			return "User already exists";
		}
		ChatClient client = ClientFactory.createClient(username);
		ChatClient stub = (ChatClient) UnicastRemoteObject.exportObject(client, 0);
		return server.register(stub);

	}

	public void sendMessage(String[] messageArr) throws RemoteException {
		server.receiveMessage(messageArr);
	}

	// TODO: move this implementation to server
	public boolean isExistingUser(String username) throws RemoteException, NotBoundException {

		Set<ChatClient> users = server.getUsers();
		for (ChatClient user : users) {
			if (user.getName().equals(username)) {
				return true;
			}
		}

		return false;
	}

	public String getWelcomeMessage() throws RemoteException {
		return server.getWelcomeMessage();
	}

}
