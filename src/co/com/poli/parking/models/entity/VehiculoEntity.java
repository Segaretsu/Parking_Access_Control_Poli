package co.com.poli.parking.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.poli.parking.models.entity.UsuarioEntity.Builder;

@Entity
@Table(name = "vehiculos")
public class VehiculoEntity {

	@Id @GeneratedValue
	@Column(name = "idVehiculo")
	private int idVehiculo;
	
	@Column(name = "idUsuario")
	private int idUsuario;
	
	@Column(name = "idTarjeta")
	private int idTarjeta;
	
	@Column(name = "idTipoVehiculo")
	private int idTipoVehiculo;
	
	@Column(name = "idMarca")
	private int idMarca;
	
	@Column(name = "idColor")
	private int idColor;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "numeroPuertas")
	private String numeroPuertas;
	
	@Column(name = "numeroChasis")
	private String numeroChasis;
	
	public VehiculoEntity(){
		
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

	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdTipoColor(int idColor) {
		this.idColor = idColor;
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

	public String getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(String numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	public String getNumeroChasis() {
		return numeroChasis;
	}

	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public VehiculoEntity (Builder builder) {
		this.idVehiculo = builder.idVehiculo;
		this.idUsuario = builder.idUsuario;
		this.idTarjeta = builder.idTarjeta;
		this.idTipoVehiculo = builder.idTipoVehiculo;
		this.idMarca = builder.idMarca;
		this.idColor = builder.idColor;
		this.placa = builder.placa;
		this.modelo = builder.modelo;
		this.numeroPuertas = builder.numeroPuertas;
		this.numeroChasis = builder.numeroChasis;
	}
	
	public static class Builder { 
		private int idVehiculo;
		private int idUsuario;
		private int idTarjeta;
		private int idTipoVehiculo;
		private int idMarca;
		private int idColor;
		private String placa;
		private String modelo;
		private String numeroPuertas;
		private String numeroChasis;
		
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
		
		public Builder withIdTipoVehiculo(int idTipoVehiculo) {
			this.idTipoVehiculo = idTipoVehiculo;
			return this;
		}
		
		public Builder withIdMarca(int idMarca) {
			this.idMarca = idMarca;
			return this;
		}
		
		public Builder withIdColor(int idColor) {
			this.idColor = idColor;
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
		
		public Builder withNumeroPuertas(String numeroPuertas) {
			this.numeroPuertas = numeroPuertas;
			return this;
		}
		
		public Builder withNumeroChasis(String numeroChasis) {
			this.numeroChasis = numeroChasis;
			return this;
		}
		
		public VehiculoEntity build() {
			return new VehiculoEntity(this);
		}
	}
}
