package me.ansuz.amrv.examenes.ev2POO_Avanzado.problema1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clase implements Comparator<Alumno> {

	/**
	 * valor numerico del curso de la clase
	 */
	private final int curso;

	/**
	 * Valor de cadena del ciclo de la clase
	 */
	private final String ciclo;

	/**
	 * Array de alumnos de la clase
	 */
	private final ArrayList<Alumno> alumnos; // colección de alumnos de la clase

	/**
	 * Crea una clase dando un curso y ciclo
	 *
	 * @param curso curso de la clase
	 * @param ciclo ciclo de la clase
	 */
	public Clase(int curso, String ciclo) {
		this.curso = curso;
		this.ciclo = ciclo;
		alumnos = new ArrayList<>();
	}

	/**
	 * Obtiene el curso de la clase
	 *
	 * @return el curso de la clase
	 */
	public int getCurso() {
		return curso;
	}

	/**
	 * Obtiene el ciclo de la clase
	 *
	 * @return ciclo de la clase
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * Obtiene una lista de todos los alumnos en la clase
	 *
	 * @return una lista de alumnos
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	/**
	 * Agrega un alumno al curso
	 *
	 * @param alumno alumno a añadir
	 */
	public void addAlumno(Alumno alumno) {
		if (alumnos.contains(alumno)) {
			throw new RuntimeException("El alumno ya esta en el curso");
		}
		alumnos.add(alumno);
	}

	/**
	 * Obtiene un alumno del curso usando su nombre completo, teniendo en cuenta las
	 * mayusculas y minusculas, si no lo encuentra tira una excepcion
	 *
	 * @param nombreCompleto nombre y apellidos del alumno
	 * @return el primer alumno encontrado con ese nombre
	 */
	public Alumno getAlumno(String nombreCompleto) {
		for (Alumno alumno : alumnos) {
			if (alumno.getNombreCompleto().equals(nombreCompleto)) {
				return alumno;
			}
		}
		throw new RuntimeException("No se ha encontrado al alumno '" + nombreCompleto + "'");
	}

	/**
	 * Obtiene todas las medias de todos los alumnos en una asignatura especifica
	 *
	 * @param asignatura la asignatura de la que se quieren obtener las medias
	 * @return un mapa con el nombre del alumno y su media en la asignatura
	 */
	public Map<String, Double> getMedias(String asignatura) {
		final Map<String, Double> medias = new HashMap<>();
		for (Alumno alumno : alumnos) {
			medias.put(alumno.getNombreCompleto(), alumno.getAsignatura(asignatura).getMedia());
		}
		return medias;
	}

	/**
	 * Obtiene una copia ordenada de los alumnos de la clase, ordenados segun su
	 * media en calificaciones
	 *
	 * @return una lista de los alumnos comparando sus medias
	 */
	public List<Alumno> ordenarExpedientes() {
		List<Alumno> resultados = new ArrayList<>();
		resultados.addAll(alumnos);
		Collections.sort(resultados, this);
		return resultados;
	}

	@Override
	public String toString() {
		return "Clase{" + "curso=" + curso + ", ciclo=" + ciclo + ", alumnos=" + alumnos + '}';
	}

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.getMedias() > o2.getMedias() ? -1 : o1.getMedias() < o2.getMedias() ? 1 : 0;
	}

}
