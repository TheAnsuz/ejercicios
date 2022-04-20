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
public class SentenciaLogica {
    
    private final static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Escriba \"exit\" para cerrar");
        
        for(;;) {
            final int num = numero();
        
            String resultado = 
                    (num < 0) ? resultado = "negativo":
                    (num >= 100) ? resultado = "mayor o igual a 100":
                    "positivo menor de 100";
           
            System.out.println("El numero (" + num + ") es " + resultado);
        
        }
    }
    
    // metodo para obtener un int o cerrar el programa sin que salte un error
    public static int numero() {
		int valor = 0;
		while (true) {
			System.out.print("Introduce el numero a comprobar ");
			final String txt = scan.nextLine().trim();

			if (txt.equalsIgnoreCase("exit"))
				System.exit(0);

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
