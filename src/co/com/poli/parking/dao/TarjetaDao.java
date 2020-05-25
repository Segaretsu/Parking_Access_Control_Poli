package co.com.poli.parking.dao;

import co.com.poli.parking.models.entity.TarjetaEntity;

public interface TarjetaDao {
	
	public boolean registrarTarjeta(TarjetaEntity tarjeta);
	
	public TarjetaEntity getTarjetaDeVehiculoByPlaca(String placa);
}
