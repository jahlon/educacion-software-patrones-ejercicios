package client.domain;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import common.TcpConnectionException;

public class TcpClient {
	
	private String url;
	private int port;
	
	protected Socket channel;
	protected PrintWriter out;
	protected BufferedReader in;
	
	protected TcpConnectionState establishedState;
	protected TcpConnectionState waitingState;
	protected TcpConnectionState closedState;
	
	protected TcpConnectionState state;
	
	public TcpClient(String url, int port) {
		establishedState = new EstablishedState(this);
		waitingState = new WaitingState(this);
		closedState = new ClosedState(this);
		
		this.url = url;
		this.port = port;
		
		state = closedState;
	}
	
	public void open() throws TcpConnectionException {
		state.openConnection();
	}
	
	public String waitResponse() throws TcpConnectionException {
		return state.waitResponse();
	}
	
	public void send(String msg) throws TcpConnectionException {
		state.sendMessage(msg);
	}
	
	public void close() throws TcpConnectionException {
		state.closeConnection();
	}
	
	void setState(TcpConnectionState state) {
		this.state = state;
	}
	
	public TcpConnectionState getEstablishedState() {
		return establishedState;
	}

	public TcpConnectionState getWaitingState() {
		return waitingState;
	}

	public TcpConnectionState getClosedState() {
		return closedState;
	}

	public Socket getChannel() {
		return channel;
	}

	public void setChannel(Socket channel) {
		this.channel = channel;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
