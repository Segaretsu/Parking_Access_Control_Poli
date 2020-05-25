package co.com.poli.parking.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_vehiculos")
public class TipoVehiculoEntity {

	@Id
	@GeneratedValue
	@Column(name = "idTipoVehiculo")
	private int idTipoVehiculo;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "nombreicono")
	private String nombreicono;
	
	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreicono() {
		return nombreicono;
	}

	public void setNombreicono(String nombreicono) {
		this.nombreicono = nombreicono;
	}

	public TipoVehiculoEntity() {
	}

	public TipoVehiculoEntity(Builder builder) {
		this.idTipoVehiculo = builder.idTipoVehiculo;
		this.descripcion = builder.descripcion;
		this.nombreicono = builder.nombreicono;
	}

	public static class Builder {
		private int idTipoVehiculo;
		private String descripcion;
		private String nombreicono;

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		public TipoVehiculoEntity build() {
			return new TipoVehiculoEntity(this);
		}

		public Builder withIdTipoVehiculo(int idTipoVehiculo) {
			this.idTipoVehiculo = idTipoVehiculo;
			return this;
		}

		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
		
		public Builder withNombreIcono(String nombreicono) {
			this.nombreicono = nombreicono;
			return this;
		}
	}
}
