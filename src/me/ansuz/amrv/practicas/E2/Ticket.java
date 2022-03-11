/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Ticket {
    
    private static long ID = 0;
    private static long getID() {
        return ++ID;
    }
    
    private final long id;
    private final LocalDate fechaEntrada;
    private final String matricula;
    private final Ubicacion ubicacion;
    private final LocalDate fechaSalida;
    private final double precio;

    public Ticket(LocalDate fechaEntrada, String matricula, Ubicacion ubicacion, LocalDate fechaSalida, double precio) {
        this.id = Ticket.getID();
        this.fechaEntrada = fechaEntrada;
        this.matricula = matricula;
        this.ubicacion = ubicacion;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public String getMatricula() {
        return matricula;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ID=" + id + ", FechaEntrada=" + fechaEntrada 
                + ", Matricula=" + matricula + ", Ubicacion=" + ubicacion 
                + ", FechaSalida=" + fechaSalida + ", Precio=" + precio + '}';
    }
    
    
    
    
    
}
