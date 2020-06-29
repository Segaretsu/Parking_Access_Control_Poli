package co.com.poli.parking.models.dto;

import java.sql.Timestamp;

public class FechasRegistrosDto {
	private Timestamp fechaIngreso;
	private Timestamp fechaSalida;
	
	public FechasRegistrosDto () {}
	
	public FechasRegistrosDto (Builder builder) {
		this.fechaIngreso = builder.fechaIngreso;
		this.fechaSalida = builder.fechaSalida;
	}
	
	public static class Builder { 
		private Timestamp fechaIngreso;
		private Timestamp fechaSalida;
		
		public static Builder newInstance () {
			return new Builder();
		}
		
		private Builder() {} 
		
		public FechasRegistrosDto build() {
			return new FechasRegistrosDto(this);
		}
		
		public Builder withFechaIngreso(Timestamp fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
			return this;
		}
		
		public Builder withFechaSalida(Timestamp fechaSalida) {
			this.fechaSalida = fechaSalida;
			return this;
		}
	
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
}
