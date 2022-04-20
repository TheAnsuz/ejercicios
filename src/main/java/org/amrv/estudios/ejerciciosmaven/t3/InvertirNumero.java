/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t3;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class InvertirNumero {

//    Escribe un programa llamado InvertirEntero que invierta los dígitos de un entero dado por el usuario
//    . Para ello convierte el número a cadena.

    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {

        System.out.println("Por favor introduce un numero para invertir");
        long num = scan.nextLong();
        
        String normal = String.valueOf(num);
        String inverso = "";
        
        // Invertir el numero
        for (int i = normal.length()-1; i >= 0; i--) {
            inverso+= normal.charAt(i);
        }
    
        System.out.println(normal + " -> " + inverso);
        
    }
    
}
