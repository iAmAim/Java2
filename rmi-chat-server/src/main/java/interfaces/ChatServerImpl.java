package interfaces;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;

public class ChatServerImpl implements ChatServer {

	private Set<ChatClient> clients = new CopyOnWriteArraySet<>();
	private ConcurrentLinkedQueue<ChatClient> messageQueue = new ConcurrentLinkedQueue<>();

	public void register(ChatClient client) throws RemoteException {

		clients.add(client);
	}

	public String sayHello(ChatClient client) {

		return "Welcome to mIRC version 2.0!!";
	}

	// Runs every second
	public void updateClients() {
		Date now = new Date();
		ChatClient currentClient = messageQueue.poll();
		String msg = "";
		if (currentClient != null) {
			String name = "";
			// Build the text e.g. name + message + date etc.
			try {
				name = currentClient.getName();
				msg = name + "(" + now + "): " + currentClient.getMessage();
			} catch (RemoteException e) {
				e.printStackTrace();
			}

			// Update all clients
			for (ChatClient client : clients) {
				try {
					client.update(msg);
				} catch (RemoteException ex) {
					clients.remove(client);
					ex.printStackTrace();
				}
			}
		}

	}

	@Override
	public void receiveMessage(ChatClient client) throws RemoteException {
		messageQueue.add(client);

	}

}
