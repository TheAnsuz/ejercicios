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
public class Consulta {

    private final int documento;
    private final LocalDate fecha;
    private final String dni;

    public Consulta(int documento, LocalDate fecha, String dni) {
        this.documento = documento;
        this.fecha = fecha;
        this.dni = dni;
    }

    public int getDocumento() {
        return documento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDni() {
        return dni;
    }

}
