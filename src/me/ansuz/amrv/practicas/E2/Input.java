/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author marruiad
 */
public class Input {

    private static final Scanner scan = new Scanner(System.in);

    private static void showHeader(String header) {
        System.out.print(header + (header.endsWith("  ") ? System.lineSeparator() : ' '));
    }

    public static int getInt(String enunciado) {
        return getInt(enunciado, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(String enunciado, int min, int max) {
        do {
            Input.showHeader(enunciado);
            try {
                int num = Integer.parseInt(scan.nextLine());
                if (num >= min && num <= max)
                    return num;
                else
                    System.err.println("El numero debe de "
                            + (min == max ? "ser " + min
                                    : "estar entre " + min + " y " + max));
            } catch (NumberFormatException e) {
                System.err.println("El valor introducido no es numerico");
            }
        } while (true);
    }

    public static float getFloat(String enunciado) {
        return getFloat(enunciado, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public static float getFloat(String enunciado, float min, float max) {
        do {
            Input.showHeader(enunciado);
            try {
                float num = Float.parseFloat(scan.nextLine());
                if (num >= min && num <= max)
                    return num;
                else
                    System.err.println("El numero debe de "
                            + (min == max ? "ser " + min
                                    : "estar entre " + min + " y " + max));
            } catch (NumberFormatException e) {
                System.err.println("El valor introducido no es numerico");
            }
        } while (true);
    }

    public static String getString(String enunciado) {
        return getString(enunciado, 1, Integer.MAX_VALUE);
    }

    public static String getString(String enunciado, int minLength, int maxLength) {
        do {
            Input.showHeader(enunciado);
            String text = scan.nextLine().trim().replaceAll("[\\s]{2,}", " ");
            if (text.length() < minLength || text.length() > maxLength)
                System.err.println("El texto debe de tener "
                        + (minLength == maxLength ? minLength + " caracteres"
                                : "entre " + minLength + " y " + maxLength + " caracteres"));
            else
                return text.toUpperCase();
        } while (true);

    }

    public static long getLong(String enunciado) {
        return getLong(enunciado, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static long getLong(String enunciado, long min, long max) {
        do {
            Input.showHeader(enunciado);
            try {
                long num = Long.parseLong(scan.nextLine());
                if (num >= min && num <= max)
                    return num;
                else
                    System.err.println("El numero debe de "
                            + (min == max ? "ser " + min
                                    : "estar entre " + min + " y " + max));
            } catch (NumberFormatException e) {
                System.err.println("El valor introducido no es numerico");
            }
        } while (true);
    }

    public static double getDouble(String enunciado) {
        return getDouble(enunciado, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public static double getDouble(String enunciado, double min, double max) {
        do {
            Input.showHeader(enunciado);
            try {
                double num = Double.parseDouble(scan.nextLine());
                if (num >= min && num <= max)
                    return num;
                else
                    System.err.println("El numero debe de "
                            + (min == max ? "ser " + min
                                    : "estar entre " + min + " y " + max));
            } catch (NumberFormatException e) {
                System.err.println("El valor introducido no es numerico");
            }
        } while (true);
    }

    /**
     *
     * @param enunciado cabecera del texto
     * @return texto con ese formato
     */
    public static String getMatricula(String enunciado) {
        return getFormat(enunciado, "[0-9]{4}\\-[A-Za-z]{3}");
    }

    public static String getFormat(String enunciado, String regex) {
        final Pattern patron = Pattern.compile(regex);
        do {
            String input = Input.getString(enunciado, 1, 256);
            if (patron.matcher(input).matches())
                return input;
            else
                System.err.println("El texto no sigue el patron requerido");
        } while (true);
    }
}
