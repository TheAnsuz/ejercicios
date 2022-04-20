/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t3;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class MCD {
    
//    Para el cálculo del MCD utilizar el “algoritmo de Euclides”, que consiste en dividir el mayor
//    número por el menor, quedarse con el resto y transformar dicho resto en el número menor
//    y el menor de antes en el mayor de ahora. Repetir el proceso hasta que el resto sea cero. en
//    ese momento el menor número será el máximo común divisor.
    
    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Introduce solo numeros enteros positivos");
        System.out.print("Introduce el primer numero ");
        int num1 = scan.nextInt();
        System.out.print("Introduce el segundo numero ");
        int num2 = scan.nextInt();
        
        int mayor = (num1 >= num2) ? num1 : num2;
        int menor = (num1 < num2) ? num1 : num2;
        
        do {
        
            int resto = mayor % menor;
            if (resto != 0) {
                mayor = menor;
                menor = resto;
            }
            
        } while(mayor % menor != 0);
        
        System.out.println("El MCD es " + menor);
    }
    
}
