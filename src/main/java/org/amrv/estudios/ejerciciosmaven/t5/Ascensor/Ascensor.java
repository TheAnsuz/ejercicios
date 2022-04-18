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
        abierto = true;
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

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        cerrar();

        if (alarma)
            throw new AlarmaException();
        if (piso < 0)
            throw new SinPisoException("El ascensor no puede ir por debajo del suelo de momento");

        if (piso > pisoMaximo)
            throw new SinPisoException("El ascensor no puede volar todavia");

        float tiempo = 750;
        while (piso != this.piso) {
            if (piso < this.piso)
                bajar(tiempo);
            else
                subir(tiempo);
            tiempo = tiempo*.95f;
        }

        System.out.println("El ascensor ha llegado a la planta " + piso);
    }

    private void bajar(float tiempo) {
        System.out.println("Bajando..."+piso);
        pausa(tiempo);
        piso--;
    }

    private void subir(float tiempo) {
        System.out.println("Subiendo..."+piso);
        pausa(tiempo);
        piso++;
    }

    private void pausa(float milis) {
        try {
            Thread.sleep((long) milis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ascensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void meterPersona(Persona persona) {
        if (!abierto)
            throw new ImposibleException("No puede entrar alguien si el ascensor esta cerrado");

        if (alarma)
            throw new AlarmaException("Ni dios puede entrar si la alarma esta activada");

        if (peso > pesoMaximo)
            throw new PesoException("No puede entrar alguien con tanto peso");

        if (peso + persona.getPeso() > pesoMaximo)
            alarma = true;

        peso += persona.getPeso();
    }

    public void sacarPersonas() {
        if (!abierto)
            throw new ImposibleException("No puede salir alguien si el ascensor esta cerrado");

        if (alarma)
            throw new AlarmaException("Ni dios sale si la alarma esta activada");
        this.peso = 0;
    }

    @Override
    public String toString() {
        return "Ascensor{" + "piso=" + piso + ", pisoMaximo=" + pisoMaximo + ", abierto=" + abierto + ", alarma=" + alarma + ", pesoMaximo=" + pesoMaximo + ", peso=" + peso + '}';
    }

}
