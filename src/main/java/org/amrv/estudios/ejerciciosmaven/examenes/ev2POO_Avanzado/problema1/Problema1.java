package me.ansuz.amrv.examenes.ev2POO_Avanzado.problema1;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marruiad
 */
public class Problema1 {

    public static void main(String[] args) {
        Clase primeroDam = new Clase(1, "Desarrollo de Aplicaciones Multiplataforma");

        // Poner nota a un alumno en una asignatura, en una evaluación determinadas.
        primeroDam.addAlumno(Problema1.crearAlumnoDAM("Adrian", "Martin"));
        primeroDam.addAlumno(Problema1.crearAlumnoDAM("Jose", "Lopez"));
        primeroDam.addAlumno(Problema1.crearAlumnoDAM("Maria", "Antonia"));

        // Mostrar un listado de la media de la clase en una asignatura determinada.
        System.out.println("Media programacion");
        Map<String, Double> medias = primeroDam.getMedias("Programacion");
        System.out.println(medias);
        System.out.println("Media sistemas");
        medias = primeroDam.getMedias("sistemas informaticos");
        System.out.println(medias);
        System.out.println("Media entornos");
        medias = primeroDam.getMedias("entornos de desarrollo");
        System.out.println(medias);

        // Mostrar un listado de alumnos ordenados alfabéticamente por apellidos.
        List<Alumno> alumnosAlfabeticamente = primeroDam.getAlumnos();
        Collections.sort(alumnosAlfabeticamente);

        // System.out.println(alumnosAlfabeticamente); No se aprecia muy bien el resultado
        for (Alumno ordenados : alumnosAlfabeticamente) {
            System.out.println(ordenados.getNombreCompleto());
        }

        // Buscar el mejor expediente de la clase. Se corresponde con el alumno cuya nota media en
        //todas las asignaturas es la mayor de la clase.
        List<Alumno> alumnosPorMedia = primeroDam.ordenarExpedientes();
        Alumno mejor = alumnosPorMedia.get(0);
        System.out.println("El mejor alumno es " + mejor.getNombreCompleto() + " con una media de " + mejor.getMedias());

    }

    /**
     * Crea un alumno dandole valores predefinidos y notas aleatorias para testeo
     * @param nombre el nombre del alumno
     * @param apellidos los apellidos del alumno
     * @return el objeto alumno con sus asignaturas
     */
    private static Alumno crearAlumnoDAM(String nombre, String apellidos) {
        final Asignatura programacion = new Asignatura("Programacion");
        programacion.setNotas(new double[]{Math.random() * 10, Math.random() * 10, Math.random() * 10});

        final Asignatura entornos = new Asignatura("Entornos de desarrollo");
        entornos.setNotas(new double[]{Math.random() * 10, Math.random() * 10, Math.random() * 10});

        final Asignatura sistemas = new Asignatura("Sistemas informaticos");
        sistemas.setNotas(new double[]{Math.random() * 10, Math.random() * 10, Math.random() * 10});

        final Alumno alumno = new Alumno(nombre, apellidos);
        alumno.addAsignatura(programacion);
        alumno.addAsignatura(entornos);
        alumno.addAsignatura(sistemas);
        return alumno;
    }

}
