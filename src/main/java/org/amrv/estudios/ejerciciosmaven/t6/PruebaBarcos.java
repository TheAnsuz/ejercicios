/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t6;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class PruebaBarcos {
    
    public static void main(String[] args) {
        Yate yate = new Yate("",60,100,100,LocalDate.now());
        Barco barco = new Yate("",60,100,100,LocalDate.now());
        Alquiler ayate = new Alquiler("","", yate,LocalDate.of(2022,4,15));
        Alquiler abarco = new Alquiler("","", barco,LocalDate.of(2022,4,15));
        System.out.println("Yate = " + ayate.getAlquiler());
        System.out.println("Barco = " + abarco.getAlquiler());
    }
}
