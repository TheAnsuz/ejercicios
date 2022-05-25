package org.amrv.estudios.ejerciciosmaven.entornos.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import org.amrv.estudios.ejerciciosmaven.entornos.mvc.model.Sintomas;
import view.View1;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Controlador implements ActionListener {

    private final Sintomas sintomas;
    private final View1 vista;

    public Controlador(Sintomas sintomas, View1 vista) {
        this.sintomas = sintomas;
        this.vista = vista;
        this.vista.getEnviar().addActionListener(this);
        this.vista.getButtonMostrar().addActionListener(this);
        init();
    }

    private final void init() {
        this.vista.setTitle("ALGO DEL COVID");
        this.vista.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.vista.pack();
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vista.getEnviar())) {
            if (this.vista.getFiebre().isSelected())
                this.sintomas.addFiebre(1);

            if (this.vista.getTos().isSelected())
                this.sintomas.addTos(1);

            if (this.vista.getDiarrea().isSelected())
                this.sintomas.addDiarrea(1);

            if (this.vista.getDolor().isSelected())
                this.sintomas.addDolor_muscular(1);

            if (this.vista.getOlfato().isSelected())
                this.sintomas.addOlfato(1);

            this.vista.getFiebre().setSelected(false);
            this.vista.getTos().setSelected(false);
            this.vista.getDiarrea().setSelected(false);
            this.vista.getDolor().setSelected(false);
            this.vista.getOlfato().setSelected(false);

        } else if (e.getSource().equals(this.vista.getButtonMostrar())) {
            final String resultado
                    = "fiebre " + this.sintomas.getFiebre() + System.lineSeparator()
                    + "tos " + this.sintomas.getTos() + System.lineSeparator()
                    + "diarrea " + this.sintomas.getDiarrea() + System.lineSeparator()
                    + "dolor muscular " + this.sintomas.getDolor_muscular() + System.lineSeparator()
                    + "perdida olfato " + this.sintomas.getOlfato();
            JOptionPane.showMessageDialog(this.vista, resultado, "Resultados actuales de la encuesta", JOptionPane.INFORMATION_MESSAGE);

        }

    }

}
