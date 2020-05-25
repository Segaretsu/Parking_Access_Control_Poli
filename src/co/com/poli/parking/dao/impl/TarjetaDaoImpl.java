package co.com.poli.parking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.com.poli.parking.connections.ConnectionDataBase;
import co.com.poli.parking.dao.TarjetaDao;
import co.com.poli.parking.models.entity.TarjetaEntity;

public class TarjetaDaoImpl implements TarjetaDao {

	@Override
	public boolean registrarTarjeta(TarjetaEntity tarjeta) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "INSERT INTO tarjetas(idEstado, numeroTarjeta) VALUES (?,?)";
		try (Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(query,
						Statement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, tarjeta.getIdEstado());
			pst.setString(2, tarjeta.getNumeroTarjeta());
			pst.execute();

			if (pst.getUpdateCount() >= 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					tarjeta.setIdTarjeta(rs.getInt(1));
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
	public TarjetaEntity getTarjetaDeVehiculoByPlaca(String placa) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT tj.idTarjeta, tj.idEstado, tj.numeroTarjeta FROM tarjetas tj "
				+ "INNER JOIN vehiculos vi ON tj.idTarjeta = vi.idTarjeta WHERE vi.placa = '" + placa + "'";
		TarjetaEntity tarjeta = null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				tarjeta = TarjetaEntity.Builder.newInstance()
						.withIdTarjeta(rs.getInt("tj.idTarjeta"))
						.withIdEstado(rs.getInt("tj.idEstado"))
						.withNumeroTarjeta(rs.getString("tj.numeroTarjeta"))
						.build();
			}
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		return tarjeta;
	}

}
