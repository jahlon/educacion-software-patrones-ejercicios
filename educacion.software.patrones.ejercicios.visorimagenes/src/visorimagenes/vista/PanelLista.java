package visorimagenes.vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import visorimagenes.modelo.Imagen;

public class PanelLista extends JPanel implements ListSelectionListener {
	private JList<Imagen<ImageIcon>> listImagenes;
	
	private FrameVisorImagenes principal;
	
	
	public PanelLista(FrameVisorImagenes principal) {
		this();
		this.principal = principal;
	}
	
	/**
	 * Create the panel.
	 */
	public PanelLista() {
		setBorder(new TitledBorder(null, "Lista de imagenes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		listImagenes = new JList<Imagen<ImageIcon>>();
		listImagenes.addListSelectionListener(this);
		add(listImagenes, BorderLayout.CENTER);
	}
	
	public void refrescarLista(ArrayList<Imagen<ImageIcon>> imagenes) {
		listImagenes.setListData(imagenes.toArray(new Imagen[0]));
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		principal.cargarImagen(listImagenes.getSelectedValue());
	}
}
