/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio5;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class EFijo extends Empleado {

    private final LocalDate alta;
    private float complemento;

    public EFijo(String nombre, LocalDate alta, float complemento) {
        super(nombre);
        this.alta = alta;
        this.complemento = complemento;
        this.calculo();
    }

    public LocalDate getAlta() {
        return alta;
    }

    public float getComplemento() {
        return complemento;

    }

    public void setComplemento(float complemento) {
        this.complemento = complemento;
        this.calculo();
    }

    private void calculo() {
        final LocalDate actual = LocalDate.now();
        int year = actual.getYear() - alta.getYear();
        super.sueldo = complemento * year;
    }

}
