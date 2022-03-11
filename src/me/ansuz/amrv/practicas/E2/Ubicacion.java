/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Ubicacion {

    private final int planta;
    private final int plaza;

    public Ubicacion(int planta, int plaza) {
        this.planta = planta;
        this.plaza = plaza;
    }

    public int getPlanta() {
        return planta;
    }

    public int getPlaza() {
        return plaza;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "planta=" + planta + ", plaza=" + plaza + '}';
    }

}
