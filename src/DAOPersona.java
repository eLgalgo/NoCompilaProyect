

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAOPersona {
	
	private static final String
	LOGIN = "SELECT * FROM PERSONA WHERE EMAIL = ? AND CLAVE = ?";
	private static final String
	UPDATE_PERSONA = "UPDATE PERSONA SET APELLIDO1 = ?, EMAIL = ?, CLAVE = ?, APELLIDO2 = ?, ID_ROL = ?, NOMBRE1 = ?, NOMBRE2 = ?, FECHA_NAC = ? WHERE DOCUMENTO = ?";
	private static final String
	DELETE_PERSONA = "DELETE FROM PERSONA WHERE DOCUMENTO=?";
	private static final String
	LISTAR = "SELECT * FROM PERSONA";
	private static final String
	INSERT_PERSONA = "INSERT INTO PERSONA (DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2, EMAIL, CLAVE, FECHA_NAC, ID_ROL) values (?,?,?,?,?,?,?,?,?)";
	
	public static boolean updateRol(String apellido1, String email, String clave, String apellido2, int idRol, String nombre1, String nombre2, String fechaNac, String documento){

		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(UPDATE_PERSONA);
			statement.setString(1, apellido1);
			statement.setString(2, email);
			statement.setString(3, clave);
			statement.setString(4, apellido2);
			statement.setInt(5, idRol);
			statement.setString(6, nombre1);
			statement.setString(7, nombre2);
			statement.setString(8, fechaNac);
			statement.setString(9, documento);
	
			statement.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	private static final String
    SELECCIONAR_PERSONA_BY_ID = "SELECT * FROM PERSONA WHERE DOCUMENTO=?";
	public static Persona buscarPersonaByDoc(String doc){

        Persona p = null;
        try {
            PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(SELECCIONAR_PERSONA_BY_ID);

            statement.setString(1, doc);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) {
                p = new Persona(
                        resultado.getString("DOCUMENTO"),
                        resultado.getString("APELLIDO1"), 
                        resultado.getString("APELLIDO2"),
                        resultado.getString("NOMBRE1"),
                        resultado.getString("NOMBRE2"),
                        resultado.getString("EMAIL"),
                        resultado.getString("CLAVE"),
                        resultado.getString("FECHA_NAC"),
                        resultado.getInt("ID_ROL")
                        );
            }
            statement.executeUpdate();

            return p;
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	public static boolean deletePersona(String doc){
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(DELETE_PERSONA);
			statement.setString(1, doc);
			
			int retorno = statement.executeUpdate();
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	public static boolean insertPeople(Persona p){
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(INSERT_PERSONA);
			statement.setString(1, p.getDocumento());
			statement.setString(2, p.getApellido1());
			statement.setString(3, p.getApellido2());
			statement.setString(4, p.getNombre1());
			statement.setString(5, p.getNombre2());
			statement.setString(6, p.getEmail());
			statement.setString(7, p.getClave());
			statement.setString(8, p.getFech_nac());
			statement.setInt(9, p.getId_rol());
			
			statement.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static int verificarLogin(String email, String clave){
		int rol = -1;
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(LOGIN);
			
			statement.setString(1, email);
			statement.setString(2, clave);
			
			ResultSet resultado = statement.executeQuery();
			
			if(resultado.next()) {
				rol = resultado.getInt("ID_ROL");
			}
			return rol;
		}catch(SQLException e) {
			return rol;
		}
	}
	public static LinkedList<Persona> selectAll(){
		LinkedList<Persona> personas = new LinkedList<>();
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(LISTAR);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Persona persona = new Persona(

							resultado.getString("DOCUMENTO"),
							resultado.getString("APELLIDO1"),
							resultado.getString("APELLIDO2"),
							resultado.getString("NOMBRE1"),
							resultado.getString("NOMBRE2"),
							resultado.getString("EMAIL"),
							resultado.getString("CLAVE"),
							resultado.getString("FECHA_NAC"),
							resultado.getInt("ID_ROL")
						);
				personas.add(persona);
			}
			return personas;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
