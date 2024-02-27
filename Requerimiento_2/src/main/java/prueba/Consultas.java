package prueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Coche;
import modelo.entidad.Concesionario;
import modelo.entidad.Direccion;
import modelo.entidad.Gerente;
import modelo.entidad.Servicio;

public class Consultas {

	public static EntityManagerFactory emf = null;

	public static EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("JPA");
		
		iniciarBBDD();
		
		em = emf.createEntityManager();
		
		System.out.println("TODO OK");
		em.close();
		emf.close();
		
		System.out.println("CERRADO");

	}
	
	private static void iniciarBBDD() {
		
		Coche c1 = new Coche(null, "Honda", "Civic", "Negro", null, null, null);
		c1.setFechaMatriculacion(new Date(2022-03-02));
		Coche c2 = new Coche(null, "Toyota", "Corolla", "Blanco", null, null, null);
		c2.setFechaMatriculacion(new Date(2022-03-02));
		Coche c3 = new Coche(null, "Ford", "Mustang", "Rojo", null, null, null);
		c3.setFechaMatriculacion(new Date(2022-03-02));
		Coche c4 = new Coche(null, "Volkswagen", "Golf", "Amarillo", null, null, null);
		c4.setFechaMatriculacion(new Date(2022-03-02));
		Coche c5 = new Coche(null, "Tesla", "Model 3", "Gris", null, null, null);
		c5.setFechaMatriculacion(new Date(2022-03-02));
		Coche c6 = new Coche(null, "BMW", "Serie 3", "Verde", null, null, null);
		c6.setFechaMatriculacion(new Date(2022-03-02));
		Coche c7 = new Coche(null, "Mercedes-Benz", "Clase C", "Rojo", null, null, null);
		c7.setFechaMatriculacion(new Date(2022-03-02));
		Coche c8 = new Coche(null, "Audi", "A3", "Azul", null, null, null);
		c8.setFechaMatriculacion(new Date(2022-03-02));
		
		Servicio s1 = new Servicio(null, "Advance", "Cambio aceite y filtros", 3, null);
		Servicio s2 = new Servicio(null, "Plus", "Cambio de neumaticos", 2, null);
		Servicio s3 = new Servicio(null, "All", "Todos los mantenimientos", 4, null);
		
		Concesionario cn1 = new Concesionario(null, "TodoCar", null, null, null);
		Direccion d1 = new Direccion("Calle", "Esperanza", "Barcelona");
		cn1.setDireccion(d1);
		Concesionario cn2 = new Concesionario(null, "AutosGon", null, null, null);
		Direccion d2 = new Direccion("Avenida", "Libertad", "Gijón");
		cn2.setDireccion(d2);
		
		Gerente g1 = new Gerente(null, "Javier", "Gonzalez Fuertes", null, cn2);
		Gerente g2 = new Gerente(null, "Blanca", "García García", null, cn1);
		g1.setFechaNacimiento(new Date(2022-03-02));
		g2.setFechaNacimiento(new Date(2022-03-02));
		
		
		cn1.setGerente(g2);
		cn2.setGerente(g1);
		c1.setConcesionario(cn2);
		c2.setConcesionario(cn1);
		c3.setConcesionario(cn2);
		c4.setConcesionario(cn1);
		c5.setConcesionario(cn1);
		c6.setConcesionario(cn2);
		c7.setConcesionario(cn2);
		c8.setConcesionario(cn1);
		
		List<Servicio> serviciosc1 = new ArrayList<Servicio>();
		serviciosc1.add(s1);
		c1.setServicios(serviciosc1);
		List<Servicio> serviciosc2 = new ArrayList<Servicio>();
		serviciosc2.add(s2);
		c1.setServicios(serviciosc2);
		List<Servicio> serviciosc3 = new ArrayList<Servicio>();
		serviciosc3.add(s2);
		c1.setServicios(serviciosc3);
		List<Servicio> serviciosc4 = new ArrayList<Servicio>();
		serviciosc4.add(s3);
		c1.setServicios(serviciosc4);
		List<Servicio> serviciosc5 = new ArrayList<Servicio>();
		serviciosc5.add(s2);
		c1.setServicios(serviciosc5);
		List<Servicio> serviciosc6 = new ArrayList<Servicio>();
		serviciosc6.add(s1);
		serviciosc6.add(s2);
		c1.setServicios(serviciosc6);
		List<Servicio> serviciosc7 = new ArrayList<Servicio>();
		serviciosc7.add(s3);
		c1.setServicios(serviciosc7);
		List<Servicio> serviciosc8 = new ArrayList<Servicio>();
		serviciosc8.add(s1);
		serviciosc8.add(s2);
		c1.setServicios(serviciosc8);
		
		List<Coche> cochesServicio1 = new ArrayList<Coche>();
		cochesServicio1.add(c1);
		cochesServicio1.add(c6);
		cochesServicio1.add(c8);
		s1.setCoches(cochesServicio1);
		
		List<Coche> cochesServicio2 = new ArrayList<Coche>();
		cochesServicio2.add(c2);
		cochesServicio2.add(c3);
		cochesServicio2.add(c5);
		cochesServicio2.add(c6);
		cochesServicio2.add(c8);
		s2.setCoches(cochesServicio2);
		
		List<Coche> cochesServicio3 = new ArrayList<Coche>();
		cochesServicio3.add(c4);
		cochesServicio3.add(c7);
		s3.setCoches(cochesServicio3);
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		em.persist(c6);
		em.persist(c7);
		em.persist(c8);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(cn1);
		em.persist(cn2);
		em.persist(g1);
		em.persist(g2);
		
		em.getTransaction().commit();
		em.close();
	}

}
