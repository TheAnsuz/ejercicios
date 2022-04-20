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
public class DiasDelMes {
    
    private final static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Escriba \"exit\" para cerrar");
        
        while (true) {
        
            final int mes = numero();
            
            final String dias = 
                    (mes == 2) ? "28 dias":
                    (mes % 2 == 0) ? ((mes > 7) ? "31 dias": "30 dias") :
                    ((mes > 7) ? "30 dias": "31 dias");
            
            System.out.println("El mes " + mes + " tiene " + dias);
        }
    }
    
    // metodo para obtener un int o cerrar el programa sin que salte un error
    public static int numero() {
		int valor = 0;
		while (true) {
			System.out.print("Introduce el numero del mes ");
			final String txt = scan.nextLine().trim();

			if (txt.equalsIgnoreCase("exit"))
				System.exit(0);

			try {
				valor = Integer.parseInt(txt);
                                if (valor > 12 || valor < 1)
                                    throw new IndexOutOfBoundsException("El numero esta fuera de rango");
                                
                                break;
			} catch (Exception e) {
				System.err.println("El valor introducido no es valido");
			}

		}
		return valor;
	}
}
