/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5;

import java.awt.Toolkit;

/**
 *
 * @author marruiad
 */
public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void desplazar(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void colocar(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distancia(double x, double y) {
        return Math.sqrt(Math.pow(x + this.x, 2) + Math.pow(y - this.y, 2));
    }
    
    public void centrar() {
        this.x = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
        this.y = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
    }
    

    @Override
    public String toString() {
        return '(' + x + ", " + y + ')';
    }

}
