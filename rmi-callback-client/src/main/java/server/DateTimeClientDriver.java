package server;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class DateTimeClientDriver {

	public static void main(String[] args) {

		DateTimeClient client = new DateTimeClientImpl();
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

		try {
			// create Stub (remote)object
			DateTimeClient stub = (DateTimeClient) UnicastRemoteObject.exportObject(client,0);
			
			//look up server object from the registry
			DateTimeServer server = (DateTimeServer)LocateRegistry.getRegistry().lookup("dateTimeServer");
			
			// register the client to the server
			server.register(stub);
			
			
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

}
