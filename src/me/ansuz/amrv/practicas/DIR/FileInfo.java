package me.ansuz.amrv.practicas.DIR;

import java.io.File;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileInfo {

	protected static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy  kk:mm");
	protected static final DecimalFormat numberFormat = new DecimalFormat("##,##0");
	private static final String DATE_TYPE = "    ";
	private static final String TYPE_SIZE = "  ";
	private static final String SIZE_NAME = " ";

	private final String date;
	private final String type;
	private final String size;
	private final String name;
	private final String path;
	private final boolean details;

	protected static FileInfo custom(boolean directory, String name, boolean details) {
		return new FileInfo(LocalDateTime.now(), directory ? "<DIR>" : "     ", 0l, name, "", details);
	}

	protected FileInfo(File file, boolean details) {
		this(LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault()),
				file.isDirectory() ? "<DIR>" : "     ", file.length(), file.getName(), file.getAbsolutePath(), details);
	}

	protected FileInfo(LocalDateTime time, String type, long size, String name, String path, boolean details) {
		this.date = dateFormat.format(time);
		this.type = type;
		this.size = numberFormat.format(size);
		this.name = name;
		this.details = details;
		this.path = path;
	}

	public String getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	private String rawConstruct() {
		return date + DATE_TYPE + type + TYPE_SIZE + size;
	}

	private String rawConstruct(int length) {
		return date + DATE_TYPE + type + String.format(TYPE_SIZE + "%-" + length + "s", size);
	}

	private String construct(int minLength) {
		if (!this.details)
			return this.getPath();

		String str = rawConstruct();
		if (str.length() < minLength)
			str = rawConstruct(minLength - str.length());

		return str + SIZE_NAME + getName();
	}

	public String toString(int requestedLength) {
		return this.construct(requestedLength);
	}

	@Override
	public String toString() {
		return this.construct(0);
	}

}
