package org.amrv.estudios.ejerciciosmaven.bucles;


import java.util.Random;

/**
 *
 * @author marruiad
 */
public class Quiniela {

    public static void main(String[] args) {

        Random rng = new Random();
        for (int y = 0; y < 14; y++) {
            System.out.print("Entrada " + (y + 1) + " \t");

            for (int x = 0; x < 10; x++) {
                int val = rng.nextInt(3);
                String resultado = "\t";

                switch (val) {
                    case 0:
                        resultado += " 1 - - ";
                        break;
                    case 1:
                        resultado += " - X - ";
                        break;
                    case 2:
                        resultado += " - - 2 ";
                        break;
                    default:
                        resultado += " - - - ";
                }

                System.out.print(resultado);
            }

            System.out.println();
        }

    }

}
