/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6.geometria;

import java.awt.Toolkit;
import org.amrv.estudios.ejerciciosmaven.t5.Punto;

/**
 *
 * @author marruiad
 */
public abstract class Figura {

    private Punto centro;

    public Figura() {
        centro = new Punto(
                Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
    }

    public Figura(Punto centro) {
        this.centro = centro;
    }

    public abstract void dibujar();

    public abstract double area();
    
    public void setCentro(Punto p) {
        this.centro.colocar(centro);
    }
    
    public void setCentro(double x, double y) {
        this.centro.colocar(x, y);
    }
    
    public Punto getCentro() {
        return this.centro;
    }
 }
