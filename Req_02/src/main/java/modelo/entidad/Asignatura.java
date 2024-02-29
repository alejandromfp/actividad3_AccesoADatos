package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "alumno_asignaturas",
			   joinColumns = {@JoinColumn(name = "fk_id_asignatura",referencedColumnName = "id")},
			   inverseJoinColumns = {@JoinColumn(name = "fk_id_alumno", referencedColumnName = "id")})
	private List<Alumno> alumnos;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_profesor", referencedColumnName = "id")
	private Profesor profesor;

	public Asignatura() {
		super();
	}

	public Asignatura(Integer id, String nombre, List<Alumno> alumnos, Profesor profesor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alumnos = alumnos;
		this.profesor = profesor;
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

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
	
	
	
	
	
	
}
