package co.com.poli.parking.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_perfiles")
public class TipoPerfilEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4944328797732148177L;

	@Id
	@Column(name = "idTipoPerfil")
	private int idTipoPerfil;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public TipoPerfilEntity () {}
	
	public int getIdTipoPerfil() {
		return idTipoPerfil;
	}

	public void setIdTipoPerfil(int idTipoPerfil) {
		this.idTipoPerfil = idTipoPerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoPerfilEntity (Builder builder) {
		this.idTipoPerfil = builder.idTipoPerfil;
		this.descripcion = builder.descripcion;
	}
	
	public static class Builder { 
		private int idTipoPerfil;
		private String descripcion;
		
		public static Builder newInstance() {
			return new Builder();
		}
		
		private Builder() {}
		
		public TipoPerfilEntity build () {
			return new TipoPerfilEntity(this);
		}
		
		public Builder withIdTipoPerfil(int idTipoPerfil) {
			this.idTipoPerfil = idTipoPerfil;
			return this;
		}
		
		public Builder withDescripcion(String descripcion) {
			this.descripcion = descripcion;
			return this;
		}
	}
}
