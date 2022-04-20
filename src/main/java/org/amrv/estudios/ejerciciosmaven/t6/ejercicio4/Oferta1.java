/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6.ejercicio4;

/**
 *
 * @author marruiad
 */
public class Oferta1 implements Operaciones {

    public static final float PRECIO = 0.3f;

    private long seconds = 0l;

    @Override
    public void conexion(int sec) {
        seconds += sec - 180 < 0 ? 0 : sec - 180;
    }

    @Override
    public double importe() {
        return seconds * PRECIO;
    }

    @Override
    public void reset() {
        seconds = 0;
    }

    public long getSeconds() {
        return seconds;
    }

    
}
