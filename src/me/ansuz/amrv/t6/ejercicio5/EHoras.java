/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6.ejercicio5;

/**
 *
 * @author marruiad
 */
public class EHoras extends Empleado {

    private final float precioHora;
    private int horas;

    public EHoras(String nombre, float salarioHora) {
        super(nombre);
        this.precioHora = salarioHora;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
        this.calculo();
    }

    public float getPrecioHora() {
        return precioHora;
    }

    private void calculo() {
        super.sueldo = precioHora * horas;
    }
}
