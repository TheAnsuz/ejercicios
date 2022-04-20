/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t7.agenda;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Programa de agenda
 *
 * Añadir un nuevo contacto. Si ya existe un contacto con ese nombre ó teléfono,
 * se le informará al usuario antes de su almacenamiento.
 *
 * Buscar un contacto por nombre ó teléfono. Si existen varios contactos
 * coincidentes, se mostrarán todos.
 *
 * Modificar los datos de un contacto (previa búsqueda).
 *
 * Eliminar un contacto (previa búsqueda). Antes de su eliminación se pedirá
 * confirmación al usuario.
 *
 * Mostrar un listado de todos los contactos almacenados en la agenda, ordenado
 * por nombre o teléfono.
 *
 * Vaciar la agenda.
 *
 * @author marruiad
 */
public class MenuAgenda {

    public static Agenda agenda = new Agenda();
    public static Contacto ultimo = null;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        do {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(MenuAgenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ultimo == null) {
                System.out.println("> 1- Agregar contacto");
                System.out.println("> 2- Buscar contacto");
                System.out.println("> 3- Vaciar agenda");
                System.out.println("> 4- Ordenar contacto");
                System.out.println("> 5- Salir");
                switch (obtenerNumero(">>> ", 1, 5)) {
                    case 1: // Agregar contacto
                        agregarContacto();
                        break;
                    case 2: // Buscar contacto
                        buscarContacto();
                        break;
                    case 3: // Vaciar agenda
                        vaciarAgenda();
                        break;
                    case 4: // Ordenar contacto
                        ordenarContactos();
                        break;
                    case 5:
                    default:
                        salir = true;
                        break;
                }
            } else {
                System.out.println("> 1- Agregar contacto");
                System.out.println("> 2- Buscar contacto");
                System.out.println("> 3- Modificar ultimo contacto");
                System.out.println("> 4- Eliminar ultimo contacto");
                System.out.println("> 5- Vaciar agenda");
                System.out.println("> 6- Ordenar contacto");
                System.out.println("> 7- Salir");
                switch (obtenerNumero(">>> ", 1, 5)) {
                    case 1: // Agregar contacto
                        agregarContacto();
                        break;
                    case 2: // Buscar contacto
                        buscarContacto();
                        break;
                    case 3: // Modificar ultimo contacto
                        modificarContacto();
                        break;
                    case 4: // Eliminar ultimo contacto
                        agenda.eliminar(ultimo);
                        ultimo = null;
                        break;
                    case 5: // Vaciar agenda
                        vaciarAgenda();
                        break;
                    case 6: // Ordenar contacto
                        ordenarContactos();
                        break;
                    case 7:
                    default:
                        salir = true;
                        break;
                }
            }
        } while (!salir);
    }

    private static void vaciarAgenda() {
        System.out.println("Has seleccionado vaciar la agenda, estas seguro");
        System.out.println("> 1- Si");
        System.out.println("> 2- No");
        if (obtenerNumero(">>> ", 1, 2) == 1)
            agenda.vaciar();
    }
    
    private static void ordenarContactos() {
        System.out.println("De que forma desea ordenar los contactos");
        System.out.println("> 1- Creacion");
        System.out.println("> 2- Nombre");
        System.out.println("> 3- Telefono");
        Contacto[] ordenados = null;
        switch (obtenerNumero(">>> ", 1, 3)) {
            case 1:
            default:
                ordenados = agenda.ordenar();
                break;
            case 2:
                ordenados = agenda.ordenarNombres();
                break;
            case 3:
                ordenados = agenda.ordenarTelefonos();
                break;
        }
        if (ordenados.length > 0)
            for (int i = 0; i < ordenados.length; i++) {
                System.out.println(ordenados[i].toString());
            }
        else
            System.err.println("No se ha encontrado ningun contacto");
    }

    private static void modificarContacto() {
        System.out.println("Modificando " + ultimo.toString());
        ultimo.setNombre(obtenerTexto("Nombre> ", true));
        ultimo.setTelefono(obtenerTexto("Telefono> ", false));
    }

    private static void agregarContacto() {
        Contacto c = new Contacto(obtenerTexto("Nombre> ", true));
        c.setTelefono(obtenerTexto("Telefono> ", false));
        if (agenda.indexOf(c) >= 0) {
            System.out.println("El contacto ya existe, desea agregarlo igualmente");
            System.out.println("> 1- Si");
            System.out.println("> 2- No");
            if (obtenerNumero(">>> ", 1, 2) == 2)
                return;
        }
        agenda.agregar(c);
    }

    private static void buscarContacto() {
        System.out.println("De que manera desea buscar el contacto");
        System.out.println("> 1- Nombre");
        System.out.println("> 2- Telefono");
        Contacto[] encontrados = null;
        switch (obtenerNumero(">>> ", 1, 2)) {
            case 1:
                encontrados = agenda.buscarNombre(obtenerTexto("Nombre> ", true), true, true);
                break;
            case 2:
                encontrados = agenda.buscarTelefono(obtenerTexto("Telefono> ", false), true, true);
                break;
        }
        if (encontrados.length > 0)
            for (int i = 0; i < encontrados.length; i++) {
                System.out.println(encontrados[i].toString());
                ultimo = encontrados[i];
            }
        else
            System.err.println("No se ha encontrado ningun contacto");
    }

    // Metodos funcionales del menu de agenda
    private static int obtenerNumero(String titulo, int min, int max) {
        while (true) {
            System.out.print(titulo);
            try {
                final int num = Integer.parseInt(scan.nextLine());
                if (num < min)
                    System.err.println("El numero introducido no puede ser menor que " + min);
                else if (num > max)
                    System.err.println("El numero introducido no puede ser mayor que " + max);
                else
                    return num;
            } catch (NumberFormatException e) {
                System.err.println("El valor introducido no es un numero");
            }
        }
    }

    private static String obtenerTexto(String titulo, boolean permiteEspacios) {
        while (true) {
            System.out.print(titulo);
            try {
                String texto = scan.nextLine();
                if (!permiteEspacios && texto.contains(" ")) {
                    System.err.println("El texto no permite espacios");
                    continue;
                }
                return texto;
            } catch (NumberFormatException e) {
                System.err.println("El texto no es valido");
            }
        }
    }

}
