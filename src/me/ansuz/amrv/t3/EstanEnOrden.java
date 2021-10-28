/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t3;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class EstanEnOrden {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int a, b, c;
        System.out.print("Primer numero  -> ");
        a = scan.nextInt();
        System.out.print("Segundo numero -> ");
        b = scan.nextInt();
        System.out.print("Tercer numero  -> ");
        c = scan.nextInt();

        if (a > b && b > c) {
            // Odenados de mayor a menor
            System.out.println("Ordenados de mayor a menor");
        } else if (a < b && b < c) {
            // Ordenados de menor a mayor
            System.out.println("Ordenados de menor a mayor");
        } else
            // No estan ordenados
            System.out.println("No estan ordenados");
    }
}
