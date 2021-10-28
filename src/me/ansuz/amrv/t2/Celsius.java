/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t2;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Celsius {
    
    private final static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Escribe \"exit\" para salir");
        
        for (;;) {
            
            final float celsius = numero();
            final float farenheit = (9 / 5) * celsius + 32;
            
            System.out.println("La temperatura " + celsius + "Cº es equivalente a " + farenheit + "Fº");
            
        }
    }
    
    public static float numero() {
		float valor = 0;
		while (true) {
			System.out.print("Introduce la temperatura en censius ");
			final String txt = scan.nextLine().trim();

			if (txt.equalsIgnoreCase("exit"))
				System.exit(0);

			try {
				valor = Float.parseFloat(txt);
                                break;
			} catch (Exception e) {
				System.err.println("El valor introducido no es valido");
			}

		}
		return valor;
	}
}
