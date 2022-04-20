/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Ejercicio4_areas {
    
    /*
        Escribe un programa Areas que permita al usuario elegir el cálculo del área de cualquiera
        de las siguientes figuras geométricas: círculo, cuadrado, rectángulo o triángulo, mediante
        métodos. Para ello muestra al usuario un menú
    */
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        String tipo;
        boolean valido = false;
        do {
            System.out.println("Introduce el area a calcular");
            System.out.println(" - circulo");
            System.out.println(" - cuadrado");
            System.out.println(" - rectangulo");
            System.out.println(" - triangulo");
            tipo = scan.nextLine();
            
            if (tipo.equalsIgnoreCase("circulo"))
                valido = true;
            else if (tipo.equalsIgnoreCase("cuadrado"))
                valido = true;
            else if (tipo.equalsIgnoreCase("rectangulo"))
                valido = true;
            else if (tipo.equalsIgnoreCase("triangulo"))
                valido = true;
        } while (!valido);
    }
}
