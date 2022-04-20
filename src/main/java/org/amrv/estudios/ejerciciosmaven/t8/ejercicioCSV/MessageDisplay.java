/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t8.ejercicioCSV;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author marruiad
 */
public class MessageDisplay {

    private static final String TAB = "\t";
    private static final String LINE = System.lineSeparator();

    public static void emptyFile(File file) {
        JOptionPane.showMessageDialog(
                Launcher.getFocused(),
                "Se ha cancelado la operación" + LINE
                + "El archivo \"" + file.getName() + "\" esta vacío",
                "Error al leer el archivo",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void invalidFileContents(String extra) {
        JOptionPane.showMessageDialog(
                Launcher.getFocused(),
                "No se ha podido leer la información del archivo" + LINE
                + extra,
                "Error al leer el archivo",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void employeeInfo(Empleado emp) {
        String message
                = "ID:  " + emp.getId() + LINE
                + "Nombre:  " + emp.getNombre() + LINE
                + "Apellido:  " + emp.getApellido() + LINE
                + "Departamento:  " + emp.getDepartamento() + LINE;
        JOptionPane.showMessageDialog(
                Launcher.getFocused(),
                message,
                emp.getNombre() + ' ' + emp.getApellido(),
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static Object buscarEmpleado() {
        final String data = JOptionPane
                .showInputDialog(
                        Launcher.getFocused(),
                        "Escribe el NOMBRE o ID del empleado" + LINE
                        + "(Si escribes un nombre, debes de tener en cuenta las "
                        + "mayusculas y minusculas y buscará cualquier "
                        + "nombre que contenga ese texto)",
                        "Buscar un empleado",
                        JOptionPane.INFORMATION_MESSAGE);
        try {
            return Integer.parseInt(data.trim().replace(',', '.'));
        } catch (NumberFormatException | NullPointerException e) {
            return data == null || data.trim().length() < 1 ? null : data;
        }
    }
}
