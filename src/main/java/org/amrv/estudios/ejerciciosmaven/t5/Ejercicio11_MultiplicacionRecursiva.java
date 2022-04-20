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
public class Ejercicio11_MultiplicacionRecursiva {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Calculo de dos enteros");
        System.out.println("Introduce el primer numero");
        int a = scan.nextInt();
        scan.nextLine();
        System.out.println("Introduce el segundo numero");
        int b = scan.nextInt();
        System.out.println(a + "x" + b + " = " + multiplicar(a, b));
    }
    // Multiplica a · b usando recursividad
    public static int multiplicar(int a, int b) {
        return (b == 0) ? a + multiplicar(a, (b < 0) ? b++ : b--) : a;
    }

}
