/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.practicas.E2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marruiad
 */
public class Maquina {

	/**
	 * Coste del aparcamiento por minuto
	 */
	private double precioPorMinuto;

	/**
	 * Nombre del parking
	 */
	private String nombre;

	/**
	 * Plano de sitios del parking
	 */
	private final Plano plano;

	/**
	 * Lista con todos los tickets almacenados en esta maquina
	 */
	private final List<Ticket> tickets;

	/**
	 * Deposito de dinero dentro de la maquina
	 */
	private final Deposito deposito;

	/**
	 * Crea una maquina nueva dentro del software
	 * 
	 * @param precioPorMinuto   coste del parking por minuto
	 * @param nombre            nombre del parking
	 * @param plantas           cantidad de plantas
	 * @param plazas            cantidad de plazas por cada planta
	 * @param capacidadDeposito capacidad inicial de monedas
	 */
	public Maquina(double precioPorMinuto, String nombre, int plantas, int plazas, int capacidadDeposito) {
		this.precioPorMinuto = precioPorMinuto;
		this.nombre = nombre;
		this.plano = new Plano(plantas, plazas);
		this.tickets = new ArrayList<>();
		this.deposito = new Deposito(capacidadDeposito);
	}

	/**
	 * Devuelve el precio por minuto
	 * 
	 * @return
	 */
	public double getPrecioPorMinuto() {
		return precioPorMinuto;
	}

	/**
	 * Cambia el precio por minuto
	 * 
	 * @param precioPorMinuto precio por minuto
	 */
	public void setPrecioPorMinuto(double precioPorMinuto) {
		this.precioPorMinuto = precioPorMinuto;
	}

	/**
	 * Obtiene el nombre del parking
	 * 
	 * @return nombre del parking
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre del parking
	 * 
	 * @param nombre nuevo nombre del parking
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el plano del parking
	 * 
	 * @return plano del parking
	 */
	public Plano getPlano() {
		return plano;
	}

	/**
	 * Agrega un ticket a la maquina
	 * 
	 * @param ticket ticket agregado
	 */
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}

	/**
	 * Elimina el ticket especificado de la maquina
	 * 
	 * @param ticket el ticket a eliminar
	 */
	public void removeTicket(Ticket ticket) {
		this.tickets.remove(ticket);
		this.plano.setLibre(ticket.getUbicacion());
	}

	/**
	 * Comprueba si existe la matricula dentro del parking
	 * 
	 * @param matricula a comprobar
	 * @return true si existe, false si no
	 */
	public boolean hasMatricula(String matricula) {
		return getTicket(matricula) != null;
	}

	/**
	 * Obtiene un ticket buscando su matricula
	 * 
	 * @param matricula a buscar
	 * @return el Ticket si se encuentra, null si no se encuentra
	 */
	public Ticket getTicket(String matricula) {
		for (Ticket ticket : tickets) {
			if (ticket.getMatricula().equals(matricula))
				return ticket;
		}
		return null;
	}

	/**
	 * Obtiene un ticket segun la id
	 * 
	 * @param id del ticket
	 * @return el Ticket si se encuentra, null si no se encuentra
	 */
	public Ticket getTicket(int id) {
		for (Ticket ticket : tickets) {
			if (ticket.getId() == id)
				return ticket;
		}
		return null;
	}

	/**
	 * Comprueba si una ID existe en el parking
	 * 
	 * @param id a buscar
	 * @return true si se encuentra, false si no
	 */
	public boolean hasTicketID(int id) {
		return getTicket(id) != null;
	}

	/**
	 * Obtiene el coste de aparcar de un ticket especifico en el momento actual
	 * 
	 * @param ticket a calcular
	 * @return el coste de haber aparcado
	 */
	public double getCoste(Ticket ticket) {
		final long segundos = ChronoUnit.SECONDS.between(LocalDateTime.now(), ticket.getFechaHora());
		return this.getPrecioPorMinuto() * (segundos % 60 + segundos / (segundos % 60) == 0 ? 0 : 1);
	}

	/**
	 * Obtiene el deposito de la maquina virtualmente
	 * 
	 * @return el deposito
	 */
	public Deposito getDeposito() {
		return deposito;
	}

}
