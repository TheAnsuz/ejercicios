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
public class Primo {
 
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Introduce el valor para comprobar si es primo");
        long num = scan.nextLong();
        
        boolean primo = true;
        int valor = 0;
        int i = 2;
        do {

            if (num % i == 0) {
                primo = false;
                valor = i;
            }
            i++;
        } while (i < Math.sqrt(num)+1 && primo);
        
        if (primo)
            System.out.println("El numero " + num + " es primo");
        else
            System.out.println("El numero " + num + " NO es primo (divisible entre " + valor + ")");
    }
    
}
