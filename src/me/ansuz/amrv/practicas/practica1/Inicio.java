package me.ansuz.amrv.practicas.practica1;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author Adrian Martin Ruiz del Valle
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
        // Clave que se obtendr√° con los datos normalizados del usuario
        String clave = "";
        // Valor numerico del DNI
        String dni = "";
        // Fecha de nacimiento del usuario
        GregorianCalendar nacimiento;
        // Clave mecanica
        String claveMecanica = "";
        // Clave secure
        String claveSecure = "";
        // Clave ideal
        String claveIdeal = "";

        System.out.println("Programa para generar claves dado el nombre");
        System.out.println("================================================");

        // Obtencion del nombre del usuario
        nombreOriginal = EntradaDatos.getTexto("Introduce tu nombre:");
        if (nombreOriginal.length() < 3) {
            System.out.println("AVISO: El nombre es muy corto, deberias usar un nombre de pila o apodo");
            // Permite al usuario cambiar el nombre en caso de que sea muy corto
            boolean valido = EntradaDatos.getBoolean("øEstas seguro de que deseas usar ese nombre?");
            if (valido) {
                System.out.println("Vale, el programa auto formateara tu nombre");
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
            // Permite al usuario cambiar el primer apellido en caso de que sea muy corto
            boolean valido = EntradaDatos.getBoolean("øEstas seguro de que deseas usar ese apellido?");
            if (valido) {
                System.out.println("Vale, el programa auto formateara tu apellido");
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
            // Permite al usuario cambiar el apellido en caso de que sea muy corto
            boolean valido = EntradaDatos.getBoolean("øEstas seguro de que deseas usar ese apellido?");
            if (valido) {
                System.out.println("Vale, el programa auto formateara tu apellido");
            } else {
                segundoApellidoOriginal = EntradaDatos.getTexto("Introduce un apellido de 2 letras minimo", 2);
            }
        }
        segundoApellidoOriginal = Operador.formatearTexto(segundoApellidoOriginal);
        segundoApellidoNormalizado = Operador.normalizarTexto(segundoApellidoOriginal, 2);

        // Obtencion del DNI
        dni = EntradaDatos.getDni("Introduce tu DNI: ");

        // Obtencion de la fecha de nacimiento del usuario
        nacimiento = EntradaDatos.getDate("Introduce tu fecha de nacimiento (dia/mes/year)", new GregorianCalendar());

        // Generacion de las claves
        Random rnd = new Random(); // Generador de dimensiones de claves
        clave = segundoApellidoNormalizado.substring(0, 2)
                + primerApellidoNormalizado.substring(0, 2)
                + nombreNormalizado.substring(0, 3);
        claveMecanica = Clave.generarMecanica(rnd.nextInt(4) + 4);
        claveSecure = Clave.generarSecureRandom(rnd.nextInt(4) + 4);

        claveIdeal = Clave.generarIdeal(rnd.nextInt(4) + 4, nombreOriginal, primerApellidoOriginal, dni, nacimiento.getTime());

        // Imprimir datos de usuario
        System.out.println("<|=======Usuario=========================|>");
        System.out.println("   Nombre: " + nombreOriginal);
        System.out.println("   Apellidos: " + primerApellidoOriginal + " " + segundoApellidoOriginal);
        System.out.println("   DNI: " + dni + ' ' + Operador.generarLetraDni(dni));
        System.out.println("   Usuario: " + clave);
//        System.out.println("   Fecha de nacimiento: " + nacimiento.getTime());
        System.out.println("   Primera clave: " + claveMecanica + " - " + Operador.formatearClave(Clave.obtenerNivelSeguridad(claveMecanica)));
        System.out.println("   Segunda clave: " + claveSecure + " - " + Operador.formatearClave(Clave.obtenerNivelSeguridad(claveSecure)));
        System.out.println("   Tercera clave: " + claveIdeal + " - " + Operador.formatearClave(Clave.obtenerNivelSeguridad(claveIdeal)));
        System.out.println("<|=======================================|>");
    }

}
