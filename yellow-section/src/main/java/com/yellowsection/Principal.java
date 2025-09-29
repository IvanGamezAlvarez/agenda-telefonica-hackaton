package com.yellowsection;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Preguntar al usuario si quiere tamaño personalizado o por defecto
        System.out.print("¿Deseas crear la agenda con tamaño personalizado? (s/n): ");
        String resp = sc.nextLine().trim().toLowerCase();
        Agenda agenda;
        if (resp.equals("s")) {
            System.out.print("Introduce el tamaño máximo de la agenda: ");
            int tamaño = sc.nextInt();
            sc.nextLine(); 
            agenda = new Agenda(tamaño);
        } else {
            agenda = new Agenda(); // tamaño por defecto de 10
        }

        int opcion;
        do {
            System.out.println("\n--- MENÚ AGENDA ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Ver si existe contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Espacios libres");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    try {
      //                  agenda.anadirContacto(new Contacto(nombre, apellido, telefono));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    if (agenda.existeContacto(new Contacto(nombre, apellido, ""))) {
                        System.out.println("El contacto existe.");
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    break;
                case 3:
        //            agenda.listarContactos();
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
       //             agenda.buscaContacto(nombre, apellido);
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
      //              agenda.eliminarContacto(nombre, apellido);
                    break;
                case 6:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.print("Nuevo Teléfono: ");
                    String nuevoTel = sc.nextLine();
       //             agenda.modificarTelefono(nombre, apellido, nuevoTel);
                    break;
                case 7:
      //              agenda.espaciosLibres();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 8);

        sc.close();
		

	}

}
