package me.ansuz.amrv.t2;

import java.util.Scanner;

public class GetASCIICodeFromChar {

	public static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Escriba \"exit\" para cerrar");

		for (;;) { // Bucle infinito con for porque me apetece usarlo

			System.out.print("Texto para convertir: ");
			String txt = scan.nextLine();

			// Terminar programa si se solicida
			if (txt.equalsIgnoreCase("exit"))
				System.exit(0);

			// Si el texto esta vacio no hay ningun caracter que convertir
			if (txt == "" || txt == null) {
				System.err.println("No hay codigo si no hay letras");
				continue;
			}

			// Convertir todos los caracteres del texto obtenido
			for (char c : txt.toCharArray()) {
				System.out.print(c + "(" + (int) c + ") ");

			}

			System.out.println();
		}
	}

}
