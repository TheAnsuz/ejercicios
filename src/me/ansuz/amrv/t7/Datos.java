/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7;

/**
 *
 * @author marruiad
 */
public class Datos {

    public static int[] numeros = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        pares();
        System.out.println("Total......." + suma());
    }

    public static void pares() {
        for (int i = 0; i < numeros.length; i++)
            if (i % 2 == 0)
                System.out.println(">> " + numeros[i]);
    }

    public static int suma() {
        int total = 0;
        for (int n : numeros)
            total += n;
        return total;
    }
}
