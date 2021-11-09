/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.ejercicios9Noviembre;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class LetrasAlternativas {

    /*
        Escribe un programa que imprima las letras de una frase introducida por 
        teclado de una forma alternativa, es decir, una de la parte inicial y la 
        siguiente de la final hasta recorrer todos los caracteres de la misma.
     */
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String nombre = "";
        String alternado = "";
        int longitud = 0;
        do {
            System.out.println("Escribe la palabra que será alternado");
            nombre = scan.nextLine();

            if (nombre.length() <= 0) {
                System.out.println("La palabra que has introducido no es valida");
            }
            
        } while (nombre.length() <= 0);
        
        longitud = nombre.length()-1;
        
        for (int i = 0; i < nombre.length() / 2; i++) {
            alternado += nombre.charAt(i);
            alternado += nombre.charAt(longitud-i);
        }

        if (nombre.length() % 2 != 0) {
            alternado += nombre.charAt(longitud / 2);
        }
        
        System.out.println("El texto alternativo es " + alternado);
    }
}
