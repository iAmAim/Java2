package server;

import java.rmi.RemoteException;

public class DateTimeClientImpl implements DateTimeClient {

	public void update(String dateTime) throws RemoteException {
		System.out.println("dateTime is: " + dateTime);
	}

}
