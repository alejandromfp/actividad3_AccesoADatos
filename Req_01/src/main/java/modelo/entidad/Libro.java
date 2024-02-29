package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Double precio;
	
	@ManyToOne(cascade=CascadeType.PERSIST) 
	@JoinColumn(name = "fk_id_editorial", referencedColumnName="id")
	private Editorial editorial;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_autor", referencedColumnName="id")
	private Autor autor;
	
	@ManyToMany(mappedBy="libros", cascade=CascadeType.PERSIST) 
	private List<Libreria> librerias;
	
	
	public Libro() {
		super();
	}
	public Libro(Integer id, String titulo, Double precio, Editorial editorial, Autor autor, List<Libreria> librerias) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
		this.librerias = librerias;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	public List<Libreria> getLibrerias() {
		return librerias;
	}
	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}
	
	
	
}
