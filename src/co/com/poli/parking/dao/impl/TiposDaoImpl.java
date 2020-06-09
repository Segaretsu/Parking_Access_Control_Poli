package co.com.poli.parking.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import co.com.poli.parking.connections.ConnectionDataBase;
import co.com.poli.parking.dao.TiposDao;
import co.com.poli.parking.models.entity.TipoColorEntity;
import co.com.poli.parking.models.entity.TipoDocumentoEntity;
import co.com.poli.parking.models.entity.TipoEstadoEntity;
import co.com.poli.parking.models.entity.TipoMarcaEntity;
import co.com.poli.parking.models.entity.TipoPerfilEntity;
import co.com.poli.parking.models.entity.TipoVehiculoEntity;
import co.com.poli.parking.models.entity.UsuarioEntity;

public class TiposDaoImpl implements TiposDao{

	@Override
	public List<TipoDocumentoEntity> getListaTipoDocumentos() {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT idTipoDocumento, descripcion FROM tipo_documentos";
		List<TipoDocumentoEntity> listaTipoDocumentos = new LinkedList<TipoDocumentoEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				TipoDocumentoEntity tipoDocumento = TipoDocumentoEntity.Builder.newInstance()
						.withIdTipoDocumento(rs.getInt("idTipoDocumento"))
						.withDescripcion(rs.getString("descripcion"))
						.build();
				listaTipoDocumentos.add(tipoDocumento);
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return listaTipoDocumentos;
	}

	@Override
	public List<TipoPerfilEntity> getListaTipoPerfiles() {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT tp.idTipoPerfil, tp.descripcion FROM tipo_perfiles tp";
		List<TipoPerfilEntity> listaTipoPerfiles = new LinkedList<TipoPerfilEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				TipoPerfilEntity tipoPerfil = TipoPerfilEntity.Builder.newInstance()
						.withIdTipoPerfil(rs.getInt("tp.idTipoPerfil"))
						.withDescripcion(rs.getString("tp.descripcion"))
						.build();
				listaTipoPerfiles.add(tipoPerfil);
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return listaTipoPerfiles;
	}

	@Override
	public List<TipoColorEntity> getListaColores() {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT tc.idColor, tc.descripcion FROM tipo_colores tc";
		List<TipoColorEntity> listaColores = new LinkedList<TipoColorEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				TipoColorEntity color = TipoColorEntity.Builder.newInstance()
						.withIdColor(rs.getInt("tc.idColor"))
						.withDescripcion(rs.getString("tc.descripcion"))
						.build();
				listaColores.add(color);
			}
		} catch (SQLException sqlex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return listaColores;
	}

	@Override
	public List<TipoEstadoEntity> getListaEstados() {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT te.idEstado, te.descripcion FROM tipo_estados te";
		List<TipoEstadoEntity> listaEstados = new LinkedList<TipoEstadoEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				TipoEstadoEntity estado = TipoEstadoEntity.Builder.newInstance()
						.withIdEstado(rs.getInt("te.idEstado"))
						.withDescripcion(rs.getString("te.descripcion"))
						.build();
				listaEstados.add(estado);
			}
		} catch (SQLException sqlex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return listaEstados;
	}

	@Override
	public List<TipoMarcaEntity> getListaMarcas() {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT tm.idMarca, tm.descripcion FROM tipo_marcas tm";
		List<TipoMarcaEntity> listaMarcas = new LinkedList<TipoMarcaEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				TipoMarcaEntity marca = TipoMarcaEntity.Builder.newInstance()
						.withIdMarca(rs.getInt("tm.idMarca"))
						.withDescripcion(rs.getString("tm.descripcion"))
						.build();
				listaMarcas.add(marca);
			}
		} catch (SQLException sqlex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return listaMarcas;
	}

	@Override
	public List<TipoVehiculoEntity> getListaTipoVehiculos() {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT tv.idTipoVehiculo, tv.descripcion, tv.nombreicono FROM tipo_vehiculos tv";
		List<TipoVehiculoEntity> listaTipoVehiculos = new LinkedList<TipoVehiculoEntity>();
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			while (rs.next()) {
				TipoVehiculoEntity tipoVehiculo = TipoVehiculoEntity.Builder.newInstance()
						.withIdTipoVehiculo(rs.getInt("tv.idTipoVehiculo"))
						.withDescripcion(rs.getString("tv.descripcion"))
						.withNombreIcono(rs.getString("tv.nombreicono"))
						.build();
				listaTipoVehiculos.add(tipoVehiculo);
			}
		} catch (SQLException sqlex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError SQL: " + sqlex.getMessage());
			return null;
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
			return null;
		}
		return listaTipoVehiculos;
	}

	@Override
	public TipoColorEntity getColorById(int idColor) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT idColor, descripcion FROM tipo_colores WHERE idColor = '" + idColor + "'";
		TipoColorEntity tipoVehiculo = null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				tipoVehiculo = TipoColorEntity.Builder.newInstance()
						.withIdColor(idColor)
						.withDescripcion(rs.getString("descripcion"))
						.build();
			}	
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		
		return tipoVehiculo;
		
	}

	@Override
	public TipoVehiculoEntity getTipoVehiculoById(int idTipoVehiculo) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT idTipoVehiculo, descripcion, nombreicono FROM tipo_vehiculos WHERE idTipoVehiculo = '" + idTipoVehiculo + "'";
		TipoVehiculoEntity tipoVehiculo= null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				tipoVehiculo = TipoVehiculoEntity.Builder.newInstance()
						.withIdTipoVehiculo(idTipoVehiculo)
						.withDescripcion(rs.getString("descripcion"))
						.withNombreIcono(rs.getString("nombreicono"))
						.build();
			}	
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		
		return tipoVehiculo;
	}

	@Override
	public TipoPerfilEntity getTipoPerfilById(int idTipoPerfil) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "SELECT idTipoPerfil, descripcion FROM tipo_perfiles WHERE idTipoPerfil = '" + idTipoPerfil + "'";
		TipoPerfilEntity tipoPerfil= null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				tipoPerfil = TipoPerfilEntity.Builder.newInstance()
						.withIdTipoPerfil(idTipoPerfil)
						.withDescripcion((rs.getString("descripcion")))
						.build();
			}	
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		
		return tipoPerfil;
	}

}
