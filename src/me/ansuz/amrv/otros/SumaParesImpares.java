/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.otros;

/**
 *
 * @author marruiad
 */
public class SumaParesImpares {

    public static void main(String[] args) {
        int sumPar = 0;
        int sumImp = 0;
        int num = 0;
        boolean continuar = true;
        while (continuar) {
            num++;

            if (num % 2 == 0) {
                sumPar += num;
            } else {
                sumImp += num;
            }

            if (num > 100) {
                continuar = false;
            }
        }
        System.out.println("Suma pares " + sumPar);
        System.out.println("Suma impares " + sumImp);
    }
}
