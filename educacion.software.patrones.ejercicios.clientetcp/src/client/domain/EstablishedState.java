package client.domain;

import common.TcpConnectionException;

public class EstablishedState extends TcpConnectionState {
	
	public EstablishedState(TcpClient connection) {
		tcpConnection = connection;
	}

	@Override
	public void openConnection() throws TcpConnectionException {
		throw new TcpConnectionException("La conexión ya está abierta.");
	}

	@Override
	public String waitResponse() throws TcpConnectionException {
		throw new TcpConnectionException("No hay respuestas pendientes");	
	}

	@Override
	public void sendMessage(String msg) throws TcpConnectionException {
		tcpConnection.getOut().println(msg);
		tcpConnection.setState(tcpConnection.getWaitingState());
	}
	
}
