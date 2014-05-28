package client.domain;

import java.io.IOException;

import common.TcpConnectionException;

public abstract class TcpConnectionState {
	
	protected TcpClient tcpConnection;
	
	public abstract void openConnection() throws TcpConnectionException;
	public abstract String waitResponse() throws TcpConnectionException;
	public abstract void sendMessage(String msg) throws TcpConnectionException;
	
	public void closeConnection() throws TcpConnectionException {
		try {
			tcpConnection.getIn().close();
			tcpConnection.getOut().close();
			tcpConnection.getChannel().close();
			tcpConnection.setState(tcpConnection.getClosedState());
		} catch (IOException e) {
			throw new TcpConnectionException("Error cerrando la conexión: " + e.getMessage());
		}
	}
	
}
