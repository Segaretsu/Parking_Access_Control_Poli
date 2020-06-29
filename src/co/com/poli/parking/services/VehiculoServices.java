package co.com.poli.parking.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.poli.parking.dao.impl.UsuarioDaoImpl;
import co.com.poli.parking.dao.impl.VehiculoDaoImpl;
import co.com.poli.parking.models.entity.UsuarioEntity;
import co.com.poli.parking.models.entity.VehiculoEntity;

@Path("vehiculo")
public class VehiculoServices {

	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/vehiculo/crear
	 */
	@POST
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int crearVehiculo(VehiculoEntity vehiculo) {
		/*VehiculoEntity vehiculo = VehiculoEntity.Builder.newInstance()
				.withIdUsuario(1)
				.withIdTarjeta(1)
				.withIdTipoVehiculo(1)
				.withIdMarca(1)
				.withIdColor(1)
				.withPlaca("ABC123")
				.withModelo("2020")
				.withNumeroPuertas("4")
				.withNumeroChasis("3565464")
				.build();           
		*/
		VehiculoDaoImpl vehiculoDaoImpl = new VehiculoDaoImpl();
		if(vehiculoDaoImpl.registrarVehiculo(vehiculo)) {
			return vehiculo.getIdVehiculo();
		} else {
			return 0;
		}
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/vehiculo/consultar/placa/asd123
	 */
	@GET
	@Path("consultar/placa/{placa}")
	@Produces("application/json")
	public VehiculoEntity consultarVehiculoByPlaca(@PathParam("placa") String placa) {
		VehiculoDaoImpl vehiculoDaoImpl = new VehiculoDaoImpl();
		return vehiculoDaoImpl.getVehiculoByPlaca(placa);
	}
}
