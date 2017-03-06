package tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import static tcp.util.Constants.DEFAULT_REPEAT;


class ProcessConnection implements Runnable{

	private Socket clientSocket;
	private PrintWriter out;
	private int interval = DEFAULT_REPEAT;
	
	public ProcessConnection(Socket clientSocket){
		this.clientSocket = clientSocket;		
	}
	
	private void setRepeatInterval(){
		try {
			InputStream inputStream = clientSocket.getInputStream();
			int receivedInterval = inputStream.read();
			if(receivedInterval > 0){
				this.interval = receivedInterval*1000;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {
			setRepeatInterval();
			OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
			out = new PrintWriter(osw);
			while(true){
				out.println(new Date());
				out.flush();
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class DateTimeServer {
	
	public static void main(String [] args){
		
		try {
			ServerSocket listener = new ServerSocket(7070);
			System.out.println("Server started on port 7070 ... ");
			while(true){
				Socket clientSocket = listener.accept();
				Thread clientThread = new Thread(new ProcessConnection(clientSocket));
				clientThread.start();
				System.out.println("Accepted connection");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
