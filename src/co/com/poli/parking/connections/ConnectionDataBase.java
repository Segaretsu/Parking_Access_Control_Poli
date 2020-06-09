package co.com.poli.parking.connections;

import java.sql.DriverManager;
import java.sql.SQLException;
//import org.aopalliance.reflect.Class;
import com.mysql.jdbc.Connection;
/**
 *
 * @author Sebas
 */
public class ConnectionDataBase {

	private static Connection conectar = null;

	public ConnectionDataBase() {

	}

	public static Connection getCon() {
		setConexionDB();
		return conectar;
	}

	public static void setCon(Connection c) {
		conectar = c;
	}

	public static void setConexionDB() {
//		String host = "localhost";
//		String puerto = "3306"; // o deacuerdo a la instancia
//		String nombreBD = "parking_access";
//		String user = "root";
//		String clave = "";
		String IP_of_instance = "35.225.157.42";
        String puerto = "3306"; // o deacuerdo a la instancia
        String databaseName = "parking_access";
        String username = "development";
        String password = "andres";
        String instanceConnectionName = "managmentdata";
        boolean GCP = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String conect = "";
			if (GCP) {
//				String jdbcUrl = String.format(
//					    "jdbc:mysql://%s/%s?cloudSqlInstance=%s"
//					        + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
//					IP_of_instance,
//					    databaseName,
//					    instanceConnectionName);
				String jdbcUrl = "jdbc:mysql://35.225.157.42/parking_access?cloudSqlInstance=modelo-data:us-central1:managmentdata&socketFactory=com.google.cloud.sql.mysql.SockectFactory&useSSL=false&user=development&password=andres";
				System.out.println(jdbcUrl);
//				System.out.println("jdbc:mysql://" + IP_of_instance + ":" + instanceConnectionName + "?user=" + username);
            	setCon((Connection)DriverManager.getConnection(jdbcUrl, username, password));
//				setCon((Connection)DriverManager.getConnection("jdbc:mysql://" + IP_of_instance + ":" + instanceConnectionName + "?user=" + username));
			} else {
				setCon((Connection) DriverManager.getConnection("jdbc:mysql://" + IP_of_instance + ":" + puerto + "/" + databaseName, username, password));
			}
			System.out.println(conect);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Clase: co.com.poli.parking.connections.ConnectionDataBase" + "\nError SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException " + e.getMessage());
		} // Si la clase no se encuentra
		catch (InstantiationException e2) {
			System.out.println("InstantiationException " + e2.getMessage());
		} // No se encontro la instancia
		catch (IllegalAccessException e3) {
			System.out.println("IllegalAccessException " + e3.getMessage());
		} // si hay acceso a la base de datos
		catch (Exception e4) {
			System.out.println("Exception" + e4.getMessage());
		} // algo general diers
	}// fin static

}