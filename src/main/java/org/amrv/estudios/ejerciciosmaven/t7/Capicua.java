/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Capicua {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        final int numero = validarNumero("Introduce un numero:");
        int[] digitos = toArray(numero);
        System.out.println(capicua(digitos) ? "El numero es capicua" : "No es capicua");
    }

    public static boolean capicua(int[] digitos) {
        for (int i = 0; i < digitos.length; i++) {
            if (digitos[i] != digitos[digitos.length - 1 - i])
                return false;
        }
        return true;
    }

    public static int[] toArray(long numero) {
        final String str = String.valueOf(numero);
        int[] digitos = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digitos[i] = str.charAt(i) - '0';
        }
        return digitos;
    }

    private static int validarNumero(String title) {
        do {
            System.out.println(title);
            String num = scan.nextLine().trim().replace(',', '.').replace("-", "");
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException nfe) {
                System.out.println("No has introducido un numero");
            }
        } while (true);
    }
    
}
