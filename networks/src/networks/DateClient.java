package networks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import client.Client;

public class DateClient {

	public static void main(String[] args) {
		//Create 10 connections that sends a Client Objects to the server
		for (int i = 0; i < 10; i++) {
			System.out.println("Client connecting..");

			try (Socket server = new Socket("127.0.0.1", 8080)) {
				System.out.println("Client connected");
				sendClientObjectToServer(server);
				receiveResultFromServer(server);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void receiveResultFromServer(Socket server) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		System.out.println(reader.readLine());
	}

	public static void sendClientObjectToServer(Socket server) throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(server.getOutputStream());
		Client client = new Client(5);
		System.out.println("Object to be sent to server: " + client);
		outputStream.writeObject(client);
	}
}
