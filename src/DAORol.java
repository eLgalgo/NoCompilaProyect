import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAORol {


	private static final String
	LISTAR = "SELECT * FROM ROL";
	private static final String
	INSERT_ROL = "INSERT INTO ROL (ID_ROL,DESCRIPCION,NOMBRE) values (?,?,?)";
	public static boolean insertROL(Rol p){
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(INSERT_ROL);
			statement.setInt(1, p.getId());
			statement.setString(2, p.getNombre());
			statement.setString(3, p.getDesc());
		
			statement.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static LinkedList<Rol> selectAll(){
		LinkedList<Rol> roles = new LinkedList<>();
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(LISTAR);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Rol rol = new Rol(

							resultado.getInt("DOCUMENTO"),
							resultado.getString("APELLIDO1"),
							resultado.getString("APELLIDO2"), 
							null
						
						);
				roles.add(rol);
			}
			return roles;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	}
