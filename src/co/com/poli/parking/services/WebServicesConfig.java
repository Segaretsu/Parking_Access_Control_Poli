package co.com.poli.parking.services;
import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("Parking-back")
public class WebServicesConfig  extends Application{
	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}
	
	public void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(co.com.poli.parking.services.PruebasServices.class);
		resources.add(co.com.poli.parking.services.UsuarioServices.class);
		resources.add(co.com.poli.parking.services.VehiculoServices.class);
		resources.add(co.com.poli.parking.services.RegistroServices.class);
	}
}
