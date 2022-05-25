package org.amrv.estudios.ejerciciosmaven.entornos.mvc.covid_mvc;

import org.amrv.estudios.ejerciciosmaven.entornos.mvc.controller.Controlador;
import org.amrv.estudios.ejerciciosmaven.entornos.mvc.model.Sintomas;
import view.View1;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Main {

    private static Controlador controlador;
    private static Sintomas sintomas;
    private static View1 vista;

    public static void main(String[] args) {
        sintomas = new Sintomas();
        vista = new View1();
        controlador = new Controlador(sintomas, vista);
    }
}
