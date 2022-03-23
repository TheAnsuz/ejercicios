/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Formateador {

	/**
	 * Formatea un texto para que este centrado
	 * 
	 * @param prefix   prefijo
	 * @param text     texto
	 * @param sufix    sufijo
	 * @param longitud longitud objetivo
	 * @param relleno  caracter de relleno
	 * @return el texto formateado
	 */
	public static String textoCentrado(String prefix, String text, String sufix, int longitud, char relleno) {
		String resultado = text;
		boolean before = false;

		while (resultado.length() < longitud) {
			resultado = before ? relleno + resultado : resultado + relleno;
			before = !before;
		}

		return prefix + resultado + sufix;
	}

	/**
	 * Formatea un texto para que este alineado a la izquierda, un poco inutil pero
	 * necesario
	 * 
	 * @param prefix   prefijo
	 * @param text     texto
	 * @param sufix    sufijo
	 * @param longitud longitud objetivo
	 * @param relleno  caracter de relleno
	 * @return el texto formateado
	 */
	public static String textoIzquierda(String prefix, String text, String sufix, int longitud, char relleno) {
		String resultado = text;

		while (resultado.length() < longitud) {
			resultado = relleno + resultado;
		}

		return prefix + resultado + sufix;
	}
}
