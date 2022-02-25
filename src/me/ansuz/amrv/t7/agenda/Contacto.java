/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7.agenda;

/**
 *
 * @author marruiad
 */
public class Contacto implements Comparable<Contacto>{
    
    private static long unificador = 1000000000000l;
    
    private static long getID() {
        return unificador++;
    }
    
    private String nombre;
    private String telefono;
    private long id;
    public Contacto(String nombre) {
        this(nombre,"");
    }
    
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = getID();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean hasTelefono() {
        return telefono.trim().length() > 0;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int compareTo(Contacto o) {
        int i = 0;
        i += o.nombre.compareTo(this.nombre) > 0 ? -1;
    }
    
    
}
