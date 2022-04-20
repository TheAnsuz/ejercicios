package org.amrv.estudios.ejerciciosmaven.bucles;


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class LanzamientoDados {

    /*
     * Programa que simule el lanzamiento de 2 dados (un nº positivo de veces)
     * y cuente el nº de veces que salee 12.
     */
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int reps = 0;
        final Random rng = new Random();
        int veces = 0;
        
        do {
        
            System.out.print("Introduce el numero de repeticiones ");
            reps = scan.nextInt();
            
            if (reps <= 0) {
                System.out.println("El numero de repeticiones debe ser mayor que 0");
            }
        } while (reps <= 0);
        
        for (int i = 0; i < reps; i++) {
            if (rng.nextInt(13) == 12)
                veces++;
        }
        
        System.out.println("El \"12\" ha salido " + veces + " veces");
    }

}
