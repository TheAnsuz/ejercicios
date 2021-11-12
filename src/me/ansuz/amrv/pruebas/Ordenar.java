/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.pruebas;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Ordenar {
    
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String[] palabras = new String[0];
        String resultado = "";
        String anterior = "";
        
        System.out.println("Introduce las palabras separadas por espacio para ordenar");
        palabras = scan.nextLine().split(" ");
        
        // Ordenar y eliminar las cadenas vacías
        for(int i = 0; i < palabras.length; i++) {
            if (!palabras[i].equals("")) {
            
                if (anterior.equals(""))
                    anterior = palabras[i];
                else {
                    resultado += (anterior.compareTo(palabras[i]) < 0) ? palabras[i] + " " + anterior : anterior + " " + palabras[i];
                    anterior = palabras[i];
                }
            }    
        }
        
        System.out.println(resultado);
    }
    
}
