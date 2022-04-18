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
public class Yate extends Barco {

    private final int camarotes;
    private final float potencia;

    public Yate(String matricula, double eslora, int camarotes, float potencia, LocalDate fabricacion) {
        super(matricula, eslora, fabricacion);
        this.camarotes = camarotes;
        this.potencia = potencia;
    }

    public int getCamarotes() {
        return camarotes;
    }

    public float getPotencia() {
        return potencia;
    }

    @Override
    public double moduloFuncion() {
        return super.moduloFuncion() + this.potencia + this.camarotes;
    }

}
