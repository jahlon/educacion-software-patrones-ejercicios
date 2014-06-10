package lectorarchivos.modelo;

public class FiltroMayusculaAMiniscula extends FiltroLectura {

	public FiltroMayusculaAMiniscula(Lector lector) {
		super(lector);
	}

	@Override
	public int leer() throws LecturaException {
		int b = lector.leer();
		return filtrar(b);
	}

	@Override
	public int filtrar(int c) {
		if (Character.isUpperCase(c)) {
			c = Character.toLowerCase(c);
		}
		return c;
	}

}
