/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6.ejercicio5;

import java.text.DecimalFormat;

/**
 *
 * @author marruiad
 */
public abstract class Empleado implements Sueldo {

    private final String nombre;
    protected float sueldo;
    private final DecimalFormat format = new DecimalFormat("##.000,##€");

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSueldoFormat() {
        return format.format(sueldo);
    }

}
