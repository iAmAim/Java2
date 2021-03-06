package networks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import client.Client;

public class DateServer {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Starting Server app");
		while (true) {
			try (ServerSocket listener = new ServerSocket(8080)) {
				System.out.println("Waiting for connecting clients..");
				Socket serverClient = listener.accept();
				System.out.println("A client magically appeared!");

				// Read object sent by client and return response.

				ObjectInputStream inStream = new ObjectInputStream(serverClient.getInputStream());

				Client client = (Client) inStream.readObject();
				System.out.println("Object received = " + client);

				PrintWriter out = new PrintWriter(new OutputStreamWriter(serverClient.getOutputStream()));
				out.println("Server says the date is: " + new Date());
				out.flush();
			} catch (IOException e) {
				System.out.println("error");
			}
		}

	}

}
