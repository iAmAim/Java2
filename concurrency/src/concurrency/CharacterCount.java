package concurrency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class CharacterCount {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		String fileName = args[0], mode = args[1];
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
			int total = 0, totalLines = 0;
			String lineOfText;
			CompletionService<Integer> service = new ExecutorCompletionService<Integer>(
					Executors.newFixedThreadPool(3));

			while ((lineOfText = reader.readLine()) != null) {
				Callable<Integer> callable = new CallableInt(lineOfText, mode);
				service.submit(callable);
				totalLines++;
			}

			while (totalLines > 0) {
				total += service.take().get();
				totalLines--;
			}
			System.out.println("Total " + mode + " is: " + total);

		} catch (Exception e) {
			System.out.println("Exception occured: be more specific what happened :p");
		}
	}
}
