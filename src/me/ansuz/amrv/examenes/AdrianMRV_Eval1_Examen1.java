/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.examenes;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marruiad
 */
public class AdrianMRV_Eval1_Examen1 {

    /*
    
        El programa esta dividido en partes para una comprension mas facil
    
     */
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        long meta = 0;
        String nombre = "";
        long caballoA = 0;
        long caballoB = 0;
        Random rng = new Random();

        // Introducir la letra, palabra o frase a dar como nombre
        System.out.println("Por favor introduce tu nombre para empezar la carrera");
        nombre = scan.nextLine();

        // Si en la entrada de datos del nombre se pulsa enter sin introducir ningun caracter, se devuelve el caracter nulo
        // tambien llamado \0, con el valor 0, por lo cual, si la cadena es nula, se introduce un espacio para darle un valor
        // minimo, tambien se comprueba si es menor de 0 por si se da el caso de algun error de ejecucion
        nombre = (nombre.length() <= 0) ? " " : nombre;

        // Convertir la cadena de texto introducida en numeros dado su valor
        for (int i = 0; i < nombre.length(); i++) {
            meta += (int) nombre.charAt(i);
        }

        // Mostrar la posicion numerica de la meta
        System.out.println("Meta en " + meta);

        do {

            // Mover un caballo aleatoriamente
            // En vez de usar 0-1 para ver que caballo se mueve, se usa una probabilidad de 50/50 para que el resultado
            // sea mas equitativo
            if (rng.nextInt(101) < 50)
                caballoA++;
            else
                caballoB++;

            /*
                Me he tomado la libertad de hacer que aparezca la meta al final, simplemente para que se vea mejor
                cuanto queda de carrera y la distancia que separa a ambos
             */
            // Imprimir en consola el movimiento del caballo A
            for (int a = 0; a < meta; a++) {
                if (a < caballoA)
                    System.out.print("1");
                else
                    System.out.print("·");
                if (a == meta-1)
                    System.out.println("|");
            }

            // Imprimir en consola el movimiento del caballo B
            for (int b = 0; b < meta; b++) {
                if (b < caballoB)
                    System.out.print("2");
                else
                    System.out.print("·");
                if (b == meta-1)
                    System.out.println("|");
            }

            // Imprimir dos lineas vacias para separar el ciclo anterior del nuevo
            System.out.println();
            System.out.println();

            // Pausar la ejecucion del programa, dentro de un try-catch para evitar errores si la operacion da error
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                // No se ha podido parar el proceso del programa por algun motivo concreto
                Logger.getLogger(AdrianMRV_Eval1_Examen1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }while (caballoA < meta && caballoB < meta);

        // Poner el ganador con un valor ternario, por usarlos ya que los hemos dado
        // No es necesario prevenir un empate ya que al solo moverse un caballo SI o SI va a haber uno
        // que este mas avanzado que el otro
        System.out.println((caballoA >= caballoB) ? "Gana el primer caballo" : "Gana el segundo caballo");
    }
}
