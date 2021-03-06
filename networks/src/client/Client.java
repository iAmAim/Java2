package client;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class Client implements Serializable, Callable<Integer> {
	int number;
	private static final long serialVersionUID = 1L;

	public Client(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Client [number=" + number + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		return compute();
	}

	/** Resource intensive method */
	public Integer compute() {
		// INSERT  algorithm that is resource-intensive
		return this.number * 1000;

	}

}