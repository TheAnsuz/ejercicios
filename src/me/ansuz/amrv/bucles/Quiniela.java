/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.bucles;

import java.util.Random;

/**
 *
 * @author marruiad
 */
public class Quiniela {

    public static void main(String[] args) {

        Random rng = new Random();

        for (int y = 0; y < 14; y++) {
            System.out.print("Columna " + (y+1) + " \t");

            for (int x = 0; x < 10; x++) {
                int val = rng.nextInt(3);
                String resultado = "\t";
                
                switch (val) {
                    case 0:
                        resultado += " 1 - - ";
                        break;
                    case 1:
                        resultado += " - X - ";
                        break;
                    case 2:
                        resultado += " - - 2 ";
                        break;
                    default:
                        resultado += " - - - ";   
                }
                
                System.out.print(resultado);
            }
            
            System.out.println();
        }

    }

}
