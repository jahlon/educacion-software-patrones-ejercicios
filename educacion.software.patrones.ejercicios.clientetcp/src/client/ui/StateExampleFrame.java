package client.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Constants;
import common.TcpConnectionException;

import client.domain.TcpClient;

@SuppressWarnings("serial")
public class StateExampleFrame extends JFrame {

	private JPanel contentPane;
	private TcpClient client;
	private ClientFormPanel clientFormPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StateExampleFrame frame = new StateExampleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StateExampleFrame() {
		setResizable(false);
		setTitle("State pattern example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		clientFormPanel = new ClientFormPanel(this);
		contentPane.add(clientFormPanel, BorderLayout.CENTER);
		
		client = new TcpClient(Constants.URL, Constants.PORT);
	}
	
	public void openConnection() {
		try {
			client.open();
			clientFormPanel.addResponse("[Conexión establecida]");
		} catch (TcpConnectionException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "State Pattern Example", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void closeConnection() {
		try {
			client.close();
			clientFormPanel.addResponse("[Conexión cerrada]");
		} catch (TcpConnectionException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "State Pattern Example", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void sendMessage(String msg) {
		try {
			client.send(msg);
			clientFormPanel.addResponse(msg);
			String response = client.waitResponse();
			clientFormPanel.addResponse(response);
		} catch (TcpConnectionException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "State Pattern Example", JOptionPane.ERROR_MESSAGE);
		}
	}
}
