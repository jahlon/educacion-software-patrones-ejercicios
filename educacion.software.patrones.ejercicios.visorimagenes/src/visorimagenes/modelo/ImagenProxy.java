package visorimagenes.modelo;

import javax.swing.ImageIcon;

public class ImagenProxy implements Imagen<ImageIcon> {

	private String nombre;
	private String ruta;
	
	private ImagenAltaResolucion imagenReal;
	
	public ImagenProxy(String nombre, String ruta) {
		this.nombre = nombre;
		this.ruta = ruta;
	}
	
	@Override
	public void cargar() {
		if(imagenReal == null){
			imagenReal = new ImagenAltaResolucion(ruta);
		}
		imagenReal.cargar();
	}
	
	public String toString() {
		StringBuffer sf = new StringBuffer(nombre);
		sf.append(" (").append(ruta).append(")");
		return sf.toString();
	}

	@Override
	public ImageIcon getImagen() {
		return imagenReal.getImagen();
	}
	
	
}
