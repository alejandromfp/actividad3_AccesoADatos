package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Articulo;
import beans.Tienda;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(Tienda.class);
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
			Articulo articulo1 = new Articulo("A001", "Camisa de algodón", "Camisa de manga larga de algodón suave y cómoda.", 50, 29.99);
			Articulo articulo2 = new Articulo("A002", "Pantalones vaqueros", "Pantalones vaqueros ajustados de mezclilla resistente.", 30, 39.99);
			Articulo articulo3 = new Articulo("A003", "Zapatillas deportivas", "Zapatillas deportivas ligeras y transpirables con suela de goma antideslizante.", 20, 49.99);
			Articulo articulo4 = new Articulo("A004", "Reloj de pulsera", "Reloj de pulsera analógico con correa de cuero y carcasa de acero inoxidable.", 15, 99.99);
			Articulo articulo5 = new Articulo("A005", "Mochila escolar", "Mochila escolar resistente al agua con múltiples compartimentos y correas acolchadas.", 40, 34.99);
			
			List<Articulo> list = new ArrayList<Articulo>();
			list.add(articulo1);
			list.add(articulo2);
			list.add(articulo3);
			list.add(articulo4);
			list.add(articulo5);
			
			Tienda tienda = new Tienda("El corte Ingles", "Madrid", list);
			
			m.marshal(tienda, new File("Articulos.xml"));
			System.out.println("Creado correctamente");
				
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
