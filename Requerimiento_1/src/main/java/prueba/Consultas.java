package prueba;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.entidad.Direccion;

public class Consultas {
	
	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("JPA");
		
		iniciarBBDD();
		
		em = emf.createEntityManager();
		
		System.out.println("TODO OK");
		
		System.out.println("Todos los libros dados de alta, con su editorial y su autor");
		System.out.println("");
		
		Query query1 = em.createQuery("SELECT l.titulo, a.nombre, a.apellidos, e.nombre FROM Libro l JOIN l.autor a JOIN l.editorial e");
		List<Object[]> list1 = query1.getResultList();
		for (Object[] l : list1) {
			System.out.println("LIBRO -> " + l[0] + " - AUTOR -> " + l[1] + " " + l[2] + " - EDITORIAL -> " + l[3]);
		}
		
		System.out.println("");
		System.out.println("Todos los autores dados de alta, con sus libros asociados");
		System.out.println("");
		
		Query query2 = em.createQuery("SELECT a.nombre, a.apellidos, l.titulo FROM Libro l JOIN l.autor a ORDER BY a.nombre ASC");
		List<Object[]> list2 = query2.getResultList();
		for (Object[] l : list2) {
			System.out.println(" AUTOR -> " + l[0] + " " + l[1] + " - LIBRO -> " + l[2]);
		}
		
		System.out.println("");
		System.out.println("Todas las librerías, con solamente sus libros asociados");
		System.out.println("");
		
		Query query3 = em.createQuery("SELECT lb.nombre, l.titulo FROM Libreria lb JOIN lb.coleccionLibros l JOIN l.librerias lb ORDER BY lb.nombre ASC");
		List<Object[]> list3 = query3.getResultList();
		for (Object[] l : list3) {
			System.out.println("LIBRERIA -> " + l[0] + " - LIBRO -> " + l[1]);
		}
		
		System.out.println("");
		System.out.println("Todos los libros dados de alta, y en la librería en la que están");
		System.out.println("");
		
		Query query4 = em.createQuery("SELECT DISTINCT l.titulo, lb.nombre FROM Libro l JOIN l.librerias lb JOIN lb.coleccionLibros l ORDER BY l.titulo ASC");
		List<Object[]> list4 = query4.getResultList();
		for (Object[] l : list4) {
			System.out.println("LIBRO -> " + l[0] + " - LIBRERIA -> " + l[1]);
		}

		em.close();
		emf.close();
		
		System.out.println("CERRADO");

	}
	
	private static void iniciarBBDD() {
		Autor a1 = new Autor(null, "Javier", "Romero García", null, null);
		a1.setFechaNacimiento(new Date(1994-07-05));
		Autor a2 = new Autor(null, "Laura", "Pérez Esteban", null, null);
		a2.setFechaNacimiento(new Date(1999-01-11));
		Autor a3 = new Autor(null, "Lucas", "Garrido Claro", null, null);
		a3.setFechaNacimiento(new Date(2001-02-25));
		
		Editorial e1 = new Editorial(null, "Planeta", null, null);
		Direccion d1 = new Direccion("Calle", "Esperanza", "Barcelona");
		e1.setDireccion(d1);
		
		Editorial e2 = new Editorial(null, "Espasa", null, null);
		Direccion d2 = new Direccion("Avenida", "Libertad", "Gijón");
		e2.setDireccion(d2);
		
		Libro l1 = new Libro(null, "Oscuridad de la magia", (float) 9.99, e1, a1, null);
		Libro l2 = new Libro(null, "Sueños sin fin", (float) 14.99, e2, a2, null);
		Libro l3 = new Libro(null, "Realidad del amor", (float) 4.99, e1, a3, null);
		Libro l4 = new Libro(null, "Promesas del olvido", (float) 9.99, e1, a1, null);
		Libro l5 = new Libro(null, "Tiempo sin fin", (float) 6.99, e2, a3, null);
		Libro l6 = new Libro(null, "Ecos de la verdad", (float) 19.99, e2, a3, null);
		Libro l7 = new Libro(null, "Viaje del olvido", (float) 12.99, e2, a2, null);
		Libro l8 = new Libro(null, "Silencio de la luna", (float) 5.99, e1, a1, null);
		
		Libreria lb1 = new Libreria(null, "La Casa del Libro", "Jaime Ferrán Pérez", null, null);
		Direccion d3 = new Direccion("Calle", "Paz", "Alicante");
		lb1.setDireccion(d3);
		Libreria lb2 = new Libreria(null, "Fnac", "Clara Gómez González", null, null);
		Direccion d4 = new Direccion("Avenida", "Luna", "Cartagena");
		lb2.setDireccion(d4);
		
		List<Libro> librosCasaLibro = new ArrayList<Libro>();
		librosCasaLibro.add(l1);
		librosCasaLibro.add(l3);
		librosCasaLibro.add(l4);
		librosCasaLibro.add(l8);
		lb1.setColeccionLibros(librosCasaLibro);
		
		List<Libro> librosFnac = new ArrayList<Libro>();
		librosFnac.add(l2);
		librosFnac.add(l5);
		librosFnac.add(l6);
		librosFnac.add(l7);
		lb2.setColeccionLibros(librosFnac);
		
		List<Libreria> libreriasLibro1 = new ArrayList<Libreria>();
		libreriasLibro1.add(lb1);
		l1.setLibrerias(libreriasLibro1);
		List<Libreria> libreriasLibro2 = new ArrayList<Libreria>();
		libreriasLibro2.add(lb2);
		l2.setLibrerias(libreriasLibro2);
		List<Libreria> libreriasLibro3 = new ArrayList<Libreria>();
		libreriasLibro3.add(lb1);
		l3.setLibrerias(libreriasLibro3);
		List<Libreria> libreriasLibro4 = new ArrayList<Libreria>();
		libreriasLibro4.add(lb1);
		l4.setLibrerias(libreriasLibro4);
		List<Libreria> libreriasLibro5 = new ArrayList<Libreria>();
		libreriasLibro5.add(lb2);
		l5.setLibrerias(libreriasLibro5);
		List<Libreria> libreriasLibro6 = new ArrayList<Libreria>();
		libreriasLibro6.add(lb2);
		l6.setLibrerias(libreriasLibro6);
		List<Libreria> libreriasLibro7 = new ArrayList<Libreria>();
		libreriasLibro7.add(lb2);
		l7.setLibrerias(libreriasLibro7);
		List<Libreria> libreriasLibro8 = new ArrayList<Libreria>();
		libreriasLibro8.add(lb1);
		l8.setLibrerias(libreriasLibro8);
		
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(e1);
		em.persist(e2);
		em.persist(l1);
		em.persist(l2);
		em.persist(l3);
		em.persist(l4);
		em.persist(l5);
		em.persist(l6);
		em.persist(l7);
		em.persist(l8);
		em.persist(lb1);
		em.persist(lb2);
		
		em.getTransaction().commit();
		em.close();
	}

}
