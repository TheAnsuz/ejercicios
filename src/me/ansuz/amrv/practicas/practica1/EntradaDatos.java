package me.ansuz.amrv.practicas.practica1;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Adrian Martin Ruiz del Valle
 */
public class EntradaDatos {

    private static final Scanner scan = new Scanner(System.in);

    /**
     * Obtiene un texto formateado valido para su uso.
     *
     * @return el texto formateado.
     * @param enunciado el texto que mostrará la consola para solicitad los
     * datos.
     */
    public static String getTexto(String enunciado) {
        return getTexto(enunciado, 1);
    }

    /**
     * Obtiene un texto formateado dado el enunciado y la longitu minima que
     * debe de tener la cadena de texto
     *
     * @param enunciado lo que se mostrara en la consola para pedir el texto
     * @param caracteres la longitud minima obligatoria que debe de tener la
     * cadena
     * @return el texto obtenido ya validado
     */
    public static String getTexto(String enunciado, int caracteres) {
        String texto = "";
        boolean valido = true;
        do {
            valido = true;
            System.out.println(enunciado);
            texto = scan.nextLine().trim();
            if (texto.length() < caracteres) {
                System.out.println("Debes introducir una cadena de texto de al menos " + caracteres
                        + ((caracteres == 1) ? " letra" : " letras"));
                valido = false;
            }

            // Comprobar que no tiene simbolos
            if (Operador.contieneSimbolos(texto)) {
                valido = false;
                System.out.println("El texto no puede contener caracteres especiales");
            } else if (Operador.contieneNumeros(texto)) {
                valido = false;
                System.out.println("El texto no puede contener numeros");
            }

        } while (!valido);
        return texto;
    }

    /**
     * Obtiene un valor booleano dado el enunciado, el valor booleano esta
     * formateado para que permita valores como si, no, S, N, true o false
     *
     * @param enunciado el texto que se mostrara antes de introducir la
     * respuesta
     * @return true si el usuario introduce un valor valido para ser considerado
     * positivo, falso si no
     */
    public static boolean getBoolean(String enunciado) {
        String texto = "";
        do {
            System.out.println(enunciado);
            texto = scan.nextLine().replaceAll("\\s", "").toLowerCase();
            switch (texto) {
                case "s":
                case "si":
                case "true":
                    return true;
                case "n":
                case "no":
                case "false":
                    return false;
                default:
                    System.out.println("Por favor responde con si o no");
                    break;
            }
        } while (true);
    }

    /**
     * Obtiene un formato de un DNI de 8 digitos valido para ser usado como DNI
     *
     * @param enunciado el texto que se mostrara para pedir el DNI
     * @return el DNI como texto
     */
    public static String getDni(String enunciado) {
        boolean valido = false;
        String valor = "";
        do {
            System.out.println(enunciado);
            valor = scan.nextLine();
            if (valor.length() != 8) {
                System.out.println("El DNI debe de tener 8 digitos");
            // Los DNI no pueden ser todo ceros asique es un caso excludio
            } else if (valor.equalsIgnoreCase("00000000")) {
                System.out.println("El DNI no puede ser todo ceros");
            } else {
                valido = true;
                for (int i = 0; i < 8; i++) {
                    if (!Character.isDigit(valor.charAt(i))) {
                        valido = false;
                    }
                }
            if (!valido)
                System.out.println("El DNI debe de ser un numero positivo de 8 digitos");
            }
        } while (!valido);
        return valor;
    }

    //===================================================================================================================
//                          OBSOLETO PORQUE EL DNI DEBE PODER EMPEZAR POR 0 >:(
//	/**
//	 * Obtiene un numero introducido por el usuario dando el enunciado y la longitud
//	 * que debe de tener ese numero, minima y maxima
//	 *
//	 * @param enunciado el texto que se mostrara en la peticion del numero
//	 * @param minBytes  longitud en bytes minima
//	 * @param maxBytes  longitud en bytes maxima
//	 * @return el numero formateado
//	 */
//	public static int getNumber(String enunciado, int minBytes, int maxBytes) {
//		boolean valido = false;
//		String entrada = "";
//		int numero = 0;
//		do {
//			System.out.println(enunciado);
//			entrada = scan.nextLine();
//			if (entrada.startsWith("0"))
//				System.out.println("El DNI no puede empezar con un 0");
//			else if (entrada.length() < minBytes || entrada.length() > maxBytes) {
//
//				if (minBytes != maxBytes)
//					System.out.println(
//							"El valor introducido debe tener entre " + minBytes + " y " + maxBytes + " digitos");
//				else
//					System.out.println("El valor valor debe tener " + minBytes + " digitos");
//
//			} else {
//				try {
//					numero = Integer.parseInt(entrada);
//					if (numero > 0)
//						valido = true;
//					else if (numero == 0)
//						System.out.println("El numero no puede ser cero");
//					else
//						System.out.println("El numero no puede ser un numero negativo");
//				} catch (Exception e) {
//					System.out.println("El valor introducido debe de ser numerico");
//				}
//			}
//		} while (!valido);
//
//		return numero;
//	}
//===================================================================================================================
    /**
     * Obtiene una fecha introucida por el usuario, dando el enunciado y la
     * fecha maxima que puede ser dada
     *
     * @param enunciado el texto que se mostrara junto a la peticion de la fecha
     * @param min el limite como fecha minima aceptada
     * @param max el limite como fecha maxima aceptada
     * @return la fecha valida introducida por el usuario
     */
    public static GregorianCalendar getDate(String enunciado, GregorianCalendar min, GregorianCalendar max) {
        boolean valido = false;
        GregorianCalendar date = new GregorianCalendar();
        date.setLenient(false);
        do {
            try {
                // dia/mes/anio
                System.out.println(enunciado);
                String[] datos = scan.nextLine().split("/");
                date.setLenient(false);
                date.set(GregorianCalendar.YEAR, Integer.parseInt(datos[2]));
                date.set(GregorianCalendar.MONTH, Integer.parseInt(datos[1]) - 1);
                date.set(GregorianCalendar.DATE, Integer.parseInt(datos[0]));
                if (date.compareTo(max) < 0 && date.compareTo(min) > 0)
                    valido = true;
                else
                    System.out.println("La fecha de nacimiento debe de estar entre 1900 y la fecha actual");
            } catch (Exception e) {
                System.out.println("La fecha introducida no es valida");
            }

        } while (!valido);

        return date;
    }

}
