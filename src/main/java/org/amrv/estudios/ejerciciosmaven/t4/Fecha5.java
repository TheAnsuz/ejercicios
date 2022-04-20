/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t4;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Fecha5 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean fechaCorrecta = false;
        boolean terminoCorrecto = false;
        GregorianCalendar facturacion = new GregorianCalendar();
        facturacion.setLenient(false);
        String termino = "";

        // Introducir la fecha de facturacion
        do {
            try {
                System.out.println("Introduce la fecha de facturacion (dia/mes):");
                String[] info = scan.nextLine().split("/");
                facturacion.set(GregorianCalendar.DATE, Integer.parseInt(info[0]));
                facturacion.set(GregorianCalendar.MONTH, Integer.parseInt(info[1])-1);
                System.out.println("Has introducido la fecha: " + facturacion.getTime());
                fechaCorrecta = true;
            } catch (Exception e) {
                System.out.println("Has introducido una fecha invalida");
            }
        } while (!fechaCorrecta);

        // Introducir los terminos de pago
        do {
            System.out.println("Introduce el termino de pago (7D, 14D, 21D, 2x45, 3x30)");
            String term = scan.nextLine();
            switch (term) {
                case "7d":
                case "7D":
                    termino = "7D";
                    terminoCorrecto = true;
                    break;
                case "14d":
                case "14D":
                    termino = "14D";
                    terminoCorrecto = true;
                    break;
                case "21d":
                case "21D":
                    termino = "21D";
                    terminoCorrecto = true;
                    break;
                case "2x45":
                case "2X45":
                    termino = "2x45";
                    terminoCorrecto = true;
                    break;
                case "3x30":
                case "3X30":
                    termino = "3x30";
                    terminoCorrecto = true;
                    break;
                default:
                    System.out.println("El termino introducido no es valido");
                    break;
            }
        } while (!terminoCorrecto);
        
        // Mostrar pagos / pedir informacion complementaria
        if (termino.equals("2x30") || termino.equals("3x45")) {
        int importe = -1;
        String[] porcentajes = new String[0];
        int[] valores = new int[(termino.equals("3x30")) ?  2  : 3];
            do {
                System.out.print("Introduce el importe de la factura: ");
                importe = scan.nextInt();
                if (importe <= 0)
                    System.out.println("La cantidad introducida no es valida");
            } while (importe <= 0);
            scan.nextLine();
            do {
                System.out.println("Introduce los porcentajes (separados por comas)");
                
                porcentajes = scan.nextLine().replace("%", "").split(",");
                
            } while ( (termino.equals("3x30")) ? porcentajes.length != 2  : porcentajes.length != 3);
            
        } else {
            switch (termino) {
                case "7D":
                facturacion.add(GregorianCalendar.DATE, 7);
                break;
                case "14D":
                    facturacion.add(GregorianCalendar.DATE, 14);
                    break;
                case "21D":
                    facturacion.add(GregorianCalendar.DATE, 21);
                    break;
            }
            
            System.out.println("Fecha de vto " + facturacion.getTime());
        }
    }

}
