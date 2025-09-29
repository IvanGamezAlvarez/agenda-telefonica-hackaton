package com.yellowsection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Agenda {
	
	private Contacto[] listaContactos;
	
	public Contacto[] getListaContactos() {
		return listaContactos;
	}
	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}
	
	
	public Agenda(int arraySize) {
		this.setListaContactos(new Contacto[arraySize]);
	}
	public Agenda() {
		this(10);
	}
	
	public void añadirContacto(String name, String apellido, int telefono) {
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] == null) {
				listaContactos[i] = new Contacto(name, apellido, telefono);
				return;
			}else {
				System.out.println("La agenda telefonica esta llena");
			}			
		}	
	}
	
	public int espaciosLibres() {
		int espaciosLibres = 0;
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] == null) {
				espaciosLibres++;
			}		
		}	
		if (espaciosLibres == 0) {
			//System.out.println("Actualmente no hay espacios libres en tu agenda.");
			return 0;
		} else {
			//System.out.println("Cuentas con:" + espaciosLibres + " espacios libres en tu agenda.");
			return espaciosLibres;
		}
	}
	
	public void listarContactos(String name, String apellido, int telefono) {
		if (espaciosLibres() == listaContactos.length ) {
			System.out.println("Tu agenda esta vacia");
			return;
		}
		System.out.println("Lista de contactos:");
		Arrays.sort(listaContactos);
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] != null) {
				System.out.println(listaContactos[i].getNombre() +" "+ listaContactos[i].getApellido() + " - " + listaContactos[i].numero  );
			}	
		}	
	}

	
}



class Contacto{
	String nombre;
	String apellido;
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	int numero;
	
	public Contacto(String name, String appellido,int numero) {
		
	}
	
}