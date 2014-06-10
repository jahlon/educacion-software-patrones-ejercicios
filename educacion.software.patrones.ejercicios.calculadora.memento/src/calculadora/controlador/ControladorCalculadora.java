package calculadora.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculadora.modelo.Calculadora;
import calculadora.modelo.CalculadoraCareTaker;
import calculadora.modelo.CalculadoraMemento;
import calculadora.vista.IVistaCalculadora;

public class ControladorCalculadora implements ActionListener {
	
	// Vista
	private IVistaCalculadora vista;
	
	// Modelo
	private Calculadora calculadora;
	private CalculadoraCareTaker caretaker;
	
	public ControladorCalculadora(IVistaCalculadora vista, Calculadora modelo, CalculadoraCareTaker caretaker) {
		this.vista = vista;
		this.calculadora = modelo;
		this.caretaker = caretaker;
		this.caretaker.addMemento(this.calculadora.crearMemento());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean crearMemento = false;
		
		if(e.getActionCommand().equals(IVistaCalculadora.SUMA)) {
			calculadora.sumar(vista.getOperando());
			crearMemento = true;
		} else if(e.getActionCommand().equals(IVistaCalculadora.RESTA)) {
			calculadora.restar(vista.getOperando());
			crearMemento = true;
		} else if(e.getActionCommand().equals(IVistaCalculadora.MULTIPLICACION)){
			calculadora.multiplicar(vista.getOperando());
			crearMemento = true;
		} else if(e.getActionCommand().equals(IVistaCalculadora.DIVISION)) {
			calculadora.dividir(vista.getOperando());
			crearMemento = true;
		} else if(e.getActionCommand().equals(IVistaCalculadora.DESHACER)) {
			CalculadoraMemento memento = caretaker.getLastMemento();
			if(memento != null)
				calculadora.setMemento(memento);
			
		} else if(e.getActionCommand().equals(IVistaCalculadora.REHACER)) {
			CalculadoraMemento memento = caretaker.getNextMemento();
			if(memento != null)
				calculadora.setMemento(memento);
		}
		
		if(crearMemento) {
			caretaker.addMemento(calculadora.crearMemento());
		}
		
		vista.actualizarResultado(calculadora.getResultado());
		vista.enfocarOperando();
	}

}
