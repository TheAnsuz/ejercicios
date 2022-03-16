/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

/**
 *
 * @author marruiad
 */
public class Pruebas {
    
    public static void main(String[] args) {
        System.out.println(Moneda.getDisplay(Moneda.EURO_1, 3));
        System.out.println(Moneda.getDisplay(Moneda.EURO_10, 1));
        System.out.println(Moneda.getDisplay(Moneda.CENTIMO_10, 4));
        System.out.println(Moneda.valueOf(10f));
        Ubicacion u = new Ubicacion(10,10);
        String m = "1234-XAC";
        System.out.println(new Ticket(m,u));
        Plano plano = new Plano(3,20);
        System.out.println(plano.getTicketID(new Ubicacion(3,20)));
    }
}
