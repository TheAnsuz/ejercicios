/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.pruebas;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class NombreInverso {
    
    private final static Scanner scan =  new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Introduce tu nombre y apellidos:");
        String nombre = scan.nextLine();
        
        String inverso = "";
        for (int i = nombre.length(); i > 0 ; i--)
            inverso = inverso + Character.toLowerCase(nombre.charAt(i-1));
        
        System.out.println(inverso);
    }
}
