package co.com.poli.parking.models.dto;

import co.com.poli.parking.models.entity.VehiculoEntity;
import co.com.poli.parking.models.entity.VehiculoEntity.Builder;

public class AccesoVehiculoInformacionDto {

	private int idVehiculo;
	private int idUsuario;
	private int idTarjeta;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String iconoTipoVehiculo;
	private String nombreColor;
	private String placa;
	private String modelo;
	
	public AccesoVehiculoInformacionDto() {
		
	}
	
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidosUsuario() {
		return apellidosUsuario;
	}
	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}
	public String getIconoTipoVehiculo() {
		return iconoTipoVehiculo;
	}
	public void setIconoTipoVehiculo(String iconoTipoVehiculo) {
		this.iconoTipoVehiculo = iconoTipoVehiculo;
	}
	public String getNombreColor() {
		return nombreColor;
	}
	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public AccesoVehiculoInformacionDto (Builder builder) {
		this.idVehiculo = builder.idVehiculo;
		this.idUsuario = builder.idUsuario;
		this.idTarjeta = builder.idTarjeta;
		this.nombreUsuario = builder.nombreUsuario;
		this.apellidosUsuario = builder.apellidosUsuario;
		this.iconoTipoVehiculo = builder.iconoTipoVehiculo;
		this.nombreColor = builder.nombreColor;
		this.placa = builder.placa;
		this.modelo = builder.modelo;
	}
	
	public static class Builder { 
		private int idVehiculo;
		private int idUsuario;
		private int idTarjeta;
		private String nombreUsuario;
		private String apellidosUsuario;
		private String iconoTipoVehiculo;
		private String nombreColor;
		private String placa;
		private String modelo;

		
		public static Builder newInstance () {
			return new Builder();
		}
		
		private Builder() {} 
		
		public Builder withIdVehiculo(int idVehiculo) {
			this.idVehiculo = idVehiculo;
			return this;
		}
		
		public Builder withIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
			return this;
		}
		
		public Builder withIdTarjeta(int idTarjeta) {
			this.idTarjeta = idTarjeta;
			return this;
		}
		
		public Builder withNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
			return this;
		}
		
		public Builder withApellidosUsuario(String apellidosUsuario) {
			this.apellidosUsuario = apellidosUsuario;
			return this;
		}
		
		public Builder withIconoTipoVehiculo(String iconoTipoVehiculo) {
			this.iconoTipoVehiculo = iconoTipoVehiculo;
			return this;
		}
		
		public Builder withNombreColor(String nombreColor) {
			this.nombreColor = nombreColor;
			return this;
		}
		
		public Builder withPlaca(String placa) {
			this.placa = placa;
			return this;
		}
		
		public Builder withModelo(String modelo) {
			this.modelo = modelo;
			return this;
		}

		public AccesoVehiculoInformacionDto build() {
			return new AccesoVehiculoInformacionDto(this);
		}
	
	}
}
