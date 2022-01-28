/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5;

/**
 *
 * @author marruiad
 */
public class Automovil {

    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private double gasolina;
    private boolean arrancado;
    private int velocidad;
    private int velocidadMaxima;
    private double capacidadMaxima;
    private int maxPersonas;
    private int personas;

    public Automovil(String matricula, int personas, int velocidad, double deposito) {
        this(matricula, "Indefinido", "Indefinido", 130, deposito, velocidad, personas);
    }

    public Automovil(String matricula, String marca, String modelo, int potencia, double deposito, int velocidad, int personas) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.gasolina = deposito;
        this.arrancado = false;
        this.velocidad = 0;
        this.velocidadMaxima = velocidad;
        this.capacidadMaxima = deposito;
        this.personas = 0;
        this.maxPersonas = personas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void arrancar() {
        this.arrancado = true;
    }

    public void parar() {
        this.arrancado = false;
    }
    
    public void acelerar() {
        if (this.gasolina >= .5d) {
        this.velocidad += 10;
        if (this.velocidad > this.velocidadMaxima)
            this.velocidad = this.velocidadMaxima;
        this.gasolina -= .5d;
        }
    }
    
    public void decelerar() {
        this.velocidad -= 10;
        if (this.velocidad < 0)
            this.velocidad = 0;
    }
    
    public void entrar() {
    
    }
    
    public void repostar(double repostado) {
        this.gasolina = (this.gasolina + repostado > this.capacidadMaxima) ? this.capacidadMaxima : this.gasolina + repostado;
    }
    
}
