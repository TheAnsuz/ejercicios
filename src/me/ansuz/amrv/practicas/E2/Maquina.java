/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marruiad
 */
public class Maquina {

    private double precioPorMinuto;
    private String nombre;
    private final Plano plano;
    private final List<Ticket> tickets;

    public Maquina(double precioPorMinuto, String nombre, int plantas, int plazas) {
        this.precioPorMinuto = precioPorMinuto;
        this.nombre = nombre;
        this.plano = new Plano(plantas, plazas);
        this.tickets = new ArrayList<>();
    }

    public double getPrecioPorMinuto() {
        return precioPorMinuto;
    }

    public void setPrecioPorMinuto(double precioPorMinuto) {
        this.precioPorMinuto = precioPorMinuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Plano getPlano() {
        return plano;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        this.tickets.remove(ticket);
        this.plano.setLibre(ticket.getUbicacion());
    }

    public boolean hasMatricula(String matricula) {
        return getTicket(matricula) != null;
    }

    public Ticket getTicket(String matricula) {
        for (Ticket ticket : tickets) {
            if (ticket.getMatricula().equals(matricula))
                return ticket;
        }
        return null;
    }

    public Ticket getTicket(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id)
                return ticket;
        }
        return null;
    }

    public boolean hasTicketID(int id) {
        return getTicket(id) != null;
    }

    public double getCoste(Ticket ticket) {
        final long segundos = ChronoUnit.SECONDS.between(LocalDateTime.now(), ticket.getFechaHora());
        return this.getPrecioPorMinuto() * (segundos % 60 + segundos / (segundos % 60) == 0 ? 0 : 1);
    }

}
