/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t8.ejercicioCSV;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author marruiad
 */
public class Launcher {

    private static VentanaCSV ventana;
    private static CSVChooser selector;

    protected static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        // Preparar el Look & feel
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Launcher.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        ventana = new VentanaCSV();
        selector = new CSVChooser();
    }

    public static Component getFocused() {
        return ventana.isVisible() ? ventana : selector;
    }

    public static VentanaCSV getVentana() {
        return ventana;
    }

    public static void selectFile(boolean clear) {
        ventana.setVisible(false);
        switch (selector.showOpenDialog(ventana)) {
            case JFileChooser.APPROVE_OPTION:
                if (clear)
                    empleados.clear();

                empleados.addAll(selector.readEmpleados());
                ventana.setListData(empleados);

            case JFileChooser.CANCEL_OPTION:
                ventana.setLocationRelativeTo(selector);
                ventana.setVisible(true);
                break;
        }
    }

    public static void ordenarId() {
        empleados.sort(
                (Empleado o1, Empleado o2) -> Integer.compare(o1.getId(), o2.getId()));
        ventana.setListData(empleados);
    }

    public static void ordenarApellidos() {
        empleados.sort(
                (Empleado o1, Empleado o2) -> o1.getApellido().compareTo(o2.getApellido()));
        ventana.setListData(empleados);
    }

    public static void ordenarDepartamento() {
        empleados.sort(
                (Empleado o1, Empleado o2) -> o1.getDepartamento().compareTo(o2.getDepartamento()));
        ventana.setListData(empleados);
    }

    public static int getOccurences(Empleado emp) {
        int reps = 0;
        for (Empleado e : empleados)
            if (e.getId() == emp.getId())
                reps++;
        return reps;
    }

    /*
        Script de Oracle SQL
        select 
            hr.employees.employee_id, hr.employees.first_name, 
            hr.employees.last_name, hr.departments.department_name
        from 
            hr.employees, hr.departments
        where 
            hr.employees.department_id = hr.departments.department_id
     */
}
