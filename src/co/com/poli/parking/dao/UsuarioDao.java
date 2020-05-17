package co.com.poli.parking.dao;

import co.com.poli.parking.models.entity.UsuarioEntity;

public interface UsuarioDao {
	public boolean registrarUsuario (UsuarioEntity usuario);
	
	public UsuarioEntity getUsuarioByIdUsuario(int idUsuario);
}
