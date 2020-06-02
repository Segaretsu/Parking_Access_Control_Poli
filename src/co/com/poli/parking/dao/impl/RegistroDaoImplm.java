package co.com.poli.parking.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import co.com.poli.parking.connections.ConnectionDataBase;
import co.com.poli.parking.dao.RegistroDao;
import co.com.poli.parking.models.entity.RegistroEntity;
import co.com.poli.parking.models.entity.TipoDocumentoEntity;

public class RegistroDaoImplm implements RegistroDao{

	@Override
	public boolean registrarRegistro(RegistroEntity registro) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "INSERT INTO registros(idVehiculo, idTarjeta, fechaEntrada, fechaSalida, idEstado) VALUES (?,?,?,?,?)";
		try (Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pst.setInt(1, registro.getIdVehiculo());
			System.out.println("PASO 1");
			pst.setInt(2, registro.getIdTarjeta());
			System.out.println("PASO 2");
			pst.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
			System.out.println("PASO 3");
			pst.setTimestamp(4, null);
			System.out.println("PASO 4");
			pst.setInt(5, registro.getIdEstado());
			System.out.println("PASO 5");
			pst.execute();
			
			if (pst.getUpdateCount() >= 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()) {
					registro.setIdRegistro(rs.getInt(1));
				}
				rs.close();
				return true;
			} else {
				return false;
			}
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		return false;
	}

	@Override
	public List<RegistroEntity> getUltimosVehiculos(int cantidadDatos, boolean vehiculoDentro) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = null;
		if(vehiculoDentro) {
			query = "SELECT * FROM `registros` WHERE idEstado = '1' ORDER BY fechaEntrada DESC LIMIT " + cantidadDatos;
		}else {
			query = "SELECT * FROM `registros` WHERE idEstado = '2' ORDER BY fechaEntrada DESC LIMIT " + cantidadDatos;
		}
		
		List<RegistroEntity> listaRegistro= new LinkedList<RegistroEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				RegistroEntity registro = RegistroEntity.Builder.newInstance()
						.withIdRegistro(rs.getInt("idRegistro"))
						.withIdVehiculo(rs.getInt("idVehiculo"))
						.withIdTarjeta(rs.getInt("idTarjeta"))
						.withFechaEntrada(rs.getTimestamp("fechaEntrada"))
						.withFechaSalida(rs.getTimestamp("fechaSalida"))
						.withIdEstado(rs.getInt("idEstado"))
						.build();
				listaRegistro.add(registro);
			}
		} catch (SQLException sqlex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return listaRegistro;
	}

}
