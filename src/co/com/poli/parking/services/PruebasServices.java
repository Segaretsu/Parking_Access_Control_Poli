package co.com.poli.parking.services;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import co.com.poli.parking.connection.pruebas;

@Path("pruebas")
public class PruebasServices {

	
	@GET
	@Path("server/estatus")
	@Produces("text/plain")
	public String getEstadoWebServices() {
		/**
		 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/pruebas/server/estatus
		 */
		pruebas p = new pruebas();
		return p.insertar();
	}
	
	@POST
	@Path("nombreEnviado/{username}")
    @Produces("text/plain")
    public String getNombreEjemplo(@PathParam("username") String nombre) {
		/**
		 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/pruebas/nombreEnviado/Juan Perez
		 */
        return nombre;
    }
	
	
	/**
	 * Para aprender un poco más de los métodos de los web services:
	 * https://docs.oracle.com/javaee/6/tutorial/doc/gilik.html
	 */
}
