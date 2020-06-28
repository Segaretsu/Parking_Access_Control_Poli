package co.com.poli.parking.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.poli.parking.models.entity.UsuarioEntity.Builder;

@Entity
@Table(name = "registros")
public class RegistroEntity {
	@Id @GeneratedValue
	@Column(name = "idRegistro")
	private int idRegistro;
	
	@Column(name = "idVehiculo")
	private int idVehiculo;
	
	@Column(name = "idTarjeta")
	private int idTarjeta;
	
	@Column(name = "fechaEntrada")
	private Date fechaEntrada;
	
	@Column(name = "fechaSalida")
	private Date fechaSalida;
	
	@Column(name = "idEstado")
	private int idEstado;
	
	public RegistroEntity(){
		
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
	public RegistroEntity (Builder builder) {
		this.idRegistro = builder.idRegistro;
		this.idVehiculo = builder.idVehiculo;
		this.idTarjeta = builder.idTarjeta;
		this.fechaEntrada = builder.fechaEntrada;
		this.fechaSalida = builder.fechaSalida;
		this.idEstado = builder.idEstado;
	}

	public static class Builder { 
		private int idRegistro;
		private int idVehiculo;
		private int idTarjeta;
		private Date fechaEntrada;
		private Date fechaSalida;
		private int idEstado;
		
		public static Builder newInstance () {
			return new Builder();
		}
		
		private Builder() {} 
		
		public Builder withIdRegistro(int idRegistro) {
			this.idRegistro = idRegistro;
			return this;
		}
		
		public Builder withIdVehiculo(int idVehiculo) {
			this.idVehiculo = idVehiculo;
			return this;
		}
		
		public Builder withIdTarjeta(int idTarjeta) {
			this.idTarjeta = idTarjeta;
			return this;
		}
		
		public Builder withFechaEntrada(Date fechaEntrada) {
			this.fechaEntrada = fechaEntrada;
			return this;
		}
		
		public Builder withFechaSalida(Date fechaSalida) {
			this.fechaSalida = fechaSalida;
			return this;
		}
		
		public Builder withIdEstado(int idEstado) {
			this.idEstado = idEstado;
			return this;
		}
		
		public RegistroEntity build() {
			return new RegistroEntity(this);
		}
	}

	@Override
	public String toString() {
		return "RegistroEntity [idRegistro=" + idRegistro + ", idVehiculo=" + idVehiculo + ", idTarjeta=" + idTarjeta
				+ ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", idEstado=" + idEstado + "]";
	}
}
