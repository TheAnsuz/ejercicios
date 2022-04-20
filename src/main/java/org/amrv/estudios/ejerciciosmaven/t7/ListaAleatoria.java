/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t7;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author marruiad
 */
public class ListaAleatoria {

    private static final Random rnd = new Random();

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = generarNumero(nums);
        }
        System.out.println("> " + Arrays.toString(nums) + " <");

    }

    public static int generarNumero(int... array) {
        final int n = rnd.nextInt(array.length) + 1;
        return contieneNumero(array, n) ? generarNumero(array) : n;
    }

    public static boolean contieneNumero(int[] array, int numero) {
        for (int n : array)
            if (n == numero)
                return true;

        return false;
    }

}
