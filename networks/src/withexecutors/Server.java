package withexecutors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {

	public static void main(String[] args) throws ClassNotFoundException, InterruptedException, ExecutionException {
		System.out.println("Server: Initializing Server");
		CompletionService<Double> service = new ExecutorCompletionService<Double>(Executors.newFixedThreadPool(10));
		while (true) {
			try (ServerSocket listener = new ServerSocket(8080)) {
				System.out.println("Server: Waiting for clients..");
				Socket serverClient = listener.accept();
				System.out.println("Server: A client is connected, processing request..");

				// Receive object sent by client
				ObjectInputStream inputStream = new ObjectInputStream(serverClient.getInputStream());
				Computable computable = (Client) inputStream.readObject();
				System.out.println("Server: Received object = " + computable);

				// Add to executor service for calculation
				Future<Double> result = service.submit(computable);
				PrintWriter out = new PrintWriter(new OutputStreamWriter(serverClient.getOutputStream()));
				
				//Send result to client
				out.println(result.get().toString());
				out.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
