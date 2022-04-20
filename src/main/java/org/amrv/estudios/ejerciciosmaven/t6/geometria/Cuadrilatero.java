/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.amrv.estudios.ejerciciosmaven.t6.geometria;

import org.amrv.estudios.ejerciciosmaven.t5.Punto;

/**
 *
 * @author marruiad
 */
public class Cuadrilatero extends Figura{

    private double ladox;
    private double ladoy;

    public Cuadrilatero(double ladox, double ladoy, Punto centro) {
        super(centro);
        this.ladox = ladox;
        this.ladoy = ladoy;
    }
    
    @Override
    public void dibujar() {
    
    }

    @Override
    public double area() {
        return ladox * ladoy;
    }
    
}
