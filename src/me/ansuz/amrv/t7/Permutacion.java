/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Permutacion {

    private static int[][] matrix = new int[0][0];
    private final static Scanner scan = new Scanner(System.in);
    private static final Random rnd = new Random();
    private static final DecimalFormat formateador = new DecimalFormat(" 000 ");

    public static void main(String[] args) {
        System.out.println("Introduce la dimension X de la matriz");
        int _x = scan.nextInt();
        System.out.println("Introduce la dimension Y de la matriz");
        int _y = scan.nextInt();
        matrix = new int[_y][_x];
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[y].length; x++)
                matrix[y][x] = rnd.nextInt(100) + 1;
        mostrar(matrix);
        permutar(matrix, _y, _y/2);
        System.out.println();
        mostrar(matrix);
    }
    
    public static void permutar(int[][] m, int fila1, int fila2) {
        final int[] temp = Arrays.copyOf(m[fila1], m[fila1].length);
        m[fila1] = m[fila2];
        m[fila2] = temp;
    }
    
    private static void mostrar(int[][] matriz) {
        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.print(formateador.format(matriz[y][x]));
            }
            System.out.println();
        }
    }
}
