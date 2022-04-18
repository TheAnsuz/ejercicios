/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author marruiad
 */
public class Ticket {

	/**
	 * Identificador privado
	 */
	private static int STATIC_ID = 0;
	/**
	 * Formateador de LocalDateTime
	 */
	private final static DateTimeFormatter fechas = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	/**
	 * Obtiene la proxima id
	 * 
	 * @return
	 */
	private static int getID() {
		return ++STATIC_ID;
	}

	/**
	 * La id del ticket
	 */
	private final int id;
	/**
	 * La fecha de creacion del ticket
	 */
	private final LocalDateTime fechaHora;
	/**
	 * La matricula almacenada en el ticket
	 */
	private final String matricula;
	/**
	 * La ubicacion del vehiculo en el parking
	 */
	private final Ubicacion ubicacion;

	/**
	 * Crea un ticket para el vehiculo determinado con su matricula y ubicacion
	 * 
	 * @param matricula matricula del vehiculo
	 * @param ubicacion ubicacion del vehiculo
	 */
	public Ticket(String matricula, Ubicacion ubicacion) {
		this.id = Ticket.getID();
		this.matricula = matricula;
		this.ubicacion = ubicacion;
		this.fechaHora = LocalDateTime.now();
	}

	/**
	 * Obtiene la id del ticket
	 * 
	 * @return id del ticket
	 */
	public int getId() {
		return id;
	}

	/**
	 * Obtiene la matricula del ticket
	 * 
	 * @return matricula del ticket
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Obtiene la ubicacion del ticket
	 * 
	 * @return ubicacion del ticket
	 */
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	/**
	 * Obtiene la fecha y hora del ticket
	 * 
	 * @return fecha y hora del ticket
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	@Override
	public String toString() {
		return "Ticket{" + "id=" + id + ", fechaHora=" + fechaHora.format(fechas) + ", matricula=" + matricula
				+ ", ubicacion=" + ubicacion + '}';
	}

}
