/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t4;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Vocales {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int contador = 0;
        String palabra = "";

        do {
            System.out.println("Introduce la palabra");
            palabra = scan.nextLine().toLowerCase().trim();
        } while (palabra.length() <= 0 || palabra.isEmpty());

        for (int i = 0; i < palabra.length(); i++) {

            switch (palabra.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contador++;
                    break;
                default:
                    continue;
            }
            
        }
        
        System.out.println("Hay " + contador + " vocales en esa palabra/frase");
    }

}
