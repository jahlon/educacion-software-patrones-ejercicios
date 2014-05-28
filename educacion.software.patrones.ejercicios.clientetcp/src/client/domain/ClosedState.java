package client.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import common.TcpConnectionException;

public class ClosedState extends TcpConnectionState {
	
	public ClosedState(TcpClient connection) {
		tcpConnection = connection;
	}

	@Override
	public void openConnection() throws TcpConnectionException {
			try {
				Socket channel = new Socket(tcpConnection.getUrl(), tcpConnection.getPort());
				tcpConnection.setChannel(channel);
				tcpConnection.setIn(new BufferedReader(new InputStreamReader(channel.getInputStream())));
				tcpConnection.setOut(new PrintWriter(channel.getOutputStream(), true));
				tcpConnection.setState(tcpConnection.getEstablishedState());
			} catch (IOException e) {
				throw new TcpConnectionException("Error estableciendo la conexión: " + e.getMessage());
			}
	}

	@Override
	public String waitResponse() throws TcpConnectionException {
		throw new TcpConnectionException("No se puede esperar respuesta si la conexión está cerrada.");		
	}

	@Override
	public void sendMessage(String msg) throws TcpConnectionException {
		throw new TcpConnectionException("No se pueden enviar mensajes si la conexión está cerrada.");	
	}

	@Override
	public void closeConnection() throws TcpConnectionException {
		throw new TcpConnectionException("La conexión ya se encuentra cerrada.");	
	}
	
}
