package com.producerconsumer;

public class Buffer {

	private StringBuffer data = new StringBuffer();

	public synchronized String getMessage() {
		String returnVal = null;
		try {
			while (data == null || data.length() == 0) {
				System.out.println("Taling " + Thread.currentThread().getName());
				wait();
				returnVal = data.toString();
			}
			data = new StringBuffer(); // reset data buffer
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("returning :" +returnVal);
		return returnVal;

	}

	public synchronized void addMessage(String message) {
		this.data.append(message);
		notifyAll();
	}

}
