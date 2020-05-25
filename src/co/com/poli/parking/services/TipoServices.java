package co.com.poli.parking.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import co.com.poli.parking.dao.impl.TiposDaoImpl;
import co.com.poli.parking.models.entity.TipoColorEntity;
import co.com.poli.parking.models.entity.TipoDocumentoEntity;
import co.com.poli.parking.models.entity.TipoEstadoEntity;
import co.com.poli.parking.models.entity.TipoMarcaEntity;
import co.com.poli.parking.models.entity.TipoPerfilEntity;
import co.com.poli.parking.models.entity.TipoVehiculoEntity;

@Path("tipo")
public class TipoServices {

	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tipo/documentos
	 */
	@GET
	@Path("documentos")
	@Produces("application/json")
	public List<TipoDocumentoEntity> listaTipoDocumentos() {
		TiposDaoImpl tipoDocumentoDaoImpl = new TiposDaoImpl();
		return tipoDocumentoDaoImpl.getListaTipoDocumentos();
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tipo/perfiles
	 */
	@GET
	@Path("perfiles")
	@Produces("application/json")
	public List<TipoPerfilEntity> listaTipoPerfiles() {
		TiposDaoImpl tipoDocumentoDaoImpl = new TiposDaoImpl();
		return tipoDocumentoDaoImpl.getListaTipoPerfiles();
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tipo/colores
	 */
	@GET
	@Path("colores")
	@Produces("application/json")
	public List<TipoColorEntity> listaColores() {
		TiposDaoImpl tipoDocumentoDaoImpl = new TiposDaoImpl();
		return tipoDocumentoDaoImpl.getListaColores();
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tipo/estados
	 */
	@GET
	@Path("estados")
	@Produces("application/json")
	public List<TipoEstadoEntity> listaEstados() {
		TiposDaoImpl tipoDocumentoDaoImpl = new TiposDaoImpl();
		return tipoDocumentoDaoImpl.getListaEstados();
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tipo/marcas
	 */
	@GET
	@Path("marcas")
	@Produces("application/json")
	public List<TipoMarcaEntity> listaMarcas() {
		TiposDaoImpl tipoDocumentoDaoImpl = new TiposDaoImpl();
		return tipoDocumentoDaoImpl.getListaMarcas();
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tipo/vehiculos
	 */
	@GET
	@Path("vehiculos")
	@Produces("application/json")
	public List<TipoVehiculoEntity> listaTipoVehiculos() {
		TiposDaoImpl tipoDocumentoDaoImpl = new TiposDaoImpl();
		return tipoDocumentoDaoImpl.getListaTipoVehiculos();
	}
}
