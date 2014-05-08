package lectorarchivos.modelo;

public class FiltroMayusculaAMiniscula extends FiltroLectura {

	public FiltroMayusculaAMiniscula(Lector lector) {
		super(lector);
	}

	@Override
	public int leer() throws LecturaException {
		int b = lector.leer();
		if (Character.isUpperCase(b)) {
			b = Character.toLowerCase(b);
		}
		return b;
	}

}
