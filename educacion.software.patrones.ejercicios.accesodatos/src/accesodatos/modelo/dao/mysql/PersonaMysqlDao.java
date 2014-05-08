package accesodatos.modelo.dao.mysql;

import java.util.Collection;

import accesodatos.modelo.Persona;
import accesodatos.modelo.dao.PersonaDAO;

public class PersonaMysqlDao implements PersonaDAO {

	@Override
	public boolean delete(Persona persona) {
		System.out.println("Borrando persona en MySQL\n" + persona.toString() + "\n");
		return false;
	}

	@Override
	public Persona find(int id) {
		System.out.println("Buscando persona en MySQL\nID: " + id + "\n");
		return null;
	}

	@Override
	public Collection<Persona> findAll() {
		System.out.println("Buscando todas las personas en MySQL" + "\n");
		return null;
	}

	@Override
	public boolean insert(Persona persona) {
		System.out.println("Insertando persona en MySQL\n" + persona.toString() + "\n");
		return false;
	}

	@Override
	public boolean update(Persona persona) {
		System.out.println("Actualizando persona en MySQL\n" + persona.toString() + "\n");
		return false;
	}

}
