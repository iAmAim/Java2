package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DateTimeServerDriver {

	
	public static DateTimeServerImpl dateTimeServer = new DateTimeServerImpl();
	public static void main(String[] args) {

		try {
			DateTimeServer stub = (DateTimeServer) UnicastRemoteObject.exportObject(dateTimeServer, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("dateTimeServer", stub);
			System.out.println("Date Time server ready.....");
			processClients();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
	private static void processClients() {
		
		while(true) {
			dateTimeServer.updateClients();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
