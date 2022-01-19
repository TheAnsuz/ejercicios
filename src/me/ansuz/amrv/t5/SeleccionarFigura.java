/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class SeleccionarFigura {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Por favor elige la figura que construir:");
        System.out.println("1 - circulo");
        System.out.println("2 - rectangulo");
        System.out.println("3 - cuadrado");
        System.out.println("4 - triangulo");
        System.out.println("Cualquier otro valor para salir");
        switch (scan.nextLine().trim()) {
            case "1":
                circulo();
                break;
            case "2":
                rectangulo();
                break;
            case "3":
                cuadrado();
                break;
            case "4":
                triangulo();
                break;
            default:
                System.out.println("Has decidido terminar el programa");
                break;
        }
    }

    private static void circulo() {
        System.out.println("Creacion de un circulo:");
        Circulo c = new Circulo(numero("Radio: ", 0), punto());
        System.out.println(c);
        System.out.println("Area: " + c.area());
        System.out.println("Perimetro: " + c.perimetro());
    }

    private static void rectangulo() {
        System.out.println("Creacion de un rectangulo:");
        Rectangulo c = new Rectangulo(numero("Ancho: ", 0), numero("Alto: ", 0), punto());
        System.out.println(c);
        System.out.println("Area: " + c.area());
        System.out.println("Perimetro: " + c.perimetro());
        System.out.println("Diagonal: " + c.diagonal());
    }

    private static void cuadrado() {
        System.out.println("Creacion de un cuadrado:");
        Cuadrado c = new Cuadrado(numero("Lado: ", 0), punto());
        System.out.println(c);
        System.out.println("Area: " + c.area());
        System.out.println("Perimetro: " + c.perimetro());
        System.out.println("Diagonal: " + c.diagonal());
    }

    private static void triangulo() {
        System.out.println("Creacion de un triangulo:");
        Triangulo c = new Triangulo(numero("Base: ", 0), numero("Altura: ", 0), punto());
        System.out.println(c);
        System.out.println("Area: " + c.area());
        System.out.println("Perimetro: " + c.perimetro());
    }

    private static Punto punto() {
        return new Punto(numero("centro X: ", Double.MIN_VALUE), numero("centro Y: ", Double.MIN_VALUE));
    }

    private static double numero(String title, double min) {
        double num = 0d;
        boolean continuar = false;
        do {
            try {
                System.out.println(title);
                num = Double.parseDouble(scan.nextLine().trim().replace(',', '.'));
                if (num > min)
                    continuar = true;
                else
                    System.out.println("El numero debe ser mayor a " + min);
            } catch (Exception e) {
                System.out.println("El valor introducido no es un numero");
            }
        } while (!continuar);
        return num;
    }

}
