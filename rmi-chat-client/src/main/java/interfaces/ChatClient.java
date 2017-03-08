package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClient extends Remote{

	void update(String dateTime) throws RemoteException;
	String getName() throws RemoteException;
	String getMessage() throws RemoteException;
	void setMessage(String message) throws RemoteException;
	void setName(String username) throws RemoteException;

}
