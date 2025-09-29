package com.yellowsection;


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
	
	public void anadirContacto(String name, String apellido, String telefono) {
		if (this.existeContacto()) return;
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
			return 0;
		} else {
			return espaciosLibres;
		}
	}
	
	public void listarContactos() {
		if (espaciosLibres() == listaContactos.length ) {
			System.out.println("Tu agenda esta vacia");
			return;
		}
		System.out.println("Lista de contactos:");
		Arrays.sort(listaContactos, (a, b) -> {
	        if (a == null && b == null) return 0;
	        if (a == null) return 1;
	        if (b == null) return -1;
	        return a.getNombre().compareToIgnoreCase(b.getNombre());
	    });
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] != null) {
				System.out.println(listaContactos[i].getNombre() +" "+ listaContactos[i].getApellido() + " - " + listaContactos[i].numero  );
			}	
		}	
	}

}



