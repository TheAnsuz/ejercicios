/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.practicas.E2;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author marruiad
 */
public class Input {

	// El escaner solo debe existir y ser accesible en esta clase
	private static final Scanner scan = new Scanner(System.in);

	/**
	 * Muestra un encabezado formateado
	 * 
	 * @param header texto del encabezado
	 */
	private static void showHeader(String header) {
		System.out.print(header + (header.endsWith("  ") ? System.lineSeparator() : ' '));
	}

	/**
	 * Obtiene un numero entero
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @return el numero entero
	 */
	public static int getInt(String enunciado) {
		return getInt(enunciado, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * Obtiene un numero entero dentro de un rango
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @param min       numero minimo
	 * @param max       numero maximo
	 * @return el numero dentro del rango
	 */
	public static int getInt(String enunciado, int min, int max) {
		do {
			Input.showHeader(enunciado);
			try {
				int num = Integer.parseInt(scan.nextLine());
				if (num >= min && num <= max)
					return num;
				else
					System.err.println(
							"El numero debe de " + (min == max ? "ser " + min : "estar entre " + min + " y " + max));
			} catch (NumberFormatException e) {
				System.err.println("El valor introducido no es numerico");
			}
		} while (true);
	}

	/**
	 * Obtiene un numero decimal
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @return numero decimal
	 */
	public static float getFloat(String enunciado) {
		return getFloat(enunciado, Float.MIN_VALUE, Float.MAX_VALUE);
	}

	/**
	 * Obtiene un numero decimal dentro de un rango
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @param min       decimal minimo
	 * @param max       decimal maximo
	 * @return numero decimal dentro de un rango
	 */
	public static float getFloat(String enunciado, float min, float max) {
		do {
			Input.showHeader(enunciado);
			try {
				float num = Float.parseFloat(scan.nextLine());
				if (num >= min && num <= max)
					return num;
				else
					System.err.println(
							"El numero debe de " + (min == max ? "ser " + min : "estar entre " + min + " y " + max));
			} catch (NumberFormatException e) {
				System.err.println("El valor introducido no es numerico");
			}
		} while (true);
	}

	/**
	 * Obtiene un texto
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @return texto
	 */
	public static String getString(String enunciado) {
		return getString(enunciado, 1, Integer.MAX_VALUE);
	}

	/**
	 * Obtiene un texto de una longitud determinada
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @param minLength longitud minima
	 * @param maxLength longitud maxima
	 * @return texto de una longitud especificada
	 */
	public static String getString(String enunciado, int minLength, int maxLength) {
		do {
			Input.showHeader(enunciado);
			String text = scan.nextLine().trim().replaceAll("[\\s]{2,}", " ");
			if (text.length() < minLength || text.length() > maxLength)
				System.err.println("El texto debe de tener " + (minLength == maxLength ? minLength + " caracteres"
						: "entre " + minLength + " y " + maxLength + " caracteres"));
			else
				return text.toUpperCase();
		} while (true);

	}

	/**
	 * Obtiene un long
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @return long
	 */
	public static long getLong(String enunciado) {
		return getLong(enunciado, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	/**
	 * Obtiene un long en un rango de valores
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @param min       valor minimo
	 * @param max       valor maximo
	 * @return el long dentro de un rango
	 */
	public static long getLong(String enunciado, long min, long max) {
		do {
			Input.showHeader(enunciado);
			try {
				long num = Long.parseLong(scan.nextLine());
				if (num >= min && num <= max)
					return num;
				else
					System.err.println(
							"El numero debe de " + (min == max ? "ser " + min : "estar entre " + min + " y " + max));
			} catch (NumberFormatException e) {
				System.err.println("El valor introducido no es numerico");
			}
		} while (true);
	}

	/**
	 * Obtiene un valor doble
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @return el valor doble
	 */
	public static double getDouble(String enunciado) {
		return getDouble(enunciado, Double.MIN_VALUE, Double.MAX_VALUE);
	}

	/**
	 * Obtiene un valor doble dentro de un rango
	 * 
	 * @param enunciado texto que aparecera en consola
	 * @param min       valor minimo
	 * @param max       valor maximo
	 * @return el valor dentro de un rango
	 */
	public static double getDouble(String enunciado, double min, double max) {
		do {
			Input.showHeader(enunciado);
			try {
				double num = Double.parseDouble(scan.nextLine());
				if (num >= min && num <= max)
					return num;
				else
					System.err.println(
							"El numero debe de " + (min == max ? "ser " + min : "estar entre " + min + " y " + max));
			} catch (NumberFormatException e) {
				System.err.println("El valor introducido no es numerico");
			}
		} while (true);
	}

	/**
	 * Obtiene una matricula usando una expresion regEx
	 * 
	 * @param enunciado cabecera del texto
	 * @return texto con ese formato
	 */
	public static String getMatricula(String enunciado) {
		return getFormat(enunciado, "[0-9]{4}\\-[A-Za-z]{3}");
	}

	/**
	 * Obtiene un texto con un formato especificado
	 * 
	 * @param enunciado texto en pantalla
	 * @param regex     expresion regEx con la que se formara el texto
	 * @return el texto con el regex especificado
	 */
	public static String getFormat(String enunciado, String regex) {
		final Pattern patron = Pattern.compile(regex);
		do {
			String input = Input.getString(enunciado, 1, 256);
			if (patron.matcher(input).matches())
				return input;
			else
				System.err.println("El texto no sigue el patron requerido");
		} while (true);
	}

}
