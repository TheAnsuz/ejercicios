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
public class Ejercicio2_divisor {
    
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Long num = null;
        
        do {
            System.out.println("Introduce el numero entero");
            String numero = scan.nextLine();
            try {
                num = Long.parseLong(numero);
            } catch (Exception e) {
                System.err.println("El valor introducido no es un numero");
            }
        } while (num == null);

        long max = maxDiv(num);
        System.out.println("el MCD de " + num + " es " + max);
    }
    
    public static long maxDiv(long num) {
        int max = 0;
        long abs = (num < 0) ? -num : num;
            for (int i = 1; i < (abs / 2) + 1; i++)
                max = (abs % i == 0) ? i : max;
        return (num < 0) ? -max : max;
    }
    
}
