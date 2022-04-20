/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

/**
 *
 * @author marruiad
 */
public class Muestra_Factorial {
 
    public static void main(String[] args) {
        long init = System.nanoTime();
        System.out.println("Recursivo: " + recursivo(15));
        long a = System.nanoTime();
        System.out.println("Nucleico:  " + recursivo(15));
        long b = System.nanoTime();
        System.out.println("Tiempos: ");
        System.out.println("Recursivo..." + (a-init));
        System.out.println("Nucleico...." + (b-init));
        System.out.println("maximo:");
        boolean continuar = true;
        long rec = 1;
        try {
        do {
            long t = recursivo(rec);
            System.out.println(rec+"! = " + t);
            rec++;
            if (t >= Long.MAX_VALUE || t <= Long.MIN_VALUE || t == 0)
                continuar = false;
        } while (continuar);
        } catch (Exception e) {
            continuar = false;
        }
    }
    
    
    public static long recursivo(long num) {
        return (num > 1) ? num * recursivo(num-1) : num;
    }
    
    public static long nucleico(long num) {
        long res = num;
        for (;num > 1; num--)
            res*=num;
        return res;
    }
}
