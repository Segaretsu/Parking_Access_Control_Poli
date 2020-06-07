package co.com.poli.parking.dao;

import java.util.List;

import co.com.poli.parking.models.entity.TipoColorEntity;
import co.com.poli.parking.models.entity.TipoDocumentoEntity;
import co.com.poli.parking.models.entity.TipoEstadoEntity;
import co.com.poli.parking.models.entity.TipoMarcaEntity;
import co.com.poli.parking.models.entity.TipoPerfilEntity;
import co.com.poli.parking.models.entity.TipoVehiculoEntity;

public interface TiposDao {
	
	public List<TipoDocumentoEntity> getListaTipoDocumentos();
	
	public List<TipoPerfilEntity> getListaTipoPerfiles();
	
	public List<TipoColorEntity> getListaColores();
	
	public List<TipoEstadoEntity> getListaEstados();
	
	public List<TipoMarcaEntity> getListaMarcas();
	
	public List<TipoVehiculoEntity> getListaTipoVehiculos();
	
	public TipoColorEntity getColorById(int idColor);
	
	public TipoVehiculoEntity getTipoVehiculoById(int idTipoVehiculo);
	
	public TipoPerfilEntity getTipoPerfilById(int idTipoPerfil);
}
