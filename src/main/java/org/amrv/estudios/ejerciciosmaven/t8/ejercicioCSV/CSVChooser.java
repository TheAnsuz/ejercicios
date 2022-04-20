/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t8.ejercicioCSV;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author marruiad
 */
public class CSVChooser extends JFileChooser {

    protected CSVChooser() {
        // Filtro para archivos csv
        super.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".csv");
            }

            @Override
            public String getDescription() {
                return "Archivos de valores separados por comas (*.csv)";
            }
        });
        // Titulo del dialogo
        super.setDialogTitle("Selecciona un archivo CSV");
        // Que no muestre para aceptar todo tipo de archivos
        super.setAcceptAllFileFilterUsed(false);
    }

    public List<Empleado> readEmpleados() {
        List<Empleado> values = new ArrayList<>();
        // Obtener el archivo csv con el wrapper
        try (BufferedReader reader = new BufferedReader(new FileReader(this.getSelectedFile()))) {
            CsvToBean csv = new CsvToBeanBuilder(reader).withType(Empleado.class).build();

            csv.forEach(emp -> {
                if (emp instanceof Empleado)
                    values.add((Empleado) emp);
            });

        } catch (IOException ex) {
            Logger.getLogger(CSVChooser.class.getName()).log(Level.SEVERE, null, ex);
            // Mostrar un mensaje de error
            MessageDisplay
                    .invalidFileContents("El archivo debe contener una ID, NOMBRE, APELLIDO y DEPARTAMENTO");
        }
        return values;
    }

}
