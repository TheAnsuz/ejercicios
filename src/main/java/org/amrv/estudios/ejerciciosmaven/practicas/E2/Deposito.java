/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.practicas.E2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 * @author marruiad
 */
public class Deposito {

	// Almacen de monedas
	private final Map<Moneda, Integer> monedas;

	/**
	 * Crea un deposito
	 * 
	 * @param capacidadInicial cantidad inicial de cada moneda
	 */
	public Deposito(int capacidadInicial) {
		monedas = new TreeMap<>();
		for (Moneda tipo : Moneda.values()) {
			monedas.put(tipo, capacidadInicial);
		}
	}

	/**
	 * Agrega una cantidad especifica de una moneda
	 * 
	 * @param moneda   el tipo de moneda
	 * @param cantidad la cantidad a agregar
	 */
	public void add(Moneda moneda, int cantidad) {
		monedas.replace(moneda, monedas.get(moneda) + cantidad);
	}

	/**
	 * Elimina una cantidad especifica de una moneda especifica
	 * 
	 * @param moneda   la moneda a eliminar
	 * @param cantidad la cantidad a eliminar
	 */
	public void remove(Moneda moneda, int cantidad) {
		if (monedas.get(moneda) - cantidad < 0)
			throw new RuntimeException("No hay tantas monedas en el deposito");
		monedas.replace(moneda, monedas.get(moneda) - cantidad);
	}

	/**
	 * Obtiene la cantidad de monedas que hay de un tipo especifico
	 * 
	 * @param moneda el tipo de moneda
	 * @return la cantidad de monedas disponibles
	 */
	public int getAmount(Moneda moneda) {
		return monedas.get(moneda);
	}

	/**
	 * Obtiene el cambio segun el valor numerico de un coste
	 * 
	 * @param devolver el coste numerico
	 * @return mapa de monedas y sus cantidades
	 */
	public Map<Moneda, Integer> getCambio(double devolver) {
		devolver *= 100;
		Map<Moneda, Integer> vuelta = new HashMap<>();
		for (Entry<Moneda, Integer> moneda : monedas.entrySet()) {
			devolver = Math.round(devolver);
			// Ignorar monedas con un valor mayor al que hay que devolver
			if (moneda.getKey().getCentimos() > devolver)
				continue;

			// Cantidad de monedas de este tipo a devolver
			int cociente = (int) Math.floor(devolver / moneda.getKey().getCentimos());

			// Comprobar que hay suficientes monedas en la maquina
			if (cociente > moneda.getValue())
				cociente = moneda.getValue();

			// Resultados
			monedas.replace(moneda.getKey(), moneda.getValue() - cociente);
			vuelta.put(moneda.getKey(), cociente);

			// Nuevo resto para continuar el calculo
			devolver -= cociente * moneda.getKey().getCentimos();

		}
		// Sin control sobre el rellenado del deposito esto es lo unico que se puede
		// hacer
		if (devolver > 0)
			throw new RuntimeException(
					"No hay suficentes monedas en la maquina para dar el cambio, Avisar al servicio tecnico!");

		return vuelta;
	}

}
