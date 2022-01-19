/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5;

/**
 *
 * @author marruiad
 */
public class Triangulo {

    private double base;
    private double altura;
    private Punto centro;

    public Triangulo(double base, double altura, Punto centro) {
        this.base = base;
        this.altura = altura;
        this.centro = centro;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Punto getCentro() {
        return centro;
    }

    public void desplazar(Punto extra) {
        this.centro.desplazar(extra);
    }
    
    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public double area() {
        return base * altura / 2;
    }

    public double perimetro() {
        return base + Math.sqrt(Math.pow(altura, 2) + Math.pow(base / 2, 2)) * 2;
    }

    @Override
    public String toString() {
        return "Triangulo{" + "base=" + base + ", altura=" + altura + ", centro=" + centro + '}';
    }
    
    
}
