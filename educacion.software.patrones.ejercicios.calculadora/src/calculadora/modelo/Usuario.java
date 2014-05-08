package calculadora.modelo;

import java.util.ArrayList;

public class Usuario {
	
	private ArrayList<ComandoCalculadora> comandos = 
					new ArrayList<ComandoCalculadora>();
	
	private int indice = -1;
	
	public void operar(ComandoCalculadora comando) {
		comando.ejecutar();
		comandos.add(comando);
		indice++;
	}
	
	public void deshacer() {
		if(indice >= 0) {
			ComandoCalculadora c = comandos.get(indice--);
			c.deshacer();
		}
	}
	
	public void rehacer() {
		if(comandos.size() > 0 && indice < comandos.size()-1) {
			ComandoCalculadora c = comandos.get(++indice);
			c.ejecutar();
		}
	}
	
	
	
}
