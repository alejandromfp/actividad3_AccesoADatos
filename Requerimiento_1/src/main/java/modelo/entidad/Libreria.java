package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "librerias")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String nombrePropietario;
	@Embedded
	private Direccion direccion;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="librerias_libros",
			   joinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id") },
			   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id")})
	private List<Libro> coleccionLibros;
	public Libreria(Integer id, String nombre, String nombrePropietario, Direccion direccion,
			List<Libro> coleccionLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombrePropietario = nombrePropietario;
		this.direccion = direccion;
		this.coleccionLibros = coleccionLibros;
	}
	public Libreria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombrePropietario() {
		return nombrePropietario;
	}
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public List<Libro> getColeccionLibros() {
		return coleccionLibros;
	}
	public void setColeccionLibros(List<Libro> coleccionLibros) {
		this.coleccionLibros = coleccionLibros;
	}
	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombrePropietario=" + nombrePropietario + ", direccion="
				+ direccion + ", coleccionLibros=" + coleccionLibros + "]";
	}
	
	

}
