package co.com.poli.parking.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarjetas")
public class TarjetaEntity {

	@Id
	@GeneratedValue
	@Column(name = "idTarjeta")
	private int idTarjeta;

	@Column(name = "idEstado")
	private int idEstado;

	@Column(name = "numeroTarjeta")
	private String numeroTarjeta;

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public TarjetaEntity() {
	}

	public TarjetaEntity(Builder builder) {
		this.idTarjeta = builder.idTarjeta;
		this.idEstado = builder.idEstado;
		this.numeroTarjeta = builder.numeroTarjeta;
	}

	public static class Builder {
		private int idTarjeta;
		private int idEstado;
		private String numeroTarjeta;

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		public TarjetaEntity build() {
			return new TarjetaEntity(this);
		}

		public Builder withIdTarjeta(int idTarjeta) {
			this.idTarjeta = idTarjeta;
			return this;
		}

		public Builder withIdEstado(int idEstado) {
			this.idEstado = idEstado;
			return this;
		}

		public Builder withNumeroTarjeta(String numeroTarjeta) {
			this.numeroTarjeta = numeroTarjeta;
			return this;
		}
	}

}
