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
public class Binario {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Introduce 0, 1 para los valores binarios, cualquier otro numero cerrara el programa");
        System.out.print("X - - \t= ");
        int cero = scan.nextInt();
        if (cero < 0 || cero > 1) {
            System.err.println("El numero introducido no es valido");
            System.exit(0);
        }

        System.out.print(cero + " X - \t= ");
        int uno = scan.nextInt();
        if (uno < 0 || uno > 1) {
            System.err.println("El numero introducido no es valido");
            System.exit(0);
        }

        System.out.print(cero + " " + uno + " X \t= ");
        int dos = scan.nextInt();
        if (dos < 0 || dos > 1) {
            System.err.println("El numero introducido no es valido");
            System.exit(0);
        }

        int resultado = 2 * 2 * cero + 2 * uno + dos;

        System.out.println(cero + " " + uno + " " + dos + " \t= " + resultado);

        scan.close();
    }

}
