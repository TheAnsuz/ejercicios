/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.pruebas;

import java.util.Scanner;

/**
 *
 * @author marruiad
 */
public class Ternario {
    
    public static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        byte a = 10, b = 10;
        
        char v = scan.next().charAt(0);
        
        double value = (v == '*') ? (a*b) :
                       (v == 'x') ? (a*b) :
                       (v == '+') ? (a+b) :
                       (v == '-') ? (a-b) : 
                       (v == '/') ? (a/b) :
                       (v == '%') ? (a%b) :
                       Double.NaN;
       
        if (value == Double.NaN)
            System.out.println("La operacion no es valida");
        else
            System.out.println(value);
    }
}
