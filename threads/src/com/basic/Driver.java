package com.basic;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws InterruptedException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter starting number: ");
		int start = scanner.nextInt();
		System.out.println("Enter end number ");
		int end = scanner.nextInt();
		System.out.println("Enter delay in seconds: ");
		int delay = scanner.nextInt();
		Numbers numbers = new Numbers(start, end, delay);

		Thread t1 = new Thread(numbers);
		t1.start();
		scanner.close();
	}

}
