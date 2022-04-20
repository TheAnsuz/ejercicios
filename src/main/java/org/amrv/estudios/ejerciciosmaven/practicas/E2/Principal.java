/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Principal {

	public static Maquina maquina;
	public static Terminal terminal;

	public static void main(String[] args) {
		// Maquina (precio/minuto, nombre, plantas, plazas, deposito inicial)
		maquina = new Maquina(.5d, "Parking Son", 3, 20, 100);
		// La terminal intermediaria entre el usuario y la maquia del parking
		terminal = new Terminal(maquina);
	}
}
