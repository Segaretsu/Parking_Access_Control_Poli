package co.com.poli.parking.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.poli.parking.models.entity.TipoPerfilEntity.Builder;

@Entity
@Table(name = "tipo_documentos")
public class TipoDocumentoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1704211996337587100L;

	@Id @GeneratedValue
	@Column(name = "idTipoDocumento")
	private int idTipoDocumento;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TipoDocumentoEntity() {}
	
	public TipoDocumentoEntity (Builder builder) {
		this.idTipoDocumento = builder.idTipoDocumento;
		this.descripcion = builder.descripcion;
	}
	
	public static class Builder { 
		private int idTipoDocumento;
		private String descripcion;
		
		public static Builder newInstance() {
			return new Builder();
		}
		
		private Builder() {}
		
		public TipoDocumentoEntity build() {
			return new TipoDocumentoEntity(this);
		}
		
		public Builder withIdTipoDocumento(int idTipoDocumento) {
			this.idTipoDocumento = idTipoDocumento;
			return this;
		}
		
		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
	}
}
