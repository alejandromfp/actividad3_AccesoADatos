package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class Main {
	
	private static EntityManagerFactory factoria;
	private static EntityManager em;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		factoria = Persistence.createEntityManagerFactory("JPALibros");
	
		//Creando direcciones autores
		
		Direccion d1 = new Direccion("Avenida", "Reforma", "Ciudad de México");
		Direccion d2 = new Direccion("Calle", "Gran Vía", "Madrid");
		Direccion d3 = new Direccion("Boulevard", "Santa Monica", "Los Ángeles");
		Direccion d4 = new Direccion("Rue", "de la Paix", "París");
		
		
		//Autores
		Autor gabriel = new Autor(null, "Gabriel", "García Márquez", new Date(1997,2,4), null);
        Autor jane= new Autor(null, "Jane", "Austen", new Date(1975, 11, 16),null);
        Autor haruki = new Autor(null, "Haruki", "Murakami", new Date(1949, 0, 12),null);
        
        //Editoriales
        
        Editorial platenaLibro  = new Editorial(null, "Planeta Libro", d1, null);
        Editorial cosmicBooks = new Editorial(null, "Cosmic Books", d2, null);
		
        //Libros
        
        Libro libro1 = new Libro(null, "El Alquimista", 20.5, platenaLibro, gabriel, null);
        Libro libro2 = new Libro(null, "Cien años de soledad", 25.0, platenaLibro, gabriel, null);
        Libro libro3 = new Libro(null, "1984", 18.75, platenaLibro, gabriel, null);
        Libro libro4 = new Libro(null, "Orgullo y prejuicio", 22.99, platenaLibro, jane, null);
        Libro libro5 = new Libro(null, "Matar a un ruiseñor", 19.99, platenaLibro, jane, null);
        Libro libro6 = new Libro(null, "Don Quijote de la Mancha", 30.0, cosmicBooks, haruki, null);
        Libro libro7 = new Libro(null, "Harry Potter", 24.5, cosmicBooks, haruki, null);
        Libro libro8 = new Libro(null, "Los juegos del hambre", 21.25, cosmicBooks, haruki, null);
        
        
        //Librerias
        
        List<Libro> listaLibros1 = new ArrayList<Libro>();
        listaLibros1.add(libro1);
        listaLibros1.add(libro2);
        listaLibros1.add(libro3);
        listaLibros1.add(libro4);
        listaLibros1.add(libro6);
        listaLibros1.add(libro8);
        
        Libreria libreria1 = new Libreria(null, "La luna nueva", "Pepe", d3,listaLibros1);
        
        List<Libro> listaLibros2 = new ArrayList<Libro>();
        listaLibros2.add(libro1);
        listaLibros2.add(libro2);
        listaLibros2.add(libro4);
        listaLibros2.add(libro5);
        listaLibros2.add(libro7);
        listaLibros2.add(libro8);
        listaLibros2.add(libro4);
        
        Libreria libreria2 = new Libreria(null, "La quinta estacion", "Juan", d4,listaLibros2);
        
        
        //Metiendo librerias a cada libro
        List<Libreria> libreriasLibro1 = new ArrayList<Libreria>();
        libreriasLibro1.add(libreria1);
        libreriasLibro1.add(libreria2);
        libro1.setLibrerias(libreriasLibro1);
        
        List<Libreria> libreriasLibro2 = new ArrayList<Libreria>();
        libreriasLibro2.add(libreria1);
        libreriasLibro2.add(libreria2);
        libro2.setLibrerias(libreriasLibro2);
        
        List<Libreria> libreriasLibro3 = new ArrayList<Libreria>();
        libreriasLibro3.add(libreria1);
        libro3.setLibrerias(libreriasLibro3);
        
        List<Libreria> libreriasLibro4 = new ArrayList<Libreria>();
        libreriasLibro4.add(libreria1);
        libreriasLibro4.add(libreria2);
        libro4.setLibrerias(libreriasLibro4);
        
        List<Libreria> libreriasLibro5 = new ArrayList<Libreria>();
        libreriasLibro5.add(libreria2);
        libro5.setLibrerias(libreriasLibro5);
        
        List<Libreria> libreriasLibro6 = new ArrayList<Libreria>();
        libreriasLibro6.add(libreria1);
        libro6.setLibrerias(libreriasLibro6);
        
        List<Libreria> libreriasLibro7 = new ArrayList<Libreria>();
        libreriasLibro7.add(libreria2);
        libro7.setLibrerias(libreriasLibro7);
        
        List<Libreria> libreriasLibro8 = new ArrayList<Libreria>();
        libreriasLibro8.add(libreria1);
        libreriasLibro8.add(libreria2);
        libro8.setLibrerias(libreriasLibro8);
        
        //Lista de libros de editoriales
        
        List<Libro> librosPlatenaLibro = new ArrayList<Libro>();
        librosPlatenaLibro.add(libro1);
        librosPlatenaLibro.add(libro2);
        librosPlatenaLibro.add(libro3);
        librosPlatenaLibro.add(libro4);
        librosPlatenaLibro.add(libro5);
        
        platenaLibro.setLibrosPublicados(librosPlatenaLibro);
        
        List<Libro> librosCosmicBooks = new ArrayList<Libro>();
        librosPlatenaLibro.add(libro6);
        librosPlatenaLibro.add(libro7);
        librosPlatenaLibro.add(libro8);

		cosmicBooks.setLibrosPublicados(librosCosmicBooks);
		
		//Libros de autores
		List<Libro> librosGabriel = new ArrayList<Libro>();
		librosGabriel.add(libro1);
		librosGabriel.add(libro2);
		librosGabriel.add(libro3);
		gabriel.setLibrosEscritos(librosGabriel);
		
		List<Libro> librosJane = new ArrayList<Libro>();
		librosJane.add(libro4);
		librosJane.add(libro5);
		jane.setLibrosEscritos(librosJane);
		
		List<Libro> librosHaruki = new ArrayList<Libro>();
		librosHaruki.add(libro6);
		librosHaruki.add(libro7);
		librosHaruki.add(libro8);
		haruki.setLibrosEscritos(librosHaruki);
		
		System.out.println("==============================================");
		em = factoria.createEntityManager();
		em.getTransaction().begin();
		
		
		em.persist(libro5);
		
		
		em.getTransaction().commit(); 
		
		System.out.println("=====================QUERIES========================");
		
		
		
		
		Query query = em.createQuery("Select l from Libro l");
		List<Libro> list = query.getResultList();
		System.out.println("\n\nLIBROS CON SU EDITORIAL Y AUTOR \n");
		for (Libro l : list) {
			Integer id = l.getId();
			String titulo =  l.getTitulo();
		    Editorial editorial = l.getEditorial();
		    Autor autor = l.getAutor();
		    System.out.println(String.format("Id: %-5s Titulo: %-30s Editorial: %-30s Autor: %-30s", id, titulo, editorial.getNombre(), autor.getNombre()));
		   
		}
		
		query = em.createQuery("Select a from Autor a");
		List<Autor> listaAutores= query.getResultList();
		System.out.println("\n\nAUTOR Y LIBROS \n");
		for (Autor a : listaAutores) {
			System.out.print("Id: " + a.getId() + "  ");
			System.out.print("Nombre: " + a.getNombre() + "  ");
		    for(Libro l : a.getLibrosEscritos())
		    	System.out.print("Libro: " + l.getTitulo() + "  ");
		    System.out.println("");
		    
		}
		
		query = em.createQuery("Select li from Libreria li");
		List<Libreria> listaLibrerias= query.getResultList();
		System.out.println("\n\nLIBRERIAS Y LIBROS ASOCIADOS \n");
		for (Libreria a : listaLibrerias) {
			System.out.print("Id: " + a.getId() + "  ");
			System.out.print("Nombre: " + a.getNombre() + "  ");
		    for(Libro l : a.getLibros())
		    	System.out.print("Libro: " + l.getTitulo() + "  ");
		    System.out.println("");
		    
		}
		
		query = em.createQuery("Select l from Libro l");
		List<Libro> listaLibrosLibreria= query.getResultList();
		System.out.println("\n\nLIBROS Y LIBRERIAS EN LAS QUE ESTA\n");
		for (Libro a : listaLibrosLibreria) {
			System.out.print("Id: " + a.getId() + "  ");
			System.out.print("Nombre: " + a.getTitulo() + "  ");
		    for(Libreria l : a.getLibrerias())
		    	System.out.print("Libreria: " + l.getNombre() + "  ");
		    System.out.println("");
		    
		}
		
		
		

		
		em.close();		
		
		factoria.close();	
		
		
		
	}

}
