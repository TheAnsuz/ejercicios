/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.bucles;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Marco {
     
//  programa que pinte por pantalla un marco cuadrado de un caracter introducido 
//  por teclado cuyas dimensiones tambien son introducidas por teclado; validar las dimensiones. ejemplo:
//  base/altura:3
//  relleno: %
//  %%%
//  % %
//  %%%
    
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        char letra = '\0';
        int base = 1;
        int altura = 1;
        System.out.println("Introduce los valores del rectangulo, los valores deben ser mayores a 0");

        System.out.print("Introduce el caracter para rellenarlo ");
        letra = scan.nextLine().charAt(0);

        do {
            System.out.print("Introduce el tamaño de la base ");
            base = scan.nextInt();
            if (base <= 0)
                System.out.println("El tamaño de la base debe ser mayor de 0");
        } while (base <= 0);

        do {
            System.out.print("Introduce la altura ");
            altura = scan.nextInt();
            if (altura <= 0)
                System.out.println("El tamaño de la altura debe ser mayor a 0");
        } while (altura <= 0);

        // Borde superior
        for (int x = 0; x < base; x++)
            System.out.print(letra + " ");
        System.out.println();
        
        // Bordes laterales
        for (int y = 1; y < altura-1; y++) {
            System.out.print(letra + " ");
            for (int s = 1; s < base-1; s++)
                System.out.print("  ");
            System.out.println(letra + " ");
        }
        
        // Borde inferior
        for (int x = 0; x < base; x++)
            System.out.print(letra + " ");
        
    }
    
}
