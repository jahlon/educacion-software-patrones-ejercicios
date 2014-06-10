package lectorarchivos.modelo;

public abstract class FiltroLectura implements Lector {
	
	protected Lector lector;
	
	public FiltroLectura(Lector lector) {
		this.lector = lector;
	}

	@Override
	public void cerrar() throws LecturaException {
		lector.cerrar();
	}
	
	public abstract int filtrar(int c);
}
