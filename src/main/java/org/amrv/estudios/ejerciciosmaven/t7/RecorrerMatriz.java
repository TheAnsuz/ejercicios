/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author marruiad
 */
public class RecorrerMatriz {

    private static final Random rnd = new Random();
    private static final DecimalFormat formateador = new DecimalFormat("00");
    private static final int[][] matrix = new int[rnd.nextInt(10) + 1][rnd.nextInt(10) + 1];

    public static void main(String[] args) {
        System.out.println("Dimensiones: " + matrix.length + "F " + matrix[0].length + "C");
        aleatorizar();
        System.out.println("Mostrar por filas:");
        mostrar(matrix);
        System.out.println();

        System.out.println("Mostrar por columnas");
        mostrar(transponer(matrix));
    }

    private static void mostrar(int[][] matriz) {
        System.out.print("     ");
        for (int i = 0; i < matriz[0].length; i++)
            System.out.print(formatear(i + 1,"c "));
        System.out.println();
        System.out.print("    |");
        for (int i = 0; i < matriz[0].length; i++)
            System.out.print("----");
        System.out.println();

        for (int y = 0; y < matriz.length; y++) {
            System.out.print(formatear(y + 1,"f | "));
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.print(formatear(matriz[y][x],"  "));
            }
            System.out.println();
        }
    }

    private static void aleatorizar() {
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[y].length; x++)
                matrix[y][x] = rnd.nextInt(100);
    }

    private static int[][] transponer(int[][] matriz) {
        int[][] transpuesta = new int[matriz[0].length][matriz.length];
        for (int y = 0; y < matriz.length; y++)
            for (int x = 0; x < matriz[y].length; x++) {
                transpuesta[x][y] = matriz[y][x];
            }
        return transpuesta;
    }
    
    public static String formatear(int num, String append) {
        return formateador.format(num).replaceAll("^0", " ") + append;
    }
}
