package calculadora.modelo;

public class Resta extends ComandoCalculadora {

	private Calculadora calculadora;

	public Resta(double operando, Calculadora calc) {
		this.operando = operando;
		calculadora = calc;
	}

	@Override
	public void ejecutar() {
		calculadora.restar(operando);
	}

	@Override
	public void deshacer() {
		calculadora.sumar(operando);

	}

}
