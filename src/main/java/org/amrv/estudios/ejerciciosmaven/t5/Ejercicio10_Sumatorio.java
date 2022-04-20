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
public class Ejercicio10_Sumatorio {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        do {
            try {
                System.out.println("Introduce un numero");
                num = Integer.parseInt(scan.nextLine());
                if (num <= 0) {
                    System.out.println("El numero debe de ser mayor de 0");
                }
            } catch (Exception e) {
                System.out.println("Debes introducir un numero");
            }
        } while (num <= 0);
        System.out.println("El valor por recursividad de " + num + "! es " + sum_rectal(num));
        System.out.println("El valor por bucles de " + num + "! es " + sum_nor(num));
    }

    public static long sum_rectal(long num) {
        return (num <= 0) ? num : num + sum_rectal(num - 1);
    }

    public static long sum_nor(long num) {
        long res = 0;
        while (num > 0) {
            res += num;
            num--;
        }
        return res;
    }

}
