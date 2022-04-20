package org.amrv.estudios.ejerciciosmaven.bucles;


import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class DiagonalCuadrado {

    /**
     * Dibujar la diagonal (principal \ o secundaria / de un cuadrado)
     */
    // Crear el escaner para obtener los datos
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Declaracion de variables
        int size = 0;
        char tipo = '\0';
        char caracter = '\0';
        // Mostrar informacion de para que sirve el programa
        System.out.println("Programa para mostrar la diagonal de un cuadrado, "
                + "recomendable usar valores mayores a 4 por que sino no se va a ver la diagonal");

        // Bucle para pedir el tamaño del cuadrado
        do {
            System.out.print("Introduce el tamaño del cuadrado ");
            size = scan.nextInt();

            if (size <= 0)
                System.out.println("El tamaño del cuadrado debe ser mayor de 0");
        } while (size <= 0);

        // Saltar de linea:
        // Al usar Scanner::nextInt luego hay que usar un Scanner::nextLine antes de pedir una cadena de texto debido a que
        // sino lo saltará por motivos muy aburridos para explicar
        scan.nextLine();

        // Bucle para pedir el tipo de diagonal
        do {
            System.out.print("Introduce el tipo de diagonal (\\ o /): ");
            tipo = scan.nextLine().charAt(0);

            if (tipo != '\\' && tipo != '/')
                System.out.println("No has introducido un caracter valido");
        } while (tipo != '\\' && tipo != '/');

        // Bucle para pedir el caracter para imprimir la diagonal
        System.out.print("Introduce el caracter para hacer la diagonal ");
        caracter = scan.nextLine().charAt(0);

        // Coordenada Y en pantalla
        for (int y = 0; y < size; y++) {
            System.out.println();

            // Ejecuta este bucle si el tipo de diagonal es /
            if (tipo == '/')
                for (int s = 0; s < size - 1 - y; s++)
                    System.out.print("  ");
            // Ejecuta este otro si el tipo de diagonal no es /, es decir, es \
            else
                for (int s = 0; s < y; s++)
                    System.out.print("  ");

            // Coordenada X en pantalla
            for (int x = 0; x < size; x++) {
                if (x == y)
                    System.out.print(caracter + " ");
            }
        }
        System.out.println();
    }
}
