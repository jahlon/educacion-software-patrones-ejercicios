package accesodatos.boot;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.util.Properties;

import accesodatos.vista.FrameAccesoDatos;

public class AccesoDatosApp {
		
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAccesoDatos frame = new FrameAccesoDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
