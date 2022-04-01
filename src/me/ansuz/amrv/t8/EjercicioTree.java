/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t8;

import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author marruiad
 */
public class EjercicioTree {

    private static final File UNOKNOWN = new File("UNKNOWN FILE");

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
        chooser.setDialogTitle("Matame por favor");
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);

        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                File[] archivos = chooser.getSelectedFiles();
                fileTree(archivos, 0);
                break;
            default:
                break;
        }
    }

    private static void print(File file, int sublevel, boolean directory, boolean last) {
        String str = "";
        for (int i = 0; i < sublevel; i++)
            str += "     ";
        str += (sublevel == 0 ? "" : (last ? "└" : "├") + "──") + (directory ? "[" + file.getName() + "]" : file.getName());
        System.out.println(str);
    }

    private static void fileTree(File[] files, int sublevel) {
        for (File f : files)
            if (f == null)
                f = UNOKNOWN;
        
        Arrays.sort(files, (File o1, File o2) -> o1.isDirectory() && o2.isDirectory() ? 0 : o1.isDirectory() ? 1 : -1);
        for (int i = 0; i < files.length; i++) {
            final File file = files[i];
            final boolean last = i == files.length - 1;

            if (file.isDirectory()) {
                print(file, sublevel, true, last);
                fileTree(file.listFiles(), sublevel + 1);

            } else
                print(file, sublevel, false, last);
        }

    }
}
