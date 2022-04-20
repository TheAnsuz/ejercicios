/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t7;

import java.util.Random;

/**
 *
 * @author marruiad
 */
public class EjemploArrays {
    
    public static void mostrar(int... array) {
        for (int i = 0;i < array.length; i++)
            System.out.println(i + " > " + array[i]);
    }
    
    public static void main(String[] args) {
        int[] array = new int[20];
        final Random rnd = new Random();
        
        for (int i = 0;i < array.length; i++)
            array[i] = rnd.nextInt(120) + 70;
        
        mostrar(array);
        mostrar(1,2,5,23,4,1,3,56,3,2);
    }
    
}
