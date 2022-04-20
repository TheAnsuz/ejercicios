/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Ejercicio1_farenheit {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        double grados = 0;

        System.out.println("Introduce la temperatura en grados (usa la coma, no el punto)");
        grados = scan.nextDouble();

        System.out.println("La temperatura es " + grados + "º -> " + toFahrenheit(grados) + "f");
    }

    public static double toFahrenheit(double celsius) {
        return ( (double) 9/5) * celsius + 32;
    }
}
