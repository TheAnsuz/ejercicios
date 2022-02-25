/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7.agenda;

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
    
    public static void main(String[] args) {
        String a = "hola que tal";
        String b = "hola buenos dias";
        System.out.println(a.compareTo(b));
    }
    
    
}
