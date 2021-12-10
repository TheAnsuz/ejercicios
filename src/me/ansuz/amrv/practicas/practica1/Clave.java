/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.practica1;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author marruiad
 */
public class Clave {

    public static void main(String[] args) {
        
        for (int i = 0; i < 255; i++) {
            System.out.println(i + " -> " + (char) i);
        }
        
        int size = 8;
        String mecanica = generarMecanica(size);
        System.out.println(">> Mecanica...." + mecanica + " >> " + Operador.contieneSimbolos(mecanica));
        System.out.println(">> SecureRnd..." + generarSecureRandom(size));
        final Date date = new Date();
        System.out.println(date);
        System.out.println(">> Ideal......." + generarIdeal(size,"adrian","MARTIN",12345678,date));
        
    }

    // Cadena de texto con los caracteres en minuscula de la clave mecanica
    public static String tabla = "abcdefghijklmnopqrstuvwxyz0123456789";
    // Cadena de texto con los caracteres mayusculos/alternativos de la clave mecanica
    public static String tablaAlternativa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ=|@#$€&/()";
    // Cadena de texto con los caracteres especiales de los numeros
    public static String caracteresEspeciales = "=!@#$%&/()";
    

    /**
     * Obtiene una clave mecanica aleatoria dado el tamaño en caracteres de la
     * misma.
     *
     * @param size tamaño que va a tener la contraseña generada
     * @return una clave segura con el procedimiento mecanico
     */
    public static String generarMecanica(int size) {
        Random rnd = new Random(); // Generador random
        String clave = ""; // Clave vacia ya declarada
        for (int i = 0; i < size; i++) {
            int fila = rnd.nextInt(6) + 1;
            int columna = rnd.nextInt(6) + 1;
            // Obtiene el valor de la variabla "tabla" convirtiendo la x e y en una posicion lineal
            int letra = (6 * (fila - 1) + columna) - 1;
            // Tira la moneda y segun devuelva true o false coge el valor de una tabla u otra
            clave += (rnd.nextBoolean()) ? tabla.charAt(letra) : tablaAlternativa.charAt(letra);
        }
        return clave;
    }
    
    public static String generarSecureRandom(int size) {
        SecureRandom rnd = new SecureRandom();
        String clave = "";
        for (int i = 0; i < size; i++) {
            boolean tipo = rnd.nextBoolean();
            int posicion = rnd.nextInt( (tipo) ? tabla.length()-1 : tablaAlternativa.length()-1 );
            clave += (tipo) ? tabla.charAt(posicion) : tablaAlternativa.charAt(posicion);
        }
        return clave;
    }
    
    public static String generarIdeal(int size, String nombre, String apellido, int dni,Date nacimiento) {
        DateFormat fecha = DateFormat.getDateInstance(DateFormat.YEAR_FIELD);
        String clave = "";
        clave += nombre.toUpperCase().charAt(0);
        clave += apellido.toLowerCase().charAt(apellido.length()-1);
        
        String claveTemporalDni = Integer.toString(dni);
        clave += claveTemporalDni.substring(claveTemporalDni.length()-2);
        clave += Operador.generarLetraDni(dni);
        
        String fechaTemporal = fecha.format(nacimiento);
        clave += fechaTemporal.substring(fechaTemporal.length()-2);
        
        Random rnd = new Random();
        clave += caracteresEspeciales.charAt(rnd.nextInt(caracteresEspeciales.length()));
        
        return clave.substring(0, size);
    }
    
    public static int obtenerNivelSeguridad(String password) {
        if (password.length() <= 6)
            return 1;
        else
            if (Operador.contieneMayusculas(password) &&
                    Operador.contieneMinusculas(password) &&
                    Operador)
    }

}
