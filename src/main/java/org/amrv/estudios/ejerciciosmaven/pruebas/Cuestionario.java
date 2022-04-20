package org.amrv.estudios.ejerciciosmaven.pruebas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Cuestionario {
    
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Cuestionario de IQ:");
        String nombre = pregunta("Cual es tu nombre");
        String apellido = pregunta("Cual es tu apellido");
        String edad = pregunta("Cuantos años tienes");
        String inteligencia = pregunta("Te consideras una persona inteligente");
        String padre = pregunta("Como se llama tu padre");
        String madre = pregunta("Como se llama tu madre");
        String nevera = pregunta("A veces cuando abres la nevera no coges nada");
        String llaves = pregunta("Alguna vez te has quedado atrapad@ fuera de casa");
        
        System.out.print("Calculando...");

        System.out.println();
        System.out.println("Conclusion:");
        int rng = new Random().nextInt(5);
        String conc = "";
        switch (rng) {
            case 0:
                conc = "Te falta calle";
                break;
            case 1:
                conc = "Tienes ausencia de pavimento publico";
                break;
            case 2:
                conc = "Eres list@";
                break;
            case 3:
                conc = "Tienes menos cromosomas que me tia abuela Maria";
                break;
            case 4:
                conc = "Te falta pelo pubico";
                break;
        }
        
        System.out.println("    " + conc);
    }
    
    private static String pregunta(String pregunta) {
        System.out.println("¿" + pregunta + "?");
        return scan.nextLine();
    }
}
