/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t6.ejercicio3;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Documentos extends Libro {

    private final String licencia;

    public Documentos(String licencia, String titulo, String autores, String editorial, LocalDate publicacion) {
        super(titulo, autores, editorial, publicacion);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

}
