package accesodatos.modelo.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import accesodatos.modelo.dao.derby.DerbyDaoFactory;
import accesodatos.modelo.dao.mysql.MySqlDaoFactory;

public abstract class DAOFactory {
	
	private static DAOFactory factory;
	
	protected Connection connection;
	
	private final static String CONFIG_FILE = "./data/data.properties";
	private final static String FACTORY_CLASS = "datasourcefactory.class";
	
	public abstract PersonaDAO getPersonaDAO();
	public abstract ProyectoDAO getProyectoDAO();
	
	public static DAOFactory getDAOFactory() throws Exception {
		
		if( factory == null) {
			Properties config = new Properties();
			try {
				FileInputStream fis =  new FileInputStream(CONFIG_FILE);
				config.load(fis);
				fis.close();
			} catch (Exception e) {
				System.out.println("Error cargando el archivo de configuración:");
				e.printStackTrace();
			}
			
			String factoryClass = config.getProperty(FACTORY_CLASS);
			Class<DAOFactory> clazz = (Class<DAOFactory>) Class.forName(factoryClass);
			factory = clazz.newInstance();
		}
		
		
		return factory;
	}

}


