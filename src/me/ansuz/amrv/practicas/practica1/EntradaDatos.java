/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.practica1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static String getTexto(String enunciado, int caracteres) {
        String texto = "";
        boolean valido = true;
        do {
            valido = true;
            System.out.println(enunciado);
            texto = scan.nextLine().trim();
            if (texto.length() < caracteres) {
                System.out.println("Debes introducir una cadena de texto de al menos " + caracteres + ((caracteres == 1) ? " letra" : " letras"));
                valido = false;
            }

            // Comprobar que todos las letras son alfanumericas
            for (int c = 0; c < texto.length(); c++) {
                
                if (!Character.isAlphabetic(texto.charAt(c))) {
                    if (texto.charAt(c) != 'ñ' && texto.charAt(c) != 'Ñ' && texto.charAt(c) != ' ') {
                    valido = false;
                        System.out.println("El texto no puede contener caracteres especiales");
                    break; 
                    
                    }
                }

            }

        } while (!valido);
        return texto;
    }

    public static boolean getBoolean(String enunciado) {
        String texto = "";
        do {
            System.out.println(enunciado);
            texto = scan.nextLine().replaceAll(" ", "").replaceAll("\t", "").toLowerCase();
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

    public static int getNumber(String enunciado, int minBytes, int maxBytes) {
        boolean valido = false;
        String entrada = "";
        int numero = 0;
        do {
            System.out.println(enunciado);
            entrada = scan.nextLine();
            if (entrada.length() < minBytes || entrada.length() > maxBytes) {

                if (minBytes != maxBytes)
                    System.out.println("El valor introducido debe tener entre " + minBytes + " y " + maxBytes + " digitos");
                else
                    System.out.println("El valor valor debe tener " + minBytes + " digitos");

            } else {
                try {
                    numero = Integer.parseInt(entrada);
                    valido = true;
                } catch (Exception e) {
                    System.out.println("El valor introducido debe de ser numerico");
                }
            }
        } while (!valido);

        return numero;
    }

    public static LocalDate getDate(String enunciado) {
        boolean valido = false;
        LocalDate date = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy");
        do {
            try {
                System.out.println(enunciado);
                date = LocalDate.parse(scan.nextLine(), formato);
                valido = true;
            } catch (Exception e) {
                System.out.println("La fecha introducida no es valida");
            }

        } while (!valido);

        return date;
    }

}
