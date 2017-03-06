package com.producerconsumer;

public class Consumer implements Runnable{

	private Buffer buffer;
	private String decorator;
	
	public Consumer(Buffer buffer, String decorator) {
		this.buffer = buffer;
		this.decorator = decorator;
	}

	@Override
	public void run() {
		
		String data = null;
		while(!("end".equals(data))){
			data = buffer.getMessage();
			System.out.println("Read: " + decorator + data);
		}
		System.out.println("Consumer ends.");
	}

}
