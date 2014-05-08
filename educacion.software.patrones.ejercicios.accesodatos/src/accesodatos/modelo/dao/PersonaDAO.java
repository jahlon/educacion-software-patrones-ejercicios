package accesodatos.modelo.dao;

import java.util.Collection;

import accesodatos.modelo.Persona;

public interface PersonaDAO {
	
	public Persona find(int id);
	public Collection<Persona> findAll();
	public boolean delete(Persona persona);
	public boolean insert(Persona persona);
	public boolean update(Persona persona);

}
