package calculadora.vista;

import calculadora.controlador.ControladorCalculadora;

public interface IVistaCalculadora {
	
	public static final String SUMA = "+";
	public static final String RESTA = "-";
	public static final String MULTIPLICACION = "*";
	public static final String DIVISION = "/";
	public static final String DESHACER = "DESHACER";
	public static final String REHACER = "REHACER";
	
	public void inicializar();
	public void actualizarResultado(double resultado);
	public double getOperando();
	public void setControlador(ControladorCalculadora controlador);
	public void enfocarOperando();
	
}
