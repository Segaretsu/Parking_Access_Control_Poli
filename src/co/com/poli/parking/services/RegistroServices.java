package co.com.poli.parking.services;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.poli.parking.dao.impl.RegistroDaoImplm;
import co.com.poli.parking.dao.impl.UsuarioDaoImpl;
import co.com.poli.parking.models.entity.RegistroEntity;
import co.com.poli.parking.models.entity.UsuarioEntity;

@Path("registro")
public class RegistroServices {

	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/registro/crear
	 */
	@GET
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int crearRegistro(RegistroEntity registro) {
//		RegistroEntity registro = RegistroEntity.Builder.newInstance()
//				.withIdVehiculo(5)
//				.withIdTarjeta(1)
//				.withFechaEntrada(new Date())
//				.withFechaSalida(null)
//				.withIdEstado(1)
//				.build();
		
		
		RegistroDaoImplm registroDaoImpl = new RegistroDaoImplm();
		if(registroDaoImpl.registrarRegistro(registro)) {
			return registro.getIdRegistro();
		} else {
			return 0;
		}
	}
}
