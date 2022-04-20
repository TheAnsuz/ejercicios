package org.amrv.estudios.ejerciciosmaven.ejercicios9Noviembre;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class LetrasAlternativas {

    /*
        Escribe un programa que imprima las letras de una frase introducida por 
        teclado de una forma alternativa, es decir, una de la parte inicial y la 
        siguiente de la final hasta recorrer todos los caracteres de la misma.
     */
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Declaracion de variables
        String nombre = "";
        String alternado = "";
        int longitud = 0;

        // Introducir texto y comprobar que no es un texto vacio
        do {
            System.out.println("Escribe la palabra que será alternado");
            nombre = scan.nextLine();

            if (nombre.length() <= 0) {
                System.out.println("La palabra que has introducido no es valida");
            }

        } while (nombre.length() <= 0);

        // Ajustar la longitud para facilitar el uso
        longitud = nombre.length() - 1;

        // Imprmir caracteres
        for (int i = 0; i < nombre.length() / 2; i++) {
            alternado += nombre.charAt(i);
            alternado += nombre.charAt(longitud - i);
        }

        // Arreglo para que si la cadena es impar introduzca el ultimo caracter correctamente
        if (nombre.length() % 2 != 0) {
            alternado += nombre.charAt(longitud / 2);
        }

        System.out.println("El texto alternativo es " + alternado);
    }
}
