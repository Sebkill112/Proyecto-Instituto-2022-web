package net.proyecto.fabrica;

import net.proyecto.dao.MySqlAlumnoDAO;
import net.proyecto.dao.MySqlCarreraDao;
import net.proyecto.dao.MySqlInscripcionDAO;
import net.proyecto.dao.MySqlUsuarioDAO;
import net.proyecto.interfaces.AlumnoDAO;
import net.proyecto.interfaces.CarreraDAO;
import net.proyecto.interfaces.InscripcionDAO;
import net.proyecto.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	public CarreraDAO getCarreraDAO() {

		return new MySqlCarreraDao();

	}

	@Override
	public InscripcionDAO getInscripcionDAO() {
		// TODO Auto-generated method stub
		return new MySqlInscripcionDAO();
	}
	
	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new MySqlAlumnoDAO();
	}


}
