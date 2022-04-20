/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t8.ejercicioCSV;

import com.opencsv.bean.CsvBindByName;

/**
 *
 * @author marruiad
 */
public class Empleado {

    @CsvBindByName(column = "EMPLOYEE_ID")
    private final int id;
    @CsvBindByName(column = "FIRST_NAME")
    private final String nombre;
    @CsvBindByName(column = "LAST_NAME")
    private final String apellido;
    @CsvBindByName(column = "DEPARTMENT_NAME")
    private final String departamento;

    // Default constructor for CSV Reader
    public Empleado() {
        this(0, null, null, null);
    }

    public Empleado(int id, String nombre, String apellido, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "(" + id + ") " + nombre + " " + apellido + " > " + departamento;
    }

}
