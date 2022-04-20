/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6;

import java.time.Duration;
import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Alquiler {

    private String nombreCliente;
    private String dni;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private int posicionAmarre;
    private Barco barco;

    public Alquiler(String nombreCliente, String dni, Barco barco, LocalDate finalizacion) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.barco = barco;
        this.fechaInicio = LocalDate.now();
        this.fechaFinal = finalizacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public double getAlquiler() {
        double dias = Duration.between(fechaInicio, fechaFinal).toDays() + 1;
        return dias * barco.moduloFuncion();
    }

}
