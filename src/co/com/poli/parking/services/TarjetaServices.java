package co.com.poli.parking.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.poli.parking.dao.TarjetaDao;
import co.com.poli.parking.dao.impl.TarjetaDaoImpl;
import co.com.poli.parking.dao.impl.UsuarioDaoImpl;
import co.com.poli.parking.models.entity.TarjetaEntity;
import co.com.poli.parking.models.entity.UsuarioEntity;

@Path("tarjeta")
public class TarjetaServices {

	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/tarjeta/crear
	 */
	@POST
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int crearUsuario(TarjetaEntity tarjeta) {
//		TarjetaEntity tarjeta = TarjetaEntity.Builder.newInstance()
//				.withIdEstado(1)
//				.withNumeroTarjeta("123456")
//				.build();
		
		TarjetaDaoImpl tarjetaDaoImpl = new TarjetaDaoImpl();
		if(tarjetaDaoImpl.registrarTarjeta(tarjeta)) {
			return tarjeta.getIdTarjeta();
		} else {
			return 0;
		}
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
