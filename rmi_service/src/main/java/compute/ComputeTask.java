package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputeTask extends Remote {
	<T> T executeTask(Task<T> t) throws RemoteException;
}
