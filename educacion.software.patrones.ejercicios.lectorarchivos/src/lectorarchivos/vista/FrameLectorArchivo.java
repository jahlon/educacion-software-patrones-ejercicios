package lectorarchivos.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lectorarchivos.modelo.FiltroEspacioAGuionBajo;
import lectorarchivos.modelo.FiltroMayusculaAMiniscula;
import lectorarchivos.modelo.Lector;
import lectorarchivos.modelo.LectorArchivo;
import lectorarchivos.modelo.LecturaException;

public class FrameLectorArchivo extends JFrame {

	private JPanel contentPane;
	private Lector lector;
	private PanelOpciones panelOpciones;
	private PanelArchivo panelArchivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLectorArchivo frame = new FrameLectorArchivo();
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
	public FrameLectorArchivo() {
		setTitle("Lector de archivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelArchivo = new PanelArchivo(this);
		contentPane.add(panelArchivo, BorderLayout.CENTER);
		
		panelOpciones = new PanelOpciones();
		panelArchivo.add(panelOpciones, BorderLayout.NORTH);
		
	}

	public void abrirArchivo(File selectedFile) {
		lector = new LectorArchivo(selectedFile.getAbsolutePath());
		
		if(panelOpciones.filtroEspacioAGuionActivado()) {
			lector = new FiltroEspacioAGuionBajo(lector);
		}
		
		if(panelOpciones.filtroMayusculaAMinuscalaActivado()) {
			lector = new FiltroMayusculaAMiniscula(lector);
		}
		
		String contenido = leer();	
		
		panelArchivo.refrescarContenido(contenido);
		
	}

	private String leer() {
		StringBuilder contenido = new StringBuilder();
		int b;
		try {
			while( -1 != (b=lector.leer()) ) {
				contenido.append((char)b);
			}
			lector.cerrar();
		} catch (LecturaException e) {
			JOptionPane.showMessageDialog(this, "Error de lectura", "Lector de Archivo", JOptionPane.ERROR_MESSAGE);
		}
		
		return contenido.toString();
	}
}
