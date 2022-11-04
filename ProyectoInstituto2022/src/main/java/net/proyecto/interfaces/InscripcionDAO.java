package net.proyecto.interfaces;

import java.util.List;

import net.proyecto.entidad.Inscripcion;

public interface InscripcionDAO {
	public int update(Inscripcion bean);
	public int eliminar(int cod);
	public Inscripcion buscar(int cod);
	public List<Inscripcion> listAll();
}
