package visorimagenes.modelo;

import javax.swing.ImageIcon;

public class ImagenAltaResolucion implements Imagen<ImageIcon> {

	private ImageIcon img;
	private String ruta;
	
	public ImagenAltaResolucion(String ruta) {
		this.ruta = ruta;
	}
	
	@Override
	public void cargar() {
		img = new ImageIcon(ruta);
	}
	
	public ImageIcon getImagen() {
		return img;
	}
}
