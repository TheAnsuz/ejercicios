package org.amrv.problema1;

import java.util.ArrayList;
import java.util.List;

public class Alumno implements Comparable<Alumno> {

    /**
     * Nombre del alumno
     */
    private final String nombre;

    /**
     * Apellidos del alumno
     */
    private final String apellidos;

    /**
     * Lista de las asignaturas que cursa el alumno
     */
    private final ArrayList<Asignatura> asignaturas; //coleccion de asignaturas del alumno

    /**
     * Crea un alumno con un nombre y apellidos especificados, los cuales no se
     * pueden cambiar luego
     *
     * @param nombre nombre del alumno
     * @param apellidos apellidos del alumno
     */
    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        asignaturas = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del alumno
     *
     * @return nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los apellidos del alumno
     *
     * @return apellidos del alumno
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene el nombre y apellidos del alumno
     *
     * @return nombre + ' ' + apellidos
     */
    public String getNombreCompleto() {
        return nombre + ' ' + apellidos;
    }

    /**
     * Obtiene la lista con las asgnaturas del alumno
     *
     * @return asignaturas del alumno
     */
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    /**
     * Obtiene la media entre las medias de todas las asignaturas que cursa el
     * alumno
     *
     * @return valor doble con la media entre todas las medias de las
     * asignaturas
     */
    public double getMedias() {
        double media = 0;
        for (Asignatura asignatura : asignaturas) {
            media += asignatura.getMedia();
        }
        return media / asignaturas.size();
    }

    /**
     * Agrega una asignatura a las que el alumno esta cursando
     *
     * @param asignatura la asignatura a añadir
     */
    public void addAsignatura(Asignatura asignatura) {
        if (asignaturas.contains(asignatura)) {
            throw new RuntimeException("El alumno ya contiene esa asignatura");
        }
        asignaturas.add(asignatura);
    }

    /**
     * Obtiene una asignatura que el alumno curse, ignorando las mayusculas, si
     * el alumno no cursa la asignatura, se tirara una excepcion
     *
     * @param nombre nombre de la asignatura
     * @return la asignatura con ese nombre que cursa el alumno
     */
    public Asignatura getAsignatura(String nombre) {
        for (Asignatura asign : asignaturas) {
            if (asign.getNombreAsignatura().equalsIgnoreCase(nombre)) {
                return asign;
            }
        }
        throw new RuntimeException("El alumno no contiene la asignatura");
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", asignaturas=" + asignaturas + '}';
    }

    @Override
    public int compareTo(Alumno o) {
        return this.getApellidos().compareTo(o.getApellidos());
    }
}
