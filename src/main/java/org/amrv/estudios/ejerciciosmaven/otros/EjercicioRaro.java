/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.otros;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class EjercicioRaro {
    
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int num = -1;
        int num2 = -1;
        
        while( num < 0 || num > 10 ) {
            System.out.print("Introduce el primer numero: ");
            num = scan.nextInt();
        }
        while( num2 < 0 || num2 > 10 ) {
            System.out.print("Introduce el segundo numero: ");
            num2 = scan.nextInt();
        }
        for (int i = 0; i < 11; i++) {
            String tablaA = num + "*" + i + " = " + (num*i);
            String tablaB = num2 + "*" + i + " = " + (num2*i);
            // Queda fatal una columna por los dos asique puedes cambiar el \n por un \t para que aparezcan dos columnas
            System.out.println(tablaA + "    \n" + tablaB);
        }
    }
}
