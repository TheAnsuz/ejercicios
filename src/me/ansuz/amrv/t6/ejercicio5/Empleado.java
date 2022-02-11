/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio5;

import java.text.DecimalFormat;

/**
 *
 * @author marruiad
 */
public abstract class Empleado implements Sueldo {

    private final String nombre;
    protected float sueldo;
    private DecimalFormat format = new DecimalFormat("##.000,##€");

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public float getSueldo() {
        return sueldo;
    }

    public String getSueldoFormat() {
        return format.format(sueldo);
    }

}
