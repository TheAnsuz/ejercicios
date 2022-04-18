/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio5;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class ETemporal extends Empleado {

    private final LocalDate alta;
    private final LocalDate baja;

    public ETemporal(String nombre, float sueldo, LocalDate alta, LocalDate baja) {
        super(nombre);
        super.sueldo = sueldo;
        this.alta = alta;
        this.baja = baja;
    }

    public LocalDate getAlta() {
        return alta;
    }

    public LocalDate getBaja() {
        return baja;
    }

}
