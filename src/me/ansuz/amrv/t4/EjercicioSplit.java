/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t4;

/**
 *
 * @author marruiad
 */
public class EjercicioSplit {
    
    public static void main(String[] args) {
        
//          mostrar por pantalla: Fabricante://Almacen://Seccion://Color:
//          String codigoArticulo = "FAB-123-56789-00";
//          String[] partes = codigoArticulo.split("-");

        String codigoArticulo = "FAB-123-56789-00";
        String[] secciones = codigoArticulo.split("-");
        
        System.out.println("Fabricante: " + secciones[0]);
        System.out.println("Almacen: " + secciones[1]);
        System.out.println("Seccion: " + secciones[2]);
        System.out.println("Color: " + secciones[3]);
    }
    
}
