package concurrency;

import java.util.concurrent.Callable;

public class CallableInt implements Callable<Integer> {

	String word;
	String mode;

	public CallableInt(String word, String mode) {
		this.word = word;
		this.mode = mode;
	}

	@Override
	public Integer call() throws Exception {
		if (mode.toLowerCase().equals("c")) {
			return word.length();
		} else if (mode.toLowerCase().equals("w")) {
			return word.split("\\s+").length;
		} else {

		}
		throw new Exception();
	}

}
