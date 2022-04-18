/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.util.Arrays;

/**
 *
 * @author marruiad
 */
public class Plano {

	// Guarda los ID de los tickets
	private final int[][] parking;

	/**
	 * Crea un plano con la cantidad de pisos y plazas especificados
	 * 
	 * @param pisos         pisos del plano
	 * @param plazasPorPiso plazas del plano
	 */
	public Plano(int pisos, int plazasPorPiso) {
		parking = new int[pisos][plazasPorPiso];
		// Rellenar el array para hacer pruebas
		for (int y = 0; y < parking.length; y++)
			for (int x = 0; x < parking[y].length; x++)
				parking[y][x] = 0;
	}

	/**
	 * Obtiene los pisos del parking
	 * 
	 * @return pisos del parking
	 */
	public int getPisos() {
		return parking.length;
	}

	/**
	 * Obtiene las plazas de cada piso
	 * 
	 * @return plazas de cada piso
	 */
	public int getPlazas() {
		return parking.length > 0 ? parking[0].length : 0;
	}

	/**
	 * Obtiene el ticket guarado en una ubicacion determinada
	 * 
	 * @param ubi la ubicacion
	 * @return el id del ticket de esa plaza, 0 si no hay
	 */
	public int getTicketID(Ubicacion ubi) {
		return parking[ubi.getPlanta() - 1][ubi.getPlaza() - 1];
	}

	/**
	 * Obtiene el ticket guardado en una ubicacion determinada
	 * 
	 * @param planta planta
	 * @param plaza  plaza
	 * @return el id del ticket de esa plaza, 0 si no hay
	 */
	public int getTicketID(int planta, int plaza) {
		return parking[planta - 1][plaza - 1];
	}

	/**
	 * Comprueba si la plaza esta ocupada
	 * 
	 * @param ubi ubicacion
	 * @return true si esta ocupada
	 */
	public boolean isOcupada(Ubicacion ubi) {
		return parking[ubi.getPlanta() - 1][ubi.getPlaza() - 1] > 0;
	}

	/**
	 * Comprueba si la plaza esta ocupada
	 * 
	 * @param planta planta del parking
	 * @param plaza  plaza dentro de la planta
	 * @return true si esta ocupada
	 */
	public boolean isOcupada(int planta, int plaza) {
		return parking[planta - 1][plaza - 1] > 0;
	}

	/**
	 * Fuerza que la plaza sea determinada como libre
	 * 
	 * @param ubi ubicacion
	 */
	public void setLibre(Ubicacion ubi) {
		setLibre(ubi.getPlanta(), ubi.getPlaza());
	}

	/**
	 * Fuerza que la plaza sea determinada como libre
	 * 
	 * @param planta planta del parking
	 * @param plaza  plaza de la planta
	 */
	public void setLibre(int planta, int plaza) {
		parking[planta - 1][plaza - 1] = 0;
	}

	/**
	 * Comprueba la disponibilidad del parking
	 * 
	 * @return true si tiene al menos una plaza libre
	 */
	public boolean hasLibre() {
		return this.getLibre() == null;
	}

	/**
	 * Obtiene la primera plaza libre del parking
	 * 
	 * @return la primera plaza libre del parking o null si no hay
	 */
	public Ubicacion getLibre() {
		for (int y = 1; y <= parking.length; y++)
			for (int x = 1; x <= parking[y - 1].length; x++) {
//                System.out.println((y-1)+"y " + (x-1) +"x " + parking[y-1][x-1] + " - " + this.isOcupada(y, x));
				if (!this.isOcupada(y, x))
					return new Ubicacion(y, x);
			}
		return null;
	}

	/**
	 * Genera un ticket estacionando un vehiculo en una plaza determinada del
	 * parking
	 * 
	 * @param matricula la matricula del vehiculo estacionado
	 * @param planta    la planta
	 * @param plaza     la plaza
	 * @return el ticket de aparcamiento
	 */
	public Ticket estacionar(String matricula, int planta, int plaza) {
		return estacionar(matricula, new Ubicacion(planta, plaza));
	}

	/**
	 * Genera un ticket estacionando un vehiculo en una plaza determinada del
	 * parking
	 * 
	 * @param matricula la matricula del vehiculo estacionado
	 * @param ubicacion la ubicacion
	 * @return el ticket de aparcamiento
	 */
	public Ticket estacionar(String matricula, Ubicacion ubicacion) {
		final Ticket ticket = new Ticket(matricula, ubicacion);
		parking[ubicacion.getPlanta() - 1][ubicacion.getPlaza() - 1] = ticket.getId();
		return ticket;
	}

	@Override
	public String toString() {

		String temp = "";
		for (int y = 0; y < parking.length; y++) {
			temp += Arrays.toString(parking[y]) + ',' + System.lineSeparator();
		}
		return temp;
	}

}
