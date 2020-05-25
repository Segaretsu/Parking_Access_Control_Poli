package co.com.poli.parking.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_estados")
public class TipoEstadoEntity {

	@Id
	@GeneratedValue
	@Column(name = "idEstado")
	private int idEstado;

	@Column(name = "descripcion")
	private String descripcion;

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoEstadoEntity() {
	}

	public TipoEstadoEntity(Builder builder) {
		this.idEstado = builder.idEstado;
		this.descripcion = builder.descripcion;
	}

	public static class Builder {
		private int idEstado;
		private String descripcion;

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		public TipoEstadoEntity build() {
			return new TipoEstadoEntity(this);
		}

		public Builder withIdEstado(int idEstado) {
			this.idEstado = idEstado;
			return this;
		}

		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
	}
}
