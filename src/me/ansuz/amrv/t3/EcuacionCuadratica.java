/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t3;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class EcuacionCuadratica {

    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //ax^2 + bx + c = 0
        System.out.println("Introduce los valores de la ecuación, si A = 0 el programa terminará");

        System.out.print("A = ");
        double a = scan.nextDouble();
        System.out.print("B = ");
        double b = scan.nextDouble();
        System.out.print("C = ");
        double c = scan.nextDouble();

        if (a == 0) {
            System.err.println("El valor de A no puede ser 0");
        } else {

            System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");

            double inter = (b * b) - (4 * a * c);
            double raiz = Math.sqrt((inter > 0) ? inter : -inter);
            double xpos = (-b + raiz) / (2 * a);
            double xneg = (-b - raiz) / (2 * a);

            if (Double.isFinite(xpos) && Double.isFinite(xneg)) {
                System.out.println("x = " + xpos + " / " + xneg);
            } else {
                System.out.println("La ecuación no tiene solución");
            }
        }
    }
}
