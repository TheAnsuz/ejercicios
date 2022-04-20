/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t7;

import static org.amrv.estudios.ejerciciosmaven.t7.Datos.generar;

/**
 *
 * @author marruiad
 */
public class DatosMultiThread {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Datos.numeros = generar(10);
                Datos.pares();
                System.out.println("Total......." + Datos.suma());
            }

        };
        t.start();
        DatosMultiThread.paresEnImpares(Datos.numeros);
    }

    public static void paresEnImpares(int[] array) {
        int cuenta = 0;
        int suma = 0;
        for (int i = 0; i < array.length; i++)
            if (i % 2 != 0 && array[i] % 2 == 0) {
                cuenta++;
                suma += array[i];
                System.out.println(i + ">> " + array[i] + "\tsuma = " + suma + " (" + cuenta + ")");
            }
    }
}
