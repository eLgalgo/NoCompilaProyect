

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
	private static Connection databaseConnection;
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "nocompila";
	private static String CLAVE = "nocompila";
	
	static {
		databaseConnection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Se encontro el Driver para Oracle DB");

			try {
				databaseConnection = DriverManager.getConnection(
						CONNECTION_STRING, //Conexion
						USUARIO,		   //Usuario
						CLAVE);			   //Clave
				System.out.println("Conexion creada con exito, es posible acceder a la base de datos!");
			}catch(SQLException e){
				System.out.println("No logramos instanciar la conexion!!");
				e.printStackTrace();
			}
		}catch(ClassNotFoundException e) {
			System.out.println("No tienes el driver en tu build-path");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return databaseConnection;
	}
}
