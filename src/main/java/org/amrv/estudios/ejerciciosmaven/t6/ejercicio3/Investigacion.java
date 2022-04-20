/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6.ejercicio3;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author marruiad
 */
public class Investigacion extends Revista {

    private final int microfilm;

    public Investigacion(int microfilm, int volumen, int numero, LocalDate mes, String titulo, String autores, String editorial, LocalDate publicacion) {
        super(volumen, numero, mes, titulo, autores, editorial, publicacion);
        this.microfilm = microfilm;
    }

    public Investigacion(int microfilm, int volumen, int numero, Month mes, String titulo, String autores, String editorial, LocalDate publicacion) {
        super(volumen, numero, mes, titulo, autores, editorial, publicacion);
        this.microfilm = microfilm;
    }

    public int getMicrofilm() {
        return microfilm;
    }

}
