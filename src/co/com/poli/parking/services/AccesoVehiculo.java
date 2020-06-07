package co.com.poli.parking.services;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.poli.parking.dao.impl.TarjetaDaoImpl;
import co.com.poli.parking.dao.impl.VehiculoDaoImpl;
import co.com.poli.parking.models.dto.AccesoVehiculoInformacionDto;
import co.com.poli.parking.models.entity.TarjetaEntity;
@Path("acceso-vehiculo")
public class AccesoVehiculo {

	/**             http://localhost:8080/Parking_Access_Control_Poli/Parking-back/acceso-vehiculo/listarVehiculos/5/true
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tarjeta/crear
	 */
	@GET
	@Path("listarVehiculos/{cantidad}/{dentro}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccesoVehiculoInformacionDto> listarVehiculos(@PathParam("cantidad") int cantidadDatos, @PathParam("dentro") boolean vehiculosDentro) {

		List<AccesoVehiculoInformacionDto> listaAccesoV = new LinkedList<AccesoVehiculoInformacionDto>();
         VehiculoDaoImpl accesoV = new VehiculoDaoImpl();
		listaAccesoV = accesoV.getListaVehiculosDentro(cantidadDatos, vehiculosDentro);
		System.out.println("SE EJECUTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:::");
        return listaAccesoV;
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tarjeta/consultar/consultarByPlaca
	 */
	@POST
	@Path("consultarByPlaca")
	@Produces("application/json")
	public TarjetaEntity consultarUsuarioById(String placa) {
		TarjetaDaoImpl tarjetaDaoImpl = new TarjetaDaoImpl();
		return tarjetaDaoImpl.getTarjetaDeVehiculoByPlaca(placa);
	}
}