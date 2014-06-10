package lectorarchivos.modelo;

public class FiltroEspacioAGuionBajo extends FiltroLectura {

	public FiltroEspacioAGuionBajo(Lector lector) {
		super(lector);
	}

	@Override
	public int leer() throws LecturaException {
		int b = lector.leer();
		return filtrar(b);
	}

	@Override
	public int filtrar(int c) {
		if(c == ' ') {
			c = '_';
		}
		return c;
	}

}
