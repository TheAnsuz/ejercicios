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
public class RomboideMatriz {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int size = 0;
        int mitad = 0;
        boolean[][] matriz;
        System.out.println("Escribe el tamaño de la matriz, este debe ser par");
        do {

            System.out.print("Introduce el tamaño de la matriz ");
            size = scan.nextInt();

            if (size < 0 && size % 2 != 0)
                System.out.println("El numero introducido es invalido");

        } while (size < 0 && size % 2 != 0);

        mitad = size/2;
        matriz = new boolean[size][size];

        // Asignar valores para la matriz
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                matriz[y][x] = (y < mitad) ? (y % 2 == 0) ? false : true : (y % 2 == 0) ? true : false;
                matriz[y][x] = (x < mitad) ? (x % 2 == 0) ? matriz[y][x] : !matriz[y][x] : (x % 2 == 0) ? !matriz[y][x] : matriz[y][x];
            
                
            }
        }

        // Imprimir valores a pantalla
        for (int y = 0; y < size; y++) {
            System.out.println();
            for (int x = 0; x < size; x++) {
                System.out.print( (matriz[y][x]) ? "[]" : "  " );
            }
        }
    }

}
