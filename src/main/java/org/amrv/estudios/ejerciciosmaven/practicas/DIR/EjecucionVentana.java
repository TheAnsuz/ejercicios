package me.ansuz.amrv.practicas.DIR;

import java.io.File;

public class EjecucionVentana {

	private final Ventana ventana;
	private boolean cancel = false;

	protected EjecucionVentana(Ventana ventana) {
		this.ventana = ventana;
	}

	public void ejecutar() {
		cancel = false;
		final File file = parseFile();
		ComandoDir cmd = parseInput(file, this.ventana.input.getText());
		if (cancel) {
			this.log("Ejecucion cancelada", true);
			return;
		}
		this.log(cmd.execute(), true);
	}

	private File parseFile() {
		final File root = this.ventana.fileChooser.getSelectedFile();
		if (root == null) {
			this.log("Debes seleccionar un archivo o carpeta existente", true);
			cancel = true;
		}
		return root;
	}

	private ComandoDir parseInput(File file, String command) {
		command = command.trim();
		ComandoDir cmd = new ComandoDir(file);
		for (String op : command.split("\\s{1,}")) {
			System.out.println(op);
			if (op.startsWith("/") || op.startsWith("-")) {
				// tag
				op = op.trim().toUpperCase();
				switch (op) {
				case "/OG":
				case "-OG":
					cmd.setOG(true);
					this.log("Ordenar directorios", false);
					break;
				case "/ON":
				case "-ON":
					cmd.setON(true);
					this.log("Ordenar nombres", false);
					break;
				case "/OGN":
				case "-OGN":
					cmd.setOGN(true);
					this.log("Ordenar directorios y nombres", false);
					break;
				case "/S":
				case "-S":
					cmd.setS(true);
					this.log("Recursivo", false);
					break;
				case "/B":
				case "-B":
					cmd.setB(true);
					this.log("Modo basico", false);
					break;
				default:
					this.log("Tag invalido: " + op + " (ignorado)", false);
				}
			} else if (op.equalsIgnoreCase("DIR")) {
				// command label ignore
				continue;
			} else if (op == null || op.length() < 1) {
				// ignore empty
				continue;

			} else {
				this.log("Sintaxis de comando no valida " + command, true);
				cancel = true;
			}
		}
		return cmd;

	}

	public void log(String message, boolean showConsole) {
		ventana.output.setText(ventana.output.getText() + message + System.lineSeparator());
		if (showConsole)
			ventana.showConsole();
	}
}
