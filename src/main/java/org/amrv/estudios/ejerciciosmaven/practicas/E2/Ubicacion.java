/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Ubicacion {

	/**
	 * Planta del parking
	 */
    private final int planta;
    /**
     * Plaza del parking
     */
    private final int plaza;

    /**
     * Crea una ubicacion dada una planta y una plaza, estas estan en una base 1
     * @param planta planta del parking
     * @param plaza plaza del parking
     */
    public Ubicacion(int planta, int plaza) {
        this.planta = planta;
        this.plaza = plaza;
    }

    /**
     * Obtiene la planta de la ubicacion
     * @return planta de la ubicacion
     */
    public int getPlanta() {
        return planta;
    }

    /**
     * Obtiene la plaza de la ubicacion
     * @return plaza de la ubicacion
     */
    public int getPlaza() {
        return plaza;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "planta=" + planta + ", plaza=" + plaza + '}';
    }

}
