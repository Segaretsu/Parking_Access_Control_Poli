package co.com.poli.parking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.metamodel.ListAttribute;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import co.com.poli.parking.connections.ConnectionDataBase;
import co.com.poli.parking.dao.UsuarioDao;
import co.com.poli.parking.dao.VehiculoDao;
import co.com.poli.parking.models.dto.AccesoVehiculoInformacionDto;
import co.com.poli.parking.models.entity.RegistroEntity;
import co.com.poli.parking.models.entity.TarjetaEntity;
import co.com.poli.parking.models.entity.UsuarioEntity;
import co.com.poli.parking.models.entity.VehiculoEntity;

public class VehiculoDaoImpl implements VehiculoDao{
    
	private RegistroDaoImplm registroDaoImplm = new RegistroDaoImplm();
	private VehiculoDaoImpl vehiculoDaoImpl = new VehiculoDaoImpl();
	private UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
	
	@Override
	public boolean registrarVehiculo(VehiculoEntity vehiculo) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "INSERT INTO vehiculos(idUsuario, idTarjeta, idTipoVehiculo, idMarca, idColor, placa, modelo, numeroPuertas, numeroChasis) VALUES (?,?,?,?,?,?,?,?,?)";
		try (Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pst.setInt(1, vehiculo.getIdUsuario());
			pst.setInt(2, vehiculo.getIdTarjeta());
			pst.setInt(3, vehiculo.getIdTipoVehiculo());
			pst.setInt(4, vehiculo.getIdMarca());
			pst.setInt(5, vehiculo.getIdColor());
			pst.setString(6, vehiculo.getPlaca());
			pst.setString(7, vehiculo.getModelo());
			pst.setString(8, vehiculo.getNumeroPuertas());
			pst.setString(9, vehiculo.getNumeroChasis());
			pst.execute();
			
			if (pst.getUpdateCount() >= 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()) {
					vehiculo.setIdVehiculo(rs.getInt(1));
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
	public VehiculoEntity getVehiculoByPlaca(String placa) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT idVehiculo,idUsuario, idTarjeta, idTipoVehiculo, idMarca, idColor, modelo, numeroPuertas, numeroChasis FROM vehiculos WHERE placa = '" + placa + "'";
		VehiculoEntity vehiculo = null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				vehiculo = VehiculoEntity.Builder.newInstance()
						.withIdVehiculo(rs.getInt("idVehiculo"))
						.withIdUsuario(rs.getInt("idUsuario"))
						.withIdTarjeta(rs.getInt("idTarjeta"))
						.withIdTipoVehiculo(rs.getInt("idTipoVehiculo"))
						.withIdMarca(rs.getInt("idMarca"))
						.withIdColor(rs.getInt("idColor"))
						.withPlaca(placa)
						.withModelo(rs.getString("modelo"))
						.withNumeroPuertas(rs.getString("numeroPuertas"))
						.withNumeroChasis(rs.getString("numeroChasis"))
						.build();
			}	
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		return vehiculo;
	}

	@Override
	public VehiculoEntity getVehiculoById(int idVehiculo) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT idVehiculo,idUsuario, idTarjeta, idTipoVehiculo, idMarca, idColor, placa, modelo, numeroPuertas, numeroChasis FROM vehiculos WHERE idVehiculo = '" + idVehiculo + "'";
		VehiculoEntity vehiculo = null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				vehiculo = VehiculoEntity.Builder.newInstance()
						.withIdVehiculo(rs.getInt(idVehiculo))
						.withIdUsuario(rs.getInt("idUsuario"))
						.withIdTarjeta(rs.getInt("idTarjeta"))
						.withIdTipoVehiculo(rs.getInt("idTipoVehiculo"))
						.withIdMarca(rs.getInt("idMarca"))
						.withIdColor(rs.getInt("idColor"))
						.withPlaca(rs.getString("placa"))
						.withModelo(rs.getString("modelo"))
						.withNumeroPuertas(rs.getString("numeroPuertas"))
						.withNumeroChasis(rs.getString("numeroChasis"))
						.build();
			}	
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		return vehiculo;
	}
	
	@Override
	public List<AccesoVehiculoInformacionDto> getListaVehiculosDentro(int cantidadDatos, boolean vehiculoDentro) {
		List<RegistroEntity> listaRegistros = registroDaoImplm.getUltimosVehiculos(cantidadDatos, vehiculoDentro);
        List<VehiculoEntity> listaVehiculos = new LinkedList<VehiculoEntity>();
		List<UsuarioEntity> listaUsuario = new LinkedList<UsuarioEntity>();
		List<AccesoVehiculoInformacionDto> AVI = new ArrayList<AccesoVehiculoInformacionDto>();
		
		
		for (RegistroEntity registro: listaRegistros) {
			VehiculoEntity vehiculoEntity = this.getVehiculoById(registro.getIdVehiculo());
			listaVehiculos.add(vehiculoEntity);
		}
		
		for (VehiculoEntity vehiculo: listaVehiculos) {
			UsuarioEntity usuarioEntity = usuarioDaoImpl.getUsuarioByIdUsuario(vehiculo.getIdUsuario());
			listaUsuario.add(usuarioEntity);
		}
		
		for (int i = 0; i < listaRegistros.size(); i++) {
			AccesoVehiculoInformacionDto aVI= AccesoVehiculoInformacionDto.Builder.newInstance()
					.withIdUsuario(listaUsuario.get(i).getIdUsuario())
					.withIdTarjeta(0)
					.withNombreUsuario(listaUsuario.get(i).getNombre())
					.withApellidosUsuario(listaUsuario.get(0).getApellidos())
					.withIconoTipoVehiculo(null)
					.withNombreColor(null)
					.withPlaca(listaVehiculos.get(i).getPlaca())
					.withModelo(listaVehiculos.get(i).getModelo())
					.build();
		}
		
		return null;
	}
}
/*private int idVehiculo;
		private int idUsuario;
		private int idTarjeta;
		private String nombreUsuario;
		private String apellidosUsuario;
		private String iconoTipoVehiculo;
		private String nombreColor;
		private String placa;
		private String modelo;
 * 
 * */



