package lectorarchivos.modelo;

public interface Lector {
	public int leer() throws LecturaException;
	public void cerrar() throws LecturaException;
}
