package com.basic;

public class Numbers implements Runnable {

	private int delay = 0;
	private int start = 0;
	private int end = 0;

	public Numbers(int start, int end, int delay) {
		this.delay = delay;
		this.start = start;
		this.end = end;
	}



	public int getDelay() {
		return delay;
	}



	public void setDelay(int delay) {
		this.delay = delay;
	}



	public int getStart() {
		return start;
	}



	public void setStart(int start) {
		this.start = start;
	}



	public int getEnd() {
		return end;
	}



	public void setEnd(int end) {
		this.end = end;
	}



	public  void printNumbers() throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			System.out.println("number " + i);
			Thread.sleep(this.delay*1000);
		}
	}

	@Override
	public void run() {
		
		try {
			printNumbers();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
