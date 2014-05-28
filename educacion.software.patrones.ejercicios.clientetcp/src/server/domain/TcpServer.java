package server.domain;

import java.io.IOException;
import java.net.ServerSocket;

import common.Constants;

public class TcpServer {
	
	private ServerSocket receiver;
	
	public TcpServer() {
		
	}
	
	public void receiveConnections() {
		try {
			receiver = new ServerSocket( Constants.PORT );
			
			while(true) {
				ClientWorker w = new ClientWorker(receiver.accept());
				Thread t = new Thread(w);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main( String[] args ) {
		TcpServer server = new TcpServer();
		server.receiveConnections();
	}
	
}
