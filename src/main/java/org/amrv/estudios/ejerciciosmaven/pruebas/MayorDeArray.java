package org.amrv.estudios.ejerciciosmaven.pruebas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class MayorDeArray {

    public static List<Integer> array = new ArrayList<Integer>();
    public static Map<Integer, Integer> moda = new HashMap<Integer, Integer>();
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce los valores a comparar separados por comas (1,4,6,2,3)");
        input();
        if (array.isEmpty()) {
            System.out.println("No hay numeros a comparar");
            System.exit(0);
        }
        int mayor = array.get(0);
        int menor = array.get(0);
        int media = 0;
        for (int i : array) {
            if (moda.isEmpty() || !moda.containsKey(i)) {
                moda.put(i, 1);
            } else {
                moda.put(i, moda.get(i) + 1);
            }
            media += i;
            if (i > mayor) {
                mayor = i;
            }
            if (i < menor) {
                menor = i;
            }
        }
        media = media / array.size();
        System.out.println();
        System.out.println("El numero mayor es " + mayor);
        System.out.println("El numero menor es " + menor);
        System.out.println("La media es de " + media);

    }

    public static void input() {

        final String content = scan.nextLine();
        for (String ind : content.replaceAll(" ", "").split(",")) {
            try {
                final int i = Integer.parseInt(ind);
                array.add(i);
            } catch (Exception e) {
                System.err.println("\"" + ind + "\" no es un numero valido, se ha ignorado para la operación");
            }
        }

    }


}
