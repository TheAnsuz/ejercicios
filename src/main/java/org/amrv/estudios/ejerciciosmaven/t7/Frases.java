/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t7;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Frases {

    private static final String[] frases = new String[5];
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < frases.length; i++) {
            System.out.println("Introduce la " + (i + 1) + "º frase:");
            frases[i] = scan.nextLine();
        }
        imprimeFrases();
        System.out.println("Mayor: ");
        mayorFrase();
        System.out.println("Menor: ");
        menorFrase();
    }

    public static void imprimeFrases() {
        for (int i = 0; i < frases.length; i++) {
            System.out.println("> " + frases[i]);
        }
    }

    public static void mayorFrase() {
        int pos = 0;
        for (int i = 0; i < frases.length; i++) {
            if (frases[i].length() >= frases[pos].length())
                pos = i;
        }
        System.out.println(pos + " > " + frases[pos]);
    }
    
    public static void menorFrase() {
        int pos = 0;
        for (int i = 0; i < frases.length; i++) {
            if (frases[i].length() <= frases[pos].length())
                pos = i;
        }
        System.out.println(pos + " > " + frases[pos]);
    }

}
