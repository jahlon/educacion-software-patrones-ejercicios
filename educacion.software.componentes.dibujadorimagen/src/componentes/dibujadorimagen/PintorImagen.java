package componentes.dibujadorimagen;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class PintorImagen extends PintorAbstracto {
	
	private static final long serialVersionUID = 6134373270277753021L;
	private BufferedImage imagen;
	
	public PintorImagen(String srcImagen) {
		super();
		try {
			URL url = (new File(srcImagen)).toURI().toURL();
			imagen = ImageIO.read(url);
			setSize(imagen.getWidth(), imagen.getHeight());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		//int imgX = imagen.getWidth() / 2;
		//int imgY = imagen.getHeight() / 2;
		
		//g.drawImage(imagen, imgX, imgY, null);
		g.drawImage(imagen, 0, 0, null);
	}

	@Override
	public Rectangle getBaseArea() {
		return getBounds();
	}
	
	
	
}
