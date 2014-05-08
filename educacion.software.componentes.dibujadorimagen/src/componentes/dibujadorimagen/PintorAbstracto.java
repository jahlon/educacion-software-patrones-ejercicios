package componentes.dibujadorimagen;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public abstract class PintorAbstracto extends JComponent {
	
	public abstract Rectangle getBaseArea();

	@Override
	public abstract void paint(Graphics g);
	
}
