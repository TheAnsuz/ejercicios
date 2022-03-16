/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.practicas.E2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author marruiad
 */
public class Ticket {

    private static int STATIC_ID = 0;
    private final static DateTimeFormatter fechas = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private static int getID() {
        return ++STATIC_ID;
    }

    private final int id;
    private final LocalDateTime fechaHora;
    private final String matricula;
    private final Ubicacion ubicacion;

    public Ticket(String matricula, Ubicacion ubicacion) {
        this.id = Ticket.getID();
        this.matricula = matricula;
        this.ubicacion = ubicacion;
        this.fechaHora = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", fechaHora=" + fechaHora.format(fechas) + ", matricula=" + matricula + ", ubicacion=" + ubicacion + '}';
    }

}
