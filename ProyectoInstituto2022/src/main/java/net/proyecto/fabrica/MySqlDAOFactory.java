package net.proyecto.fabrica;

import net.proyecto.dao.MySqlUsuarioDAO;
import net.proyecto.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

}
