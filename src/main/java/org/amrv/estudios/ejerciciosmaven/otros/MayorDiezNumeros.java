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
public class MayorDiezNumeros {

    // No tiene ningun sentido hacer un ejercicio asi sin usar arrays,
    // escribir 40 lineas de codigo de if elses para comparar numeros 
    // no es nada practico
    
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int mayor = Integer.MIN_VALUE;
        int num = 0;
        int i = 1;
        while (i < 10) {
            System.out.println("Introduce el numero " + (i));
            num = scan.nextInt();
            if (num > mayor) {
                mayor = num;
            }
            i++;
        }
        
        System.out.println("El mayor es " + mayor);
    }

}
