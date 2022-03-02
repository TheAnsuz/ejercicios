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
public class MatrizTraspuesta {

    private static int[][] matrix = new int[4][5];
    private static DecimalFormat formateador = new DecimalFormat(" 000 ");
    private static Random rnd = new Random();

    public static void main(String[] args) {
        aleatorizar();
        mostrar(matrix);
        System.out.println();
        mostrar(transponer(matrix));
    }

    private static void aleatorizar() {
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[y].length; x++)
                matrix[y][x] = rnd.nextInt(100)+1;
    }

    private static void mostrar(int[][] matriz) {
        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.print(formateador.format(matriz[y][x]));
            }
            System.out.println();
        }
    }
    
    private static int[][] transponer(int[][] matriz) {
        int[][] transpuesta = new int[matriz[0].length][matriz.length];
        for (int y = 0; y < matriz.length; y++)
            for (int x = 0; x < matriz[y].length; x++) {
                transpuesta[x][y] = matriz[y][x];
            }
        return transpuesta;
    }
    
//    private static <T> T[][] transponer(T[][] matriz) {
//        Object[][] transpuesta = new Object[matriz[0].length][matriz.length];
//        
//        return (T[][]) transpuesta;
//    }
}
