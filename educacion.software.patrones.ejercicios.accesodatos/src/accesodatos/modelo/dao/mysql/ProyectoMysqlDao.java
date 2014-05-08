package accesodatos.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import accesodatos.modelo.Proyecto;
import accesodatos.modelo.dao.ProyectoDAO;

public class ProyectoMysqlDao implements ProyectoDAO {

	@Override
	public boolean delete(String codigo) throws Exception {
		boolean result = true;
		Connection conn = MySqlDaoFactory.crearConexion();
		String sql = "DELETE FROM proyectos WHERE codigo=?";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, codigo);
		try {
			stm.executeUpdate();
		} catch( Exception e ) {
			result = false;
		}
		stm.close();
		conn.close();
		return result;
	}

	@Override
	public Proyecto find(String codigo) throws Exception {
		Connection conn = MySqlDaoFactory.crearConexion();
		String sql = "SELECT * FROM proyectos WHERE codigo=?";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, codigo);
		ResultSet rs = stm.executeQuery();
		Proyecto p = null;
		if(rs.next()) {
			p = new Proyecto(rs.getString("codigo"),
									rs.getString("nombre"),
									rs.getString("descripcion"));
		}
		stm.close();
		conn.close();
		return p;
	}

	@Override
	public Collection<Proyecto> findAll() {
		throw new RuntimeException("Funcionalidad no implementada aún");
	}

	@Override
	public boolean insert(Proyecto proyecto) throws Exception {
		boolean result = true;
		Connection conn = MySqlDaoFactory.crearConexion();
		String sql = "INSERT INTO proyectos(codigo, nombre, descripcion) VALUES (?, ?, ?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, proyecto.getCodigo());
		stm.setString(2, proyecto.getNombre());
		stm.setString(3, proyecto.getDescripcion());
		try {
			stm.executeUpdate();
		} catch( Exception e ) {
			result = false;
		}
		stm.close();
		conn.close();
		return result;
	}

	@Override
	public boolean update(Proyecto proyecto) throws Exception {
		boolean result = true;
		Connection conn = MySqlDaoFactory.crearConexion();
		String sql = "UPDATE proyectos SET nombre=?, descripcion=? WHERE codigo=?";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(3, proyecto.getCodigo());
		stm.setString(1, proyecto.getNombre());
		stm.setString(2, proyecto.getDescripcion());
		try {
			stm.executeUpdate();
		} catch( Exception e ) {
			result = false;
		}
		stm.close();
		conn.close();
		return result;
	}

}
