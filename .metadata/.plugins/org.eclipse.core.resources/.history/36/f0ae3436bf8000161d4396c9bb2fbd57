package tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import static tcp.util.Constants.DEFAULT_REPEAT;

class DateTimeProcessor{
	
	
	private void sendRepeatTimeInterval(Socket socket, int interval){
		try {
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(interval);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private int getRepeatInterval(String []args){
		int interval = DEFAULT_REPEAT;
		if(args.length >= 1){
			try{
			    interval = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		return interval;
	}
	
	public void fetchDataTime(String []args){
		try {
			Socket inputSocket = new Socket("127.0.0.1",7070);
			sendRepeatTimeInterval(inputSocket, getRepeatInterval(args));
	
			InputStreamReader inputReader = new InputStreamReader(inputSocket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputReader);
			while(true){
				System.out.println(bufferedReader.readLine());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

public class DateTimeClient {
	 
	public static void main(String[] args) {
		DateTimeProcessor processor = new DateTimeProcessor();
		processor.fetchDataTime(args);
	}

}
