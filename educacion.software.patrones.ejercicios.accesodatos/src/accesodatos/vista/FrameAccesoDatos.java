package accesodatos.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesodatos.modelo.Proyecto;
import accesodatos.modelo.dao.DAOFactory;
import accesodatos.modelo.dao.ProyectoDAO;

public class FrameAccesoDatos extends JFrame {

	private JPanel contentPane;
	private PanelProyecto panelPersona;

	/**
	 * Create the frame.
	 */
	public FrameAccesoDatos() {
		setTitle("Acceso a datos - Proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		panelPersona = new PanelProyecto(this);
		contentPane.add(panelPersona, BorderLayout.CENTER);
	}

	public void guardarProyecto(String id, String nombre, String descripcion) {
		Proyecto p = new Proyecto(id, nombre, descripcion);
		DAOFactory factory;
		try {
			factory = DAOFactory.getDAOFactory();
			ProyectoDAO dao = factory.getProyectoDAO();
			if(dao.find(id) == null) {
				dao.insert(p);
				JOptionPane.showMessageDialog(this, "Elemento insertado!", "Acceso Datos", JOptionPane.INFORMATION_MESSAGE);
				panelPersona.limpiarFormulario();
			} else {
				dao.update(p);
				JOptionPane.showMessageDialog(this, "Elemento actualizado!", "Acceso Datos", JOptionPane.INFORMATION_MESSAGE);
				panelPersona.limpiarFormulario();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error guardando proyecto: " + e.getMessage(),"Acceso Datos", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	public void borrarProyecto(String id) {
		try {
			DAOFactory factory = DAOFactory.getDAOFactory();
			ProyectoDAO dao = factory.getProyectoDAO();
			dao.delete(id);
			JOptionPane.showMessageDialog(this, "Elemento borrado!", "Acceso Datos", JOptionPane.INFORMATION_MESSAGE);
			panelPersona.limpiarFormulario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void buscarProyecto(String id) {
		
		try {
			DAOFactory factory = DAOFactory.getDAOFactory();
			ProyectoDAO dao = factory.getProyectoDAO();
			Proyecto p = dao.find(id);
			if(p == null) {
				JOptionPane.showMessageDialog(this, "Elemento no encontrado!", "Acceso Datos", JOptionPane.INFORMATION_MESSAGE);
			} else {
				panelPersona.refrescarFormulario(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
