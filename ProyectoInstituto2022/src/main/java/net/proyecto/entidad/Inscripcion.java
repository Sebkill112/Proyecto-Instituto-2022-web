package net.proyecto.entidad;


public class Inscripcion {
	private int IdInscripcion, IdCarrera;
	private String dni;
	private String FecInscripcion;

	public int getIdInscripcion() {
		return IdInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		IdInscripcion = idInscripcion;
	}

	public int getIdCarrera() {
		return IdCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		IdCarrera = idCarrera;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFecInscripcion() {
		return FecInscripcion;
	}

	public void setFecInscripcion(String fecInscripcion) {
		FecInscripcion = fecInscripcion;
	}

}
