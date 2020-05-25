package co.com.poli.parking.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1900130513311017066L;

	@Id @GeneratedValue
	@Column(name = "idUsuario")
	private int idUsuario;
	
	@Column(name = "idTipoDocumento")
	private int idTipoDocumento;
	
	@Column(name = "idTipoPerfil")
	private int idTipoPerfil;
	
	@Column(name = "numeroDocumento")
	private String numeroDocumento;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "correo")
	private String correo;
	
	public UsuarioEntity () {
		
	}
	
    public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public int getIdTipoPerfil() {
		return idTipoPerfil;
	}

	public void setIdTipoPerfil(int idTipoPerfil) {
		this.idTipoPerfil = idTipoPerfil;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public UsuarioEntity (Builder builder) {
		this.idUsuario = builder.idUsuario;
		this.idTipoDocumento = builder.idTipoDocumento;
		this.idTipoPerfil = builder.idTipoPerfil;
		this.numeroDocumento = builder.numeroDocumento;
		this.nombre = builder.nombre;
		this.apellidos = builder.apellidos;
		this.telefono = builder.telefono;
		this.correo = builder.correo;
	}

	public static class Builder { 
		private int idUsuario;
		private int idTipoDocumento;
		private int idTipoPerfil;
		private String numeroDocumento;
		private String nombre;
		private String apellidos;
		private String telefono;
		private String correo;
		
		public static Builder newInstance () {
			return new Builder();
		}
		
		private Builder() {} 
		
		public Builder withIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
			return this;
		}
		
		public Builder withIdTipoDocumento(int idTipoDocumento) {
			this.idTipoDocumento = idTipoDocumento;
			return this;
		}
		
		public Builder withIdTipoPerfil(int idTipoPerfil) {
			this.idTipoPerfil = idTipoPerfil;
			return this;
		}
		
		public Builder withNumeroDocumento(String numeroDocumento) {
			this.numeroDocumento = numeroDocumento;
			return this;
		}
		
		public Builder withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder withApellidos(String apellidos) {
			this.apellidos = apellidos;
			return this;
		}
		
		public Builder withTelefono (String telefono) {
			this.telefono = telefono;
			return this;
		}
		
		public Builder withCorreo(String correo) {
			this.correo = correo;
			return this;
		}
		
		public UsuarioEntity build() {
			return new UsuarioEntity(this);
		}
    }
    
}
