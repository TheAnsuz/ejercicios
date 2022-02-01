/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5.Ascensor;

import java.util.Calendar;
import java.util.Scanner;
import me.ansuz.amrv.t5.Persona;

/**
 *
 * @author marruiad
 */
public class Principal {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Ascensor ascensor = crearAscensor();
        String operacion = "";
        System.out.println(ascensor.toString());
        System.out.println("Las operaciones pueden ser:\nSubir, Bajar, Abrir, Cerrar, Piso, Vaciar, (Montar, Entrar)");
        do {
            operacion = scan.nextLine();
            operacion = operacion.toLowerCase();

            try {
                switch (operacion) {
                    case "subir":
                    case "ascender":
                        ascensor.setPiso(ascensor.getPiso() + 1);
                        break;
                    case "bajar":
                    case "descender":
                        ascensor.setPiso(ascensor.getPiso() - 1);
                        break;
                    case "abrir":
                        ascensor.abrir();
                        break;
                    case "cerrar":
                        ascensor.cerrar();
                        break;
                    case "vaciar":
                        ascensor.sacarPersonas();
                        break;
                    case "entrar":
                    case "montar":
                        ascensor.meterPersona(new Persona("XXXXXXXX", "Persona", "Sin apellido", 'H', Calendar.getInstance().getTime(), 200, validarFloat("Introduce el peso de la persona:"), false));
                        break;
                    case "mover":
                    case "piso":
                        ascensor.setPiso(validarInteger("Introduce el piso al que moverse"));
                        break;
                    default:
                        System.err.println("La operacion escrita no es valida");
                }
                System.out.println("Subir, Bajar, Abrir, Cerrar, Piso, Vaciar, (Montar, Entrar)");
                System.out.println(ascensor.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (!operacion.equalsIgnoreCase("exit"));

    }

    private static int validarInteger(String enunciado) {
        while (true) {
            try {
                System.out.println(enunciado);
                return Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.err.println("El valor no es un numero");
            }
        }
    }

    private static float validarFloat(String enunciado) {
        while (true) {
            try {
                System.out.println(enunciado);
                return Float.parseFloat(scan.nextLine());
            } catch (Exception e) {
                System.err.println("El valor no es un numero");
            }
        }
    }

    private static Ascensor crearAscensor() {
        int pisos = -1;
        float capacidad = -1f;
        // Validar pisos
        do {
            System.out.println("Introduce el numero de pisos del ascensor");
            try {
                pisos = Integer.parseInt(scan.nextLine());
                if (pisos < 1)
                    System.err.println("El ascensor debe de tener al menos 1 piso");
            } catch (Exception e) {
                System.err.println("El valor introducido no es un numero");
            }
        } while (pisos <= 0);
        // Validar capacidad
        do {
            System.out.println("Introduce la capacidad en kilogramos del ascensor");
            try {
                capacidad = Float.parseFloat(scan.nextLine());
                if (capacidad < 1)
                    System.err.println("El ascensor debe de tener al menos 1 piso");
            } catch (Exception e) {
                System.err.println("El valor introducido no es un numero");
            }
        } while (capacidad <= 0);
        return new Ascensor(pisos, capacidad);
    }
}
