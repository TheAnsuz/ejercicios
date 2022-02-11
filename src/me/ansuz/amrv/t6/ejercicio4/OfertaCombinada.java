/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio4;

/**
 *
 * @author marruiad
 */
public class OfertaCombinada implements Operaciones {

    public static final float PRECIO = 0.3f;

    private long seconds = 0l;
    private final float percent;

    public OfertaCombinada(float percent) {
        this.percent = percent;
        this.seconds = 0;
    }

    @Override
    public void conexion(int sec) {
        seconds += sec - 180 < 0 ? 0 : sec - 180;
    }

    @Override
    public double importe() {
        return seconds * percent * PRECIO;
    }

    @Override
    public void reset() {
        this.seconds = 0;
    }

    public long getSeconds() {
        return seconds;
    }

    public float getPercent() {
        return percent;
    }

    
}
