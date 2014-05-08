package accesodatos.modelo.dao.derby;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import accesodatos.modelo.dao.DAOFactory;
import accesodatos.modelo.dao.PersonaDAO;
import accesodatos.modelo.dao.ProyectoDAO;

public class DerbyDaoFactory extends DAOFactory {
	
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String DBURL = "jdbc:derby:accesodatosdb;create=true";
	
	public DerbyDaoFactory() throws Exception{
		
		File data = new File("./data");
		System.setProperty("derby.system.home", data.getAbsolutePath());
		
		Connection conn = crearConexion();
		Statement s = conn.createStatement();
		boolean createTable = false;
		
		try{
			s.executeQuery("SELECT * FROM proyectos WHERE 1=2");
		} catch( Exception e ) {
			createTable = true;
		}
		
		if(createTable) {
			s.execute("CREATE TABLE proyectos (codigo varchar(50), nombre varchar(100), descripcion varchar(250), PRIMARY KEY(codigo))");
		}
		
		s.close();
	}
	
	public static Connection crearConexion() throws Exception {
		Class.forName(DRIVER).newInstance();
		return DriverManager.getConnection(DBURL);
	}
	
	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaDerbyDao();
	}

	@Override
	public ProyectoDAO getProyectoDAO() {
		return new ProyectoDerbyDao();
	}

}
