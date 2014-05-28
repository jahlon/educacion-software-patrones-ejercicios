package client.domain;

import java.io.IOException;

import common.TcpConnectionException;

public class WaitingState extends TcpConnectionState {
	
	public WaitingState(TcpClient connection) {
		tcpConnection = connection;
	}

	@Override
	public void openConnection() throws TcpConnectionException {
		throw new TcpConnectionException("La conexión ya está abierta.");
		
	}

	@Override
	public String waitResponse() throws TcpConnectionException {
		String line = "";
		try {
			line = tcpConnection.getIn().readLine();
			tcpConnection.setState(tcpConnection.getEstablishedState());
		} catch (IOException e) {
			throw new TcpConnectionException("Error recibiendo mensaje: " + e.getMessage());
		}
		return line;
	}

	@Override
	public void sendMessage(String msg) throws TcpConnectionException {
		throw new TcpConnectionException("La conexión está en espera de respuesta y no se pueden enviar mensajes");
	}
	
}
