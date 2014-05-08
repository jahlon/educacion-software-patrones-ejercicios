 package visorimagenes.modelo;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Visualizador {
	
	private ArrayList<Imagen<ImageIcon>> imagenes;
	
	public Visualizador() {
		imagenes = new ArrayList<Imagen<ImageIcon>>();
		for(int i=1; i<=12; i++){
			String nombre = "Imagen " + i;
			String ruta = "img/img"+i+".jpg";
			imagenes.add(new ImagenProxy(nombre,ruta));
		}
	}
	
	public ArrayList<Imagen<ImageIcon>> listarImagenes() {
		return imagenes;
	}

}
