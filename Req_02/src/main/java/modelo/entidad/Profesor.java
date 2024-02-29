package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@OneToOne(mappedBy = "tutor", cascade = CascadeType.PERSIST)
	private Curso tutor;
	
	@OneToMany(mappedBy = "profesor" ,cascade = CascadeType.PERSIST)
	private List<Asignatura> asignaturas;
	
	public Profesor() {
		super();
	}

	public Profesor(Integer id, String nombre, Curso curso, List<Asignatura> asignaturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tutor = curso;
		this.asignaturas = asignaturas;
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

	public Curso getCurso() {
		return tutor;
	}

	public void setCurso(Curso curso) {
		this.tutor = curso;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", curso=" + tutor + ", asignaturas=" + asignaturas + "]";
	}
	
	
	
	
}
