/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5.Ascensor;

/**
 *
 * @author marruiad
 */
public class PesoException extends RuntimeException {

    public PesoException() {
        super("La capacidad esta al limite");
    }
    
    public PesoException(String message) {
        super(message);
    }
}
