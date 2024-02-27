package modelo.entidad;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="almacen")
public class Almacen {
	
	private String nombre;
	private String ciudad;
	private List<Articulo> articulos;
	
	public Almacen() {
		articulos = new ArrayList<Articulo>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@XmlElementWrapper(name = "productos")
	@XmlElement(name = "producto")
	public List<Articulo> getArticulos() {
	    return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	

}
