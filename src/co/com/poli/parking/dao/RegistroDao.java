package co.com.poli.parking.dao;

import java.util.List;

import co.com.poli.parking.models.entity.RegistroEntity;

public interface RegistroDao {
	
	public boolean registrarRegistro (RegistroEntity usuario);
	
	public List<RegistroEntity> getUltimosVehiculos(int cantidadDatos, boolean vehiculoDentro);
	
}
