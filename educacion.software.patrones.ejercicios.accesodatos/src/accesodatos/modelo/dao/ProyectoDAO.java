package accesodatos.modelo.dao;

import java.util.Collection;

import accesodatos.modelo.Proyecto;

public interface ProyectoDAO {
	
	public Proyecto find(String codigo) throws Exception;
	public Collection<Proyecto> findAll();
	public boolean delete(String codigo) throws Exception;
	public boolean insert(Proyecto proyecto) throws Exception;
	public boolean update(Proyecto proyecto) throws Exception;
	
}
