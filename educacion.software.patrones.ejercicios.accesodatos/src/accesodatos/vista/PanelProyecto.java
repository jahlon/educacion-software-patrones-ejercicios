package accesodatos.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import accesodatos.modelo.Proyecto;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PanelProyecto extends JPanel {
	private JTextField txtId;
	private JTextField txtNombre;
	private FrameAccesoDatos frame;
	private JTextArea txtrDescripcion;
	
	
	

	public PanelProyecto(FrameAccesoDatos frame) {
		this();
		this.frame = frame;
	}
	
	
	protected PanelProyecto() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		FormLayout fl_panel = new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.MIN_ROWSPEC,});
		panel.setLayout(fl_panel);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		panel.add(lblCodigo, "2, 2, right, default");
		
		txtId = new JTextField();
		panel.add(txtId, "4, 2, fill, default");
		txtId.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.buscarProyecto(txtId.getText());
			}
		});
		panel.add(btnBuscar, "6, 2");
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre, "2, 4, right, default");
		
		txtNombre = new JTextField();
		panel.add(txtNombre, "4, 4, fill, default");
		txtNombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		panel.add(lblDescripcin, "2, 6, default, top");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "4, 6, fill, fill");
		
		txtrDescripcion = new JTextArea();
		scrollPane.setViewportView(txtrDescripcion);
		
		JPanel panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		panel.add(panelBotones, "1, 8, 6, 1, fill, top");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.guardarProyecto(txtId.getText(), txtNombre.getText(), txtrDescripcion.getText());
			}
		});
		panelBotones.add(btnGuardar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.borrarProyecto(txtId.getText());
			}
		});
		panelBotones.add(btnBorrar);

	}


	public void limpiarFormulario() {
		txtId.setText("");
		txtNombre.setText("");
		txtrDescripcion.setText("");
	}


	public void refrescarFormulario(Proyecto p) {
		txtId.setText(p.getCodigo());
		txtNombre.setText(p.getNombre());
		txtrDescripcion.setText(p.getDescripcion());
	}
}
