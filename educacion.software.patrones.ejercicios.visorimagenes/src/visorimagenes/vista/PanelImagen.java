package visorimagenes.vista;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelImagen extends JPanel {
	private JLabel lbImagen;

	/**
	 * Create the panel.
	 */
	public PanelImagen() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		lbImagen = new JLabel("");
		scrollPane.setViewportView(lbImagen);

	}
	
	public void mostrarImagen(ImageIcon img) {
		lbImagen.setIcon(img);
	}

}
