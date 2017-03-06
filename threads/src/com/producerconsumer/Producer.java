package com.producerconsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producer implements Runnable {

	private Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String line = null;
		try {
			while (!"end".equals(line)) {
				line = br.readLine();
				buffer.addMessage(line);
			}
			System.out.println("producer ends.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
