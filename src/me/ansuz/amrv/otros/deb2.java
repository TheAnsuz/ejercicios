/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.otros;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class deb2 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Escribe numeros, puedes parar escribiendo no");
        while (true) {
            System.out.print("Escribe un numero ");
            int n = scan.nextInt();

            // Limpiar el scanner ya que el metodo nextInt no causa la siguiente linea
            // produciendo un error en la proxima entrada de datos
            scan.nextLine();
            if (n % 2 == 0) {
                System.out.println("El numero es par");
            } else {
                System.out.println("El numero es impar");
            }

            System.out.println("¿Otro numero?");
            String texto = scan.nextLine();
            
            // Uso de equalsIgnoreCase y no == porque es mas correcto para comparar cadenas de texto
            if (texto.equalsIgnoreCase("no")) {
                break;
            }
        }

    }
}
