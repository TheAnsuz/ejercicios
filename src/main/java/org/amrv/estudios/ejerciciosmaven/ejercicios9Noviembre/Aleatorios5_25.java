/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.ejercicios9Noviembre;

import java.util.Random;

/**
 *
 * @author marruiad
 */
public class Aleatorios5_25 {

    //  Escribe un programa que genere 100 aleatorios entre 5 y 25, y diga que 
    //  numero es el que ha salido mas veces de forma seguida.
    public static void main(String[] args) {

        Random rnd = new Random();
        int repetido = 0; // el numero mas repetido
        int reps = 0; // las repeticiones del numero mas repetido
        int actual = 0; // el numero que se esta repitiendo actualmente
        int repsActual = 0; // las repeticiones del numero repitiendose actualmente
        
        // Bucle para comprobar el numero
        for (int i = 0; i < 100; i++) {
            int num = rnd.nextInt(21) + 5;
            System.out.print("> " + num);

            //  Si el numero que se acaba de generar es igual al numero que 
            //  esta actualmente repitiendose
            if (num == actual) {
                repsActual++;
            } else {
                //  Si no es igual al que estaba repitiendose, lo sustituye 
                //  y resetea
                actual = num;
                repsActual = 1;
            }
            
            //  Si el numero que se esta repitiendo actualmente tiene mas 
            //  repeticiones que el que esta almacenado como mas repetido, 
            //  lo sustituye
            if (repsActual >= reps) {
                repetido = num;
                reps = repsActual;
                System.out.print("<<");
            }
            
            System.out.print("\tActual=" + actual + " \t(" + repsActual+ "), Repetido=" +repetido+ " \t(" + reps + ")");
            System.out.println();
        }
        
        System.out.println("El numero mas repetido es " + repetido + ", repetido " + reps + " veces seguidas");

    }

}

