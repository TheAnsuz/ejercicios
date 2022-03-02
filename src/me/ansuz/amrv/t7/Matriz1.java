/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t7;

/**
 *
 * @author marruiad
 */
public class Matriz1 {

    private int[][] matrix;

    public Matriz1() {
        this(5);
    }

    public Matriz1(int size) {
        matrix = new int[size][size];
        int index = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = (int) Math.round(Math.random() * 9);
//                matrix[y][x] = index++;
            }

        }
    }

    public void imprimirMatriz() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                System.out.print(matrix[y][x] + " ");
            }
            System.out.println();
        }
    }

    public long sumarMatriz() {
        long res = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                res += matrix[y][x];
            }
        }
        return res;
    }

    public void diagonal() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (y == x)
                    System.out.print(matrix[y][x]+" ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Matriz1 m = new Matriz1();
        m.imprimirMatriz();
        System.out.println();
        System.out.println("Suma: " + m.sumarMatriz());
        System.out.println();
        m.diagonal();
    }
}
