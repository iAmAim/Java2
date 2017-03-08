package chatclient;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import interfaces.ChatClient;
import interfaces.ChatServer;

public class ChatClientDriver {

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {

			while (true) {

				ChatClient client = new ChatClientImpl();
				// create Stub (remote)object
				ChatClient stub = (ChatClient) UnicastRemoteObject.exportObject(client, 0);

				// look up server object from the registry
				ChatServer server = (ChatServer) LocateRegistry.getRegistry().lookup("chatServer");

				
				// TODO: Validate the username if it is valid or duplicate
				System.out.println("Enter your username: ");
				String username = getInput();
				client.setName(username);
				
				
				
				
				//WElcome the user to the chat room!
				String helloFromServer = server.sayHello(stub);

				System.out.println("Server says: " + helloFromServer);
				server.register(stub);

				while (true) {
					System.out.println(">");
					String message = getInput();
					client.setMessage(message);
					server.receiveMessage(client);
				}
			}

			// register the client to the server
			// server.register(stub);

		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static String getInput() {
		try(Scanner scanner = new Scanner(System.in)){		
			String input = scanner.nextLine();
			return input;
		}
	}

}