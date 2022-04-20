/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t5;

/**
 *
 * @author marruiad
 */
public class ValidarDatos {
    
    public static void main(String[] args) {
        System.out.println("Numero " + validarNumero(" 213 ", 15, 12, 100));
    }
    
    public static boolean esNumero(String valor) {
        if (valor == null)
            return false;
        valor = valor.trim();
        boolean decimal = false;
        
        for (int i = 0; i < valor.length(); i++) {
            if (Character.isDigit(valor.charAt(i))) {
                // Es un digito
                
            } else if (i == 0 && valor.charAt(i) == '-') {
                // Es la inicial de negativo
                
            } else if (!decimal && valor.charAt(i) == '.') {
                // Es decimal porque tiene punto
                decimal = true;
                
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static double validarNumero(String numero, double porDefecto, double min, double max) {
        final double num = esNumero(numero) ? Double.parseDouble(numero) : porDefecto;
        return num > max ? max : num < min ? min : num;
    }

}
