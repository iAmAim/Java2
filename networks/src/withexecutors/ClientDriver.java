package withexecutors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientDriver {

	public static void main(String[] args) {
		//Create x connections that sends a Client Objects to the server
		for (int i = 1; i <= 100; i++) {
			System.out.println("Client: Connecting to Server..");

			try (Socket server = new Socket("127.0.0.1", 8080)) {
				System.out.println("Client: Connected");
				Computable computable = new Client(i);
				send(server, computable);
				receive(server);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void receive(Socket server) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		System.out.println("\tClient: I received "+reader.readLine() + " from server");
	}

	private static void send(Socket server, Computable client) throws IOException {
		System.out.println("Client: I will send: " + client + " to the server");
		ObjectOutputStream outputStream = new ObjectOutputStream(server.getOutputStream());
		outputStream.writeObject(client);
	}
}
