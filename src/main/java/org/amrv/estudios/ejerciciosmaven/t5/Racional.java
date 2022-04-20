/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

/**
 *
 * @author marruiad
 */
public class Racional {

    private double numerador;
    private double denominador;

    public static Racional simplificar(Racional racional) {
        double num = racional.numerador;
        double den = racional.denominador;
        for (int i = (int) ((num > den) ? num : den); i >= 2; i--)
            if (num % i == 0 && den % i == 0) {
                num/=i;
                den/=i;
            }
        return new Racional(num, den);
    }

    public Racional(double numerador, double denominador) {
        this.denominador = denominador;
        this.numerador = numerador;
    }

    public double getNumerador() {
        return numerador;
    }

    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    public double getDenominador() {
        return denominador;
    }

    public void setDenominador(double denominador) {
        this.denominador = denominador;
    }

    public Racional sumar(Racional racional) {
        // a/b + c/d	c*b + a*d / b*d
        double num = racional.numerador * this.denominador + this.numerador + racional.denominador;
        double den = this.denominador * racional.denominador;
        return simplificar(new Racional(num, den));
    }

    public Racional restar(Racional racional) {
        // a/b + c/d	c*b + a*d / b*d
        double num = racional.numerador * this.denominador - this.numerador + racional.denominador;
        double den = this.denominador * racional.denominador;
        return simplificar(new Racional(num, den));
    }

    // a/b · c/d
    // a*c / b*d
    public Racional multiplicar(Racional racional) {
        return simplificar(new Racional(this.numerador * racional.numerador, this.denominador * racional.denominador));
    }

    public Racional dividir(Racional racional) {
        return simplificar(new Racional(this.numerador * racional.denominador, this.denominador * racional.numerador));
    }

    public double toDecimal() {
        return this.numerador / this.denominador;
    }

    @Override
    public String toString() {
        return this.numerador + "/" + this.denominador;
    }
    
    public boolean equals(Racional racional) {
        racional = simplificar(racional);
        Racional actual = simplificar(this);
        return actual.numerador == racional.numerador && actual.denominador == racional.denominador;
    }
    
    public int compareTo(Racional racional) {
        return 0; // 1 mayor, 0 igual, -1 menor
    }
   
    public static void main(String[] args) {
        System.out.println(new Racional(422, 123).dividir(new Racional(112, 100))); // 5275.0/1722.0
    }

}
