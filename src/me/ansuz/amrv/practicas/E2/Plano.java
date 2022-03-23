/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.util.Arrays;

/**
 *
 * @author marruiad
 */
public class Plano {

    // Guarda los ID de los tickets
    private final int[][] parking;

    public Plano(int pisos, int plazasPorPiso) {
        parking = new int[pisos][plazasPorPiso];
        // Rellenar el array para hacer pruebas
        for (int y = 0; y < parking.length; y++)
            for (int x = 0; x < parking[y].length; x++)
                parking[y][x] = 0;
    }

    public int getPisos() {
        return parking.length;
    }

    public int getPlazas() {
        return parking.length > 0 ? parking[0].length : 0;
    }

    public int getTicketID(Ubicacion ubi) {
        return parking[ubi.getPlanta() - 1][ubi.getPlaza() - 1];
    }

    public int getTicketID(int planta, int plaza) {
        return parking[planta - 1][plaza - 1];
    }

    public boolean isOcupada(Ubicacion ubi) {
        return parking[ubi.getPlanta() - 1][ubi.getPlaza() - 1] > 0;
    }

    public boolean isOcupada(int planta, int plaza) {
        return parking[planta - 1][plaza - 1] > 0;
    }

    public void setLibre(Ubicacion ubi) {
        setLibre(ubi.getPlanta(), ubi.getPlaza());
    }

    public void setLibre(int planta, int plaza) {
        parking[planta - 1][plaza - 1] = 0;
    }

    public boolean hasLibre() {
        return this.getLibre() == null;
    }

    public Ubicacion getLibre() {
        for (int y = 1; y <= parking.length; y++)
            for (int x = 1; x <= parking[y - 1].length; x++) {
//                System.out.println((y-1)+"y " + (x-1) +"x " + parking[y-1][x-1] + " - " + this.isOcupada(y, x));
                if (!this.isOcupada(y, x))
                    return new Ubicacion(y, x);
            }
        return null;
    }

    public Ticket estacionar(String matricula, int planta, int plaza) {
        return estacionar(matricula, new Ubicacion(planta, plaza));
    }

    public Ticket estacionar(String matricula, Ubicacion ubicacion) {
        final Ticket ticket = new Ticket(matricula, ubicacion);
        parking[ubicacion.getPlanta() - 1][ubicacion.getPlaza() - 1] = ticket.getId();
        return ticket;
    }

    @Override
    public String toString() {

        String temp = "";
        for (int y = 0; y < parking.length; y++) {
            temp += Arrays.toString(parking[y]) + ',' + System.lineSeparator();
        }
        return temp;
    }

}
