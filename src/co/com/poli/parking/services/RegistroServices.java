package co.com.poli.parking.services;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jmx.snmp.Timestamp;

import co.com.poli.parking.dao.impl.RegistroDaoImpl;
import co.com.poli.parking.dao.impl.TarjetaDaoImpl;
import co.com.poli.parking.dao.impl.UsuarioDaoImpl;
import co.com.poli.parking.dao.impl.VehiculoDaoImpl;
import co.com.poli.parking.models.dto.FechasRegistrosDto;
import co.com.poli.parking.models.entity.RegistroEntity;
import co.com.poli.parking.models.entity.TarjetaEntity;
import co.com.poli.parking.models.entity.UsuarioEntity;
import co.com.poli.parking.models.entity.VehiculoEntity;

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
		
		
		RegistroDaoImpl registroDaoImpl = new RegistroDaoImpl();
		if(registroDaoImpl.registrarRegistro(registro)) {
			return registro.getIdRegistro();
		} else {
			return 0;
		}
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/registro/ingreso/placa/{placa}/idTipoV/{idTipoVehiculo}
	 */
	@GET
	@Path("ingreso/placa/{placa}/idTipoV/{idTipoVehiculo}")
	@Produces(MediaType.TEXT_PLAIN)
	public int crearRegistro(@PathParam("placa") String placa, @PathParam("idTipoVehiculo") int idTipoVehiculo) {
		VehiculoDaoImpl vehiculoDaoImpl = new VehiculoDaoImpl();
		VehiculoEntity vehiculo = vehiculoDaoImpl.getVehiculoByPlaca(placa);
		RegistroEntity registro = null;
		if(vehiculo != null) {
			registro = RegistroEntity.Builder.newInstance()
					.withIdVehiculo(vehiculo.getIdVehiculo())
					.withIdTarjeta(vehiculo.getIdTarjeta())
					.withFechaEntrada(new Date())
					.withFechaSalida(null)
					.withIdEstado(1)
					.build();
		} else {
			VehiculoEntity vehiculoNew = VehiculoEntity.Builder.newInstance()
					.withIdTipoVehiculo(idTipoVehiculo)
					.withIdTarjeta(0)
					.withIdMarca(0)
					.withModelo("No Registra")
					.withPlaca(placa)
					.build();
			vehiculoDaoImpl.registrarVehiculo(vehiculoNew);
			registro = RegistroEntity.Builder.newInstance()
					.withIdVehiculo(vehiculoNew.getIdVehiculo())
					.withIdTarjeta(vehiculoNew.getIdTarjeta())
					.withFechaEntrada(new Date())
					.withFechaSalida(null)
					.withIdEstado(1)
					.build();
		}
		RegistroDaoImpl registroDaoImpl = new RegistroDaoImpl();
		if(registroDaoImpl.registrarRegistro(registro)) {
			return registro.getIdRegistro();
		} else {
			return 0;
		}
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/registro/salida/placa/{placa}
	 */
	@GET
	@Path("salida/placa/{placa}")
	@Produces(MediaType.TEXT_PLAIN)
	public int registrarSalida(@PathParam("placa") String placa) {
		VehiculoDaoImpl vehiculoDaoImpl = new VehiculoDaoImpl();
		VehiculoEntity vehiculo = vehiculoDaoImpl.getVehiculoByPlaca(placa);
		RegistroDaoImpl registroDaoImpl = new RegistroDaoImpl();
		RegistroEntity registro = registroDaoImpl.getUltimoRegistroByIdVehiculo(vehiculo.getIdVehiculo());
		registro.setIdEstado(2);
		registro.setFechaSalida(new java.sql.Timestamp(new java.util.Date().getTime()));
		if(registroDaoImpl.actualizarRegistro(registro)) {
			return 1;
		} 
		else {
			return 0;
		}
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/registro/fechas/p/asd123/FI/2020-01-01/FF/2020-12-31
	 */
	@GET
	@Path("fechas/p/{placa}/FI/{fechaInicio}/FF/{fechaFin}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FechasRegistrosDto> getListaFechas(@PathParam("placa") String placa, @PathParam("fechaInicio") String fechaInicio, 
			@PathParam("fechaFin") String fechaFin) {
		VehiculoDaoImpl vehiculoDaoImpl = new VehiculoDaoImpl();
		VehiculoEntity vehiculo = vehiculoDaoImpl.getVehiculoByPlaca(placa);
		RegistroDaoImpl registroDaoImpl = new RegistroDaoImpl();
		return registroDaoImpl.getListaFechasRegistros(vehiculo.getIdVehiculo(), fechaInicio, fechaFin);
	}
}
