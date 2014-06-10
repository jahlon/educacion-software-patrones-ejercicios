package calculadora.bootstrap;

import java.awt.EventQueue;

import calculadora.controlador.ControladorCalculadora;
import calculadora.modelo.Calculadora;
import calculadora.modelo.CalculadoraCareTaker;
import calculadora.vista.CalculadoraUI;
import calculadora.vista.IVistaCalculadora;

public class CalculadoraBootstrap {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IVistaCalculadora vista = new CalculadoraUI();
					Calculadora modelo = new Calculadora();
					CalculadoraCareTaker caretaker = new CalculadoraCareTaker();
					ControladorCalculadora controlador = new ControladorCalculadora(vista,modelo,caretaker);
					vista.setControlador(controlador);
					vista.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
