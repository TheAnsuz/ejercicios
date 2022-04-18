/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio3;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Libro {

    private final String titulo;
    private final String autores;
    private final String editorial;
    private final LocalDate publicacion;

    public Libro(String titulo, String autores, String editorial, LocalDate publicacion) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.publicacion = publicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutores() {
        return autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public LocalDate getPublicacion() {
        return publicacion;
    }

}
