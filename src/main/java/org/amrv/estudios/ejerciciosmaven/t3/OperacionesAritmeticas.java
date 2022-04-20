/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t3;

/**
 *
 * @author marruiad
 */
public class OperacionesAritmeticas {
    
    public static void main(String[] args) {
        
        final int a = (int) Math.round(Math.random() * 10);
        final int b = (int) Math.round(Math.random() * 10);
        
        final String prefix = a + " # " + b + " = ";
        final int sum = a + b;
        final int res = a - b;
        final int mul = a * b;
        float div = a / (float) b;
        // Ajustar los decimales del float
        div = Math.round(div * 100f) / 100f;
        final float rest = a % (float) b;
        
        //Uso prefix.replace para evitar redundancia
        System.out.println( prefix.replace("#", "+") + sum );
        System.out.println( prefix.replace("#", "-") + res );
        System.out.println( prefix.replace("#", "*") + mul );
        System.out.println( prefix.replace("#", "/") + div );
        System.out.println( prefix.replace("#", "%") + rest );
    }
    
}
