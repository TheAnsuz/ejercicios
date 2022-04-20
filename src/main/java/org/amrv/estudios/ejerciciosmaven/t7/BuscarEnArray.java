/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t7;

import java.awt.Toolkit;
import java.util.Arrays;
import org.amrv.estudios.ejerciciosmaven.t5.Punto;

/**
 *
 * @author marruiad
 *
 *
 * metodo que reciba como parametros el array de puntos, y el cuadrante, 1-2-3-4
 * metodo que devuelva los puntos que se encuentran en el cuadrante dado, se
 * considera el plano de tu pantalla metodo que busque si se encuentra un punto
 * en el array de puntos, ambos recibidos como parametro metodo que busque si se
 * encuentra un punto en el array de puntos, ambos recibidos como parametro y en
 * caso afirmativo el metodo devolviera el cuadrante en el que se encuentra
 */
public class BuscarEnArray {

    private static final int XCENTER = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
    private static final int YCENTER = Toolkit.getDefaultToolkit().getScreenSize().height / 2;

//            |
//        2   |   1
//            |
//    --------|-------- 
//            |
//        3   |   4
//            |
    
    public static Punto[] getPuntos(int cuadrante, Punto... puntos) {
        int size = 0;
        final Punto[] inside = new Punto[puntos.length];

        for (Punto punto : puntos)
            if (getCuadrante(punto) == cuadrante) {
                inside[size] = punto;
                size++;
            }
        return Arrays.copyOfRange(inside, 0, size);
    }

    public static int getCuadrante(Punto punto) {
        return punto.getX() < XCENTER ? punto.getY() < YCENTER ? 2 : 3 : punto.getY() < YCENTER ? 1 : 4;
    }

    public static int getCuadrante(Punto punto, Punto... puntos) {
        final int index = Arrays.binarySearch(puntos, 0, puntos.length, punto);
        return index < 0 ? index : getCuadrante(punto);
    }
}
