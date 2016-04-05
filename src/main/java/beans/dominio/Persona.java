package beans.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")//si las tablas tiene distintos nombres, no es sensible a mayusculas
public class Persona {
	
	@Id  //llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto incrementable
	@Column(name="id_persona")//cuando los nombres de id son distinto se utiliza la anotacion Column para identificar el nombre que posee en BD
	private Integer idPersona;
	
	@Column(nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido_paterno", nullable=false, length=45)
	private String apePaterno;
	
	@Column(name="apellido_materno", length=45)
	private String apeMaterno;
	
	@Column(nullable=false, length=45)
	private String email;
	
	@Column(length=45)
	private String telefono;

	//Este constructor utilizado por JPA es necesario agregarlo
	public Persona(){}
	
	public Persona (Integer idPersona){
		this.idPersona = idPersona;
	}
	
	
	
	public Persona(String nombre, String apePaterno, String apeMaterno, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.telefono = telefono;
	}



	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apePaterno=" + apePaterno + ", apeMaterno="
				+ apeMaterno + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
	
	
	

}
