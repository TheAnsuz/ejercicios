/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t4;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Fecha3 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // segundos
        long segundos = 0;
        // calendario
        GregorianCalendar tiempo = new GregorianCalendar(); 
        // texto de operacion (al sumar, restar o no hacer nada porque el numero sea 0)
        String operacion = "agregando"; 
        // Formato de la fecha a mostrar en modo LONG y con el languaje español (es_ES)
        DateFormat formato = DateFormat.getDateInstance(DateFormat.LONG, Locale.forLanguageTag("es_ES"));
        
        System.out.print("Por favor introduce los segundos de la fecha: ");
        segundos = scan.nextLong();

        // cambiar lo que muestra la operacion, simplemente para que quede mejor
        operacion = (segundos > 0) ? "agregando" : (segundos < 0) ? "restando" : "sin modificar";
        
        tiempo.setTimeInMillis(System.currentTimeMillis() + (segundos * 1000) );
        
        System.out.println("El tiempo actual " + operacion + " es " + formato.format(tiempo.getTime()));
    }

}
