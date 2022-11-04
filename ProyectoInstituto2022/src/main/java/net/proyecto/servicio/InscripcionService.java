package net.proyecto.servicio;

import java.util.List;

import net.proyecto.entidad.Inscripcion;
import net.proyecto.fabrica.DAOFactory;
import net.proyecto.interfaces.InscripcionDAO;

public class InscripcionService {
	//Paso 1: enviar origen de datos "4" al m�todo getDAOFactory
	private DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	//Paso 2: indicar con que m�todo del objeto "fabrica" se va a trabajar
	private InscripcionDAO objInsc = fabrica.getInscripcionDAO();
	
	//m�todos de servicio  que sirven para invocar a los m�todos del objeto "objDoc" 
	public int actualizar(Inscripcion bean) {
		return objInsc.update(bean);
	}
	public int eliminarPorID(int cod) {
		return objInsc.eliminar(cod);
	}
	public Inscripcion buscarPorID(int cod) {
		return objInsc.buscar(cod);
	}
	public List<Inscripcion> listarTodos(){
		return objInsc.listAll();
	}
}
