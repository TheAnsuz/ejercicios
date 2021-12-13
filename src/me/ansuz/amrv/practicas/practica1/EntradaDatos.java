/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.practica1;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class EntradaDatos {

    private static final Scanner scan = new Scanner(System.in);

    /**
     * Obtiene un texto formateado valido para su uso.
     *
     * @return el texto formateado.
     * @param enunciado el texto que mostrará la consola para solicitad los
     * datos.
     */
    public static String getTexto(String enunciado) {
        return getTexto(enunciado, 1);
    }

    /**
     * Obtiene un texto formateado dado el enunciado y la longitu minima que
     * debe de tener la cadena de texto
     *
     * @param enunciado lo que se mostrara en la consola para pedir el texto
     * @param caracteres la longitud minima obligatoria que debe de tener la
     * cadena
     * @return el texto obtenido ya validado
     */
    public static String getTexto(String enunciado, int caracteres) {
        String texto = "";
        boolean valido = true;
        do {
            valido = true;
            System.out.println(enunciado);
            texto = scan.nextLine().trim();
            if (texto.length() < caracteres) {
                System.out.println("Debes introducir una cadena de texto de al menos " + caracteres
                        + ((caracteres == 1) ? " letra" : " letras"));
                valido = false;
            }

            // Comprobar que todos las letras son alfanumericas
            for (int c = 0; c < texto.length(); c++) {

                if (!Character.isLetterOrDigit(texto.charAt(c)) && !Character.isWhitespace(texto.charAt(c))) {
                    valido = false;
                    System.out.println("El texto no puede contener caracteres especiales");
                    break;

                }

            }

        } while (!valido);
        return texto;
    }

    /**
     * Obtiene un valor booleano dado el enunciado, el valor booleano esta
     * formateado para que permita valores como si, no, S, N, true o false
     *
     * @param enunciado el texto que se mostrara antes de introducir la
     * respuesta
     * @return true si el usuario introduce un valor valido para ser considerado
     * positivo, falso si no
     */
    public static boolean getBoolean(String enunciado) {
        String texto = "";
        do {
            System.out.println(enunciado);
            texto = scan.nextLine().replaceAll("\\s", "").toLowerCase();
            switch (texto) {
                case "s":
                case "si":
                case "true":
                    return true;
                case "n":
                case "no":
                case "false":
                    return false;
                default:
                    System.out.println("Por favor responde con si o no");
                    break;
            }
        } while (true);
    }

    /**
     * Obtiene un numero introducido por el usuario dando el enunciado y la
     * longitud que debe de tener ese numero, minima y maxima
     *
     * @param enunciado el texto que se mostrara en la peticion del numero
     * @param minBytes longitud en bytes minima
     * @param maxBytes longitud en bytes maxima
     * @return el numero formateado
     */
    public static int getNumber(String enunciado, int minBytes, int maxBytes) {
        boolean valido = false;
        String entrada = "";
        int numero = 0;
        do {
            System.out.println(enunciado);
            entrada = scan.nextLine();
            if (entrada.length() < minBytes || entrada.length() > maxBytes) {

                if (minBytes != maxBytes)
                    System.out.println(
                            "El valor introducido debe tener entre " + minBytes + " y " + maxBytes + " digitos");
                else
                    System.out.println("El valor valor debe tener " + minBytes + " digitos");

            } else {
                try {
                    numero = Integer.parseInt(entrada);
                    if (numero > 0)
                        valido = true;
                    else
                        System.out.println("El numero no puede ser un numero negativo");
                } catch (Exception e) {
                    System.out.println("El valor introducido debe de ser numerico");
                }
            }
        } while (!valido);

        return numero;
    }

    /**
     * Obtiene una fecha introucida por el usuario, dando el enunciado y la
     * fecha maxima que puede ser dada
     *
     * @param enunciado el texto que se mostrara junto a la peticion de la fecha
     * @param max el limite como fecha maxima aceptada
     * @return la fecha valida introducida por el usuario
     */
    public static GregorianCalendar getDate(String enunciado, GregorianCalendar max) {
        boolean valido = false;
        GregorianCalendar date = new GregorianCalendar();
        date.setLenient(false);
        do {
            try {
                // dia/mes/año
                System.out.println(enunciado);
                String[] datos = scan.nextLine().split("/");
                date.setLenient(false);
                date.set(GregorianCalendar.YEAR, Integer.parseInt(datos[2]));
                date.set(GregorianCalendar.MONTH, Integer.parseInt(datos[1])-1);
                date.set(GregorianCalendar.DATE, Integer.parseInt(datos[0]));
                System.out.println(date.getTime());
                if (date.compareTo(max) < 0)
                    valido = true;
                else
                    System.out.println("La fecha de nacimiento debe de ser anterior a la fecha actual");
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("La fecha introducida no es valida");
            }

        } while (!valido);

        return date;
    }
    
    public static void main(String[] args) {
        GregorianCalendar cal = getDate("DAME TU PUTA FECHA", new GregorianCalendar());
        System.out.println(cal.getTime());
    }

}
