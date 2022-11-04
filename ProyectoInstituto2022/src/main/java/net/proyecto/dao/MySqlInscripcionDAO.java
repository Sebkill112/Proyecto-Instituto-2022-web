package net.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.proyecto.entidad.Inscripcion;
import net.proyecto.interfaces.InscripcionDAO;
import net.proyecto.utils.MySqlConexion;

public class MySqlInscripcionDAO implements InscripcionDAO {

	@Override
	public int update(Inscripcion bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql= "update inscripcion set DNI=?,id_Carrera=?,fec_Inscripcion=? where idInscripcion=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getDni());
			pstm.setInt(2, bean.getIdCarrera());
			pstm.setString(3, bean.getFecInscripcion());
			pstm.setInt(4, bean.getIdInscripcion());
			//pstm.setDate(3, new java.sql.Date(bean.getFecInscripcion().getDate()));
			//5
			salida=pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int eliminar(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="delete from inscripcion where idInscripcion=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public Inscripcion buscar(int cod) {
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs = null;
		Inscripcion i = null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select * from inscripcion where idInscripcion=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setInt(1, cod);
			//5
			rs=pstm.executeQuery();
			//6
			if(rs.next()) {
				//7
				i = new Inscripcion();
				//8
				i.setIdInscripcion(rs.getInt(1));
				i.setDni(rs.getString(2));
				i.setIdCarrera(rs.getInt(3));
				i.setFecInscripcion(rs.getString(4));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public List<Inscripcion> listAll() {
		List<Inscripcion> lista=new ArrayList<Inscripcion>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select *from inscripcion";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			
			//5
			rs=pstm.executeQuery();
			//6
			while(rs.next()) {
				//7
				Inscripcion i=new Inscripcion();
				//8
				i.setIdInscripcion(rs.getInt(1));
				i.setDni(rs.getString(2));
				i.setIdCarrera(rs.getInt(3));
				i.setFecInscripcion(rs.getString(4));
				//9
				lista.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
