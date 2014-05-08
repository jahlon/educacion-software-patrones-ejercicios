package lectorarchivos.modelo;

public class FiltroEspacioAGuionBajo extends FiltroLectura {

	public FiltroEspacioAGuionBajo(Lector lector) {
		super(lector);
	}

	@Override
	public int leer() throws LecturaException {
		int b = lector.leer();
		if(b == ' ') {
			b = '_';
		}
		return b;
	}

}
