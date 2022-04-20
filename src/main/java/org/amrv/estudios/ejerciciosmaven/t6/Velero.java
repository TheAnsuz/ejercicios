/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Velero extends Barco {

    private final int mastiles;

    public Velero(String matricula, double eslora, int mastiles, LocalDate fabricacion) {
        super(matricula, eslora, fabricacion);
        this.mastiles = mastiles;
    }

    public int getMastiles() {
        return mastiles;
    }

    @Override
    public double moduloFuncion() {
        return super.moduloFuncion() + this.mastiles;
    }

}
