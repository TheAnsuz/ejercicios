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
            System.out.println("Introduce la frase para comparar (o escribe \"terminar\" para mostrar la frase mas larga)");
            fraseActual = scan.nextLine().trim();
            
            if (fraseActual.length() <= 0)
                System.out.println("La frase que has introducido no es valida ya que no contiene texto");
            else {
                if (longitudMayor < fraseActual.length()) {
                    fraseMayor = fraseActual;
                    longitudMayor = fraseActual.length();
                }
            }
            
        } while (!fraseActual.equalsIgnoreCase("terminar"));
        
        System.out.println("La frase mas larga es:");
        System.out.println(fraseMayor + "(" + longitudMayor + ")");
    }
    
}
