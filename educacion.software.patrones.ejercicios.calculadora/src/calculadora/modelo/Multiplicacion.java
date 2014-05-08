package calculadora.modelo;

public class Multiplicacion extends ComandoCalculadora {

	private Calculadora calculadora;

	public Multiplicacion(double operando, Calculadora calc) {
		this.operando = operando;
		calculadora = calc;
	}

	@Override
	public void ejecutar() {
		calculadora.multiplicar(operando);

	}

	@Override
	public void deshacer() {
		calculadora.dividir(operando);

	}

}
