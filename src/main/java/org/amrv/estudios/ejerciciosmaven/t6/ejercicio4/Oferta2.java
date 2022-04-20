/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6.ejercicio4;

/**
 *
 * @author marruiad
 */
public class Oferta2 implements Operaciones {

    public static final float PRECIO = 0.25f;

    private final float percent;
    private long seconds;

    public Oferta2(float percent) {
        this.percent = percent;
        this.seconds = 0;
    }

    @Override
    public void conexion(int sec) {
        seconds += sec < 0 ? 0 : seconds;
    }

    @Override
    public double importe() {
        return seconds * percent * PRECIO;
    }

    @Override
    public void reset() {
        seconds = 0;
    }

    public float getPercent() {
        return percent;
    }

    public long getSeconds() {
        return seconds;
    }

    
    
}
