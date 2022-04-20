package org.amrv.estudios.ejerciciosmaven.pruebas;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class PruebaSwitch {

    private final static Scanner scan = new Scanner(System.in);

    @SuppressWarnings("Unused")
    public static void main(String[] args) {
        int a = scan.nextInt();

    }

    private static int switchValue(String mode) {
        switch (mode) {
            case "a":
            case "b":
                return 1;
            case "c":
                return 1;
            case "d":
            case "e":
            case "f":
                return 1;
            default:
                return -1;
        }
    }
}
