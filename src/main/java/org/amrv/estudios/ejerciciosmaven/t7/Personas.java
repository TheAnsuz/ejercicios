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
public class Personas {

    private static final Scanner scan = new Scanner(System.in);
    private static final String[] personas = new String[20];

    public static void main(String[] args) {

        for (int i = 0; i < personas.length; i++) {
            System.out.println("Introduce el nombre de la " + (i+1) + "º persona:");
            personas[i] = scan.nextLine();
        }
        System.out.println("Personas: ");
        imprimePersonas();
        System.out.println();
        System.out.println("Pares: ");
        pares();
    }

    public static void imprimePersonas() {
        for (String persona : personas) {
            System.out.println(" > " + persona);
        }
    }

    public static void pares() {
        for (int i = 0; i < personas.length; i += 2)
            System.out.println(" > " + personas[i]);
    }

}
