package co.com.poli.parking.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_marcas")
public class TipoMarcaEntity {

	@Id
	@GeneratedValue
	@Column(name = "idMarca")
	private int idMarca;

	@Column(name = "descripcion")
	private String descripcion;
	
	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoMarcaEntity() {
	}

	public TipoMarcaEntity(Builder builder) {
		this.idMarca = builder.idMarca;
		this.descripcion = builder.descripcion;
	}

	public static class Builder {
		private int idMarca;
		private String descripcion;

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		public TipoMarcaEntity build() {
			return new TipoMarcaEntity(this);
		}

		public Builder withIdMarca(int idMarca) {
			this.idMarca = idMarca;
			return this;
		}

		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
	}
}
