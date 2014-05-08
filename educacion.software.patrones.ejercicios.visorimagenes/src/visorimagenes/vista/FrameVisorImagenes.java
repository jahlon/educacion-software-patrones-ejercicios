package visorimagenes.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visorimagenes.modelo.Imagen;
import visorimagenes.modelo.Visualizador;

public class FrameVisorImagenes extends JFrame {

	private JPanel contentPane;
	private PanelLista panelLista;
	private PanelImagen panelImage;
	
	private Visualizador visualizador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVisorImagenes frame = new FrameVisorImagenes();
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
	public FrameVisorImagenes() {
		visualizador = new Visualizador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelLista = new PanelLista(this);
		panelLista.setPreferredSize(new Dimension(200, 300));
		contentPane.add(panelLista, BorderLayout.EAST);
		
		panelImage = new PanelImagen();
		contentPane.add(panelImage, BorderLayout.CENTER);
				
		panelLista.refrescarLista(visualizador.listarImagenes());
		
	}
	
	public void cargarImagen(Imagen<ImageIcon> imagen) {
		imagen.cargar();
		panelImage.mostrarImagen(imagen.getImagen());
	}
}
