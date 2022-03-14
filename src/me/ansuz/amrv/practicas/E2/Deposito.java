/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marruiad
 */
public class Deposito implements Moneda {
    //Moneda Cantidad

    private final Map<Float, Integer> monedas;

    public Deposito(int capacidadInicial) {
        monedas = new HashMap<>();
        monedas.put(Moneda.CENTIMO_5, capacidadInicial);
        monedas.put(Moneda.CENTIMO_10, capacidadInicial);
        monedas.put(Moneda.CENTIMO_20, capacidadInicial);
        monedas.put(Moneda.CENTIMO_50, capacidadInicial);
        monedas.put(Moneda.EURO_1, capacidadInicial);
        monedas.put(Moneda.EURO_2, capacidadInicial);
        monedas.put(Moneda.EURO_5, capacidadInicial);
        monedas.put(Moneda.EURO_10, capacidadInicial);
        monedas.put(Moneda.EURO_20, capacidadInicial);
    }

    public void add(float moneda, int cantidad) {
        if (!monedas.containsKey(moneda))
            throw new RuntimeException("No se puede introducir el tipo de moneda");
        monedas.replace(moneda, monedas.get(moneda) + cantidad);
    }

    public void remove(float moneda, int cantidad) {
        if (!monedas.containsKey(moneda))
            throw new RuntimeException("No se puede introducir el tipo de moneda");
        if (monedas.get(moneda) - cantidad < 0)
            throw new RuntimeException("No hay tantas monedas en el deposito");
        monedas.replace(moneda, monedas.get(moneda) - cantidad);
    }
    
    public boolean isValid(float moneda) {
        return monedas.containsKey(moneda);
    }
    
    public int getAmount(float moneda) {
        if (!monedas.containsKey(moneda))
            throw new RuntimeException("No se puede introducir el tipo de moneda");
        return monedas.get(moneda);
    }

}
