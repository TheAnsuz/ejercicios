/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.amrv.estudios.ejerciciosmaven.t8;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marruiad
 */
public class LeerCSV {

    public static void main(String[] args) {

    }

    public static List<String[]> readAll(Reader reader) {
        try (CSVReader r = new CSVReader(reader)) {
            return r.readAll();
        } catch (IOException | CsvException ex) {
            Logger.getLogger(LeerCSV.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    public static List<String[]> readLines(Reader reader) {
        final List<String[]> array = new ArrayList<>();
        try (CSVReader r = new CSVReader(reader)) {
//            r.iterator().forEachRemaining(array::add);
        } catch (IOException ex) {
            Logger.getLogger(LeerCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    // Basicamente el CSV reader hace esto pero con alguna verificacion mas
    // Pero soy demasiado vago para añadir esas verificaciones
    public static List<String[]> csvReader(Reader reader) {
        final List<String[]> array = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(reader)) {
            while (r.ready()) {
                array.add(r.readLine().split(";"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return array;
    }
}
