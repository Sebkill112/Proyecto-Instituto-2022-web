package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Carrera;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.CarreraDAO;

public class CarreraService {
	
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private CarreraDAO objCa=fabrica.getCarreraDAO();
	
	public int registrar(Carrera bean) {
		return objCa.save(bean);
	}
	public int actualizar(Carrera bean) {
		return objCa.update(bean);
	}
	public int eliminarPorID(int codigo) {
		return objCa.delete(codigo);
	}
	public Carrera buscarPorID(int codigo) {
		return objCa.buscar(codigo);
	}
	public List<Carrera> listarTodos(){
		return objCa.lisAll(); 
		
	}

}
