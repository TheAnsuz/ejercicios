/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio3;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author marruiad
 */
public class Revista extends Libro {

    private final int volumen;
    private final int numero;
    private final Month mes;

    public Revista(int volumen, int numero, LocalDate mes, String titulo, String autores, String editorial, LocalDate publicacion) {
        super(titulo, autores, editorial, publicacion);
        this.volumen = volumen;
        this.numero = numero;
        this.mes = mes.getMonth();
    }

    public Revista(int volumen, int numero, Month mes, String titulo, String autores, String editorial, LocalDate publicacion) {
        super(titulo, autores, editorial, publicacion);
        this.volumen = volumen;
        this.numero = numero;
        this.mes = mes;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getNumero() {
        return numero;
    }

    public Month getMes() {
        return mes;
    }

}
