package dibujadorimagen.vista.decoracion;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import componentes.dibujadorimagen.PintorAbstracto;

public class DecoradorEstrella extends DecoradorImagen {
	
	public DecoradorEstrella(PintorAbstracto pintor) {
		super(pintor);
		try {
			URL url = (new File("imagenes/star.png")).toURI().toURL();
			decoracion = ImageIO.read(url);
			setSize(decoracion.getWidth(), decoracion.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		pintor.repaint();
		
		Rectangle area = getBaseArea();
		
		int imgX = area.width - decoracion.getWidth();
		int imgY = area.y;
		
		setLocation(imgX, imgY);
		
		g.drawImage(decoracion, 0, 0, null);
	}

}
