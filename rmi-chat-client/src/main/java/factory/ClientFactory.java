package factory;

import chatclient.ChatClientImpl;
import interfaces.ChatClient;

public class ClientFactory {

	
	public static ChatClient createClient(String name) {
		
		return new ChatClientImpl(name);
			
	}
}
