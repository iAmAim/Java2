package withexecutors;


import java.io.Serializable;
import java.util.concurrent.Callable;

public class Client implements  Computable, Serializable, Callable<Double> {
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
	public Double call() throws Exception {
		
		return compute();
	}

	/** Resource intensive method 
	 * @throws InterruptedException */
	public Double compute() {
		// INSERT  algorithm that is resource-intensive
		System.out.println("\t\tRunning compute() method of Client");
		return this.number * 1000.1;

	}

}