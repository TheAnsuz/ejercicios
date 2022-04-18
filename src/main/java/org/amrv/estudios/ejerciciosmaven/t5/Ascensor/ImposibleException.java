/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5.Ascensor;

/**
 *
 * @author marruiad
 */
public class ImposibleException extends RuntimeException {

    public ImposibleException() {
        super("No se puede realizar la operacion");
    }
    
    public ImposibleException(String message) {
        super(message);
    }
    
}
