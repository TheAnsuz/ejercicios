/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t2;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Pascua {
    
    private final static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Escribe \"exit\" para terminar el programa");
        
        while (1 == 1) {
            final int y = numero();
        
            final int a = y % 19;
            final int b = y % 4;
            final int c = y % 7;
            final int d = ( (19 * a) + 24) % 30;
            final int e = ((2 * b) + (4 * c) + (6 * d) + 5) % 7;
            final int N = 22 + d + e;
            
            final String fecha = 
                    (N <= 31) ? (N + " de Marzo"):
                    ( (N-31) + " de Abril" );
            
            System.out.println("El domingo de pascua es el " + fecha);
        }
        
    }
    
    public static int numero() {
        int valor = 0;
        while (true) {
            System.out.print("Introduce el año ");
            final String txt = scan.nextLine().trim();

            if (txt.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            try {
                valor = Integer.parseInt(txt);
                break;
            } catch (Exception e) {
                System.err.println("El valor introducido no es valido");
            }

        }
        return valor;
    }
}
