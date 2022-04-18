/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t4;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class EjercicioCadenas {

    /*
        Programa que pida por pantalla dos cadenas y muestre las veces que se 
        muestra la segunda cadena en la primera junto a su posicion
    
        ej:
        cadena 1: "Desarrollo de aplicaciones multiplataforma"
        cadena 2: "o"
        
        > 4 veces en posiciones 6, 9, 15, 23
     */
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String texto = ""; // variable para guardar el texto en el que se busca
        String encontrar = ""; // variable para guardar la cadena a buscar
        int ocurrencias = 0; // las veces que se encuentra
        int indexAnterior = 0; // la posicion de la ultima vez que se encontró
        String posicionOcurrencias = " "; // cadena conteniendo de manera formateada las posiciones en las que se encontro

        // Introducir las cadenas de texto
        System.out.println("Introduce la frase en la que se van a buscar los caracteres");
        texto = scan.nextLine();
        System.out.println("Introduce la cadena que se tiene que buscar en el texto");
        encontrar = scan.nextLine();

        // Buscar la cadena dentro del primer texto
        while (texto.contains(encontrar)) {
            int index = texto.indexOf(encontrar);
            indexAnterior += index+1;
            ocurrencias++;
            posicionOcurrencias += indexAnterior + " ";
            texto = texto.substring(index + 1);
        }

        // Mostrar el resultado del programa
        if (ocurrencias > 0) {
            System.out.println("Se ha encontrado la cadena \"" + encontrar + "\" " + ocurrencias + " veces");
            System.out.println("en las posiciones" + posicionOcurrencias);
        } else
            System.out.println("No hay instancias de la cadena \"" + encontrar + "\" :/");
    }
}
