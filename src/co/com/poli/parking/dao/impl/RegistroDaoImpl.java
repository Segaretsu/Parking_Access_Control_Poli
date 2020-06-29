package co.com.poli.parking.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import co.com.poli.parking.connections.ConnectionDataBase;
import co.com.poli.parking.dao.RegistroDao;
import co.com.poli.parking.models.dto.FechasRegistrosDto;
import co.com.poli.parking.models.entity.RegistroEntity;
import co.com.poli.parking.models.entity.TipoDocumentoEntity;

public class RegistroDaoImpl implements RegistroDao {

	@Override
	public boolean registrarRegistro(RegistroEntity registro) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "INSERT INTO registros(idVehiculo, idTarjeta, fechaEntrada, fechaSalida, idEstado) VALUES (?,?,?,?,?)";
		try (Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(query,
						Statement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, registro.getIdVehiculo());
			pst.setInt(2, registro.getIdTarjeta());
			pst.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
			pst.setTimestamp(4, null);
			pst.setInt(5, registro.getIdEstado());
			pst.execute();

			if (pst.getUpdateCount() >= 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
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
		if (vehiculoDentro) {
			query = "SELECT * FROM registros WHERE idEstado = '1' ORDER BY fechaEntrada DESC LIMIT " + cantidadDatos;
		} else {
			query = "SELECT * FROM registros WHERE idEstado = '2' ORDER BY fechaEntrada DESC LIMIT " + cantidadDatos;
		}

		List<RegistroEntity> listaRegistro = new LinkedList<RegistroEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				RegistroEntity registro = RegistroEntity.Builder.newInstance().withIdRegistro(rs.getInt("idRegistro"))
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

	@Override
	public boolean actualizarRegistro(RegistroEntity registroNuevo) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "UPDATE registros SET fechaEntrada=?, fechaSalida=?, idEstado=? WHERE idVehiculo = ?"
				+ " ORDER BY fechaEntrada DESC LIMIT 1";
		try (Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(query,
						Statement.RETURN_GENERATED_KEYS)) {
			pst.setTimestamp(1, (Timestamp) registroNuevo.getFechaEntrada());
			pst.setTimestamp(2, (Timestamp) registroNuevo.getFechaSalida());
			pst.setInt(3, registroNuevo.getIdEstado());
			pst.setInt(4, registroNuevo.getIdVehiculo());
			pst.execute();

			if (pst.getUpdateCount() >= 1) {
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
	public RegistroEntity getUltimoRegistroByIdVehiculo(int idVehiculo) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = null;
		query = "SELECT idRegistro, idVehiculo, idTarjeta, fechaEntrada, fechaSalida, idEstado FROM registros WHERE idVehiculo = '"
				+ idVehiculo + "' ORDER BY idRegistro DESC LIMIT 1";
		RegistroEntity registro = null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				registro = RegistroEntity.Builder.newInstance()
						.withIdRegistro(rs.getInt("idRegistro"))
						.withIdVehiculo(rs.getInt("idVehiculo"))
						.withIdTarjeta(rs.getInt("idTarjeta"))
						.withFechaEntrada(rs.getTimestamp("fechaEntrada"))
						.withFechaSalida(rs.getTimestamp("fechaSalida"))
						.withIdEstado(rs.getInt("idEstado")).build();
			}
		} catch (SQLException sqlex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return registro;
	}

	@Override
	public List<FechasRegistrosDto> getListaFechasRegistros (int idVehiculo, String fechaInicio, String fechaFin) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT idRegistro, idVehiculo, idTarjeta, fechaEntrada, fechaSalida, idEstado FROM registros WHERE idVehiculo = " + idVehiculo 
				+ " AND ((fechaSalida <= '" + fechaFin + "' AND fechaEntrada >= '" + fechaInicio + "')"
				+ " OR fechaSalida BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'"
				+ " OR fechaEntrada BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "')";
		List<FechasRegistrosDto> fechas = new LinkedList<FechasRegistrosDto>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				FechasRegistrosDto fecha = FechasRegistrosDto.Builder.newInstance()
						.withFechaIngreso(rs.getTimestamp("fechaEntrada"))
						.withFechaSalida(rs.getTimestamp("fechaSalida"))
						.build();
				fechas.add(fecha);
			}
		} catch (SQLException sqlex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return (fechas.size() > 0)? fechas : null;
	}

}
