/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Lancha extends Barco {

    private final float potencia;

    public Lancha(String matricula, double eslora, float potencia, LocalDate fabricacion) {
        super(matricula, eslora, fabricacion);
        this.potencia = potencia;
    }

    public float getPotencia() {
        return potencia;
    }

    @Override
    public double moduloFuncion() {
        return super.moduloFuncion() + this.potencia;
    }

}
