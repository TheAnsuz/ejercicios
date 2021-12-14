package me.ansuz.amrv.practicas.practica1;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Adrian Martin Ruiz del Valle
 */
public class Clave {

    // Cadena de texto con los caracteres en minuscula de la clave mecanica
    public static String tabla = "abcdefghijklmnopqrstuvwxyz0123456789";
    // Cadena de texto con los caracteres mayusculos/alternativos de la clave
    // mecanica
    public static String tablaAlternativa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ=|@#$%&/()";
    // Cadena de texto con los caracteres especiales de los numeros
    public static String caracteresEspeciales = "=|@#$%&/()";

    /**
     * Obtiene una clave mecanica aleatoria dada la longitud en caracteres de la
     * misma.
     *
     * @param size longitud que va a tener la clave generada
     * @return una clave segura con el procedimiento mecanico
     */
    public static String generarMecanica(int size) {
        Random rnd = new Random(); // Generador random
        String clave = ""; // Clave vacia ya declarada
        for (int i = 0; i < size; i++) {
            int fila = rnd.nextInt(6) + 1;
            int columna = rnd.nextInt(6) + 1;
            // Obtiene el valor de la variabla "tabla" convirtiendo la x e y en una posicion
            // lineal
            int letra = (6 * (fila - 1) + columna) - 1;
            // Tira la moneda y segun devuelva true o false coge el valor de una tabla u
            // otra
            clave += (rnd.nextBoolean()) ? tabla.charAt(letra) : tablaAlternativa.charAt(letra);
        }
        return clave;
    }

    /**
     * Obtiene la clave mediante un secure random dando la longitud de la clave
     *
     * @param size longitud de la clave
     * @return la clave mediante secure random
     */
    public static String generarSecureRandom(int size) {
        SecureRandom rnd = new SecureRandom(); // Random seguro
        String clave = ""; // Almacen para la clave obtenida
        for (int i = 0; i < size; i++) {
            boolean tipo = rnd.nextBoolean();
            int posicion = rnd.nextInt((tipo) ? tabla.length() - 1 : tablaAlternativa.length() - 1);
            clave += (tipo) ? tabla.charAt(posicion) : tablaAlternativa.charAt(posicion);
        }
        return clave;
    }

    /**
     * Obtiene la clave ideal usando los parametros ofrecidos previamente por el
     * usuario
     *
     * @param size longitud de la clave
     * @param nombre el nombre del usuario
     * @param apellido el primer apellido del usuario
     * @param dni el valor numerico del dni del usuario
     * @param nacimiento la fecha de nacimiento del usuario
     * @return la clave ideal con la longitud requerida
     */
    public static String generarIdeal(int size, String nombre, String apellido, String dni, Date nacimiento) {
        DateFormat fecha = DateFormat.getDateInstance(DateFormat.YEAR_FIELD); // Fecha
        String clave = "";
        Random rnd = new Random();
        // Primera parte de la clave (letra del nombre)
        clave += nombre.toUpperCase().charAt(0);
        // Segunda parte de la clave (letra apellido)
        clave += apellido.toLowerCase().charAt(apellido.length() - 1);
        // Tercera y cuarta parte de la clave (cifras del DNI)
        clave += dni.substring(dni.length() - 2);
        // Quinto caracter de la clave (letra del DNI)
        clave += Operador.generarLetraDni(dni);
        // Sexto y septimo caracteres de la clave (fecha de nacimiento)
        String fechaTemporal = fecha.format(nacimiento);
        clave += fechaTemporal.substring(fechaTemporal.length() - 2);
        // Octavo caracter de la clave (simbolo aleatorio)
        clave += caracteresEspeciales.charAt(rnd.nextInt(caracteresEspeciales.length()));

        // Devolver la seccion de la clave
        return clave.substring(0, size);
    }

    /**
     * Obtiene el nivel de seguridad numerico de una clave, perfecto para ser
     * usado internamente
     *
     * @param password la clave de la cual se va a comprobar el nivel de
     * seguridad
     * @return un numero entre 1 y 3 indicando la seguridad de la clave (cuanto
     * mas alto mayor)
     */
    public static int obtenerNivelSeguridad(String password) {
        if (password.length() <= 6)
            return 1;
        else if (Operador.contieneMayusculas(password) && Operador.contieneMinusculas(password)
                && Operador.contieneNumeros(password) && Operador.contieneSimbolos(password))
            return 3;
        else
            return 2;
    }

}
