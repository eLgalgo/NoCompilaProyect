import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAORolFunc {
	private static final String
	LISTAR = "SELECT * FROM ROL";
	private static final String
	INSERT_ROL_FUNC = "INSERT INTO ROL_FUNC (ID_ROL_FUNC,ID_ROL, ID_FUNC) values (SEQ_ROL_FUNC.NEXTVAL,?,?)";
	
	public static boolean agregarFuncARol(int idRol, String nombreFunc) {
		try {
			PreparedStatement statement = DataBaseManager.getConnection().prepareStatement(INSERT_ROL_FUNC);
			statement.setInt(1, idRol);
			int idFunc = DAOFuncionalidad.buscarFuncByNombre(nombreFunc).getId();
			System.out.println(idRol);
			statement.setInt(2, idFunc);
			
			
			statement.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
