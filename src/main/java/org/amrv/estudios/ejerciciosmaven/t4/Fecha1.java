/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t4;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Fecha1 {
    
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int dia = 0; // dia de nacimiento
        int mes = 0; // mes de nacimiento
        int year = 0; // año de nacimiento
        boolean bisiesto = false; // comprobacion de si el año es bisiesto
        int dias_max = 31; // dias maximos aceptados
        GregorianCalendar calendario = null; // objeto calendario
        SimpleDateFormat fcorto = new SimpleDateFormat("d/M/yy");
        SimpleDateFormat flargo = new SimpleDateFormat("EEEE d MMMM yyyy");
        
        // Primero se introduce el año y se comprueba si es bisiesto o que es
        do {
            System.out.print("Introduce tu año de nacimiento: ");
            year = scan.nextInt();
            
            if (year < 1900 || year > 2021) {
                System.out.println("Estoy muy seguro que no naciste en ese año, vuelve a introducirlo");
            }
            
        } while (year < 1900 || year > 2021);
        
        // Comprobacion si el año es bisiesto
        bisiesto = (year % 4 != 0) ? false : 
                   (year % 100 != 0) ? true : 
                   (year % 400 == 0);
        
        // Ahora el mes y se comprueba el numero de dias que tiene
        do {
            System.out.print("Introduce el mes en el que naciste (1-enero, 12-diciembre): ");
            mes = scan.nextInt();
            if (mes < 1 || mes > 12)
                System.out.println("El mes introducido no es valido");
        } while (mes < 1 || mes > 12);
        
        // Se ajusta el maximo numero de dias que puede aceptar para la fecha
        dias_max = (mes == 2) ? 
                   (bisiesto) ? 29 : 28: 
                   (mes % 2 == 0) ? (
                   (mes > 7) ? 31: 30) : (
                   (mes > 7) ? 30: 31);
        
        // Se pide el dia
        do {
            System.out.print("Introduce el dia en el que naciste (max: "+dias_max+"): ");
            dia = scan.nextInt();
            if (dia < 1 || dia > dias_max)
                System.out.println("El dia que has introducido no es valido");
        } while (dia < 1 || dia > dias_max);
        
        // Se crea el calendario gregoriano con los datos
        calendario = new GregorianCalendar(year,mes-1,dia);
        
        System.out.println(fcorto.format(calendario.getTime()));
        System.out.println(flargo.format(calendario.getTime()));
    }
    
}
