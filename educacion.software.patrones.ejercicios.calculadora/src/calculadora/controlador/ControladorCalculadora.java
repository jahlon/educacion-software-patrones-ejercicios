package calculadora.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculadora.modelo.Calculadora;
import calculadora.modelo.ComandoCalculadora;
import calculadora.modelo.Division;
import calculadora.modelo.Multiplicacion;
import calculadora.modelo.Resta;
import calculadora.modelo.Suma;
import calculadora.modelo.Usuario;
import calculadora.vista.IVistaCalculadora;

public class ControladorCalculadora implements ActionListener {
	
	// Vista
	private IVistaCalculadora vista;
	
	// Modelo
	private Calculadora modelo;
	
	private Usuario usuario;
	
	public ControladorCalculadora(IVistaCalculadora vista, Calculadora modelo, Usuario usuario) {
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ComandoCalculadora comando = null;
		if(e.getActionCommand().equals(IVistaCalculadora.SUMA)) {
			comando = new Suma(vista.getOperando(), modelo);
		} else if(e.getActionCommand().equals(IVistaCalculadora.RESTA)) {
			comando = new Resta(vista.getOperando(), modelo);
		} else if(e.getActionCommand().equals(IVistaCalculadora.MULTIPLICACION)){
			comando = new Multiplicacion(vista.getOperando(), modelo);
		} else if(e.getActionCommand().equals(IVistaCalculadora.DIVISION)) {
			comando = new Division(vista.getOperando(), modelo);
		} else if(e.getActionCommand().equals(IVistaCalculadora.DESHACER)) {
			usuario.deshacer();
		} else if(e.getActionCommand().equals(IVistaCalculadora.REHACER)) {
			usuario.rehacer();
		}
		if(comando != null) {
			usuario.operar(comando);
		}
		vista.actualizarResultado(modelo.getResultado());
		vista.enfocarOperando();
	}

}
