package accesodatos.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import accesodatos.modelo.dao.DAOFactory;
import accesodatos.modelo.dao.PersonaDAO;
import accesodatos.modelo.dao.ProyectoDAO;

public class MySqlDaoFactory extends DAOFactory {
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost/accesodatosdb?user=root&password=root";
	
	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaMysqlDao();
	}

	@Override
	public ProyectoDAO getProyectoDAO() {
		return new ProyectoMysqlDao();
	}

	public static Connection crearConexion() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(DBURL);
	}

}
