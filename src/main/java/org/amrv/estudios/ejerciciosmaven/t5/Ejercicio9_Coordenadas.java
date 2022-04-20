/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Ejercicio9_Coordenadas {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        double angulo = 0;
        double r = 0;
        boolean valido = false;
        DecimalFormat formato = new DecimalFormat("#.##");
        // Pedir los valores
        do {
            try {
                System.out.print("Introduce la distancia R: ");
                r = Double.parseDouble(scan.nextLine());
                System.out.print("Introduce el angulo: ");
                angulo = Double.parseDouble(scan.nextLine());
                if (angulo < 0 || angulo > 360)
                    System.out.println("El angulo debe estar entre 0º y 360º");
                else
                    valido = true;
            } catch (Exception e) {
                System.out.println("El numero introducido no es valido");
            }
        } while (!valido);
       
        // Obtener el resultado
        double x = cos(r,gradosToRadianes(angulo));
        double y = sen(r,gradosToRadianes(angulo));
        
        // Mostrar por pantalla
        System.out.println("Las coordenadas son ( " + formato.format(x) + "x " + formato.format(y) + "y )");
    }
    
    public static double gradosToRadianes(double grados) {
        return Math.toRadians(grados);
    }
    public static double cos(double longitud, double radians) {
        return longitud * Math.cos(radians);
    }
    public static double sen(double longitud, double radians) {
        return longitud * Math.sin(radians);
    }

}
