package calculadora.modelo;

public class Calculadora {

	private double resultado;

	public Calculadora() {
		resultado = 0;
	}

	public void sumar(double operando) {
		resultado += operando;
	}

	public void restar(double operando) {
		resultado -= operando;
	}

	public void dividir(double operando) {
		resultado /= operando;

	}

	public void multiplicar(double operando) {
		resultado *= operando;

	}

	public double getResultado() {
		return resultado;
	}
	
	public CalculadoraMemento crearMemento() {
		return new CalculadoraMemento(resultado);
	}
	
	public void setMemento(CalculadoraMemento memento) {
		resultado = memento.getResultado();
	}

}
