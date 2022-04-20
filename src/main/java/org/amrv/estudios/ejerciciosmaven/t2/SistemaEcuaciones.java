package org.amrv.estudios.ejerciciosmaven.t2;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class SistemaEcuaciones {

    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Escribe \"exit\" para cerrar el programa");

        for (;;) {
            System.out.println();
            System.out.println("ax + by = c");
            System.out.println("dx + ey + f");

            double a = numero("A");
            double b = numero("B");
            double c = numero("C");
            double d = numero("D");
            double e = numero("E");
            double f = numero("F");

            System.out.println( a + "x + " + b + "y = " + c );
            System.out.println( d + "x + " + e + "y = " + f );
            
            double x = (c*e - b*f) / (a*e - b*d);
            double y = (a*f - c*d) / (a*e - b*d);
            
            final String message = (Double.isFinite(x)) ? 
                    (Double.isFinite(y)) ? "X = " + x + "\n" + "Y = " + y :
                    "Sin solución\n" : "Sin solución\n";
            System.out.println(message);

            
            
        }

    }

    public static float numero(String v) {
        float valor = 0;
        while (true) {
            System.out.print("Introduce el valor de " + v + ": ");
            final String txt = scan.nextLine().trim();

            if (txt.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            try {
                valor = Float.parseFloat(txt);
                break;
            } catch (Exception e) {
                System.err.println("El valor introducido no es valido");
            }

        }
        return valor;
    }
}
