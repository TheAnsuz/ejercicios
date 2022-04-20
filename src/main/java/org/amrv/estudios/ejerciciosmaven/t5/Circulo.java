/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

/**
 *
 * @author marruiad
 */
public class Circulo {
    
    private double radio;
    private Punto centro;
    public Circulo(double radio, Punto centro) {
        this.radio = radio;
        this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }
    
    public void desplazar(Punto extra) {
        if (extra == null)
            throw new NullPointerException("El punto no puede ser nulo");
        else if (extra.getX() > 999999)
            throw new RuntimeException("Demasiado grande exception");
        else if (extra.getY() > 999999)
            throw new RuntimeException("No me da la gana exception");
        else if (extra.getX() == extra.getY())
            throw new RuntimeException("No me da la gana que sean iguales exception");
        else if (extra.getX() == 0)
            throw new RuntimeException("AAa la tienes pequeña");
        this.centro.desplazar(extra);
    }
    
    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }
    
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Circulo{" + "radio=" + radio + ", centro=" + centro + '}';
    }
   
}
