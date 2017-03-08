package client;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.ComputeTask;
import compute.Task;

public class CurrencyClient {

	public static void main(String[] args) {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			ComputeTask converterService = (ComputeTask) registry.lookup("converter");
			CurrencyConverter c = new CurrencyConverter(100);
			double amountInEuros = converterService.executeTask(c);
			System.out.format("100 pounds in euro is %.2f", amountInEuros);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

 class CurrencyConverter implements Task<Double>, Serializable {

    private static final long serialVersionUID = 227L;
    private final static double POUNDS_TO_EURO = 1.25;
	private double amount;

    CurrencyConverter(double amount){  	
    	this.amount = amount;
    }
    
	public Double execute() {
		return convertPoundsToEuro(this.amount);
	}
	
	public double convertPoundsToEuro(double pounds) {

		return pounds * POUNDS_TO_EURO;
	}
    
}