package co.com.poli.parking.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class pruebas {
	
	public String insertar() {
		ConnectionDataBase conexion  = new ConnectionDataBase();
		
		String query = "insert into tipoestado(descripcion) values(?)";
		try(Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) conexion.getCon().prepareStatement(query);) {
			pst.setString(1, "prueba");
			pst.executeUpdate(query);
			
			if(pst.getUpdateCount()>=1) {
				System.out.println("Se inserto correctamente se pueden dormir gracias!!");
				return "Se inserto correctamente se pueden dormir gracias!!";
			}else {
				System.out.println("No nos podemos dormir sigue intentando");
				return "No nos podemos dormir sigue intentando";
			}
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "Fatality";
	}
}
