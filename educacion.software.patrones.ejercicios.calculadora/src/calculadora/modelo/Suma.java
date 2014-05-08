package calculadora.modelo;

public class Suma extends ComandoCalculadora {
	
	private Calculadora calculadora;
	
	public Suma(double operando, Calculadora calc) {
		this.operando = operando;
		calculadora = calc;
	}
	
	@Override
	public void ejecutar() {
		calculadora.sumar(operando);

	}

	@Override
	public void deshacer() {
		calculadora.restar(operando);
	}

}
