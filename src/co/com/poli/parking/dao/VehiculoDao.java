package co.com.poli.parking.dao;

import java.util.List;

import co.com.poli.parking.models.dto.AccesoVehiculoInformacionDto;
import co.com.poli.parking.models.entity.VehiculoEntity;

public interface VehiculoDao {
	
	public boolean registrarVehiculo (VehiculoEntity vehiculo);
	
	public VehiculoEntity getVehiculoByPlaca(String placa);
	
	public List<AccesoVehiculoInformacionDto> getListaVehiculosDentro(int cantidadDatos, boolean vehiculoDentro);

}
