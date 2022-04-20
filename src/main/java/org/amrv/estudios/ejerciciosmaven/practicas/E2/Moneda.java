/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.practicas.E2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author marruiad
 */
public enum Moneda {

	EURO_20(20f, "veinte euros", 2),
	EURO_10(10f, "diez euros", 2),
	EURO_5(5f, "cinco euros", 2),
	EURO_2(2f, "dos euros", 1),
	EURO_1(1f, "un euro", 1),
	CENTIMO_50(.5f, "cincuenta centimos", 0),
	CENTIMO_20(.2f, "veinte centimos", 0),
	CENTIMO_10(.1f, "diez centimos", 0),
	CENTIMO_5(.05f, "cinco centimos", 0),

	;

	/**
	 * Un formateador para hacer que se vean mas bonitas las monedas
	 */
	private static final NumberFormat formateador = new DecimalFormat("0.00");

	/**
	 * Obtiene el valor de la moneda en centimos
	 * 
	 * @return el valor en centimos
	 */
	public int getCentimos() {
		return Math.round(VALUE * 100);
	}

	/**
	 * Comprueba si la moneda es tipo de centimo
	 * 
	 * @return true si es un centimo, false si no
	 */
	public boolean isCentimo() {
		return tipo == 0;
	}

	/**
	 * Comprueba si la moneda es un tipo de billete
	 * 
	 * @return true si es un billete, false si no
	 */
	public boolean isBillete() {
		return tipo == 2;
	}

	/**
	 * Obtiene el valor de la moneda formateado con dos decimales
	 * 
	 * @return el valor formateado 0.00
	 */
	public String getValue() {
		return formateador.format(this.VALUE).replace(',', '.');
	}

	final float VALUE;
	final String DISPLAY;
	private final int tipo; // 0 centimo, 1 moneda euro, 2 billete

	private Moneda(float value, String texto, int tipo) {
		this.VALUE = value;
		this.DISPLAY = texto;
		this.tipo = tipo;
	}

	/**
	 * Obtiene la suma de las monedas de un mapa
	 * 
	 * @param monedas mapa con las monedas
	 * @return el valor numerico de las monedas
	 */
	public static double getSum(Map<Moneda, Integer> monedas) {
		float value = 0;
		for (Entry<Moneda, Integer> moneda : monedas.entrySet()) {
			value += Moneda.getSum(moneda.getKey(), moneda.getValue());
		}
		return value;
	}

	/**
	 * Obtiene la suma de una cantidad de una moneda
	 * 
	 * @param moneda el tipo de moneda
	 * @param amount la cantidad de esa moneda
	 * @return el valor de la suma de esas monedas
	 */
	public static double getSum(Moneda moneda, int amount) {
		return moneda.VALUE * amount;
	}

	@Override
	public String toString() {
		return (this.isBillete() ? "billete" : "moneda") + " de " + this.DISPLAY;
	}

	/**
	 * Obtiene un texto formateado con el valor de la moneda
	 * 
	 * @param moneda el tipo de moneda
	 * @param amount la cantidad de la moneda
	 * @return el texto formateado to bonito
	 */
	public static String getDisplay(Moneda moneda, int amount) {
		return amount + " " + (moneda.isBillete() ? "billete" : "moneda") + (amount > 1 || amount < 1 ? "s" : "")
				+ " de " + moneda.DISPLAY;
	}

	/**
	 * Valor de una cantidad de dinero como moneda
	 * 
	 * @param value valor de la moneda
	 * @return moneda con ese valor o null si no existe una moneda con ese valor
	 */
	public static Moneda valueOf(float value) {
		for (Moneda moneda : Moneda.values()) {
			if (moneda.VALUE == value)
				return moneda;
		}
		return null;
	}
}
