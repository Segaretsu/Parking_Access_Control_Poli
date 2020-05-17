package co.com.poli.parking.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import co.com.poli.parking.dao.impl.UsuarioDaoImpl;
import co.com.poli.parking.models.entity.UsuarioEntity;

@Path("usuario")
public class UsuarioServices {

	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/usuario/crear
	 */
	@GET
	@Path("crear")
	@Produces("text/plain")
	public int crearUsuario() {
		UsuarioEntity usuario = UsuarioEntity.Builder.newInstance()
				.withIdTipoDocumento(1)
				.withIdTipoPerfil(1)
				.withNumeroDocumento("123456")
				.withNombre("Armando Esteban")
				.withApellidos("Quito")
				.withTelefono("112233")
				.withCorreo("prueba@prueba.com")
				.build();
		UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
		if(usuarioDaoImpl.registrarUsuario(usuario)) {
			return usuario.getIdUsuario();
		} else {
			return 0;
		}
	}
	
	/**
	 * URL Ejemplo: http://localhost:8080/Parking_Access_Control_Poli/Parking-back/usuario/consultar/idUsuario/12
	 */
	@GET
	@Path("consultar/idUsuario/{idUsuario}")
	@Produces("application/json")
	public UsuarioEntity crearUsuario(@PathParam("idUsuario") int idUsuario) {
		UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
		return usuarioDaoImpl.getUsuarioByIdUsuario(idUsuario);
	}
}
