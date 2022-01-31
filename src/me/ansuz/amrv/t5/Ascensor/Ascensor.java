/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5.Ascensor;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.ansuz.amrv.t5.Persona;

/**
 *
 * @author marruiad
 */
public class Ascensor {
    
    private int piso;
    private final int pisoMaximo;
    private boolean abierto;
    private boolean alarma;
    private float pesoMaximo;
    private float peso;
    
    public Ascensor(int pisos, float capacidad) {
        piso = 0;
        pisoMaximo = pisos;
        abierto = false;
        alarma = false;
        pesoMaximo = capacidad;
        peso = 0;
    }
    
    public boolean isAbierto() {
        return abierto;
    }
    
    public boolean isAlarmado() {
        return alarma;
    }
    
    public void abrir() {
        abierto = true;
    }
    
    public void cerrar() {
        abierto = false;
    }
    
    public void setPiso(int piso) {
        if (alarma)
            throw new AlarmaException();
        if (piso < 0)
            throw new SinPisoException("El ascensor no puede ir por debajo del suelo de momento");
        
        if (piso > pisoMaximo)
            throw new SinPisoException("El ascensor no puede volar todavia");
        
        System.out.println(this.piso > piso ? "Bajando..." : "Subiendo...");
        try {
            Thread.sleep(250*Math.abs(this.piso - piso));
        } catch (InterruptedException ex) {
            Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.piso = piso;
        System.out.println("Tin, el ascensor ha llegado");
    }
    
    public void meterPersona(Persona persona) {
        if (alarma)
            throw new AlarmaException("Ni dios puede entrar si la alarma esta activada");
        
        if (peso > pesoMaximo)
            throw new PesoException("No puede entrar alguien con tanto peso");
        
        if (peso + persona.getPeso() > pesoMaximo)
            alarma = true;
        
       peso += persona.getPeso();
    }
    
    public void sacarPersona(Persona persona) {
        
    }
}
