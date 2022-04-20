/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t4;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Fecha2 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // bandera para comprobar si los datos introducidos son validos
        boolean valido = false; 
        // dias para introducir
        int dia = 0;
        // meses para introducir
        int mes = 0;
        // años para introducir
        int year = 0;
        // milisegundos actuales (se cambian despues de validar la fecha introducida)
        long ms = 0;
        // el resto en dias entre la fecha introducida y la actual
        long dias = 0;
        // el calendario con los datos del programa
        GregorianCalendar calendario = new GregorianCalendar();
        calendario.setLenient(false);

        // Bucle para obtener los datos
        do {
            System.out.println("Introduce la fecha inicial (dd/mm/yyyy)");
            String[] datos = scan.nextLine().split("/");
            try {
                dia = Integer.parseInt(datos[0]);
                mes = Integer.parseInt(datos[1]);
                year = Integer.parseInt(datos[2]);
                calendario.set(year, mes-1, dia);
                System.out.println("Has establecido la fecha: " + calendario.getTime());
                valido = true;
            } catch (Exception e) {
                System.out.println("Los valores no son una fecha valida");
            }
        } while (!valido);
        
        ms = System.currentTimeMillis();
        
        dias = (calendario.getTimeInMillis() - ms) / 1000;
        dias/= 60 * 60 * 24;

        System.out.println( (dias < 0) ? "Han pasado " + (-dias) + " dias" :
                            (dias > 0) ? "Quedan " + (dias+1) + " dias" :
                            "No ha pasado ningun dia" );
    }

}