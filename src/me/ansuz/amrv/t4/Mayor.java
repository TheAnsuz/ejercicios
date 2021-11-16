/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t4;

import java.util.Random;

/**
 *
 * @author marruiad
 */
public class Mayor {
    
    public static void main(String[] args) {
        Random rnd = new Random();
        int mayor = 0;
        
        for (int i = 0; i < 20; i++) {
            int num = rnd.nextInt(1000) + 1;
            System.out.print("Numero: " +  num);
            if (num > mayor) {
                mayor = num;
                System.out.println(" es el nuevo numero mayor");
            } else
                System.out.println();
        }
        
        System.out.println("El numero mayor es " + mayor);
    }
    
}
