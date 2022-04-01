/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ansuz.amrv.t8;

import java.awt.GridLayout;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author marruiad
 */
public class TresEnRaya {

    public static void main(String[] args) {
        Window ventana = new Window(3);
        ventana.setVisible(true);
    }

    private static class Window extends JFrame {

        private final JButton[][] botones;
        private final int dimension = 75;
        private final int margin = 5;
        
        public Window(int size) {
            super.setSize(WIDTH, HEIGHT);
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
            super.setContentPane(panel);
            super.setLayout(new GridLayout(size, size,margin,margin));
            botones = new JButton[size][size];
            for (JButton[] boton : botones) {
                for (JButton subBoton : boton) {
                    subBoton = new JButton();
                    subBoton.setSize(dimension, dimension);
                    subBoton.setText(" ");
                    subBoton.setFocusable(false);
                    super.add(subBoton);
                }
            }
            super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            super.setSize(dimension*size, dimension*size);
            super.setResizable(false);
            super.setLocationRelativeTo(null);
        }
        
    }
    
}