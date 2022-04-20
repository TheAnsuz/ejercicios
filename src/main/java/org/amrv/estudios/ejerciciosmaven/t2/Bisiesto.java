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
public class Bisiesto {

    private final static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {

        System.out.println("Escribe \"exit\" para cerrar");

        for (;;) {

            final int y = numero();
            
            final String es = (y % 4 != 0) ? "no es bisiesto" :
                    (y % 100 != 0) ? "es Bisiesto" :
                    (y % 400 == 0) ? "es bisiesto" :
                    "no es Bisiesto";
            
            System.out.println("El año " + y + " " + es);
            
        }
    }

    public static int numero() {
        int valor = 0;
        while (true) {
            System.out.print("Introduce el año: ");
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
