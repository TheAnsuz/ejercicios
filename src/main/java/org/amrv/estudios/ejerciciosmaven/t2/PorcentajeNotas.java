package org.amrv.estudios.ejerciciosmaven.t2;

import java.util.Scanner;

public class PorcentajeNotas {

	public static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Escriba \"exit\" para cerrar");
		int notas[] = new int[5];
		for (;;) {
			// Introduccion de las notas individualmente
			notas[0] = pedirNota("Introduce el numero de sobresalientes: ");
			notas[1] = pedirNota("Introduce el numero de notables: ");
			notas[2] = pedirNota("Introduce el numero de aprobados: ");
			notas[3] = pedirNota("Introduce el numero de suspensos: ");
			notas[4] = pedirNota("Introduce el numero de no presentados: ");

			// Calculo de total de alumnos e imprimir los resultados
			int alumnos = notas[0] + notas[1] + notas[2] + notas[3] + notas[4];
			System.out.println("#========================= " + alumnos + " =========================#");
			System.out.println();
			System.out.println(ftext("Sobresalientes: ", notas[0], percent(notas[0], alumnos)));
			System.out.println(ftext("Notables: ", notas[1], percent(notas[1], alumnos)));
			System.out.println(ftext("Aprobados: ", notas[2], percent(notas[2], alumnos)));
			System.out.println(ftext("Suspensos: ", notas[3], percent(notas[3], alumnos)));
			System.out.println(ftext("No presentados: ", notas[4], percent(notas[4], alumnos)));
			System.out.println(ftext("Total alumnos: ", alumnos, percent(alumnos, alumnos)));
			final int presentados = notas[0] + notas[1] + notas[2] + notas[3];
			System.out.println(ftext("Total Presentados: ", presentados, percent(presentados, alumnos)));
			final int aprobados = notas[0] + notas[1] + notas[2];
			System.out.println(ftext("Total Aprobados: ", aprobados, percent(aprobados, alumnos)));
			System.out.println(ftext("Total Suspensos: ", notas[3], percent(notas[3], alumnos)));
			System.out.println(ftext("Total no presentados: ", notas[4], percent(notas[4], alumnos)));
			System.out.println();

			// Cerrar la muestra de resultados con el mismo tama�o con el que se abri�
			String reps = "";
			for (int i = 0; i < (alumnos + "").length(); i++) {
				reps = reps + "=";
			}

			System.out.println("#==========================" + reps + "==========================#");
		}

	}

	// Convierte los tres valores ofrecidos en una cadena de texto formateada para
	// que tenga un tama�o concreto
	public static String ftext(final String prefix, int num, float percent) {
		String text = prefix;
		final int init = text.length() + (num + " ").length();
		final int max = 30;
		for (int i = 0; i < max; i++) {
			if (i == init)
				text = text + num;
			else if (i > init && i < max)
				text = text + '.';
		}
		text = text + percent + "%";
		return "       " + text;
	}

	// Convierte el valor parcial y su total en un porcentaje de dos difras
	// decimales como mucho
	public static float percent(float parcial, float total) {
		float full = Math.round(parcial / total * 10000);
		return full / 100;
	}

	// Pide la nota junto a un proceso para evitar fallos con los numeros, ademas de
	// una opcion para salir del programa si es necesario
	public static int pedirNota(final String msg) {
		int valor = 0;
		while (true) {
			System.out.print(msg);
			final String txt = scan.nextLine().trim();

			if (txt.equalsIgnoreCase("exit"))
				System.exit(0);

			try {
				valor = Integer.parseInt(txt);
				if (valor < 0)
					throw new Exception("El valor no puede ser negativo");
				else
					break;
			} catch (Exception e) {
				System.err.println("El valor introducido no es valido");
			}

		}
		return valor;
	}

}
