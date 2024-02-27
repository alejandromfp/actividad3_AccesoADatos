package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "coches")
public class Coche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;
	private String color;
	@Temporal(TemporalType.DATE)
	private Date fechaMatriculacion;
	@ManyToOne
	@JoinColumn(name="fk_id_concesionario", referencedColumnName="id")
	private Concesionario concesionario;
	@ManyToMany(mappedBy="coches", cascade=CascadeType.PERSIST)
	private List<Servicio> servicios;
	public Coche(String matricula, String marca, String modelo, String color, Date fechaMatriculacion,
			Concesionario concesionario, List<Servicio> servicios) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.fechaMatriculacion = fechaMatriculacion;
		this.concesionario = concesionario;
		this.servicios = servicios;
	}
	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getFechaMatriculacion() {
		return fechaMatriculacion;
	}
	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}
	public Concesionario getConcesionario() {
		return concesionario;
	}
	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", fechaMatriculacion=" + fechaMatriculacion + ", concesionario=" + concesionario + ", servicios="
				+ servicios + "]";
	}
	
	
	
}
