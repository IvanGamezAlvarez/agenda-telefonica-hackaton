package com.yellowsection;
import java.util.Objects;

public class Contactos implements Comparable<Contactos> {
	private String nombre;
    private String apellido;
    private String telefono;

    /**
     * Constructor de la clase Contactos.
     * Valida que nombre y apellido no estén vacíos.
     */
    public Contactos(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y apellido no pueden estar vacíos.");
        }
        this.nombre = nombre.trim(); // elimina espacios al inicio y fin
        this.apellido = apellido.trim();
        this.telefono = telefono;
    }

    // ------------------- GETTERS Y SETTERS -------------------
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // ------------------- MÉTODOS DE IGUALDAD -------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contactos)) return false;
        Contactos c = (Contactos) o;
        return nombre.equalsIgnoreCase(c.nombre) && apellido.equalsIgnoreCase(c.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    // ------------------- REPRESENTACIÓN EN TEXTO -------------------
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }

    // ------------------- ORDENACIÓN -------------------
    @Override
    public int compareTo(Contactos otro) {
        int cmp = this.nombre.compareToIgnoreCase(otro.nombre);
        if (cmp != 0) return cmp;
        return this.apellido.compareToIgnoreCase(otro.apellido);
    }

}
