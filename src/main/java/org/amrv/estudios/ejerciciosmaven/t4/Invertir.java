/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t4;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Invertir {
    
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String texto;
        String inverso = "";
        
        System.out.println("Por favor escribe el texto a invertir");
        texto = scan.nextLine();
        
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            inverso += (Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c);
        }
        
        System.out.println(inverso);
        
    }
    
}
