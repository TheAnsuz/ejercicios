package org.amrv.estudios.ejerciciosmaven.t8.ejercicioCSV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class EmpleadoRender extends JPanel implements ListCellRenderer<Empleado> {

    private final JLabel labelID;
    private final JLabel labelName;
    private final JLabel labelDepartment;
    private final Color[] colors;
    private final Color[] foregrounds;

    public EmpleadoRender() {
        super.setLayout(new BorderLayout());
        super.setBorder(new EmptyBorder(0, 5, 0, 5));

        labelID = new JLabel();
        labelName = new JLabel();
        labelName.setBorder(new EmptyBorder(0, 5, 0, 0));
        labelDepartment = new JLabel();

        super.add(labelID, BorderLayout.LINE_START);
        super.add(labelName, BorderLayout.CENTER);
        super.add(labelDepartment, BorderLayout.LINE_END);

        colors = new Color[]{super.getBackground(), super.getBackground()
            .brighter()};
        foregrounds = new Color[]{super.getForeground(), super.getForeground()
            .darker()};
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Empleado> list, Empleado value, int index, boolean isSelected, boolean cellHasFocus) {
        labelName.setText(value.getNombre() + " " + value.getApellido());

        labelDepartment
                .setText(Launcher.getVentana().shouldDisplayDepartment() ? value
                        .getDepartamento() : "");

        labelID.setText(Launcher.getVentana().shouldDisplayID() ? String
                .valueOf(value.getId()) : "");
        labelDepartment
                .setForeground(Launcher.getOccurences(value) > 1 ? foregrounds[1] : foregrounds[0]);
        labelName
                .setForeground(Launcher.getOccurences(value) > 1 ? foregrounds[1] : foregrounds[0]);
        labelID
                .setForeground(Launcher.getOccurences(value) > 1 ? foregrounds[1] : foregrounds[0]);

        this.setBackground(colors[index % colors.length]);

        return this;
    }

}
