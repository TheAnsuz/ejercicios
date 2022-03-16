/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Principal {
    
    public static Maquina maquina;
    public static Terminal terminal;
    
    public static void main(String[] args) {
        maquina = new Maquina(.5d, "Parking Son",3,20);
        terminal = new Terminal(maquina);
    }
}
