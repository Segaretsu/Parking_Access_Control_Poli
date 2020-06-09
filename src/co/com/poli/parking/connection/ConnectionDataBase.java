package co.com.poli.parking.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.lang.Class;

import com.mysql.jdbc.Connection;


public class ConnectionDataBase {

    private static Connection conectar = null;

    public ConnectionDataBase () {
    	
    }

    public static Connection getCon() {
        setConexionDB();
        return conectar;
    }

    public static void setCon(Connection c) {
        conectar = c;
    }

    public static void setConexionDB() {
//    	define('servidor', '35.225.157.42');
//        define('nombre_bd', 'data');
//        define('usuario', 'development');
//        define('password', 'andres');	
        String host = "35.225.157.42";
        String puerto = "3306"; // o deacuerdo a la instancia
        String nombreBD = "parking_access";
        String user = "development";
        String clave = "andres";
        boolean GCP = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conect = "";
            if(GCP) {
            	conect = "jdbc:mysql:///" + nombreBD + "?cloudSqlInstance=" + host + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=" + user + "&password=" + clave;
            	setCon((Connection)DriverManager.getConnection(conect));
            } else {
            	setCon((Connection)DriverManager.getConnection("jdbc:mysql://" + host + ":"
                        + puerto + "/" + nombreBD, user, clave));
            }
            System.out.println(conect);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("BREYNER SE TIRO EL PROYECTO");
        }
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException" + e.getMessage());
        }//Si la clase no se encuentra 
        catch (InstantiationException e2) {
            System.out.println("InstantiationException" + e2.getMessage());
        }//No se encontro la instancia       
        catch (IllegalAccessException e3) {
            System.out.println("IllegalAccessException" + e3.getMessage());
        }//si hay acceso a la base de datos   
        catch (Exception e4) {
            System.out.println("Exception" + e4.getMessage());
        }//algo general diers
    }//fin static

}