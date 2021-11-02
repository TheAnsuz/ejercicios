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
public class Not {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Debes escribir un numero binario de 8 bits, ejemplo 00100100");

        // Declaración de variables
        String binario = "";
        String inverso = "";
        boolean pedirNumero = true;
        boolean caracteresInvalidos = false;

        // Comprobacion del numero evitando el uso de for(), break; continue; o System.exit(0);
        while (pedirNumero) {
            System.out.print("Introduce el binario a invertir ");
            // Elimina los espacios en blanco para evitar problemas
            binario = scan.nextLine().replaceAll(" ", "");
            if (binario.length() != 8) {
                caracteresInvalidos = true;
            }
            int size = 0;
            while (size < binario.length() && !caracteresInvalidos) {
                if (binario.charAt(size) != '0' && binario.charAt(size) != '1') {
                    // El numero tiene caracteres invalidos por lo cual debe volver a pedir el numero
                    caracteresInvalidos = true;
                }
                size++;
            }

            if (caracteresInvalidos) {
                System.out.println("El valor introducdo tiene valores incorrectos");
            } else {
                pedirNumero = false;
            }
        }

        int decimal = 0;
        int decimalInverso = 0;
        int actual = 0;
        while (actual < binario.length()) {
            if (binario.charAt(actual) == '1') {
                inverso += '0';
                decimal += Math.pow(2, actual);

            } else {
                inverso += '1';
                decimalInverso += Math.pow(2, actual);
            }
            actual++;
        }

        System.out.println("NOT(" + binario + ") = " + inverso);
        System.out.println("NOT(" + decimal + ") = " + decimalInverso);

    }

}
