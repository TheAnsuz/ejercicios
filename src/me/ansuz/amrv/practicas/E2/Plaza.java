/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Plaza {
    
    private final String matricula;
    private final LocalDate fecha;

    public Plaza(String matricula, LocalDate fecha) {
        this.matricula = matricula;
        this.fecha = fecha;
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Plaza{" + "matricula=" + matricula + ", fecha=" + fecha + '}';
    }
    
    
}
