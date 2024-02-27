package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "concesionarios")

public class Concesionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@Embedded
	private Direccion direccion;
	@OneToMany(mappedBy="concesionario", cascade=CascadeType.PERSIST)
	private List<Coche> coches;
	@OneToOne(mappedBy = "concesionario", cascade=CascadeType.PERSIST)
	private Gerente gerente;
	public Concesionario(Integer id, String nombre, Direccion direccion, List<Coche> coches, Gerente gerente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.coches = coches;
		this.gerente = gerente;
	}
	public Concesionario() {
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
	public List<Coche> getCoches() {
		return coches;
	}
	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	@Override
	public String toString() {
		return "Concesionario [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", coches=" + coches
				+ ", gerente=" + gerente + "]";
	}
	
	

}
