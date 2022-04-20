/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t3;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class MiNota {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Si los numeros introducidos son mayor o menor de 100 se ajustaran al limite maximo o minimo");

        System.out.print("Primer numero  -> ");
        int a = scan.nextInt();
        System.out.print("Segundo numero -> ");
        int b = scan.nextInt();
        System.out.print("Tercer numero  -> ");
        int c = scan.nextInt();
        System.out.print("Cuarto numero  -> ");
        int d = scan.nextInt();
        a = (a < 0) ? 0 : (a > 100) ? 100 : a;
        b = (b < 0) ? 0 : (b > 100) ? 100 : b;
        c = (c < 0) ? 0 : (c > 100) ? 100 : c;
        d = (d < 0) ? 0 : (d > 100) ? 100 : d;

        double media = (double) (a + b + c + d) / 4;
        char calif = 'E';
        
        if (media >= 90)
            calif = 'A';
        else if (media >= 80)
            calif = 'B';
        else if (media >= 70)
            calif = 'C';
        else if (media >= 60)
            calif = 'D';

        System.out.println("Tu media es " + media + " por lo cual tu calificacion es de " + calif);
        
        scan.close();
    }

}
