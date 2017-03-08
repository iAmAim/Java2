package server;

import java.rmi.RemoteException;

import compute.ComputeTask;
import compute.Task;

public class ComputeTaskService implements ComputeTask {
	public <T> T executeTask(Task<T> t) throws RemoteException {
		return t.execute();
	}

}
