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
public class Ejercicio8_MayorDe3 {
 
    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        float a = 0;
        float b = 0;
        float c = 0;
        boolean valido = false;
        do {
            try {
                System.out.print("Introduce el primer numero ");
                a = Float.parseFloat(scan.nextLine());
                System.out.print("Introduce el segundo numero ");
                b = Float.parseFloat(scan.nextLine());
                System.out.print("Introduce el tercer numero ");
                c = Float.parseFloat(scan.nextLine());
                valido = true;
            } catch (Exception e) {
                System.err.println("El numero introducido no es valido");
            }
        } while (!valido);
            
        System.out.println("El numero mayor es " + elMayor(a,b,c));
    }
    
    public static float elMayor(float a, float b, float c) {
        return (elMayor(a,b) > elMayor(b,c)) ? elMayor(a,b) : elMayor(b,c);
    }
    
    public static float elMayor(float a, float b) {
        return (a > b) ? a : b;
    }
    
}
