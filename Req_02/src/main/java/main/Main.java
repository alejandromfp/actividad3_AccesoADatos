package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import modelo.entidad.Alumno;
import modelo.entidad.Asignatura;
import modelo.entidad.Curso;
import modelo.entidad.Direccion;
import modelo.entidad.Profesor;

public class Main {

	private static EntityManagerFactory factoria;
	private static EntityManager em;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		factoria = Persistence.createEntityManagerFactory("JPAAlumnos");
		em = factoria.createEntityManager();
		
		
		//DIRECCIONES 
		Direccion d1 = new Direccion("Avenida", "Reforma", "Ciudad de México");
		Direccion d2 = new Direccion("Calle", "Gran Vía", "Madrid");
		Direccion d3 = new Direccion("Boulevard", "Santa Monica", "Los Ángeles");
		Direccion d4 = new Direccion("Rue", "de la Paix", "París");
		Direccion d5 = new Direccion("Calle", "de la Plata", "Cádiz");
		
		
		//ALUMNOS
		Alumno alumno1 = new Alumno(null, "Juan", 18,d1,null, null);
	    Alumno alumno2 = new Alumno(null, "María", 17, d2,null, null);
	    Alumno alumno3 = new Alumno(null, "Pedro", 19, d3,null, null);
	    Alumno alumno4 = new Alumno(null, "Laura", 16, d4,null, null);
	    Alumno alumno5 = new Alumno(null, "Carlos", 20, d5,null, null);
	    
	    
	    //ASIGNATURAS
	    List<Alumno> alumnosTodos = new ArrayList<Alumno>();
	    alumnosTodos.add(alumno1);
	    alumnosTodos.add(alumno2);
	    alumnosTodos.add(alumno3);
	    alumnosTodos.add(alumno4);
	    alumnosTodos.add(alumno5);
	    
		Asignatura matematicas = new Asignatura(null,"Matematicas",alumnosTodos, null);
		Asignatura lengua = new Asignatura(null,"Lengua",alumnosTodos, null);
		Asignatura biologia = new Asignatura(null,"Biologia",alumnosTodos, null);
		Asignatura ingles = new Asignatura(null,"Inglés",alumnosTodos, null);
		
		
		List<Alumno> alumnosFyQ = new ArrayList<Alumno>();
	    alumnosFyQ.add(alumno1);
	    alumnosFyQ.add(alumno2);
	    alumnosFyQ.add(alumno3);
		Asignatura fisicayquimica = new Asignatura(null,"Fisica y Quimica",alumnosFyQ, null);
		
		List<Alumno> alumnosArte = new ArrayList<Alumno>();
	    alumnosArte.add(alumno4);
	    alumnosArte.add(alumno5);
		Asignatura arte = new Asignatura(null,"Arte",alumnosArte, null);
		
		//CURSOS
		
		List<Alumno> alumnos1A = new ArrayList<Alumno>();
		alumnos1A.add(alumno1);
		alumnos1A.add(alumno2);
		Curso curso1 = new Curso(null, "1ºA", alumnos1A, null);
		
		List<Alumno> alumnos1B = new ArrayList<Alumno>();
		alumnos1B.add(alumno3);
		alumnos1B.add(alumno4);
		Curso curso2 = new Curso(null, "1ºB", alumnos1B, null);
		
		List<Alumno> alumnos1C = new ArrayList<Alumno>();
		alumnos1C.add(alumno5);
		Curso curso3 = new Curso(null, "1ºC", alumnos1C, null);
		
		
		List<Asignatura> asignaturasAndres = new ArrayList<Asignatura>();
		asignaturasAndres.add(matematicas);
		asignaturasAndres.add(lengua);
		Profesor andres = new Profesor(null, "Andres", curso1, asignaturasAndres);
		
		List<Asignatura> asignaturasPepe = new ArrayList<Asignatura>();
		asignaturasPepe.add(ingles);
		asignaturasPepe.add(biologia);
		Profesor pepe = new Profesor(null, "Pepe", curso2, asignaturasPepe);
		
		List<Asignatura> asignaturasLaura = new ArrayList<Asignatura>();
		asignaturasLaura.add(arte);
		asignaturasLaura.add(fisicayquimica);
		Profesor laura = new Profesor(null, "Laura", curso3, asignaturasLaura);
		
		//Bidirecionalidad
		
		//CURSOS
		curso1.setTutor(andres);
		curso2.setTutor(pepe);
		curso3.setTutor(laura);
		
		//ASIGNATURAS
		
		matematicas.setProfesor(andres);
		lengua.setProfesor(andres);
		ingles.setProfesor(pepe);
		biologia.setProfesor(pepe);
		arte.setProfesor(laura);
		fisicayquimica.setProfesor(laura);
		
		//ALUMNOS 
		
		//asignaturas de alumnnos artes o ciencias
		List<Asignatura> asignaturasCiencias = new ArrayList<Asignatura>();
		asignaturasCiencias.add(matematicas);
		asignaturasCiencias.add(lengua);
		asignaturasCiencias.add(ingles);
		asignaturasCiencias.add(biologia);
		asignaturasCiencias.add(fisicayquimica);
		alumno1.setAsignaturas(asignaturasCiencias);
		alumno2.setAsignaturas(asignaturasCiencias);
		alumno3.setAsignaturas(asignaturasCiencias);
		
		List<Asignatura> asignaturasArtes = new ArrayList<Asignatura>();
		asignaturasArtes.add(matematicas);
		asignaturasArtes.add(lengua);
		asignaturasArtes.add(ingles);
		asignaturasArtes.add(biologia);
		asignaturasArtes.add(arte);
		alumno4.setAsignaturas(asignaturasArtes);
		alumno5.setAsignaturas(asignaturasArtes);
		
		alumno1.setCurso(curso1);
		alumno2.setCurso(curso1);
		alumno3.setCurso(curso2);
		alumno4.setCurso(curso2);
		alumno5.setCurso(curso3);
		
		System.out.println("============================================================");
		em.getTransaction().begin();
		
		em.persist(matematicas);
		
		em.getTransaction().commit();
		
		System.out.println("===================QUERIES==================================");
		
		
		System.out.println("\n\nAlumnos y todas las asignatauras");
		
		Query query = em.createQuery("Select a from Alumno a");
		List<Alumno> listaAlumnos = query.getResultList();
		
		for (Alumno a : listaAlumnos) {
			
			System.out.print("Id: " + a.getId()+ "  ");
			System.out.print("Nombre: " + a.getNombre()+ "  ");
			System.out.print("Asignaturas");
			for(Asignatura asig : a.getAsignaturas()) {
				System.out.print("| " + asig.getNombre() + " |");
			}
			System.out.println("");
		}
		
		System.out.println("\n\nCursos con tutor y alumnos");
		
		Query query2 = em.createQuery("Select c from Curso c");
		List<Curso> listaCursos = query2.getResultList();
		
		for (Curso c : listaCursos) {
			
			System.out.print("Id: " + c.getId()+ "  ");
			System.out.print("Nombre: " + c.getNombre()+ "  ");
			System.out.print("Tutor: " + c.getTutor().getNombre() + "  ");
			System.out.print("Alumnos:[ ");
			for(Alumno alum : c.getAlumnos()) {
				System.out.print(" " + alum.getNombre() + " | ");
			}
			System.out.println("]");
		}
		
		
	}

}
