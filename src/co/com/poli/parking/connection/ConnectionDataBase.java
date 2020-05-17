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
        String host = "localhost";
        String puerto = "3306"; // o deacuerdo a la instancia
        String nombreBD = "parkin_acces";
        String user = "root";
        String clave = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            setCon((Connection)DriverManager.getConnection("jdbc:mysql://" + host + ":"
                    + puerto + "/" + nombreBD, user, clave));
        } catch (ClassNotFoundException | SQLException ex) {
            
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