package lectorarchivos.vista;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelArchivo extends JPanel {
	
	private FrameLectorArchivo frame;
	private JTextArea textAreaArchivo;
	
	public PanelArchivo(FrameLectorArchivo frame) {
		this();
		this.frame = frame;
	}
	
	/**
	 * Create the panel.
	 */
	protected PanelArchivo() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new BorderLayout(0, 0));
		
		textAreaArchivo = new JTextArea();
		add(textAreaArchivo, BorderLayout.CENTER);
		
		JButton btnAbrirArchivo = new JButton("Abrir archivo");
		btnAbrirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int result = fc.showOpenDialog(frame);
				if(result == JFileChooser.APPROVE_OPTION) {
					frame.abrirArchivo(fc.getSelectedFile());
				}
			}
		});
		add(btnAbrirArchivo, BorderLayout.SOUTH);

	}
	
	public void refrescarContenido(String content) {
		textAreaArchivo.setText(content);
	}
}
