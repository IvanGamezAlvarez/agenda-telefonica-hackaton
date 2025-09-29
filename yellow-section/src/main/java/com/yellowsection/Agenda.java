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

	public void anadirContacto(String nombre, String apellido, String telefono) {
		if (this.existeContacto(nombre, apellido))
			return;
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] == null) {
				listaContactos[i] = new Contacto(nombre, apellido, telefono);
				return;
			} else {
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
		if (espaciosLibres() == listaContactos.length) {
			System.out.println("Tu agenda esta vacia");
			return;
		}
		System.out.println("Lista de contactos:");
		Arrays.sort(listaContactos, (a, b) -> {
			if (a == null && b == null)
				return 0;
			if (a == null)
				return 1;
			if (b == null)
				return -1;
			return a.getNombre().compareToIgnoreCase(b.getNombre());
		});
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] != null) {
				System.out.println(listaContactos[i].getNombre() + " " + listaContactos[i].getApellido() + " - "
						+ listaContactos[i].getTelefono());
			}
		}
	}

	public void borrarContacto(String name, String lastname) {


		if (existeContacto(name, lastname)) {

			int idContacto = this.buscaContacto(name, lastname);
			listaContactos[idContacto] = null;
			System.out.println("Contacto Eliminado");
		}



		else {

			System.out.println("No se pudo encontrar el contacto ingresado:(");

		}
	}

	public void modificarTelefono(String name, String lastname, String numberPhone) {

		if (existeContacto(name, lastname)) {

			this.listaContactos[buscaContacto(name, lastname)].setTelefono(numberPhone);

			System.out.println("Numero de contacto modificado correctamente");
		} else {

			System.out.println("No se pudo encontrar el contacto ingresado:(");

		}

	}

	public boolean existeContacto(String nombre, String apellido) {

		for (int i = 0; i < this.listaContactos.length; i++) {
			if(this.listaContactos[i] != null) {
				if (this.listaContactos[i].getNombre().equals(nombre)  && this.listaContactos[i].getApellido().equals(apellido) ) {

					System.out.println("El contacto se encuentra dentro de la agenda");
					return true;
				}
			}

			

		}

		
		return false;
	}

	public Integer buscaContacto(String nombre, String apellido) {

		for (int i = 0; i < this.listaContactos.length; i++) {
			if(this.listaContactos[i] != null) {
				System.out.println("buscando");
				if (this.listaContactos[i].getNombre().equals(nombre) && this.listaContactos[i].getApellido().equals(apellido)) {

					System.out.println("El numero de contacto es:" + this.listaContactos[i].getTelefono());
					return i;
				}
			}

			
		}
		System.out.println("No se pudo encontrar el contacto ingresado:(");
		return null;

	}

}
