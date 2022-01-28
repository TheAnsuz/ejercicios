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

    public Punto() {
        this.x = 0;
        this.y = 0;
    }
     
    public Punto(double x, double y) {
        if (validarCoordsSeguro(x, y)) {
            this.x = x;
            this.y = y;
        } else {
            this.x = 0;
            this.y = 0;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (!validarCoordsSeguro(x, y))
            return;
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (!validarCoordsSeguro(x, y))
            return;
        this.y = y;
    }

    public void desplazar(double x, double y) {
        if (!validarCoordsSeguro(x, y))
            return;
        this.x += x;
        this.y += y;
    }

    public void desplazar(Punto punto) {
        if (punto == null || !validarCoordsSeguro(punto.x, punto.y))
            return;
        this.x += punto.x;
        this.y += punto.y;
    }

    public void colocar(double x, double y) {
        if (!validarCoordsSeguro(x, y))
            return;
        this.x = x;
        this.y = y;
    }

    public void colocar(Punto punto) {
        if (punto == null || !validarCoordsSeguro(punto.x, punto.y))
            return;

        this.x = punto.x;
        this.y = punto.y;
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
//
//    private static void validarCoordenadas(double x, double y) {
//        if (x < 0 || y < 0)
//            throw new RuntimeException("El valor" + (x < 0 ? "X" : "Y") + " no puede ser menor de 0");
//
//        if (Toolkit.getDefaultToolkit().getScreenSize().getWidth() > x)
//            throw new RuntimeException("El valor X no puede ser mayor al tamaño de la pantalla");
//
//        else if (Toolkit.getDefaultToolkit().getScreenSize().getHeight() > y)
//            throw new RuntimeException("El valor Y no puede ser mayor al tamaño de la pantalla");
//    }

    private boolean validarCoordsSeguro(double x, double y) {
        if (x + this.x < 0 || y + this.y < 0)
            return false;

        if (x + this.x > Toolkit.getDefaultToolkit().getScreenSize().getWidth())
            return false;

        else if (y + this.y > Toolkit.getDefaultToolkit().getScreenSize().getHeight())
            return false;

        return true;
    }
}
