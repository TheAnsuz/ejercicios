package org.amrv.estudios.ejerciciosmaven.t2;

import java.util.Scanner;

public class GetCharFromAsciiCode {

	public static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Escriba \"exit\" para cerrar");

		while (true) { // Bucle con while porque me apetece

			System.out.print("Codigo para convertir: ");
			int num = 0;

			final String temp = scan.nextLine();

			// Cerrar el programa si el valor introducido es exit
			if (temp.equalsIgnoreCase("exit"))
				System.exit(0);

			// Bloque try para evitar que un valor invalido arruine el codigo al convertirlo
			// en un int
			// El valor se recoje como string ya que scan.nextInt() puede dar error si se
			// introduce un valor no numerico
			try {
				num = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				System.err.println("El valor introducido no es valido para la conversion (" + temp + ")");
				continue;
			}

			System.out.println("Ascii de " + num + " = " + (char) num);
		}

	}

}
