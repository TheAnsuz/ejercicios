/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.otros;

/**
 *
 * @author marruiad
 */
public class banderas {

    public static void main(String[] args) {
        boolean bucle = true;
        int modo = 0;

        while (bucle) {
            modo++;
            if (modo % 2 == 0) {
                System.out.println("Hola");
            } else {
                System.out.println("Adios");
            }
            
            if (modo > 100) {
                bucle = false;
            }
        }
    }

}
