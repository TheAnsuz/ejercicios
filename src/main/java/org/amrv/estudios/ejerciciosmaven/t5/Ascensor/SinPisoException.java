/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5.Ascensor;

/**
 *
 * @author marruiad
 */
public class SinPisoException extends RuntimeException {

    public SinPisoException() {
        super("No existe el piso");
    }
    
    public SinPisoException(String message) {
        super(message);
    }
}
