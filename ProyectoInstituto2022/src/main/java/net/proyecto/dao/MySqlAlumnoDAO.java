package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.proyecto.entidad.Alumno;
import net.proyecto.entidad.Carrera;
import net.proyecto.entidad.ListadoAlumnos;
import net.proyecto.interfaces.AlumnoDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlAlumnoDAO implements AlumnoDAO {

	@Override
	public int deleteByDni(int dni) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="delete from alumno where dni=?;";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, dni);
			salida=pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();			
			}
		}		
		return salida;
	}

	@Override
	public List<ListadoAlumnos> listAll() {
		
		List<ListadoAlumnos> lista = new ArrayList<ListadoAlumnos>();
		
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select \r\n"
					+ "	a.dni,\r\n"
					+ "    a.nombre,\r\n"
					+ "    a.apellido,\r\n"
					+ "    a.fecha_nac,\r\n"
					+ "    a.correo,\r\n"
					+ "    c.nom_Carrera,\r\n"
					+ "    c.ciclo,\r\n"
					+ "    a.direccion,\r\n"
					+ "    i.fec_Inscripcion,\r\n"
					+ "	a.pais\r\n"
					+ "from alumno a \r\n"
					+ "left join inscripcion i on a.dni = i.dni\r\n"
					+ "left join carrera c on i.id_Carrera = c.idCarrera ";
			
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				
				ListadoAlumnos bean = new ListadoAlumnos();
				
				Alumno alumno = new Alumno();
				alumno.setDni(rs.getInt(1));
				alumno.setNombre(rs.getString(2));
				alumno.setApellido(rs.getString(3));
				alumno.setFechaNacimiento(rs.getString(4));
				alumno.setCorreo(rs.getString(5));
				
				Carrera carrera = new Carrera();
				carrera.setNomCarrera(rs.getString(6));
				carrera.setCiclo(rs.getString(7));
				
				alumno.setDireccion(rs.getString(8));
				alumno.setPais(rs.getString(10));
				
				bean.setAlumno(alumno);
				bean.setCarrera(carrera);
				bean.setFechaInscripcion(rs.getDate(9));
				
				lista.add(bean);				
			}

		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();			
			}
		}
		return lista ;
	}

	@Override
	public ListadoAlumnos findByDni(int dni) {
		ListadoAlumnos bean = null;
		
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select \r\n"
					+ "	a.dni,\r\n"
					+ "    a.nombre,\r\n"
					+ "    a.apellido,\r\n"
					+ "    a.fecha_nac,\r\n"
					+ "    a.correo,\r\n"
					+ "    c.nom_Carrera,\r\n"
					+ "    c.ciclo,\r\n"
					+ "    a.direccion,\r\n"
					+ "    i.fec_Inscripcion,\r\n"
					+ "	a.pais\r\n"
					+ "from alumno a \r\n"
					+ "left join inscripcion i on a.dni = i.dni\r\n"
					+ "left join carrera c on i.id_Carrera = c.idCarrera\r\n"
					+ "where a.dni= ?;";
			
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, dni);
			rs=pstm.executeQuery();
			while(rs.next()) {
				
				bean = new ListadoAlumnos();
				
				Alumno alumno = new Alumno();
				alumno.setDni(rs.getInt(1));
				alumno.setNombre(rs.getString(2));
				alumno.setApellido(rs.getString(3));
				alumno.setFechaNacimiento(rs.getString(4));
				alumno.setCorreo(rs.getString(5));
				
				Carrera carrera = new Carrera();
				carrera.setNomCarrera(rs.getString(6));
				carrera.setCiclo(rs.getString(7));
				
				alumno.setDireccion(rs.getString(8));
				alumno.setPais(rs.getString(10));
				
				bean.setAlumno(alumno);
				bean.setCarrera(carrera);
				bean.setFechaInscripcion(rs.getDate(9));
			}

		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();			
			}
		}
		return bean ;
	}

	@Override
	public int create(Alumno alumno) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="insert into alumno value (?,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, alumno.getDni());
			pstm.setString(2, alumno.getNombre());
			pstm.setString(3, alumno.getApellido());
			pstm.setString(4, alumno.getFechaNacimiento());
			pstm.setString(5, alumno.getCorreo());
			pstm.setString(6, alumno.getDireccion());
			pstm.setString(7, alumno.getPais());
			
			
			salida=pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();			
			}
		}		
		return salida;
	}

	@Override
	public int update(Alumno alumno) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="update alumno set nombre=?,apellido=?,fecha_nac=?,correo=?,direccion=?,pais=? where dni=?";
			pstm=cn.prepareStatement(sql);
			
			pstm.setString(1, alumno.getNombre());
			pstm.setString(2, alumno.getApellido());
			pstm.setString(3, alumno.getFechaNacimiento());
			pstm.setString(4, alumno.getCorreo());
			pstm.setString(5, alumno.getDireccion());
			pstm.setString(6, alumno.getPais());
			pstm.setInt(7, alumno.getDni());
			
			salida=pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();			
			}
		}		
		return salida;
	}
	
}
