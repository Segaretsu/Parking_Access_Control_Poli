package co.com.poli.parking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import co.com.poli.parking.connections.ConnectionDataBase;
import co.com.poli.parking.dao.UsuarioDao;
import co.com.poli.parking.models.entity.UsuarioEntity;

public class UsuarioDaoImpl implements UsuarioDao{

	@Override
	public boolean registrarUsuario(UsuarioEntity usuario) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "INSERT INTO usuarios(idTipoDocumento, numeroDocumento, nombre, apellidos, telefono, correo, idTipoPerfil) VALUES (?,?,?,?,?,?,?)";
		try (Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			pst.setInt(1, usuario.getIdTipoDocumento());
			pst.setString(2, usuario.getNumeroDocumento());
			pst.setString(3, usuario.getNombre());
			pst.setString(4, usuario.getApellidos());
			pst.setString(5, usuario.getTelefono());
			pst.setString(6, usuario.getCorreo());
			pst.setInt(7, usuario.getIdTipoPerfil());
			pst.execute();
			
			if (pst.getUpdateCount() >= 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
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
	public UsuarioEntity getUsuarioByIdUsuario(int idUsuario) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		System.out.println("id: " + idUsuario);
		String query = "SELECT idTipoDocumento, numeroDocumento, nombre, apellidos, telefono, correo, idTipoPerfil FROM usuarios us WHERE us.idUsuario = '" + idUsuario + "'";
		UsuarioEntity usuario = null;
		try (Connection con = conexion.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {
			if (rs.next()) {
				usuario = UsuarioEntity.Builder.newInstance()
						.withIdUsuario(idUsuario)
						.withIdTipoDocumento(rs.getInt("idTipoDocumento"))
						.withIdTipoPerfil(rs.getInt("idTipoPerfil"))
						.withNumeroDocumento(rs.getString("numeroDocumento"))
						.withNombre(rs.getString("nombre"))
						.withApellidos(rs.getString("apellidos"))
						.withTelefono(rs.getString("telefono"))
						.withCorreo(rs.getString("correo"))
						.build();
			}	
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		} catch (Exception ex) {
			System.out.println("Clase: " + this.getClass().getName() + "\nError: " + ex.getMessage());
		}
		return usuario;
	}
	

}
