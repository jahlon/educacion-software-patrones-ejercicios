package calculadora.modelo;

public class Division extends ComandoCalculadora {
	
	private Calculadora calculadora;
	
	public Division(double operando, Calculadora calc) {
		this.operando = operando;
		calculadora = calc;
	}
	
	@Override
	public void ejecutar() {
		calculadora.dividir(operando);

	}

	@Override
	public void deshacer() {
		calculadora.multiplicar(operando);
	}

}
