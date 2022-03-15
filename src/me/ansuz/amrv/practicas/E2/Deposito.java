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
public class Deposito {

    private final Map<Moneda, Integer> monedas;

    public Deposito(int capacidadInicial) {
        monedas = new HashMap<>();
        for (Moneda tipo : Moneda.values()) {
            monedas.put(tipo, capacidadInicial);
        }
    }

    public void add(Moneda moneda, int cantidad) {
        monedas.replace(moneda, monedas.get(moneda) + cantidad);
    }

    public void remove(Moneda moneda, int cantidad) {
        if (monedas.get(moneda) - cantidad < 0)
            throw new RuntimeException("No hay tantas monedas en el deposito");
        monedas.replace(moneda, monedas.get(moneda) - cantidad);
    }
    
    public int getAmount(Moneda moneda) {
        return monedas.get(moneda);
    }

}
