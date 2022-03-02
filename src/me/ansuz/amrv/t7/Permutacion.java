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
        matrix = new int[obtenerNumero("Introduce el nº de filas: ", 1, 255)][obtenerNumero("Introduce el nº de columnas: ", 1, 255)];
        for (int y = 0; y < matrix.length; y++)
            for (int x = 0; x < matrix[y].length; x++)
                matrix[y][x] = rnd.nextInt(100) + 1;

        mostrar(matrix);

        System.out.println("Permutacion de filas");
        permutarFilas(matrix, obtenerNumero("Introduce fila origen: ", 1, matrix.length)-1, obtenerNumero("Introduce fila destino: ", 1, matrix.length)-1);
        System.out.println();
        mostrar(matrix);
        
        System.out.println("Permutacion de columnas");
        permutarColumnas(matrix, obtenerNumero("Introduce columna origen: ", 1, matrix[0].length)-1, obtenerNumero("Introduce columna destino: ", 1, matrix[0].length)-1);
        System.out.println();
        mostrar(matrix);
    }

    public static void permutarFilas(int[][] m, int fila1, int fila2) {
        final int[] temp = Arrays.copyOf(m[fila1], m[fila1].length);
        m[fila1] = m[fila2];
        m[fila2] = temp;
    }
    
    public static void permutarColumnas(int[][] m, int columna1, int columna2) {
        for (int i = 0; i < m.length; i++) {
            final int temp = m[i][columna1];
            m[i][columna1] = m[i][columna2];
            m[i][columna2] = temp;
        }
    }

    private static void mostrar(int[][] matriz) {
        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                System.out.print(formateador.format(matriz[y][x]));
            }
            System.out.println();
        }
    }

    private static int obtenerNumero(String titulo, int min, int max) {
        while (true) {
            System.out.print(titulo);
            try {
                final int num = Integer.parseInt(scan.nextLine());
                if (num < min)
                    System.err.println("El numero introducido no puede ser menor que " + min);
                else if (num > max)
                    System.err.println("El numero introducido no puede ser mayor que " + max);
                else
                    return num;
            } catch (NumberFormatException e) {
                System.err.println("El valor introducido no es un numero");
            }
        }
    }
}
