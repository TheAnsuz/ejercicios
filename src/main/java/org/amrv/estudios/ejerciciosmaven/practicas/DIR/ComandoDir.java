package org.amrv.estudios.ejerciciosmaven.practicas.DIR;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComandoDir {

	private static final DecimalFormat cantidad = new DecimalFormat("####");
	private boolean primeroDirectorios = false;
	private boolean ordenAlfabetico = false;
	private boolean subdirectorios = false;
	private boolean detalles = true;
	private final File root;

	private StringBuilder builder;
	private int file = 0;
	private long fileSize = 0;
	private int dir = 0;
	private long freeSize = 0;

	public ComandoDir(File root) {
		builder = new StringBuilder();
		this.root = root;
	}

	public void setOG(boolean primeroDirectorios) {
		this.primeroDirectorios = primeroDirectorios;
	}

	public void setON(boolean ordenAlfabetico) {
		this.ordenAlfabetico = ordenAlfabetico;
	}

	public void setOGN(boolean ordenDirectoriosYAlfabetico) {
		this.primeroDirectorios = ordenDirectoriosYAlfabetico;
		this.ordenAlfabetico = ordenDirectoriosYAlfabetico;
	}

	public void setS(boolean subdirectorios) {
		this.subdirectorios = subdirectorios;
	}

	public void setB(boolean detalles) {
		this.detalles = detalles;
	}

	public String execute() {
		builder.setLength(0);
		file = 0;
		fileSize = 0;
		dir = 0;
		if (root == null || root.isHidden())
			return "El archivo esta fuera del alcance de lectura";
		freeSize = root.getFreeSpace();
		this.startfileTree(root);

		if (this.detalles) {
			builder.append(System.lineSeparator());
			builder.append("\t" + "Total de archivos en la lista:" + System.lineSeparator());

			builder.append("\t  " + cantidad.format(file) + " archivos" + "\t" + FileInfo.numberFormat.format(fileSize)
					+ " bytes" + System.lineSeparator());
			builder.append("\t  " + cantidad.format(dir) + " dirs" + "\t" + FileInfo.numberFormat.format(freeSize)
					+ " bytes libres" + System.lineSeparator());
		}

		return builder.toString();
	}

	private void startfileTree(File root) {

		if (this.detalles) {
			builder.append(System.lineSeparator());
			builder.append(root.getParent() == null ? "El archivo no tiene directorio raiz"
					: "Directorio de " + root.getAbsolutePath() + System.lineSeparator());
		}

		int actualFile = 0;
		long actualFileSize = 0;

		if (root.isDirectory()) {
			final List<File> queue = new ArrayList<>();
			final List<FileInfo> display = new ArrayList<>();

			// Start to walk the file tree
			File[] subfiles = root.listFiles();

			// Ordenar los archivos (orden alfabetico)
			if (this.ordenAlfabetico)
				Arrays.sort(subfiles, (a, b) -> a.getName().compareTo(b.getName()));

			if (this.primeroDirectorios)
				Arrays.sort(subfiles, (a, b) -> a.isDirectory() && b.isDirectory() ? 0 : a.isDirectory() ? 1 : -1);

			for (File child : subfiles) {
				if (child == null || child.isHidden()) {
					builder.append("Archivo oculto");
					continue;
				}

				if (child.isDirectory()) {
					queue.add(child);
					dir++;

				} else {
					file++;
					fileSize += child.length();
				}

				display.add(new FileInfo(child, detalles));
			}
			// Display the contents of the file tree
			int longitud = 0;
			for (FileInfo info : display) {
				longitud = info.toString().length() > longitud ? info.toString().length() : longitud;
			}

			if (this.detalles) {
				this.append(FileInfo.custom(true, ".", detalles), longitud);
				this.append(FileInfo.custom(true, "..", detalles), longitud);
			}

			for (FileInfo info : display) {
				this.append(info, longitud);
			}

			if (this.detalles)
				builder.append("\t  " + cantidad.format(actualFile) + " archivos" + "\t"
						+ FileInfo.numberFormat.format(actualFileSize) + " bytes" + System.lineSeparator());

			if (this.subdirectorios)
				for (File newRoot : queue) {
					this.startfileTree(newRoot);
				}

		} else {
			// Show the info of that file
			this.append(new FileInfo(root, detalles));
			fileSize += root.length();
			file++;
		}
	}

	private void append(FileInfo info) {
		builder.append(info.toString() + System.lineSeparator());
	}

	private void append(FileInfo info, int length) {
		builder.append(info.toString(length) + System.lineSeparator());
	}

}
