package org.amrv.problema1;

import java.util.Arrays;

public class Asignatura {

    /**
     * Tamaño del array de notas
     */
    private final static int CANTIDAD_NOTAS = 3;

    /**
     * Nobre de la asignatura
     */
    private final String nombreAsignatura;

    /**
     * Array con las notas
     */
    private double[] notas = new double[CANTIDAD_NOTAS]; //notas en las 3 evaluaciones

    /**
     * Crea la asignatura con un nombre especifico inalterable
     *
     * @param nombreAsignatura nombre de la asignatura
     */
    public Asignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * Obtiene el nombre de la asignatura
     *
     * @return nombre de la asignatura
     */
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    /**
     * Obtiene el array de las notas
     *
     * @return array de double
     */
    public double[] getNotas() {
        return notas;
    }

    /**
     * Cambia las notas por el array otorgado
     *
     * @param notas array de notas nuevo
     */
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    /**
     * Obtiene la media de las notas de la asignatura
     *
     * @return la media de la notas
     */
    public double getMedia() {
        double resultado = 0;
        for (double nota : notas) {
            resultado += nota;
        }
        return resultado / notas.length;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombreAsignatura=" + nombreAsignatura + ", notas=" + Arrays.toString(notas) + '}';
    }

}
