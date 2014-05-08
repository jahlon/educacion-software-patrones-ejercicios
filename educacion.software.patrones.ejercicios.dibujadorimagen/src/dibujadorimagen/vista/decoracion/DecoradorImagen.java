package dibujadorimagen.vista.decoracion;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import componentes.dibujadorimagen.PintorAbstracto;

public abstract class DecoradorImagen extends PintorAbstracto {

	protected PintorAbstracto pintor;
	
	protected BufferedImage decoracion;
	
	public DecoradorImagen(PintorAbstracto pintor) {
		super();
		this.pintor = pintor;
	}

	@Override
	public Rectangle getBaseArea() {
		return pintor.getBaseArea();
	}
	
}
