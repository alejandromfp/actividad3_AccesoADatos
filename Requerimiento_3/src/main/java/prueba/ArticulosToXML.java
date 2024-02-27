package prueba;

import modelo.entidad.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.*;

public class ArticulosToXML {

	public static void main(String[] args) {
		
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Almacen.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Almacen almacen = new Almacen();
			almacen.setNombre("Ferreteria del Sur");
			almacen.setCiudad("Córdoba");
			
			almacen.getArticulos().add(new Articulo(1, "Tornillo", "De acero", 257, (float) 0.5));
			almacen.getArticulos().add(new Articulo(2, "Sierra", "Para madera", 15, (float) 15.90));
			almacen.getArticulos().add(new Articulo(3, "Martillo", "Para clavos", 34, (float) 5.5));
			
			m.marshal(almacen, System.out);

			m.marshal(almacen, new File("articulos.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
