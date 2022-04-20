package org.amrv.estudios.ejerciciosmaven.t2;

import java.util.Scanner;

public class TablaMultiplicar {

	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Escriba \"exit\" para cerrar");

		while (true) {

			System.out.print("Tabla de multiplicar de: ");
			int num = 0;

			final String temp = scan.nextLine().trim();

			// Cerrar el programa si se pide
			if (temp.equalsIgnoreCase("exit"))
				System.exit(0);

			// Convertir el texto en un numero entero si es posible
			try {
				num = Integer.parseInt(temp);
			} catch (Exception e) {
				System.err.println("Numero no valido");
				continue;
			}

			// Mostrar la tabla de multiplicar bien
			System.out.println("|================ " + temp + " ================|");
			for (int i = 0; i < 15; i++) {
				// Operador ternario para que quede mejor en la consola
				System.out.println("\t  " + ((i <= 9) ? " " : "") + i
						+ " * " + num + " = " + (num*i));
			}
			System.out.print("|=================");
			
			String and = "";
			
			// Evitar muchos System.out ya que causan lentitud en el programa
			for (int i = 0; i < temp.length(); i++)
				and = and + "=";
			System.out.println(and + "=================|\n");
		}
	}
	
}
