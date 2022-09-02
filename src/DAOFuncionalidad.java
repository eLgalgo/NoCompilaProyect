import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DAOFuncionalidad {
	private static final String
	LISTAR = "SELECT * FROM FUNCIONALIDAD";
	private static final String
	INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDAD (ID_FUNC, NOMBRE, DESCRIPCION) values (?,?,?)";
	private static final String
	SELECCIONAR_FUNCIONALIDAD_BY_ID = "SELECT * FROM FUNCIONALIDAD WHERE ID_FUNC=?";
	private static final String
	UPDATE_FUNCIONALIDAD = "UPDATE FUNCIONALIDAD SET NOMBRE = ?, DESCRIPCION = ? WHERE ID_FUNC= ?";
	
	public static boolean updateFunc(Funcionalidad f){
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(UPDATE_FUNCIONALIDAD);
			statement.setString(1, f.getNombre());
			statement.setString(2, f.getDesc());
			statement.setInt(3, f.getId());
	
			statement.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static Funcionalidad buscarFuncById(int id){
		
		Funcionalidad f = null;
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(SELECCIONAR_FUNCIONALIDAD_BY_ID);
			
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				f = new Funcionalidad(
						resultado.getInt("ID_FUNC"),
						resultado.getString("NOMBRE"), 
						resultado.getString("DESCRIPCION")
						);
			}
			statement.executeUpdate();
			
			return f;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static boolean insertFunc(Funcionalidad f){
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);
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
	public static LinkedList<Funcionalidad> selectAll(){
		LinkedList<Funcionalidad> funcionalidades = new LinkedList<>();
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(LISTAR);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Funcionalidad funcionalidad = new Funcionalidad(

							resultado.getInt("ID_FUNC"),
							resultado.getString("NOMBRE"),
							resultado.getString("DESCRIPCION")
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
