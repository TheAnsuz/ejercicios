/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author marruiad
 */
public class Persona {

    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

    private final String DNI;
    private String nombre;
    private String apellidos;
    private char genero;
    private Date fechaNacimiento;
    private int altura;
    private float peso;
    private boolean casado;

    public Persona(String dni, String nombre, String apellidos, char genero, Date nacimiento, int altura, float peso, boolean casado) {
        this.DNI = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaNacimiento = nacimiento;
        this.altura = altura;
        this.peso = peso;
        this.casado = casado;
    }

    public String getDni() {
        return DNI;
    }

    public char getLetraDNI() {
        return LETRAS.charAt((Integer.parseInt(DNI) % 23) + 1);
    }

    public int getEdad() {
        Calendar actual = Calendar.getInstance();
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);

        return nacimiento.get(Calendar.YEAR) - actual.get(Calendar.YEAR);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaNacimientoFormateada() {
        DateFormat df = new SimpleDateFormat("w-MM-yyyy");
        return df.format(fechaNacimiento);
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getPesoIdeal() {
        final double ideal = 0.75 * (altura - 150) + 50;
        return (ideal > peso) ? -1 : (ideal < peso) ? 1 : 0;
    }

    public boolean isMayorDeEdad() {
        return getEdad() > 18;
    }

    @Override
    public String toString() {
        return "Persona{dni= " + DNI + getLetraDNI() + " nombre= " + nombre + " " + apellidos
                + " genero= " + ((genero == 'h') ? "hombre" : "mujer") + " nacimiento= "
                + getFechaNacimientoFormateada().toLowerCase() + " altura= " + altura + " peso= " + peso
                + " casado= " + ((casado) ? "si" : "no") + "}";
    }

}
