package co.com.poli.parking.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_colores")
public class TipoColorEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1276826317949346702L;

	@Id @GeneratedValue
	@Column(name = "idColor")
	private int idColor;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoColorEntity() {}
	
	public TipoColorEntity (Builder builder) {
		this.idColor = builder.idColor;
		this.descripcion = builder.descripcion;
	}
	
	public static class Builder { 
		private int idColor;
		private String descripcion;
		
		public static Builder newInstance() {
			return new Builder();
		}
		
		private Builder() {}
		
		public TipoColorEntity build() {
			return new TipoColorEntity(this);
		}
		
		public Builder withIdColor(int idColor) {
			this.idColor = idColor;
			return this;
		}
		
		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
	}
}
