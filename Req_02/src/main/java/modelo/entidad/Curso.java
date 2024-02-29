package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bytebuddy.asm.Advice.OnMethodEnter;

@Entity
@Table
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@OneToMany (mappedBy = "curso", cascade = CascadeType.PERSIST)
	private List<Alumno> alumnos;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_profesor", referencedColumnName = "id")
	private Profesor tutor;

	public Curso() {
		super();
	}

	public Curso(Integer id, String nombre, List<Alumno> alumnos, Profesor tutor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alumnos = alumnos;
		this.tutor = tutor;
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

	public Profesor getTutor() {
		return tutor;
	}

	public void setTutor(Profesor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
	
	
	
}
