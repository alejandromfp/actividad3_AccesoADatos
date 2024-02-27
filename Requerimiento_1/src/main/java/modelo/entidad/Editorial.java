package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "editoriales")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@Embedded
	private Direccion direccion;
	@OneToMany(mappedBy="autor", cascade=CascadeType.ALL)
	private List<Libro> coleccionLibros;
	public Editorial(Integer id, String nombre, Direccion direccion, List<Libro> coleccionLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.coleccionLibros = coleccionLibros;
	}
	public Editorial() {
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
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", coleccionLibros="
				+ coleccionLibros + "]";
	}
	
	

}
