import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAORol {
	private static final String
	DELETE_ROL = "DELETE FROM ROL WHERE ID_ROL=?";
	private static final String
	LISTAR = "SELECT * FROM ROL";
	private static final String
	INSERT_ROL = "INSERT INTO ROL (ID_ROL, NOMBRE, DESCRIPCION) values (?,?,?)";
	private static final String
	UPDATE_ROL = "UPDATE ROL SET NOMBRE = ?, DESCRIPCION = ? WHERE ID_= ?";
	private static final String
    SELECCIONAR_ROL_BY_ID = "SELECT * FROM ROL WHERE ID_ROL=?";
	
	public static boolean deleteRol(int id){
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(DELETE_ROL);
			statement.setInt(1, id);
			
			int retorno = statement.executeUpdate();
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	public static Rol buscarRolById(int id){

        Rol f = null;
        try {
            PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(SELECCIONAR_ROL_BY_ID);

            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) {
                f = new Rol(
                        resultado.getInt("ID_ROL"),
                        resultado.getString("NOMBRE"), 
                        resultado.getString("DESCRIPCION"),
                        null
                        );
            }
            statement.executeUpdate();

            return f;
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


	
	public static boolean updateRol(String nombre, String desc, int id){

		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(UPDATE_ROL);
			statement.setString(1, nombre);
			statement.setString(2, desc);
			statement.setInt(3, id);
	
			statement.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean insertRol(Rol f){
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(INSERT_ROL);
			statement.setString(2, f.getNombre());
			statement.setString(3, f.getDesc());
			statement.setInt(1, f.getId());
			
			statement.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static LinkedList<Rol> selectAll(){
		LinkedList<Rol> funcionalidades = new LinkedList<>();
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(LISTAR);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Rol funcionalidad = new Rol(

							resultado.getInt("ID_ROL"),
							resultado.getString("NOMBRE"),
							resultado.getString("DESCRIPCION"),
							null
						);
				funcionalidades.add(funcionalidad);
			}
			return funcionalidades;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
