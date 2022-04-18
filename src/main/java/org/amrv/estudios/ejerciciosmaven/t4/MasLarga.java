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
public class MasLarga {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String fraseActual = "";
        String fraseMayor = "";
        int longitudMayor = 0;

        do {
            System.out.println("Introduce la frase para comparar o dejalo vacio para terminar");
            fraseActual = scan.nextLine().trim();

            if (longitudMayor < fraseActual.length()) {
                fraseMayor = fraseActual;
                longitudMayor = fraseActual.length();
            }

        } while (fraseActual.length() > 0);

        if (longitudMayor > 0){
        System.out.println("La frase mas larga es:");
        System.out.println(fraseMayor + "(" + longitudMayor + ")");
        }
        else
            System.out.println("No has introducido ninguna frase por lo cual no hay resultado");
    }

}
