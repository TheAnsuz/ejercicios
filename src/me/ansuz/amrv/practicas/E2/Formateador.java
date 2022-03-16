/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Formateador {

    public static String textoCentrado(String prefix, String text, String sufix, int longitud, char relleno) {
        String resultado = text;
        boolean before = false;

        while (resultado.length() < longitud) {
            resultado = before ? relleno + resultado : resultado + relleno;
            before = !before;
        }

        return prefix + resultado + sufix;
    }

    public static String textoIzquierda(String prefix, String text, String sufix, int longitud, char relleno) {
        String resultado = text;

        while (resultado.length() < longitud) {
            resultado = relleno + resultado;
        }

        return prefix + resultado + sufix;
    }
}
