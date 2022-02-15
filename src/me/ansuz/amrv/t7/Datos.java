/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7;

import java.util.Random;

/**
 *
 * @author marruiad
 */
public class Datos {

    public static int[] numeros = new int[0];

    public static void main(String[] args) {
        numeros = generar(10);
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
    
    public static int[] generar(int size) {
        Random rnd = new Random();
        int[] numeros = new int[size];
        for (int i = 0; i < size; i ++) {
            numeros[i] = rnd.nextInt(10);
        }
        return numeros;
    }
}
