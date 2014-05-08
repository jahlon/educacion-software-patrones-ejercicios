package accesodatos.modelo.dao.derby;

import java.util.Collection;

import accesodatos.modelo.Persona;
import accesodatos.modelo.dao.PersonaDAO;

public class PersonaDerbyDao implements PersonaDAO {

	@Override
	public boolean delete(Persona persona) {
		System.out.println("Borrando persona en SYBASE\n" + persona.toString() + "\n");
		return false;
	}

	@Override
	public Persona find(int id) {
		System.out.println("Buscando persona en SYBASE\nID: " + id + "\n");
		return null;
	}

	@Override
	public Collection<Persona> findAll() {
		System.out.println("Buscando todas las personas en SYBASE" + "\n");
		return null;
	}

	@Override
	public boolean insert(Persona persona) {
		System.out.println("Insertando persona en SYBASE\n" + persona.toString() + "\n");
		return false;
	}

	@Override
	public boolean update(Persona persona) {
		System.out.println("Actualizando persona en SYBASE\n" + persona.toString() + "\n");
		return false;
	}

}
