package org.amrv.estudios.ejerciciosmaven.bucles;


import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Rectuangulo {

//  programa que pinte por pantalla un rectangulo de un caracter introducido 
//  por teclado cuyas dimensiones tambien son introducidas por teclado; validar las dimensiones. ejemplo:
//  base: 5
//  altura: 3
//  relleno: %
//  %%%%%
//  %%%%%
//  %%%%%
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

        for (int y = 0; y < altura; y++) {
            System.out.println();
            for (int x = 0; x < base; x++)
                System.out.print(letra + " ");
        }
        System.out.println();
    }
}
