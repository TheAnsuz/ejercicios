package org.amrv.estudios.ejerciciosmaven.examenes.ev2POO_Avanzado.problema2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Realiza un programa que dada una cadena de caracteres introducida por
 * teclado, cuya longitud es arbitraria, muestre como resultado el carácter que
 * más veces aparece en la cadena y ese nº de veces.
 * <p>
 * Para resolver el problema, utiliza un mapa y un conjunto.
 *
 * @author marruiad
 */
public class Problema2 {

    /**
     * Leer lo que el usuario escribe
     */
    private final static Scanner scan = new Scanner(System.in);

    /**
     * Metodo main
     *
     * @param args argumentos de lanzamiento del programa
     */
    public static void main(String[] args) {
        String texto = "";
        // Asegura que el texto tiene almenos 1 caracter
        do {
            System.out.print("Introduce un texto: ");
            texto = scan.nextLine();
        } while (texto.trim().length() < 1);

        // Obtiene un mapa con cada caracter y sus apariciones
        Map<Character, Integer> resultado = Problema2.textScan(texto);
        // Obtiene el caracter mas repetido como un entry
        Entry<Character, Integer> maximo = Problema2.getMostRepeated(resultado);
        System.out.println(resultado);
        System.out.println("El caracter mas frecuente es el: " + maximo.getKey());
        System.out.println("Aparece: " + maximo.getValue() + " veces");

    }

    private static Map<Character, Integer> textScan(String text) {
        Map<Character, Integer> caracteres = new HashMap<>();
        // Cicla a traves de todos los caracteres una vez se han eliminado los espacios
        for (Character c : text.replace(" ", "").toCharArray()) {
            if (caracteres.containsKey(c)) {
                caracteres.replace(c, caracteres.get(c) + 1);
            } else {
                caracteres.put(c, 1);
            }
        }
        return caracteres;
    }

    private static Entry<Character, Integer> getMostRepeated(Map<Character, Integer> map) {
        Entry<Character, Integer> maximun = null;
        // Obtiene el caracter mas repetido, si maximun es nulo, le da el primer valor
        // que encuentra
        for (Entry<Character, Integer> entrada : map.entrySet()) {
            maximun = maximun == null || maximun.getValue() < entrada.getValue() ? entrada : maximun;
        }
        return maximun;
    }
}
