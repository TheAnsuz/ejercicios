/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.practica1;

import java.time.LocalDate;

/**
 *
 * @author marruiad
 */
public class Inicio {

    public static void main(String[] args) {
        // Nombre tal cual se obtiene, preparado para ser formateado para mostrarlo al usuario final
        String nombreOriginal = "";
        // Nombre modificado para ser usado internamente para las operaciones de obtencion de datos
        String nombreNormalizado = "";
        // Primer apellido preparado para ser formateado para mostrarlo al usuario final
        String primerApellidoOriginal = "";
        // Primer apellido modificado para ser usado internamente en las operaciones
        String primerApellidoNormalizado = "";
        // Segundo apellido formateado para mostrar al usuario final
        String segundoApellidoOriginal = "";
        // Segundo apellido modificado para que se pueda usar en las operaciones internas
        String segundoApellidoNormalizado = "";
        // Clave que se obtendrá con los datos normalizados del usuario
        String clave = "";
        // Valor numerico del DNI
        int dni = 0;
        // Fecha de nacimiento del usuario
        LocalDate nacimiento;

        System.out.println("Programa para generar contrasñeas dado el nombre");
        System.out.println("================================================");

        // Obtencion del nombre del usuario
        nombreOriginal = EntradaDatos.getTexto("Introduce tu nombre:");
        if (nombreOriginal.length() < 3) {
            System.out.println("AVISO: El nombre es muy corto, deberias usar un nombre de pila o apodo");
            boolean valido = EntradaDatos.getBoolean("¿Estas seguro de que deseas usar ese nombre?");
            if (valido) {
                System.out.println("Vale, el programa auto formateará tu nombre");
            } else {
                nombreOriginal = EntradaDatos.getTexto("Introduce un nombre de 3 letras minimo", 3);
            }
        }
        nombreOriginal = Operador.formatearTexto(nombreOriginal);
        nombreNormalizado = Operador.normalizarTexto(nombreOriginal, 3);

        // Obtencion del primer apellido del usuario
        primerApellidoOriginal = EntradaDatos.getTexto("Introduce tu primer apellido:");
        if (primerApellidoOriginal.length() < 2) {
            System.out.println("AVISO: El apellido es muy corto, deberias usar un nombre de pila o apodo");
            boolean valido = EntradaDatos.getBoolean("¿Estas seguro de que deseas usar ese apellido?");
            if (valido) {
                System.out.println("Vale, el programa auto formateará tu apellido");
            } else {
                primerApellidoOriginal = EntradaDatos.getTexto("Introduce un apellido de 2 letras minimo", 2);
            }
        }
        primerApellidoOriginal = Operador.formatearTexto(primerApellidoOriginal);
        primerApellidoNormalizado = Operador.normalizarTexto(primerApellidoOriginal, 2);

        // Obtencion del segundo apellido
        segundoApellidoOriginal = EntradaDatos.getTexto("Introduce tu segundo apellido:");
        if (segundoApellidoOriginal.length() < 2) {
            System.out.println("AVISO: El apellido es muy corto, deberias usar un nombre de pila o apodo");
            boolean valido = EntradaDatos.getBoolean("¿Estas seguro de que deseas usar ese apellido?");
            if (valido) {
                System.out.println("Vale, el programa auto formateará tu apellido");
            } else {
                segundoApellidoOriginal = EntradaDatos.getTexto("Introduce un apellido de 2 letras minimo", 2);
            }
        }
        segundoApellidoOriginal = Operador.formatearTexto(segundoApellidoOriginal);
        segundoApellidoNormalizado = Operador.normalizarTexto(segundoApellidoOriginal, 2);

        // Obtencion del DNI
        dni = EntradaDatos.getNumber("Introduce tu DNI: ", 8, 8);

        // Obtencion de la fecha de nacimiento del usuario
        nacimiento = EntradaDatos.getDate("Introduce tu fecha de nacimiento (dia/mes/año)");
        
        // Generacion de la clave
        clave = segundoApellidoNormalizado.substring(0, 2)
                + primerApellidoNormalizado.substring(0, 2)
                + nombreNormalizado.substring(0, 3);

        // Imprimir datos de usuario
        System.out.println("=======Usuario=========================");
        System.out.println("Nombre: " + nombreOriginal);
        System.out.println("Apellidos: " + primerApellidoOriginal + " " + segundoApellidoOriginal);
        System.out.println("DNI: " + dni + ' ' + Operador.generarLetraDni(dni));
        System.out.println("Clave: " + clave);
        System.out.println("Fecha de nacimiento: " + nacimiento);
        System.out.println("=======================================");
    }

}
