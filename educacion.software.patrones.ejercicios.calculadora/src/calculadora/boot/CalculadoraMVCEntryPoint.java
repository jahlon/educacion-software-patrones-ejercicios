package calculadora.boot;

import java.awt.EventQueue;

import calculadora.controlador.ControladorCalculadora;
import calculadora.modelo.Calculadora;
import calculadora.modelo.Usuario;
import calculadora.vista.CalculadoraUI;
import calculadora.vista.IVistaCalculadora;

public class CalculadoraMVCEntryPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IVistaCalculadora vista = new CalculadoraUI();
					Calculadora modelo = new Calculadora();
					Usuario usuario = new Usuario();
					ControladorCalculadora controlador = new ControladorCalculadora(vista,modelo,usuario);
					vista.setControlador(controlador);
					vista.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
