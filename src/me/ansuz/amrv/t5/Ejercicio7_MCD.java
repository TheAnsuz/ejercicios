/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Ejercicio7_MCD {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        boolean valido = false;
        do {

            try {
                System.out.println("Introduce dos numeros enteros positivos, el primero debe ser mayor que el segundo");
                System.out.print("Introduce el primer numero ");
                a = Integer.parseInt(scan.nextLine());
                System.out.print("Introduce el segundo numero ");
                b = Integer.parseInt(scan.nextLine());

                if (a < 0 || b < 0)
                    System.err.println("Los numeros no pueden ser negativos");
                else
                    valido = true;
            } catch (Exception e) {
                System.err.println("El numero introducido no es valido");
            }

        } while (!valido);

        int mcd = (a > b) ? mcd(a,b) : mcd(b,a);
        
        System.out.println("El MCD de " + a + " y " + b + " es " + mcd);
        
    }

    public static int mcd(int a, int b) {
        int mayor = a;
        int menor = b;
        do {

            int resto = mayor % menor;
            if (resto != 0) {
                mayor = menor;
                menor = resto;
            }

        } while (mayor % menor != 0);
        return menor;
    }

}
