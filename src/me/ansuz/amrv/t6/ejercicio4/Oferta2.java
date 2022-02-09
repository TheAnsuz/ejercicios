/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio4;

/**
 *
 * @author marruiad
 */
public class Oferta2 implements Operaciones {

    public static final float PRECIO = 0.25f;

    private final float percent;
    private long seg;

    public Oferta2(float percent) {
        this.percent = percent;
        this.seg = 0;
    }

    @Override
    public void conexion(int sec) {
        seg += sec < 0 ? 0 : seg;
    }

    @Override
    public double importe() {
        return seg * percent * PRECIO;
    }

    @Override
    public void reset() {
        seg = 0;
    }

    public float getPercent() {
        return percent;
    }

    
    
}
