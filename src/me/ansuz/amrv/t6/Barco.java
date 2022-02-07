/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Barco {

    private static final float MULTIPLICADOR = 2f;

    private String matricula;
    private final double eslora;
    private final LocalDate fabricado;

    public Barco(String matricula, double eslora, LocalDate fabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.fabricado = fabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public LocalDate getFabricado() {
        return fabricado;
    }

    public double moduloFuncion() {
        return (this.eslora * 10) * MULTIPLICADOR;
    }

}
