package net.proyecto.fabrica;

import net.proyecto.interfaces.CarreraDAO;
import net.proyecto.interfaces.InscripcionDAO;
import net.proyecto.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	// los posibles orígenes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    // Existirá un método get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract CarreraDAO getCarreraDAO();
    public abstract InscripcionDAO getInscripcionDAO();
    // registramos nuestros daos

   
   
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	    //return new XmlDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();*/
        	case SQLSERVER:
        	    return null;
        	/*case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
