package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tienda")
public class Tienda {
	
	private String nombre;
	private String ciudad;
	@XmlElement(name = "articulo")
	@XmlElementWrapper(name = "articulos")
	private List<Articulo> articulos;
	public Tienda() {
		super();
	}
	public Tienda(String nombre, String ciudad, List<Articulo> articulos) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.articulos = articulos;
	}
	
	
	
	
	
}
