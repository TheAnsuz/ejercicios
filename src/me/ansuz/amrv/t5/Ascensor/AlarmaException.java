/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5.Ascensor;

/**
 *
 * @author marruiad
 */
public class AlarmaException extends RuntimeException {

    public AlarmaException() {
        super("El ascensor no puede operar");
    }
    
    public AlarmaException(String message) {
        super(message);
    }
    
}
