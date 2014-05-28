package client.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class ClientFormPanel extends JPanel {
	private JTextArea taMessages;
	
	private StateExampleFrame mainFrame;
	private JTextField tfMessage;
	
	public ClientFormPanel(StateExampleFrame mainFrame) {
		this();
		this.mainFrame = mainFrame;
	}
	
	/**
	 * Create the panel.
	 */
	public ClientFormPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		taMessages = new JTextArea();
		taMessages.setEditable(false);
		scrollPane.setViewportView(taMessages);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		FormLayout fl_panel_2 = new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("44px:grow"),
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,});
		panel_2.setLayout(fl_panel_2);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		panel_2.add(lblMensaje, "1, 2, left, center");
		
		tfMessage = new JTextField();
		panel_2.add(tfMessage, "2, 2, fill, default");
		tfMessage.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		panel_2.add(btnEnviar, "3, 2");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = tfMessage.getText();
				mainFrame.sendMessage(msg);
				//taMessages.append(msg);
			}
		});
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.openConnection();
			}
		});
		panel_1.add(btnConectar);
		
		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.closeConnection();
			}
		});
		panel_1.add(btnDesconectar);

	}
	
	public void addResponse(String response) {
		taMessages.append("\n" + response);
	}
}
