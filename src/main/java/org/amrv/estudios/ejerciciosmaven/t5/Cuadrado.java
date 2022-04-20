/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

/**
 *
 * @author marruiad
 */
public class Cuadrado {
    
    private double lado;
    private Punto centro;

    public Cuadrado(double lado, Punto centro) {
        this.lado = lado;
        this.centro = centro;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }
    
    public void desplazar(Punto extra) {
        this.centro.desplazar(extra);
    }
    
    public double area() {
        return Math.pow(lado, 2);
    }
    
    public double perimetro() {
        return 4 * lado;
    }
    
    public double diagonal() {
        return Math.sqrt(Math.pow(lado, 2) + Math.pow(lado, 2));
    }

    @Override
    public String toString() {
        return "Cuadrado{" + "lado=" + lado + ", centro=" + centro + '}';
    }
}
