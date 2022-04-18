/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7;

/**
 *
 * @author marruiad
 */
public class Datos2 {

    public static void main(String[] args) {
        paresEnImpares(Datos.numeros);
    }

    public static void paresEnImpares(int[] array) {
        int cuenta = 0;
        int suma = 0;
        for (int i = 0; i < array.length; i++)
            if (i % 2 != 0 && array[i] % 2 == 0) {
                cuenta++;
                suma+= array[i];
                System.out.println(i + ">> " + array[i] + "\tsuma = " + suma + " ("+cuenta+")");
            }
    }
    
    
}
