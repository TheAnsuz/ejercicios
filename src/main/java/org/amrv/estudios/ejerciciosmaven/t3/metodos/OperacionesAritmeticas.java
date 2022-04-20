package org.amrv.estudios.ejerciciosmaven.t3.metodos;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class OperacionesAritmeticas {

    /*
        Escribe un programa llamado OperacionesAritmeticas que genere dos números enteros
        aleatorios A y B entre 0 y 10 (ambos inclusive) y muestre las 5 operaciones aritméticas básicas
        +, -, *, / y % que pueden hacerse entre ellos en el sentido A op B. Utiliza para generar los
        números aleatorios el método random() de la clase Math.
    
        Metodo para validar la opcion del menu
        Trabajar con las opciones del menu como char
     */
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        double a = obtenerNumero("Introduce el primer numero: ", 0, 10);
        double b = obtenerNumero("Introduce el segundo numero: ", 0, 10);;
        char operacion = obtenerOperacion("Introduce la operacion que desea realizar (+,-,*,/,%): ");
        switch (operacion) {
            case '+':
                System.out.println("Suma: " + (a + b));
                break;
            case '-':
                System.out.println("Resta: " + (a - b));
                break;
            case '*':
                System.out.println("Multiplicacion: " + (a * b));
                break;
            case '/':
                System.out.println("Division: " + (a / b));
                break;
            case '%':
                System.out.println("Resto: " + (a % b));
                break;
            default:
                System.out.println("La operacion no ha salido bien");
                break;
        }
    }

    public static double obtenerNumero(String texto, double min, double max) {
        Double num;
        do {
            System.out.print(texto);
            num = scan.nextDouble();

            if (num < min || num > max) {
                System.err.println("El valor introducido no es valido");
            }

        } while (num == null || num < min || num > max);
        scan.nextLine(); // arreglar el fallo de linea con valores numericos
        return num;
    }

    public static char obtenerOperacion(String texto) {
        char resultado = '\0';
        boolean valido = false;
        do {
            System.out.print(texto);
            String linea = scan.nextLine();

            if (validarChar(linea)) {
                valido = true;
                resultado = linea.charAt(0);
            } else
                System.err.println("El valor introducido no es valido");

        } while (!valido);
        return resultado;
    }

    public static boolean validarChar(String text) {
        if (text.length() != 1)
            return false;
        char c = text.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

}
