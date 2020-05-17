package co.com.poli.parking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.com.poli.parking.connections.ConnectionDataBase;
import co.com.poli.parking.dao.UsuarioDao;
import co.com.poli.parking.models.entity.UsuarioEntity;

public class UsuarioDaoImpl implements UsuarioDao{

	@Override
	public boolean RegistrarUsuario(UsuarioEntity usuario) {
		ConnectionDataBase conexion = new ConnectionDataBase();
		String query = "INSERT INTO usuarios(idTipoDocumento, numeroDocumento, nombre, apellidos, telefono, correo, idTipoPerfil) VALUES (?,?,?,?,?,?,?)";
		try (Connection con = conexion.getCon();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement(query)){
			pst.setInt(1, usuario.getIdTipoDocumento());
			pst.setString(2, usuario.getNumeroDocumento());
			pst.setString(3, usuario.getNombre());
			pst.setString(4, usuario.getApellidos());
			pst.setString(5, usuario.getTelefono());
			pst.setString(6, usuario.getCorreo());
			pst.setInt(7, usuario.getIdTipoPerfil());
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

}
