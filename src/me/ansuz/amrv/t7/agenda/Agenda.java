/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7.agenda;

import java.util.Arrays;

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
public class Agenda {
    
    private Contacto[] contactos = new Contacto[100];
    private int indice = 0;
    
    private boolean comprobarEspacio() {
        if (indice + 10 > Integer.MAX_VALUE)
            return false;
        if (indice + 10 >= contactos.length) {
            contactos = Arrays.copyOf(contactos, contactos.length*2);
        }
        return true;
    }
    
    public int indexOf(Contacto contacto) {
        for (int i = 0; i < indice; i++) {
            if (contactos[i].getId() == contacto.getId())
                return i;
        }
        return -1;
    }
    
    public boolean agregar(Contacto contacto) {
        if (!comprobarEspacio())
            return false;
        contactos[indice++] = contacto;
        return true;
    }
    
    public boolean eliminar(Contacto contacto) {
        if (contacto == null)
            return false;
        return eliminar(this.indexOf(contacto));
    }
    
    public boolean eliminar(int posicion) {
        if (posicion <= 0 || posicion > indice)
            return false;
        contactos[indice--] = null;
        return true;
    }
    
    public Contacto[] buscarNombre(String nombre, boolean ignoreCase, boolean onlyContains) {
        Contacto[] encontrados = new Contacto[indice];
        int index = 0;
        for (int i = 0; i < indice; i++) {
            final String dato = contactos[i].getNombre();
            if (onlyContains) {
                if (ignoreCase ? dato.toLowerCase().contains(nombre.toLowerCase()) : dato.contains(nombre))
                    encontrados[index++] = contactos[i];
            } else
                if (ignoreCase ? dato.equalsIgnoreCase(nombre) : dato.equals(nombre))
                    encontrados[index++] = contactos[i];
        }
        return Arrays.copyOf(encontrados, index+1);
    }
    
    public Contacto[] buscarTelefono(String telefono, boolean ignoreCase, boolean onlyContains) {
        Contacto[] encontrados = new Contacto[indice];
        int index = 0;
        for (int i = 0; i < indice; i++) {
            final String dato = contactos[i].getTelefono();
            if (onlyContains) {
                if (ignoreCase ? dato.toLowerCase().contains(telefono.toLowerCase()) : dato.contains(telefono))
                    encontrados[index++] = contactos[i];
            } else
                if (ignoreCase ? dato.equalsIgnoreCase(telefono) : dato.equals(telefono))
                    encontrados[index++] = contactos[i];
        }
        return Arrays.copyOf(encontrados, index+1);
    }
    
    public boolean modificarContacto(int posicion,String nombre, String telefono) {
        if (nombre == null || nombre.trim().length() < 1)
            return false;
        if (telefono == null || telefono.trim().length() < 1)
            return false;
        if (posicion < 0 || posicion > indice)
            return false;
        contactos[posicion].setNombre(nombre);
        contactos[posicion].setTelefono(telefono);
        return true;
    }
    
    public Contacto[] ordenarPorNombre() {
        Arrays.so
    }
}
