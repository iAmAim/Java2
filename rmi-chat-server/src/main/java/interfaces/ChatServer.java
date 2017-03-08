package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServer extends Remote{

	void register(ChatClient client) throws RemoteException;
	void receiveMessage(ChatClient client) throws RemoteException;
	String sayHello(ChatClient client)   throws RemoteException;
}
