/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.practica1;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author marruiad
 */
public class Operador {

	// Cadena de texto de los posibles valores que puede tener el dni
	public static String caracteresDni = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Obtiene la letra de DNI dado e valor numerico.
	 *
	 * @param dni valor numerico del DNI
	 * @return letra correspondiente
	 */
	public static char generarLetraDni(int dni) {
		return Character.toUpperCase(caracteresDni.charAt((int) dni % 23));
	}

	/**
	 * Obtiene la fecha a partir del dia, mes y año correspondientes.
	 *
	 * @param dia  el dia de la fecha
	 * @param mes  el mes de la fecha empezando en 1 y acabando en 12
	 * @param year el año de la fecha
	 * @return un objeto Date conteniendo la fecha
	 */
	public static Date generarFecha(int dia, int mes, int year) {
		return new GregorianCalendar(year, mes, dia).getTime();
	}

	/**
	 * Comprueba que el texto introducido cumpla la caracteristica de longitud
	 * minima.
	 *
	 * @param texto  el texto que debe de ser validado
	 * @param minimo la longitud minima requerida para el texto
	 * @return el texto validado en longitud
	 */
	public static String validarTexto(String texto, int minimo) {
		String resultado = texto.replaceAll(" ", "").replaceAll("\t", "");
		if (resultado.length() < minimo) {
			boolean valido = false;
			System.out.println("AVISO: El texto tiene menos de " + minimo + ((minimo == 1) ? " letra" : " letras")
					+ ", es recomendable que introduzcas uno mas largo");
			do {
				String validacion = EntradaDatos.getTexto("Quieres cambiar el texto (Si/No)");
				if (validacion.equalsIgnoreCase("si")) {
					resultado = EntradaDatos.getTexto("Introduce el texto, prueba usando una variante:", 3);
					valido = true;
				} else if (validacion.equalsIgnoreCase("no")) {
					System.out.println("De acuerdo, el programa autorellenará los caracteres que faltan del texto");
					for (int i = resultado.length(); i < 3; i++)
						resultado += texto.charAt(texto.length() - 1);
					valido = true;
				} else {
					System.out.println("Lo siento pero debes responder con Si o No");
				}
			} while (!valido);
		}
		return resultado;
	}

	/**
	 * Comprueba si la cadena de texto introducida contiene simbolos
	 * 
	 * @param texto la cadena de texto a comprobar
	 * @return true si los contiene, falso sino
	 */
	public static boolean contieneSimbolos(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (c > 32 && c < 48)
				return true;
			else if (c > 57 && c < 65)
				return true;
		}
		return false;
	}

	/**
	 * Comprueba si la cadena de texto introducida contiene mayusculas
	 * 
	 * @param texto la cadena de texto a comprobar
	 * @return true si los contiene, falso sino
	 */
	public static boolean contieneMayusculas(String texto) {
		for (int i = 0; i < texto.length(); i++)
			if (Character.isUpperCase(texto.charAt(i)))
				return true;
		return false;
	}

	/**
	 * Comprueba si la cadena de texto introducida contiene minusuculas
	 * 
	 * @param texto la cadena de texto a comprobar
	 * @return true si los contiene, falso sino
	 */
	public static boolean contieneMinusculas(String texto) {
		for (int i = 0; i < texto.length(); i++)
			if (Character.isLowerCase(texto.charAt(i)))
				return true;
		return false;
	}

	/**
	 * Comprueba si la cadena de texto introducida contiene numeros
	 * 
	 * @param texto la cadena de texto a comprobar
	 * @return true si los contiene, falso sino
	 */
	public static boolean contieneNumeros(String texto) {
		for (int i = 0; i < texto.length(); i++)
			if (Character.isDigit(texto.charAt(i)))
				return true;
		return false;
	}

	/**
	 * Convierte un texto sin formato en un texto preparado usar internamente
	 * 
	 * @param texto         el texto crudo
	 * @param minCaracteres la longitud minima que debe de tener el texto
	 *                      normalizado, si la cadena es menor que este numero
	 *                      estirara el ultimo caracter
	 * @return el texto preparado para usar internamente
	 */
	public static String normalizarTexto(String texto, int minCaracteres) {
		String normalizado = texto.replaceAll(" ", "").replaceAll("\t", "");
		while (normalizado.length() < minCaracteres) {
			normalizado += normalizado.charAt(normalizado.length() - 1);
		}
		return normalizado.toLowerCase();
	}

	/**
	 * Convierte la cadena de texto crudo en una cadena de texto preparada para ser
	 * mostrada en pantalla al usuario de una manera mas clara y praprada, entre
	 * otras cosas convierte cada inicial de palabra en su version mayuscula y el
	 * resto en minuscula
	 * 
	 * @param texto el texto crudo
	 * @return el texto formateado
	 */
	public static String formatearTexto(String texto) {
		String formateado = "";
		for (int i = 0; i < texto.length(); i++) {
			if (i == 0 || Character.isWhitespace(texto.charAt(i - 1)))
				formateado += Character.toUpperCase(texto.charAt(i));
			else
				formateado += Character.toLowerCase(texto.charAt(i));
		}
		return formateado;
	}

	/**
	 * Convierte el valor numerico de una clave en un texto representando su nivel
	 * de seguridad
	 * 
	 * @param seguridad el valor numerico de la seguriad de la clave
	 * @return el valor en texto de la seguridad de la clave
	 */
	public static String formatearClave(int seguridad) {
		return (seguridad > 2) ? "Muy segura" : (seguridad < 2) ? "Poco segura" : "Segura";
	}

}
