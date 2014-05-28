package server.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientWorker implements Runnable {
	
	protected Socket client;
	
	public ClientWorker(Socket client) {
		this.client = client; 
	}
	
	@Override
	public void run() {
		String line;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while( true ) {
			try {
				// Read line form client
				line = in.readLine();
				
				// Respond to client
				out.println("Recibido (" + new Date() + "): " + line);				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
