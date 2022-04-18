/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.otros;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class deb1 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int impar = 0;
        int par = 0;
        System.out.println("Escribe numeros, si escribes \"0\" el programa se cerrará y mostrará la cantidad introducida");
        while (true) {
            System.out.print("Escribe un numero ");
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }
            if (n % 2 == 0) {
                System.out.println("El numero es par");
                par++;
            } else {
                System.out.println("El numero es impar");
            }
            impar++;
        }
        System.out.println("Has introducido " + (par+impar)+ " numeros, de los cuales " + par + " numeros pares y " + impar + " numeros impares");
    }
    
}
