/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Maquina {

    private double precioPorMinuto;
    private String nombre;
    private final Plano plano;

    public Maquina(double precioPorMinuto, String nombre, int plantas, int plazas) {
        this.precioPorMinuto = precioPorMinuto;
        this.nombre = nombre;
        this.plano = new Plano(plantas, plazas);
    }

    public double getPrecioPorMinuto() {
        return precioPorMinuto;
    }

    public void setPrecioPorMinuto(double precioPorMinuto) {
        this.precioPorMinuto = precioPorMinuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Plano getPlano() {
        return plano;
    }

}
