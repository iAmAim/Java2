package com.producerconsumer;
public class Driver {

	public static void main(String[] args) {
		
		
		System.out.println("Demo Producer Consumer");
		Buffer buffer = new Buffer();
		Thread producerThread =new Thread( new Producer(buffer));
		Thread consumerThread1 =new Thread( new Consumer(buffer, "###"));
		Thread consumerThread2 =new Thread( new Consumer(buffer, "!!!"));
		Thread consumerThread3 =new Thread( new Consumer(buffer, ">>>"));
		producerThread.start();
		
		// There is no guarantee which consumer receives the message. notifyAll() notfies
		// all the threads, but we do not have mechanism setup to handle which consumers
		// will wait() 
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();
	}

}
