package lectorarchivos.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LectorArchivo implements Lector {
	
	private FileInputStream stream;
	
	public LectorArchivo(String archivo) {
		try {
			stream = new FileInputStream(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int leer() throws LecturaException {
		try {
			return stream.read();
		} catch (IOException e) {
			throw new LecturaException(e.getMessage());
		}		
	}

	@Override
	public void cerrar() throws LecturaException {
		try {
			stream.close();
		} catch (IOException e) {
			throw new LecturaException(e.getMessage());
		}
	}

}
