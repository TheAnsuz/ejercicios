/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author marruiad
 */
public final class Terminal {

	/**
	 * Referencia a la maquina del parking
	 */
	private final Maquina maquina;

	/**
	 * Construye la terminal con la maquina especificada
	 * 
	 * @param maquina
	 */
	public Terminal(Maquina maquina) {
		this.maquina = maquina;
		showMenu();
	}

	/**
	 * Obtiene la maquina a la que esta ajustada la terminal
	 * 
	 * @return
	 */
	public Maquina getMaquina() {
		return maquina;
	}

	/**
	 * Muestra el menu mas basico, no hay opcion de salir porque no tiene sentido
	 * poder salir de una maquina de parking, no es un sistema operativo
	 */
	public void showMenu() {
		int longitud = Math.max("Estacionar vehiculo".length(),
				Math.max("Sacar vehiculo".length(), maquina.getNombre().length() + 2));
		while (true) {
			System.out
					.println(Formateador.textoCentrado(">>> ", ' ' + maquina.getNombre() + ' ', " <<<", longitud, '-'));
			System.out.println("> 1 " + "Estacionar vehiculo");
			System.out.println("> 2 " + "Sacar vehiculo");
			switch (Input.getInt(">>>>>", 1, 2)) {
			case 1:
				estacionarVehiculo();
				break;
			case 2:
				sacarVehiculo();
			}
		}
	}

	/**
	 * Estaciona un vehiculo
	 */
	private void estacionarVehiculo() {
		// Comprueba que haya espacio
		if (maquina.getPlano().hasLibre())
			System.err.println(">>> No hay espacio");
		else {
			String matricula;
			// Validacion de matricula
			do {
				matricula = Input.getMatricula("Matricula del vehiculo (0000-XXX):");
				if (maquina.hasMatricula(matricula))
					System.err.println("Ya existe un vehiculo con esa matricula en el parking");
			} while (maquina.hasMatricula(matricula));
			// Obtiene el ticket resultado y opera con el
			final Ticket resultado = maquina.getPlano().estacionar(matricula, maquina.getPlano().getLibre());
			System.out.println("Generando ticket...");
			Terminal.pause(500);
			maquina.addTicket(resultado);
			System.out.println(resultado);
			System.out.println();
		}
		mostrarPlano();

	}

	/**
	 * Saca un vehiculo
	 */
	private void sacarVehiculo() {
		int id = 0;
		// Obtiene un id valido
		do {
			id = Input.getInt("Introduce la ID del ticket:", 1,
					maquina.getPlano().getPisos() * maquina.getPlano().getPlazas());
			if (!maquina.hasTicketID(id))
				System.err.println("Ticket no reconocido");

		} while (!maquina.hasTicketID(id));
		// Realizar los calculos con la id del ticket
		final Ticket ticket = maquina.getTicket(id);
		final double coste = maquina.getCoste(ticket);
		System.out.println();
		System.out.println("Total a pagar: " + coste);

		// Aqui es donde el usuario debe de introducir el cambio y toda la pesca
		double importe = 0;
		while (importe < coste) {
			System.out.println();
			final Map<Moneda, Integer> introducido = getDineroIntroducido();
			importe += Moneda.getSum(introducido);
		}
		// Mostrar por consola las monedas usadas bien bonitas
		Terminal.pause(500);
		System.out.println();
		final Map<Moneda, Integer> cambio = maquina.getDeposito().getCambio(importe);
		System.out.println(Formateador.textoCentrado(">>> ", "Cambio", "", 15, ' '));
		System.out.println(">");
		for (Entry<Moneda, Integer> entry : cambio.entrySet()) {
			System.out.println(Moneda.getDisplay(entry.getKey(), entry.getValue()));
		}
		System.out.println(">");
		System.out.println(Formateador.textoCentrado(">>> ", "Total: " + (importe - coste), "", 15, ' '));
		System.out.println();
		System.out.println();
		maquina.removeTicket(ticket);
	}

	/**
	 * Obtiene el dinero introducido en forma de mapa de monedas
	 * 
	 * @return mapa de monedas del dinero introducido
	 */
	private Map<Moneda, Integer> getDineroIntroducido() {
		// Texto conteniendo todos los tipos de moneda, hecho para que en caso de que se
		// añada un tipo de moneda se ajuste automaticamente sin necesidad
		// de que nadie cambie este codigo
		String tipos = "(";
		for (Moneda moneda : Moneda.values()) {
			tipos += moneda.getValue() + ", ";
		}
		tipos += ")  ";
		tipos = tipos.replace(", )", ")  ");
		// Obtiene las monedas en un array asegurandose de que tiene 9 valores numericos
		// separados por espacios, usando regex
		String[] monedas = Input
				.getFormat("Introduce la cantidad de monedas en el orden especificado" + System.lineSeparator() + tipos,
						"(?:\\d+\\s){" + (Moneda.values().length - 1) + "}\\d")
				.split(" ");
		Map<Moneda, Integer> introducido = new HashMap<Moneda, Integer>();
		int index = 0;
		// Añade las monedas al dinero introducido
		for (Moneda moneda : Moneda.values()) {
			introducido.put(moneda, Integer.parseInt(monedas[index++]));
		}
		return introducido;
	}

	/**
	 * Muestra el plano en la terminal
	 */
	public void mostrarPlano() {
		System.out.println(maquina.getPlano().toString());
	}

	/**
	 * Pausa la terminal por un determinado periodo de tiempo
	 * 
	 * @param milis milisegundos de pausa
	 */
	private static void pause(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
