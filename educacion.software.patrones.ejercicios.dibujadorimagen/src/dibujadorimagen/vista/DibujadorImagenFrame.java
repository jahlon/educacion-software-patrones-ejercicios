package dibujadorimagen.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componentes.dibujadorimagen.PintorAbstracto;
import componentes.dibujadorimagen.PintorImagen;

import dibujadorimagen.vista.decoracion.DecoradorError;

public class DibujadorImagenFrame extends JFrame {

	private JPanel contentPane;
	private PintorAbstracto pintor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DibujadorImagenFrame frame = new DibujadorImagenFrame();
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
	public DibujadorImagenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelDibujo = new JPanel();
		panelDibujo.setBorder(null);
		contentPane.add(panelDibujo, BorderLayout.CENTER);
		panelDibujo.setLayout(null);
		pintor = new PintorImagen("imagenes/dog.png");
		//PintorAbstracto decoEstrella = new DecoradorEstrella(pintor);
		PintorAbstracto decoError = new DecoradorError(pintor);
		//panelDibujo.add(deco1);
		panelDibujo.add(pintor);
		//panelDibujo.add(decoEstrella);
		panelDibujo.add(decoError);
		
		//panelDibujo.validate();
		
	}

}
