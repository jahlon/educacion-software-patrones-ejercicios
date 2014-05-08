package calculadora.modelo;

public abstract class ComandoCalculadora {
	
	protected double operando;
	
	public abstract void ejecutar();
	public abstract void deshacer();
	
}
