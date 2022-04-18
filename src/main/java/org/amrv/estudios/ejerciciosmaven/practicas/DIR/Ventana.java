package me.ansuz.amrv.practicas.DIR;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;

public class Ventana implements ChangeListener {

	private final JFrame marco;
	protected final JFileChooser fileChooser;
	private final JCheckBox check;
	protected final JTextField input;
	protected final JTextArea output;
	private final EjecucionVentana ejecutor;
	private final JScrollPane scroll;

	public Ventana(String nombre) {
		// Crear el marco
		marco = new JFrame(nombre);
		marco.setLayout(new BorderLayout());
		marco.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		marco.setResizable(false);

		// Crear la entrada de comando
		input = new JTextField();
		input.setBorder(null);
		input.setToolTipText("El comando dir que quieras ejecutar");
		input.setColumns(32);

		final JButton ejecutar = new JButton("ejecutar");
		ejecutar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ejecutor != null)
					ejecutor.ejecutar();
			}
		});

		final JTextField texto = new JTextField("Comando DIR: ");
		texto.setBorder(null);
		texto.setEditable(false);
		texto.setFocusable(false);
		texto.setFont(new Font(texto.getFont().getName(), Font.BOLD, texto.getFont().getSize()));

		JPanel entrada = new JPanel();
		entrada.setLayout(new BorderLayout());
		entrada.add(texto, BorderLayout.LINE_START);
		entrada.add(input);
		entrada.add(ejecutar, BorderLayout.LINE_END);

		marco.add(entrada, BorderLayout.PAGE_START);

		// Crear el file chooser
		fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		// Crear la salida de datos
		output = new JTextArea();
		output.setEditable(false);
		scroll = new JScrollPane(output);

		marco.add(fileChooser, BorderLayout.CENTER);

		// Pie de ventana
		JButton cls = new JButton("Vaciar consola");
		cls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (output != null)
					output.setText("");
			}
		});

		JPanel pie = new JPanel();
		pie.setLayout(new BorderLayout(10, 0));
		check = new JCheckBox("Mostrar file chooser", true);
		check.addChangeListener(this);
		check.setSelectedIcon(null);
		check.setDisabledSelectedIcon(null);
		pie.add(check, BorderLayout.LINE_START);
		pie.add(cls, BorderLayout.LINE_END);
		marco.add(pie, BorderLayout.PAGE_END);

		// Creacion del ejecutor
		ejecutor = new EjecucionVentana(this);

		// Finalizacion de construccion
		marco.pack();
		marco.setMinimumSize(marco.getSize());
		marco.setMaximumSize(marco.getSize());
		marco.setLocationRelativeTo(null);
		marco.setVisible(true);
	}

	public void showConsole() {
		check.setSelected(false);
		this.changeWindow();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.changeWindow();
	}

	private void changeWindow() {
		if (check.isSelected()) {
			marco.remove(scroll);
			marco.add(fileChooser);
		} else {
			marco.remove(fileChooser);
			marco.add(scroll);
		}
		marco.repaint();
		marco.pack();
	}

}
